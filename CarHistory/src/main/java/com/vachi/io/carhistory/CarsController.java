package com.vachi.io.carhistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CarsController {

    @Autowired
    private CarsRepo carsRepo;

    @GetMapping("/carHistory")
    public Iterable<Cars>getCarHistory(){
        return carsRepo.findAll();
    }

    @PostMapping("/addcarhistory")
    public Cars insertNewCars(@RequestBody Cars c1) {
        return carsRepo.save(c1);
    }
}
