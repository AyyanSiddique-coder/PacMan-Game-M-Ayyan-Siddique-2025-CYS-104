package CEP_2_LAB;

import javax.swing.*;
import java.awt.event.*;

public class StudentPanel extends JFrame {

    JComboBox<String> busBox;

    JButton trackButton;

    JLabel result;

    public StudentPanel() {

        setTitle("Student Panel");

        String[] buses = {

                "1", "2", "3", "4", "5",
                "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15"
        };

        busBox = new JComboBox<>(buses);

        trackButton = new JButton("Track Bus");

        result = new JLabel();

        setLayout(null);

        busBox.setBounds(50, 50, 200, 30);

        trackButton.setBounds(50, 100, 200, 40);

        result.setBounds(50, 170, 300, 30);

        add(busBox);

        add(trackButton);

        add(result);

        trackButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int id =
                        Integer.parseInt(
                                busBox.getSelectedItem().toString());

                for(Bus bus : BusSystem.buses) {

                    if(bus.getBusId() == id) {

                        result.setText(
                                "Current Location: "
                                        + bus.getCurrentLocation());

                        break;
                    }
                }
            }
        });

        setSize(400, 300);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
