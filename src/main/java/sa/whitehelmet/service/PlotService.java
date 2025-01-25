package sa.whitehelmet.service;

import sa.whitehelmet.model.dto.PlotDTO;

import java.util.List;

public interface PlotService {
    List<PlotDTO> getAll(Integer offset, Integer limit);
    Long count();
}
