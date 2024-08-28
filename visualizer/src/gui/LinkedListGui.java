package gui;

import main.linkedlist.LinkedList;
import main.linkedlist.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LinkedListGui extends JFrame {
    private LinkedList linkedList;
    private JTextField inputField;
    private JTextField positionField;

    public LinkedListGui() {
        linkedList = new LinkedList();
        setupUI();
    }

    private void setupUI() {
        setTitle("Linked List Visualization");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        inputField = new JTextField(10);
        positionField = new JTextField(5);

        JButton insertAtHeadButton = new JButton("Insert at Head");
        insertAtHeadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(inputField.getText());
                linkedList.insertAtHead(value);
                repaint();
            }
        });

        JButton insertAtTailButton = new JButton("Insert at Tail");
        insertAtTailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(inputField.getText());
                linkedList.insertAtTail(value);
                repaint();
            }
        });

        JButton insertAtPositionButton = new JButton("Insert at Position");
        insertAtPositionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(inputField.getText());
                int position = Integer.parseInt(positionField.getText());
                linkedList.insertAtPosition(position, value);
                repaint();
            }
        });

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(inputField.getText());
                linkedList.delete(value);
                repaint();
            }
        });

        JButton deleteAtPositionButton = new JButton("Delete at Position");
        deleteAtPositionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int position = Integer.parseInt(positionField.getText());
                linkedList.deleteAtPosition(position);
                repaint();
            }
        });

        JButton reverseButton = new JButton("Reverse List");
        reverseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                linkedList.reverse();
                repaint();
            }
        });

        JPanel controlPanel = new JPanel();
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

        add(controlPanel, BorderLayout.SOUTH);
        add(new LinkedListPanel(linkedList), BorderLayout.CENTER);
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
