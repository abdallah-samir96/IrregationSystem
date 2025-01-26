package sa.whitehelmet.resource.v1;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sa.whitehelmet.model.dto.PlotDTO;
import sa.whitehelmet.model.dto.PlotRequestDTO;
import sa.whitehelmet.model.dto.WhiteHelmetResponse;
import sa.whitehelmet.service.PlotService;

import java.util.List;
@RestController
@RequestMapping("/v1/plots")
public class PlotResource {

    private final PlotService plotService;
    @Autowired
   public PlotResource(PlotService plotService) {
       this.plotService = plotService;
   }

    @PostMapping
    public void create(@RequestBody @Valid PlotDTO plotDTO) {
        plotService.create(plotDTO);
    }
   @GetMapping
   public ResponseEntity<WhiteHelmetResponse<List<PlotDTO>>> getAll(
           @RequestParam(defaultValue = "0") @Min(value = 0, message = "Offset Should be > 0") Integer offset,
           @RequestParam(defaultValue = "25") @Min(value = 0, message = "Limit Should be > 0") Integer limit
   ) {
        var data = plotService.getAll(offset, limit);
        var count = plotService.count();
        var response = new WhiteHelmetResponse.Builder<List<PlotDTO>>()
                        .data(data)
                        .totalCount(count)
                        .offset(offset.longValue())
                        .limit(limit.longValue())
                        .moreDetails("Getting All Plot Details")
                        .build();
        return ResponseEntity.ok(response);
   }

    @PutMapping("/configure")
    public void configure(@RequestBody @Valid PlotRequestDTO plotDTO) {
        plotService.configure(plotDTO);
    }

}
