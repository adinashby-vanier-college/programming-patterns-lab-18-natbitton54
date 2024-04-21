package com.prog2.labs;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author natha
 */
public class PatientForm extends javax.swing.JFrame {

    static PatientListener listner;
    private ResourceBundle messages;
    static HospitalController ctl = new HospitalController();

    /**
     * Creates new form PatientRecord
     */
    public PatientForm(PatientListener listner, HospitalController ctl) {
        initComponents();
        this.listner = listner;
         this.ctl = ctl;
    }

    private void updateLocale(Locale locale) {
        this.messages = ResourceBundle.getBundle("Messages", locale);
        localize();
    }

    private void localize() {
        patientFirstName.setText(messages.getString("firstName"));
        patientLastName.setText(messages.getString("lastName"));
        patientAge.setText(messages.getString("age"));
        patientHeight.setText(messages.getString("height"));
        patientWeight.setText(messages.getString("weight"));
        patientIllness.setText(messages.getString("illness"));
        drLabel.setText(messages.getString("doctor"));
        addPatientBtn.setText(messages.getString("addPatient"));
        enBtn.setText(messages.getString("english"));
        frBtn.setText(messages.getString("french"));
        jLabel1.setText(messages.getString("enterPatientInfo"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        patientFirstName = new javax.swing.JLabel();
        patientLastName = new javax.swing.JLabel();
        patientAge = new javax.swing.JLabel();
        patientHeight = new javax.swing.JLabel();
        patientWeight = new javax.swing.JLabel();
        patientIllness = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        firstNameInput = new javax.swing.JTextField();
        lastNameInput = new javax.swing.JTextField();
        ageInput = new javax.swing.JTextField();
        weightInput = new javax.swing.JTextField();
        heightInput = new javax.swing.JTextField();
        illnessInput = new javax.swing.JTextField();
        addPatientBtn = new javax.swing.JButton();
        drInput = new javax.swing.JTextField();
        drLabel = new javax.swing.JLabel();
        enBtn = new javax.swing.JRadioButton();
        frBtn = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setForeground(new java.awt.Color(255, 255, 255));

        patientFirstName.setForeground(java.awt.Color.black);
        patientFirstName.setText("Patient First Name:");

        patientLastName.setForeground(new java.awt.Color(0, 0, 0));
        patientLastName.setText("Patient Last Name:");

        patientAge.setForeground(new java.awt.Color(0, 0, 0));
        patientAge.setText("Patient Age:");

        patientHeight.setForeground(new java.awt.Color(0, 0, 0));
        patientHeight.setText("Patient Height:");

        patientWeight.setForeground(new java.awt.Color(0, 0, 0));
        patientWeight.setText("Patient Weight (kg):");

        patientIllness.setForeground(new java.awt.Color(0, 0, 0));
        patientIllness.setText("Patient Illness");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.black);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Enter Patient Info");

        addPatientBtn.setForeground(new java.awt.Color(0, 0, 0));
        addPatientBtn.setText("Add Patient");
        addPatientBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPatientBtnActionPerformed(evt);
            }
        });

        drLabel.setForeground(new java.awt.Color(0, 0, 0));
        drLabel.setText("Doctor:");

        buttonGroup1.add(enBtn);
        enBtn.setForeground(new java.awt.Color(0, 0, 0));
        enBtn.setSelected(true);
        enBtn.setText("English");
        enBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enBtnActionPerformed(evt);
            }
        });

        buttonGroup1.add(frBtn);
        frBtn.setForeground(new java.awt.Color(0, 0, 0));
        frBtn.setText("French");
        frBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frBtnActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(patientFirstName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(patientLastName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(patientAge, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(patientHeight, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(patientWeight, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(patientIllness, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(firstNameInput, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lastNameInput, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(ageInput, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(weightInput, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(heightInput, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(illnessInput, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(addPatientBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(drInput, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(drLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(enBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(frBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(frBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                    .addComponent(patientFirstName)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(firstNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(patientLastName)
                                        .addComponent(patientAge)
                                        .addComponent(patientWeight)
                                        .addComponent(patientHeight)
                                        .addComponent(patientIllness)
                                        .addComponent(drLabel))
                                    .addGap(38, 38, 38)
                                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(drInput, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(heightInput, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                            .addComponent(lastNameInput, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(weightInput, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(ageInput, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(illnessInput))))
                                .addComponent(enBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(addPatientBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel1)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patientFirstName)
                    .addComponent(firstNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patientLastName)
                    .addComponent(lastNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patientAge)
                    .addComponent(ageInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patientWeight)
                    .addComponent(weightInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patientHeight)
                    .addComponent(heightInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patientIllness)
                    .addComponent(illnessInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(drInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(drLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(enBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frBtn)
                .addGap(23, 23, 23)
                .addComponent(addPatientBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enBtnActionPerformed
        // TODO add your handling code here:
        if (enBtn.isSelected()) {
            updateLocale(Locale.ENGLISH);
        }
    }//GEN-LAST:event_enBtnActionPerformed

    private void frBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frBtnActionPerformed
        // TODO add your handling code here:
        if (frBtn.isSelected()) {
            updateLocale(Locale.FRANCE);

        }
    }//GEN-LAST:event_frBtnActionPerformed

    private void addPatientBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPatientBtnActionPerformed
        // TODO add your handling code here:
        // Check if any field is empty
        if (firstNameInput.getText().trim().isEmpty()
                || lastNameInput.getText().trim().isEmpty()
                || ageInput.getText().trim().isEmpty()
                || heightInput.getText().trim().isEmpty()
                || weightInput.getText().trim().isEmpty()
                || illnessInput.getText().trim().isEmpty()
                || drInput.getText().trim().isEmpty()) {

            // Show error message if any field is empty
            JOptionPane.showMessageDialog(this,
                    "All fields must be filled out.",
                    "Incomplete Data",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            // If all fields are filled, proceed to add patient
            listner.addPatient(ctl.addPatientRecord(this));
            clearInputFields();
        }
    }//GEN-LAST:event_addPatientBtnActionPerformed

    private void clearInputFields() {
        firstNameInput.setText("");
        lastNameInput.setText("");
        ageInput.setText("");
        heightInput.setText("");
        weightInput.setText("");
        illnessInput.setText("");
        drInput.setText("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PatientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientForm(listner, ctl).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPatientBtn;
    private javax.swing.JTextField ageInput;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField drInput;
    private javax.swing.JLabel drLabel;
    private javax.swing.JRadioButton enBtn;
    private javax.swing.JTextField firstNameInput;
    private javax.swing.JRadioButton frBtn;
    private javax.swing.JTextField heightInput;
    private javax.swing.JTextField illnessInput;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField lastNameInput;
    private javax.swing.JLabel patientAge;
    private javax.swing.JLabel patientFirstName;
    private javax.swing.JLabel patientHeight;
    private javax.swing.JLabel patientIllness;
    private javax.swing.JLabel patientLastName;
    private javax.swing.JLabel patientWeight;
    private javax.swing.JTextField weightInput;
    // End of variables declaration//GEN-END:variables

    public JTextField getAgeInput() {
        return ageInput;
    }

    public JTextField getFirstNameInput() {
        return firstNameInput;
    }

    public JTextField getHeightInput() {
        return heightInput;
    }

    public JTextField getIllnessInput() {
        return illnessInput;
    }

    public JTextField getLastNameInput() {
        return lastNameInput;
    }

    public JTextField getWeightInput() {
        return weightInput;
    }

    public JTextField getDrInput() {
        return drInput;
    }

}
