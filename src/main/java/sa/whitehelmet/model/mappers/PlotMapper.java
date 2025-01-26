package sa.whitehelmet.model.mappers;

import sa.whitehelmet.model.Plot;
import sa.whitehelmet.model.PlotStatus;
import sa.whitehelmet.model.dto.PlotDTO;
import sa.whitehelmet.model.dto.PlotUpdateRequestDTO;

public class PlotMapper implements Mapper<Plot, PlotDTO>{
    @Override
    public Plot toEntity(PlotDTO dto) {
        var plot = new Plot();
        plot.setName(dto.name());
        plot.setDescription(dto.description());
        plot.setStatus(dto.status() == null? PlotStatus.NEW: dto.status());
        plot.setIrrigationPeriodInHours(dto.irrigationPeriodInHours());
        plot.setWaterAmount(dto.waterAmount());
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
                entity.getWaterAmount(),
                entity.getCreatedAt(),
                entity.getIrrigatedAt()
        );
    }

    public void toEntity(Plot plot, PlotUpdateRequestDTO dto) {
        plot.setName(dto.name());
        plot.setDescription(dto.description());
        plot.setStatus(dto.status());
        plot.setIrrigationPeriodInHours(dto.irrigationPeriodInHours() == null? plot.getIrrigationPeriodInHours(): dto.irrigationPeriodInHours());
        plot.setWaterAmount(dto.waterAmount() == null? plot.getWaterAmount(): dto.waterAmount());
        plot.setIrrigatedAt(dto.irrigatedAt() == null? plot.getIrrigatedAt(): dto.irrigatedAt());
    }
}
