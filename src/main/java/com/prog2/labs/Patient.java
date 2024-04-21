package com.prog2.labs;

public class Patient {

    private int patientID;
    private String firstName;
    private String lastName;
    private int age;
    private double height;
    private double weight;
    private Illness illness;
    private Doctor doctor;

    public Patient(int id, String firstName, String lastName, int age, double height, double weight, Illness illness, Doctor doctor) {
        this.patientID = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.illness = illness;
        this.doctor = doctor;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Illness getIllness() {
        return illness;
    }

    public void setIllness(Illness illness) {
        this.illness = illness;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "ID: " + patientID + " - " +  ", First Name: " + firstName + ", Last Name: " + lastName
                + ", Age: " + age + ", Height: " + height + "cm" + ", Weight: " + weight + "kg"
                + ", Illness: " + illness + ", Doctor: " + doctor;
    }
}
