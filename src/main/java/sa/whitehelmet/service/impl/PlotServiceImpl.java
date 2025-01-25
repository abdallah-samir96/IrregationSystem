package sa.whitehelmet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sa.whitehelmet.model.dto.PlotDTO;
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
}
