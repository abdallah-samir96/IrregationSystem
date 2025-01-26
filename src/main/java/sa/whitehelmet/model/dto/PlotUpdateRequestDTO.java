package sa.whitehelmet.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import sa.whitehelmet.model.PlotStatus;

import java.time.ZonedDateTime;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public record PlotUpdateRequestDTO(@NotNull Long id, @NotBlank String name, @NotBlank String description, @NotNull PlotStatus status, Integer irrigationPeriodInHours, Integer waterAmount, ZonedDateTime irrigatedAt) { }
