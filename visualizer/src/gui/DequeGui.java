package gui;

import main.deque.Deque;
import main.deque.DequeUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DequeGui extends JFrame {
    private Deque<Integer> deque;
    private JTextArea displayArea;
    private JTextField inputField;

    public DequeGui() {
        deque = new Deque<>();
        setupUI();
    }

    private void setupUI() {
        setTitle("Deque Visualization");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        displayArea = new JTextArea();
        displayArea.setEditable(false);

        inputField = new JTextField(10);

        JButton addFrontButton = new JButton("Add Front");
        addFrontButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(inputField.getText());
                deque.addFront(value);
                updateDisplay();
            }
        });

        JButton addRearButton = new JButton("Add Rear");
        addRearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(inputField.getText());
                deque.addRear(value);
                updateDisplay();
            }
        });

        JButton removeFrontButton = new JButton("Remove Front");
        removeFrontButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    deque.removeFront();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(DequeGui.this, "Deque is empty!");
                }
                updateDisplay();
            }
        });

        JButton removeRearButton = new JButton("Remove Rear");
        removeRearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    deque.removeRear();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(DequeGui.this, "Deque is empty!");
                }
                updateDisplay();
            }
        });

        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Value:"));
        controlPanel.add(inputField);
        controlPanel.add(addFrontButton);
        controlPanel.add(addRearButton);
        controlPanel.add(removeFrontButton);
        controlPanel.add(removeRearButton);

        add(new JScrollPane(displayArea), BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
    }

    private void updateDisplay() {
        displayArea.setText("");
        DequeUtils.printDeque(deque);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DequeGui().setVisible(true);
            }
        });
    }
}
