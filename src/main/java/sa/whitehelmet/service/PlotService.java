package sa.whitehelmet.service;

import sa.whitehelmet.model.dto.PlotDTO;
import sa.whitehelmet.model.dto.PlotRequestDTO;
import sa.whitehelmet.model.dto.PlotUpdateRequestDTO;

import java.util.List;

public interface PlotService {
    void create(PlotDTO plotDTO);
    void configure(PlotRequestDTO plotDTO);
    List<PlotDTO> getAll(Integer offset, Integer limit);
    Long count();
    void update(PlotUpdateRequestDTO plotUpdateRequestDTO);
}
