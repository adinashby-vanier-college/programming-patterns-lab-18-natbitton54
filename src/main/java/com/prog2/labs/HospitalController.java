package com.prog2.labs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class HospitalController {

    static PatientFactory factory = new PatientFactory();
    private List<PatientListener> listeners = new ArrayList<>();

    public Patient addPatientRecord(PatientForm patientForm) {
        // Extract patient information from the form
        String firstName = patientForm.getFirstNameInput().getText();
        String lastName = patientForm.getLastNameInput().getText();
        int age = Integer.parseInt(patientForm.getAgeInput().getText());
        double height = Double.parseDouble(patientForm.getHeightInput().getText());
        double weight = Double.parseDouble(patientForm.getWeightInput().getText());
        Illness illness = new Illness(patientForm.getIllnessInput().getText());
        Doctor doctor = new Doctor(patientForm.getDrInput().getText());

        // Use the factory to create the patient
        Patient patient = factory.createPatient(firstName, lastName, age, height, weight, illness, doctor);

        // Now, let's add the patient to the database
        try (Connection conn = DatabaseUtil.connect()) {
            // Check if illness and doctor already exist in the DB and get their IDs
            int illnessId = fetchIllnessId(illness.getName(), conn);
            int doctorId = fetchDoctorId(doctor.getName(), conn);

            // Insert the patient into the database
            String sql = "INSERT INTO patients (first_name, last_name, age, height, weight, illness_id, doctor_id) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setString(1, firstName);
                pstmt.setString(2, lastName);
                pstmt.setInt(3, age);
                pstmt.setDouble(4, height);
                pstmt.setDouble(5, weight);
                pstmt.setInt(6, illnessId);
                pstmt.setInt(7, doctorId);

                int affectedRows = pstmt.executeUpdate();
                if (affectedRows == 0) {
                    throw new SQLException("Creating patient failed, no rows affected.");
                }

                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        patient.setPatientID(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating patient failed, no ID obtained.");
                    }
                }
            }

            // Notify listeners that a new patient has been added
            notifyPatientAdded(patient);
        } catch (SQLException e) {
            System.out.println("Error adding patient: " + e.getMessage());
            return null;
        }
        return patient;
    }

    public boolean deletePatient(int patientID) {
        String sql = "DELETE FROM patients WHERE patient_id = ?";
        try (Connection conn = DatabaseUtil.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, patientID);
            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println("Error deleting patient: " + e.getMessage());
            return false;
        }
    }

    public void addPatientListener(PatientListener listener) {
        listeners.add(listener);
    }

    public void removePatientListener(PatientListener listener) {
        listeners.remove(listener);
    }

    private void notifyPatientAdded(Patient patient) {
        for (PatientListener listener : listeners) {
            listener.addPatient(patient);
        }
    }

    private int fetchIllnessId(String illnessName, Connection conn) throws SQLException {
        String sql = "SELECT illness_id FROM illnesses WHERE name = ?";
        try (PreparedStatement psm = conn.prepareStatement(sql)) {
            psm.setString(1, illnessName);
            ResultSet rs = psm.executeQuery();
            if (rs.next()) {
                return rs.getInt("illness_id");
            } else {
                sql = "INSERT INTO illnesses (name) VALUES (?)";
                try (PreparedStatement insert = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                    insert.setString(1, illnessName);
                    insert.executeUpdate();
                    rs = insert.getGeneratedKeys();
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            }
        }
        throw new SQLException("Unable to fetch or create illness ID");
    }

    private int fetchDoctorId(String doctorName, Connection conn) throws SQLException {
        String sql = "SELECT doctor_id FROM doctors WHERE name = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, doctorName);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("doctor_id");
            } else {
                sql = "INSERT INTO doctors (name) VALUES (?)";
                try (PreparedStatement insertStmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                    insertStmt.setString(1, doctorName);
                    insertStmt.executeUpdate();
                    rs = insertStmt.getGeneratedKeys();
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            }
            throw new SQLException("Unable to fetch or create doctor ID");
        }
    }

    public List<Patient> searchPatients(String searchText) {
        List<Patient> results = new ArrayList<>();
        String sql = "SELECT p.*, d.name as doctor_name, i.name as illness_name FROM patients p "
                + "JOIN doctors d ON p.doctor_id = d.doctor_id "
                + "JOIN illnesses i ON p.illness_id = i.illness_id "
                + "WHERE p.first_name LIKE ? OR p.last_name LIKE ? OR i.name LIKE ?";

        try (Connection conn = DatabaseUtil.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + searchText + "%");
            pstmt.setString(2, "%" + searchText + "%");
            pstmt.setString(3, "%" + searchText + "%");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Doctor doctor = new Doctor(rs.getString("doctor_name"));
                Illness illness = new Illness(rs.getString("illness_name"));
                Patient patient = new Patient(
                        rs.getInt("patient_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("age"),
                        rs.getDouble("height"),
                        rs.getDouble("weight"),
                        illness,
                        doctor
                );
                results.add(patient);
            }
        } catch (SQLException e) {
            System.out.println("Error searching patients: " + e.getMessage());
        }
        return results;
    }

    public List<Patient> getAllPatientRecords() {
        List<Patient> patients = new ArrayList<>();

        try (Connection conn = DatabaseUtil.connect()) {
            String sql = "SELECT p.*, d.name AS doctor_name, i.name AS illness_name "
                    + "FROM patients p "
                    + "JOIN doctors d ON p.doctor_id = d.doctor_id "
                    + "JOIN illnesses i ON p.illness_id = i.illness_id";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Doctor doctor = new Doctor(rs.getString("doctor_name"));
                    Illness illness = new Illness(rs.getString("illness_name"));
                    Patient patient = new Patient(
                            rs.getInt("patient_id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getInt("age"),
                            rs.getDouble("height"),
                            rs.getDouble("weight"),
                            illness,
                            doctor
                    );
                    patients.add(patient);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving patient records: " + e.getMessage());
        }

        return patients;
    }
}
