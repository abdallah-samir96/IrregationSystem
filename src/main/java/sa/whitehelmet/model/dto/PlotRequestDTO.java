package sa.whitehelmet.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
/**
 * used to configure the plot of land
 * */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlotRequestDTO {
    @NotNull
    private Long id;
    @NotNull
    @Min(value = 1, message = "irrigationPeriodInHours should be greater than 0")
    private Integer irrigationPeriodInHours;
    @Min(value = 1, message = "water amount in liter should be greater than 0")
    private Integer waterAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIrrigationPeriodInHours() {
        return irrigationPeriodInHours;
    }

    public void setIrrigationPeriodInHours(Integer irrigationPeriodInHours) {
        this.irrigationPeriodInHours = irrigationPeriodInHours;
    }

    public Integer getWaterAmount() {
        return waterAmount;
    }

    public void setWaterAmount(Integer waterAmount) {
        this.waterAmount = waterAmount;
    }
}
