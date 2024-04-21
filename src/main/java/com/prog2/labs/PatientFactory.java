package com.prog2.labs;

public class PatientFactory {
    private static int patientID = 1;

    public Patient createPatient(String firstName, String lastName, int age, double height, double weight, Illness illness, Doctor doctor) {
        Patient patient = new Patient(patientID++, firstName, lastName, age, height, weight, illness, doctor);
        doctor.addPatient(patient); // Add the patient to the doctor's patient list
        return patient;
    }
}


