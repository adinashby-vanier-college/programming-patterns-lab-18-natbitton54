package com.prog2.labs;

/**
 * @author adinashby
 *
 */
public class LabEighteen {

    /**
     * Write your test code below in the main (optional).
     *
     */
    public static void main(String[] args) {
        // run HospitalView -- right click run for better UI Background Design
        DatabaseUtil.initializeDB();
        HospitalView vw = new HospitalView();
        vw.setVisible(true);
    }
}
