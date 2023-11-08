package com.example.demo;

import jakarta.annotation.Nullable;
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

    @PostMapping
    public ResponseEntity<String> addPatient(@RequestBody Patient patient){
        if (patient == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Body cant be null!");
        }

        Patient p = new Patient(patient.Id, patient.name, patient.age);
        patientList.put(patient.Id, p);

        return ResponseEntity.status(HttpStatus.OK).body("New patient Id created ");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id){
        if(patientList.containsKey(id)){
            patientList.remove(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Patient with id : " + id + "has been deleted");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient with id : "+id + " don't exist");
        }
    }


}
