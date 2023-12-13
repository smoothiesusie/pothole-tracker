package com.techelevator.controller;

import com.techelevator.dao.inspectedDate;
import com.techelevator.model.inspectedDateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class InspectionController {

    private inspectedDateDto inspectionDateDto;

    private inspectedDate inspectedDateDao;

    @Autowired
    public InspectionController(inspectedDate inspectedDateDao){

        this.inspectedDateDao = inspectedDateDao;
    }


    @RequestMapping(path = "/addInspectedDate", method = RequestMethod.POST)
    public ResponseEntity<String> addInspectedDate(@RequestBody inspectedDateDto inspection) {
        inspectedDateDao.addNewInspectedDate(inspection.getInspectedDate());
        return ResponseEntity.status(HttpStatus.CREATED).body("Inspection added successfully");
    }



}
