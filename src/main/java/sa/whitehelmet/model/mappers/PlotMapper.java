package sa.whitehelmet.model.mappers;

import sa.whitehelmet.model.Plot;
import sa.whitehelmet.model.PlotStatus;
import sa.whitehelmet.model.dto.PlotDTO;

public class PlotMapper implements Mapper<Plot, PlotDTO>{
    @Override
    public Plot toEntity(PlotDTO dto) {
        var plot = new Plot();
        plot.setName(dto.name());
        plot.setDescription(dto.description());
        plot.setStatus(dto.status() == null? PlotStatus.NEW: dto.status());
        plot.setIrrigationPeriodInHours(dto.irrigationPeriodInHours());
        return plot;
    }

    @Override
    public PlotDTO toDTO(Plot entity) {
        return new PlotDTO(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getStatus(),
                entity.getIrrigationPeriodInHours(),
                entity.getCreatedAt(),
                entity.getIrrigatedAt()
        );
    }
}
