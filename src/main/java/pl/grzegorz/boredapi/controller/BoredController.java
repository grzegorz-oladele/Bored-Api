package pl.grzegorz.boredapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.grzegorz.boredapi.model.dto.BoredDto;
import pl.grzegorz.boredapi.model.dto.BoredDtoInfo;
import pl.grzegorz.boredapi.service.BoredService;

@RestController
@RequestMapping("/api/bored")
@RequiredArgsConstructor
public class BoredController {

    private final BoredService boredService;

    @GetMapping
    public BoredDto getBored() {
        return boredService.getBored();
    }

    @PostMapping
    public BoredDtoInfo addBored(@RequestBody BoredDto boredDto) {
        return boredService.addBored(boredDto);
    }
}
