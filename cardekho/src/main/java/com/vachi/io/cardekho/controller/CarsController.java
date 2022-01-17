package com.vachi.io.cardekho.controller;

import com.vachi.io.cardekho.Exception.ResourceNotFoundException;
import com.vachi.io.cardekho.config.CarConfig;
import com.vachi.io.cardekho.entity.Cars;
import com.vachi.io.cardekho.repository.CarsRepo;
import com.vachi.io.cardekho.service.CarService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Api(value = "Swagger2DemoRestController", description = "REST APIs related to Student Entity!!!!")
@RestController
@Configuration
@RequestMapping("/api")
public class CarsController {

    @Autowired
    public CarService carService;

    @Autowired
    public CarConfig carConfig;

    @Autowired
    private CarsRepo carsRepo;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/allcars")
    public Iterable<Cars> getCarDetails() {
        return carService.getCarDetails();
    }

    @GetMapping("/getcarbyyear/{year}")
    public List<Cars> getCarByYear(@PathVariable int year){
        return carService.getCarByYear(year);
    }

    @GetMapping("/getcarbyprice/{price}")
    public List<Cars> getCarByPrice( double price){
        return carService.getCarByPrice(price);
    }

    @GetMapping("/getcarbyvin/{vin}")
    public List<Cars> getCarByVin(@PathVariable long vin ){
        return carService.getCarByVin(vin);
    }


    @GetMapping("/getCreditInfo")
    public List<Object> getCreditInfo(){
        return carService.getCreditInfo();
    }

    @GetMapping("/getCreditByPanNo/{panNo}")
    public List<Object> getCreditByPanNo(@PathVariable Long panNo){
        return carService.getCreditByPanNo(panNo);
    }

    @GetMapping("/carsbymake/{make}")
    public Optional<Object> getCarMake(@PathVariable String make) {
        return carService.getCarMake(make);
    }

    @GetMapping("/getHistoryDetails")
    public List<Object> getHistoryDetails(){
        return carService.getHistoryDetails();
    }

    @GetMapping("/getHistoryByPan/{panNo}")
    public List<Object> getHistoryByPan(@PathVariable Long panNo){
        return carService.getHistoryByPan(panNo);
    }

    @GetMapping("/carsbymodel/{model}")
    public ResponseEntity<Object> getCarsByModel(@PathVariable String model)
            throws ResourceNotFoundException {
        return carService.getCarsByModel(model);
    }

     @PostMapping("/addcars")
    public Cars insertNewCars(@RequestBody Cars c1){
        return carService.insertNewCars(c1);
    }

     @PutMapping("/updatecarprice/{id}")
    public ResponseEntity<Cars> updateExistingCarPrice(@PathVariable Long id,
                                                       @Validated @RequestBody Cars carDetails) throws ResourceNotFoundException {
        return carService.updateExistingCarPrice(id,carDetails);
    }

    @PutMapping("/editcars/{id}")
    public ResponseEntity<Cars> updateCars(@PathVariable(value = "id") Long id,
                                           @Validated @RequestBody Cars carDetails) throws ResourceNotFoundException {
       return carService.updateCars(id,carDetails);
    }

     @DeleteMapping("/deletecar/{id}")
    public Map<String, Boolean> deleteCar(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return carService.deleteCar(id);
    }
}