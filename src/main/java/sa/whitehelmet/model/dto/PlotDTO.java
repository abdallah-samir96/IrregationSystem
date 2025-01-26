package sa.whitehelmet.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import sa.whitehelmet.model.PlotStatus;

import java.time.ZonedDateTime;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public record PlotDTO(Long id, @NotBlank String name, @NotBlank String description, PlotStatus status, Integer irrigationPeriodInHours, Integer waterAmount, ZonedDateTime createdAt, ZonedDateTime irrigatedAt) { }
