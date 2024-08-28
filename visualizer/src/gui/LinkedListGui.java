package gui;

import main.linkedlist.LinkedList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LinkedListGui extends JFrame {
    private final LinkedList linkedList;
    private JTextField inputField;
    private JTextField positionField;
    private LinkedListPanel linkedListPanel;

    public LinkedListGui() {
        linkedList = new LinkedList();
        setupUI();
    }

    private void setupUI() {
        setTitle("Linked List Visualization");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create and configure the panel for linked list visualization
        linkedListPanel = new LinkedListPanel(linkedList);
        linkedListPanel.setBackground(Color.BLACK); // Set background color of the panel
        linkedListPanel.setPreferredSize(new Dimension(800, 400));

        // Create and configure the display area
        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setBackground(Color.BLACK); // Set background color
        displayArea.setForeground(Color.WHITE); // Set text color to white for visibility

        // Create and configure the input field
        inputField = new JTextField(10);
        inputField.setBackground(Color.DARK_GRAY); // Set background color
        inputField.setForeground(Color.WHITE); // Set text color to white for visibility

        // Create and configure the position field
        positionField = new JTextField(5);
        positionField.setBackground(Color.DARK_GRAY); // Set background color
        positionField.setForeground(Color.WHITE); // Set text color to white for visibility

        JButton insertAtHeadButton = new JButton("Insert at Head");
        insertAtHeadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(inputField.getText());
                linkedList.insertAtHead(value);
                linkedListPanel.repaint(); // Refresh the linked list panel
            }
        });

        JButton insertAtTailButton = new JButton("Insert at Tail");
        insertAtTailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(inputField.getText());
                linkedList.insertAtTail(value);
                linkedListPanel.repaint(); // Refresh the linked list panel
            }
        });

        JButton insertAtPositionButton = new JButton("Insert at Position");
        insertAtPositionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(inputField.getText());
                int position = Integer.parseInt(positionField.getText());
                linkedList.insertAtPosition(position, value);
                linkedListPanel.repaint(); // Refresh the linked list panel
            }
        });

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(inputField.getText());
                linkedList.delete(value);
                linkedListPanel.repaint(); // Refresh the linked list panel
            }
        });

        JButton deleteAtPositionButton = new JButton("Delete at Position");
        deleteAtPositionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int position = Integer.parseInt(positionField.getText());
                linkedList.deleteAtPosition(position);
                linkedListPanel.repaint(); // Refresh the linked list panel
            }
        });

        JButton reverseButton = new JButton("Reverse List");
        reverseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                linkedList.reverse();
                linkedListPanel.repaint(); // Refresh the linked list panel
            }
        });

        JPanel controlPanel = new JPanel();
        controlPanel.setBackground(Color.BLACK); // Set background color
        controlPanel.add(new JLabel("Value:"));
        controlPanel.add(inputField);
        controlPanel.add(new JLabel("Position:"));
        controlPanel.add(positionField);
        controlPanel.add(insertAtHeadButton);
        controlPanel.add(insertAtTailButton);
        controlPanel.add(insertAtPositionButton);
        controlPanel.add(deleteButton);
        controlPanel.add(deleteAtPositionButton);
        controlPanel.add(reverseButton);
        controlPanel.setForeground(Color.WHITE); // Set text color to white for visibility

        add(linkedListPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LinkedListGui().setVisible(true);
            }
        });
    }
}
