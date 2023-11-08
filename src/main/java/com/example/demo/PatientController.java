package com.example.demo;

import org.springframework.http.HttpStatus;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
    Map<Long, Patient> patientList = new HashMap<Long, Patient>();


    PatientController(){
        Patient patient1 = new Patient(1, "raj", 22);
        Patient patient2 = new Patient(2, "sankalp", 31);
        patientList.put(1L, patient1);
        patientList.put(2L, patient2);
    }

    @GetMapping(value="{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Patient> getPatient(@PathVariable("id") long id){
        if(!patientList.containsKey(id)){
            return new ResponseEntity<>( HttpStatusCode.valueOf(404));
        }

        return new ResponseEntity<>(patientList.get(id), HttpStatus.OK);

    }

    @PostMapping("/data")
    public ResponseEntity addPatient(Patient data){
        if (data == null){
            return new ResponseEntity("Body cant be null!", HttpStatus.BAD_REQUEST);
        }


        return null;
    }


}
