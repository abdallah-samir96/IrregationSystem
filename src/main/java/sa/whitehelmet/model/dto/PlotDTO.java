package sa.whitehelmet.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import sa.whitehelmet.model.PlotStatus;

import java.time.ZonedDateTime;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public record PlotDTO(Long id, String name, String description, PlotStatus status, Integer irrigationPeriodInHours, ZonedDateTime createdAt, ZonedDateTime irrigatedAt) { }
