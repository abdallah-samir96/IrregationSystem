package sa.whitehelmet.service.impl;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sa.whitehelmet.configuration.TwilioConfig;
import sa.whitehelmet.repository.PlotRepository;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

@Service
public class SensorIrrigationService {
    private final RestTemplate httpClient;
    private final AtomicInteger retryNumber;
    private final PlotRepository repository;
    private final TwilioConfig twilioConfig;
    private final Logger logger = Logger.getLogger(SensorIrrigationService.class.getName());
    @Value("${sensor.service.url}")
    private String url;

    @Autowired
    public SensorIrrigationService(
            TwilioConfig config,
            PlotRepository repository,
            RestTemplate restTemplate,
            @Value("${retry.count}") String retryNumberValue) {
        this.twilioConfig = config;
        this.repository = repository;
        this.httpClient = restTemplate;
        this.retryNumber = new AtomicInteger(Integer.parseInt(retryNumberValue));
        twilioConfig.initTwilio();
    }

    @Scheduled(cron = "${irrigation.cron}")
    public void tryIrrigateJob() {
        try {
            if (retryNumber.get() <= 0) {
                sendAlertMessage("Alerting message From Sensor after retrying");
                return;
            }
            var ids = getPlotsIds();
            var responseEntity = httpClient.exchange(url, HttpMethod.POST, new HttpEntity<>(ids), new ParameterizedTypeReference<List<Long>>() {
            });
            var statusCode = responseEntity.getStatusCode();
            if (!statusCode.is2xxSuccessful()) {
                retryNumber.decrementAndGet();
            }
        } catch (Exception ex) {
            logger.info("There is Exception when sending to sensor with message : " + ex.getMessage());
            retryNumber.decrementAndGet();
        }
    }

    /**
     * This method is used to get all Plot that needs to irrigate and integrate with te sensor
     */

    private List<Long> getPlotsIds() {
        return repository.getAllPlotsToIrrigate();
    }

    private void sendAlertMessage(String sms) {
        // Send SMS using Twilio API
        Message message = Message.creator(
                new PhoneNumber("+201097261247"), // To phone number
                new PhoneNumber(twilioConfig.getPhoneNumber()),
                sms
        ).create();
    }
}
