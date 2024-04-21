/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prog2.labs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author natha
 */
public class DatabaseUtil {

    private static final String URL = "jdbc:sqlite:hospital_system.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void initializeDB() {
        String doctorTable
                = "CREATE TABLE IF NOT EXISTS doctors ("
                + "  doctor_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "  name TEXT NOT NULL"
                + ");";

        String illnessTable
                = "CREATE TABLE IF NOT EXISTS illnesses ("
                + "  illness_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "  name TEXT NOT NULL"
                + ");";

        String patientTable
                = "CREATE TABLE IF NOT EXISTS patients ("
                + "  patient_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "  first_name TEXT NOT NULL, "
                + "  last_name TEXT NOT NULL, "
                + "  age INTEGER NOT NULL, "
                + "  height REAL NOT NULL, "
                + "  weight REAL NOT NULL, "
                + "  illness_id INTEGER NOT NULL, "
                + "  doctor_id INTEGER NOT NULL, "
                + "  FOREIGN KEY (illness_id) REFERENCES illnesses(illness_id), "
                + "  FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id)"
                + ");";

        try (Connection conn = connect(); Statement sm = conn.createStatement()) {
            sm.execute(doctorTable);
            sm.execute(illnessTable);
            sm.execute(patientTable);

        } catch (SQLException e) {
            System.out.println("Error during database initialization: " + e.getMessage());
        }
    }

    public static List<Patient> getPatients() {
        List<Patient> patients = new ArrayList<>();
        try (Connection conn = connect(); // Establish a database connection
                 Statement statement = conn.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT * FROM patients")) {
            while (resultSet.next()) {
                // Retrieve patient data from the result set
                int patientID = resultSet.getInt("patient_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                double height = resultSet.getDouble("height");
                double weight = resultSet.getDouble("weight");
                int illnessID = resultSet.getInt("illness_id");
                int doctorID = resultSet.getInt("doctor_id");

                Illness illness = getIllnessByID(illnessID);
                Doctor doctor = getDoctorByID(doctorID);

                // Create Patient object and add it to the list
                Patient patient = new Patient(patientID, firstName, lastName, age, height, weight, illness, doctor);
                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle database query errors
        }
        return patients;
    }

    public static Illness getIllnessByID(int id) {
        Illness illness = null;
        try (Connection conn = connect(); Statement statement = conn.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT * FROM illnesses WHERE illness_id = " + id)) {
            if (resultSet.next()) {
                // Retrieve illness data from the result set
                String name = resultSet.getString("name");
                illness = new Illness(name);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle database query errors
        }
        return illness;
    }

    public static Doctor getDoctorByID(int id) {
        Doctor doctor = null;
        try (Connection conn = connect(); Statement statement = conn.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT * FROM doctors WHERE doctor_id = " + id)) {
            if (resultSet.next()) {
                // Retrieve doctor data from the result set
                String name = resultSet.getString("name");
                doctor = new Doctor(name);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle database query errors
        }
        return doctor;
    }
}
