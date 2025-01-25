package sa.whitehelmet.resource.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class IrrigationHomePageResource {

    @GetMapping("/home")
    public String homePage() {
        return "<a href = 'https://whitehelmet.sa/ar/whitehelmet-ar/' target= '_blank'>Hello Page<a/>";
    }
}

