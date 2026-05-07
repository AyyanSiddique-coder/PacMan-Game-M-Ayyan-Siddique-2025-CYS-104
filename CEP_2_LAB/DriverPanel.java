package CEP_2_LAB;

import javax.swing.*;
import java.awt.event.*;

public class DriverPanel extends JFrame {

    JComboBox<String> busBox;
    JTextField locationField;
    JButton updateButton;

    public DriverPanel() {

        setTitle("Driver Panel");

        String[] buses = {

                "1", "2", "3", "4", "5",
                "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15"
        };

        busBox = new JComboBox<>(buses);

        locationField = new JTextField();

        updateButton = new JButton("Update Location");

        setLayout(null);

        busBox.setBounds(50, 50, 200, 30);

        locationField.setBounds(50, 100, 200, 30);

        updateButton.setBounds(50, 150, 200, 40);

        add(busBox);

        add(locationField);

        add(updateButton);

        updateButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int id =
                        Integer.parseInt(
                                busBox.getSelectedItem().toString());

                String newLocation =
                        locationField.getText();

                for(Bus bus : BusSystem.buses) {

                    if(bus.getBusId() == id) {

                        bus.setCurrentLocation(newLocation);

                        break;
                    }
                }

                BusSystem.saveBuses();

                JOptionPane.showMessageDialog(null,
                        "Location Updated Successfully!");
            }
        });

        setSize(350, 300);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}