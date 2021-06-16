package com.iotserver.controller;

import com.iotserver.model.Vehicle;
import com.iotserver.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    VehicleRepository vehicleRepository;

    @GetMapping("/")
    public ResponseEntity<?> get(){
        List<Vehicle> _vehicles = vehicleRepository.findAll();
        return new ResponseEntity<>(_vehicles, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> add (@RequestBody Vehicle v){
        int id = v.getId();
        Optional<Vehicle> vehicle =  vehicleRepository.findById(id);
        if(vehicle.isEmpty()){
            vehicleRepository.save(v);
            return new ResponseEntity<>("Created", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Vehicle exits!", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVehicle (@PathVariable("id")int id,
                                            @RequestBody Vehicle _vehicle){
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if(vehicle.isEmpty()){
            return new ResponseEntity<>("Input id is invalid!", HttpStatus.BAD_REQUEST);
        }
        else {
            vehicleRepository.saveAndFlush(_vehicle);
            return new ResponseEntity<>("Update success!", HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVehicle (@PathVariable("id")int id){
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if(vehicle.isEmpty()){
            return new ResponseEntity<>("Input id is invalid!", HttpStatus.BAD_REQUEST);
        }
        else {
            vehicleRepository.deleteById(id);
            return new ResponseEntity<>("Delete success!", HttpStatus.OK);
        }
    }
}
