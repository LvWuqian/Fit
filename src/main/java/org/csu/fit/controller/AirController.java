package org.csu.fit.controller;

import org.csu.fit.domain.AirQuality;
import org.csu.fit.service.AirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AirController {

    @Autowired
    private AirService airService;

    @GetMapping("/air")
    public AirQuality getAirQuality(@RequestParam("city") String city){
        return airService.getAirByCity(city);
    }
}
