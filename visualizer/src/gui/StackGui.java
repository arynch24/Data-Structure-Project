package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class StackGui extends JFrame {
    private Stack<Integer> stack;
    private DefaultListModel<Integer> listModel;
    private JList<Integer> list;
    private JTextField valueField;
    private JButton pushButton;
    private JButton popButton;

    public StackGui() {
        stack = new Stack<>();
        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);

        setTitle("Stack Visualization");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Center panel to show stack elements
        add(new JScrollPane(list), BorderLayout.CENTER);

        // Bottom panel for input and buttons
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());

        valueField = new JTextField(10);
        pushButton = new JButton("Push");
        popButton = new JButton("Pop");

        bottomPanel.add(new JLabel("Value:"));
        bottomPanel.add(valueField);
        bottomPanel.add(pushButton);
        bottomPanel.add(popButton);

        add(bottomPanel, BorderLayout.SOUTH);

        // Event handling for push button
        pushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputValue = valueField.getText();
                try {
                    int value = Integer.parseInt(inputValue);
                    stack.push(value);
                    listModel.addElement(value);
                    valueField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid integer.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Event handling for pop button
        popButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!stack.isEmpty()) {
                    stack.pop();
                    listModel.remove(listModel.size() - 1);
                } else {
                    JOptionPane.showMessageDialog(null, "Stack is empty.", "Empty Stack", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StackGui().setVisible(true);
        });
    }
}
