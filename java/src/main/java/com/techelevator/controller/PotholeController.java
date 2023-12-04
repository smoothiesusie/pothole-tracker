package com.techelevator.controller;

import com.techelevator.dao.PotholeDao;
import com.techelevator.model.Pothole;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PotholeController {

    private Pothole pothole;
    private PotholeDao potholeDao;
    public PotholeController(PotholeDao potholeDao){
        this.potholeDao = potholeDao;

    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/addPothole", method = RequestMethod.POST)
    public Pothole createPothole(@Valid @RequestBody Pothole pothole){
        return potholeDao.createNewPothole(
                pothole.getUserId(),
                pothole.getLatitude(),
                pothole.getLongitude(),
                pothole.getSeverity(),
                pothole.getStatus()
        );
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(path = "/potholes", method = RequestMethod.GET)
    public List<Pothole> getAllPotholes(){
        return potholeDao.getAllPotholes();
    }
}
