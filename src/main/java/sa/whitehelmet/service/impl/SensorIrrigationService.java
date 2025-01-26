package sa.whitehelmet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class SensorIrrigationService {
    @Value("${sensor.service.url}")
    private String url;

    private final RestTemplate httpClient;
    @Autowired
    public SensorIrrigationService(RestTemplate restTemplate) {
        this.httpClient = restTemplate;
    }

    public void tryIrrigateJob(){
        System.out.println("Call ME!!!!!");
        var ids = getPlotsIds();
        var responseEntity = httpClient.exchange(url, HttpMethod.POST, new HttpEntity<>(ids), new ParameterizedTypeReference<List<Long>>(){});
        var statusCode = responseEntity.getStatusCode();
        if(statusCode.is2xxSuccessful()) {
            System.out.println("Okay");
        }else if(statusCode.isError()) {
            System.out.println("Error and need to retry again later!!!");
        }
    }

    /**
     * This method is used to get all Plot that needs to irrigate and integrate with te sensor
     * */

    private static List<Integer> getPlotsIds() {
        return List.of(1, 2, 3, 4, 5, 6);
    }

}
