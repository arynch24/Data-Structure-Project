package gui;

import main.queue.Queue;
import main.queue.QueueUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QueueGui extends JFrame {
    private Queue<Integer> queue;
    private JTextArea displayArea;
    private JTextField inputField;

    public QueueGui() {
        queue = new Queue<>();
        setupUI();
    }

    private void setupUI() {
        setTitle("Queue Visualization");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        displayArea = new JTextArea();
        displayArea.setEditable(false);

        inputField = new JTextField(10);

        JButton enqueueButton = new JButton("Enqueue");
        enqueueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(inputField.getText());
                queue.enqueue(value);
                updateDisplay();
            }
        });

        JButton dequeueButton = new JButton("Dequeue");
        dequeueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    queue.dequeue();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(QueueGui.this, "Queue is empty!");
                }
                updateDisplay();
            }
        });

        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Value:"));
        controlPanel.add(inputField);
        controlPanel.add(enqueueButton);
        controlPanel.add(dequeueButton);

        add(new JScrollPane(displayArea), BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
    }

    private void updateDisplay() {
        displayArea.setText("");
        QueueUtils.printQueue(queue);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new QueueGui().setVisible(true);
            }
        });
    }
}
