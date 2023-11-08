package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Patient {
    @JsonProperty
    private long Id;

    @JsonProperty
    private String name;

    @JsonProperty
    private int age;

    @Override
    public String toString() {
        return "Patient{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Patient() {
        Id = 1;
        name = "sam";
        age = 20;
    }

    public Patient(long Id, String name, int age) {
        this.Id = Id;
        this.name = name;
        this.age = age;
    }

//    public void getInfo() {
//        System.out.println("Patients ID :" + Id);
//        System.out.println("Patients Name :" + name);
//        System.out.println("Patients Age :" + age);
//    }
//
//    public void setInfo(long Id, String name, int age) {
//        this.Id = Id;
//        this.name = name;
//        this.age = age;
//    }
}
