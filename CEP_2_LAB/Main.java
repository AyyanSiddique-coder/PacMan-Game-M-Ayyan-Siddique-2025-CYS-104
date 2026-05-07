package CEP_2_LAB;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        BusSystem.loadBuses();

        String[] options = {

                "Driver Panel",
                "Student Panel"
        };

        int choice =
                JOptionPane.showOptionDialog(
                        null,
                        "Select User Type",
                        "Bus Tracking System",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        options,
                        options[0]
                );

        if(choice == 0) {

            new DriverPanel();
        }

        else {

            new StudentPanel();
        }
    }
}