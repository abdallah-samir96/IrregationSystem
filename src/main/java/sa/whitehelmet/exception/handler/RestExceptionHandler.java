package sa.whitehelmet.exception.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sa.whitehelmet.exception.PlotNotFoundException;
import sa.whitehelmet.model.dto.ErrorCodes;
import sa.whitehelmet.model.dto.ErrorDTO;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(PlotNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleNotFoundException(HttpServletRequest request, PlotNotFoundException exception) {
        var errorDTO = new ErrorDTO(
                exception.getMessage(),
                ErrorCodes.PLOT_NOT_FOUND.code,
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return ResponseEntity
                .status(exception.getStatus())
                .body(errorDTO);
    }
}
