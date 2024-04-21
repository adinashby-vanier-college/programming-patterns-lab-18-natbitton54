package com.prog2.labs;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String name;
    private List<Patient> patientList = new ArrayList<>();

    public Doctor(String name) {
        this.name = name;
    }

    public void addPatient(Patient patient) {
        patientList.add(patient);
    }

    public List<Patient> getPatientList() {
        return patientList;
    }
    
    
    public String getName() {
        return name;
    }
    
       @Override
    public String toString() {
        return name;
    }
}
