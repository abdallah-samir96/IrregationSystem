package sa.whitehelmet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import sa.whitehelmet.exception.PlotNotFoundException;
import sa.whitehelmet.model.dto.PlotDTO;
import sa.whitehelmet.model.dto.PlotRequestDTO;
import sa.whitehelmet.model.dto.PlotUpdateRequestDTO;
import sa.whitehelmet.model.mappers.PlotMapper;
import sa.whitehelmet.repository.PlotRepository;
import sa.whitehelmet.service.PlotService;

import java.util.List;

@Service
public class PlotServiceImpl implements PlotService {

    private final PlotRepository plotRepository;

    @Autowired
    public PlotServiceImpl(PlotRepository plotRepository) {
        this.plotRepository = plotRepository;
    }

    @Override
    public void create(PlotDTO plotDTO) {
        var plot = new PlotMapper().toEntity(plotDTO);
        plotRepository.save(plot);
    }
    @Override
    public List<PlotDTO> getAll(Integer offset, Integer limit) {
        int page = offset / limit;
        Pageable pageable =  PageRequest.of(page, limit);
        var plots = plotRepository.findAll(pageable);
        return new PlotMapper().toDTO(plots.stream().toList());
    }

    @Override
    public Long count() {
        return plotRepository.count();
    }

    @Override
    public void configure(PlotRequestDTO plotDTO) {
        var plot = plotRepository.findById(plotDTO.getId()).orElseThrow(()-> new PlotNotFoundException("Plot with Id : " + plotDTO.getId() + " Is not found", HttpStatus.NOT_FOUND.value()));
        plot.setWaterAmount(plotDTO.getWaterAmount());
        plot.setIrrigationPeriodInHours(plotDTO.getIrrigationPeriodInHours());
        plotRepository.save(plot);
    }

    @Override
    public void update(PlotUpdateRequestDTO dto) {
        var plot = plotRepository.findById(dto.id()).orElseThrow(()-> new PlotNotFoundException("Plot with Id : " + dto.id() + " Is not found", HttpStatus.NOT_FOUND.value()));
        new PlotMapper().toEntity(plot, dto);
        plotRepository.save(plot);
    }
}
