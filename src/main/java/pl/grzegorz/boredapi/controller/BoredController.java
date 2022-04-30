package pl.grzegorz.boredapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.grzegorz.boredapi.model.dto.BoredDtoInfo;
import pl.grzegorz.boredapi.service.activity.BoredService;

@RestController
@RequestMapping("/api/bored")
@RequiredArgsConstructor
public class BoredController {

    private final BoredService boredService;

//    @GetMapping
//    public BoredDto getBored() {
//        return boredService.getBored();
//    }

    @GetMapping
    public BoredDtoInfo addBored() {
        return boredService.addBored();
    }
}
