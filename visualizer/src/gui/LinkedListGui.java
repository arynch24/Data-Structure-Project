package gui;

import main.linkedlist.LinkedList;

import javax.swing.*;
import java.awt.*;

public class LinkedListGui extends JFrame {
    private final LinkedList linkedList;
    private JTextField inputField;
    private JTextField positionField;
    private JLabel sizeLabel;
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

        // Create and configure the input and position fields
        inputField = new JTextField(10);
        inputField.setBackground(Color.DARK_GRAY); // Set background color
        inputField.setForeground(Color.ORANGE); // Set text color to orange for visibility

        positionField = new JTextField(10);
        positionField.setBackground(Color.DARK_GRAY); // Set background color
        positionField.setForeground(Color.ORANGE); // Set text color to orange for visibility

        sizeLabel = new JLabel("Size: 0");
        sizeLabel.setForeground(Color.WHITE); // Set text color to white for visibility

        JButton insertAtHeadButton = new JButton("Insert at Head");
        JButton insertAtTailButton = new JButton(" Insert at Tail ");
        JButton insertAtPositionButton = new JButton("Insert at Position ");
        JButton deleteAtPositionButton = new JButton("Delete at Position");
        JButton deleteAtHeadButton = new JButton("Delete at Head");
        JButton deleteAtTailButton = new JButton(" Delete at Tail ");
        JButton reverseButton = new JButton("Reverse List");

        Color buttonBackgroundColor = Color.darkGray; // Set your desired color

        insertAtHeadButton.setBackground(buttonBackgroundColor);
        insertAtTailButton.setBackground(buttonBackgroundColor);
        insertAtPositionButton.setBackground(buttonBackgroundColor);
        deleteAtTailButton.setBackground(buttonBackgroundColor);
        deleteAtHeadButton.setBackground(buttonBackgroundColor);
        deleteAtPositionButton.setBackground(buttonBackgroundColor);
        reverseButton.setBackground(buttonBackgroundColor);

        Color buttonForegroundColor = Color.white;
        insertAtHeadButton.setForeground(buttonForegroundColor);
        insertAtTailButton.setForeground(buttonForegroundColor);
        insertAtPositionButton.setForeground(buttonForegroundColor);
        deleteAtTailButton.setForeground(buttonForegroundColor);
        deleteAtHeadButton.setForeground(buttonForegroundColor);
        deleteAtPositionButton.setForeground(buttonForegroundColor);
        reverseButton.setForeground(buttonForegroundColor);


        insertAtHeadButton.addActionListener(e -> {
            int value = Integer.parseInt(inputField.getText());
            linkedList.insertAtHead(value);
            updateSize();
            linkedListPanel.repaint();
        });

        insertAtTailButton.addActionListener(e -> {
            int value = Integer.parseInt(inputField.getText());
            linkedList.insertAtTail(value);
            updateSize();
            linkedListPanel.repaint();
        });

        insertAtPositionButton.addActionListener(e -> {
            int value = Integer.parseInt(inputField.getText());
            int position = Integer.parseInt(positionField.getText());
            linkedList.insertAtPosition(position, value);
            updateSize();
            linkedListPanel.repaint();
        });

        deleteAtPositionButton.addActionListener(e -> {
            int position = Integer.parseInt(positionField.getText());
            linkedList.deleteAtPosition(position);
            updateSize();
            linkedListPanel.repaint();
        });

        deleteAtHeadButton.addActionListener(e -> {
            linkedList.deleteAtHead();
            updateSize();
            linkedListPanel.repaint();
        });

        deleteAtTailButton.addActionListener(e -> {
            linkedList.deleteAtTail();
            updateSize();
            linkedListPanel.repaint();
        });

        reverseButton.addActionListener(e -> {
            linkedList.reverse();
            linkedListPanel.repaint();
        });

        // Create and configure the control panel using GridBagLayout
        JPanel controlPanel = new JPanel(new GridBagLayout());
        controlPanel.setBackground(Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;


        JLabel valueLabel = new JLabel("Value:");
        valueLabel.setForeground(Color.white); // Change text color to white

        JLabel positionLabel = new JLabel("Position:");
        positionLabel.setForeground(Color.white); // Change text color to white


        // Row 1: Value Label and Input Field
        gbc.gridx = 0;
        gbc.gridy = 0;
        controlPanel.add(valueLabel, gbc);
        gbc.gridx = 1;
        controlPanel.add(inputField, gbc);

        // Row 1: Insert at Head and Delete at Head Buttons
        gbc.gridx = 2;
        gbc.gridwidth = 2;
        controlPanel.add(insertAtHeadButton, gbc);
        gbc.gridx = 4;
        gbc.gridwidth = 2;
        controlPanel.add(deleteAtHeadButton, gbc);

        gbc.gridx = 6;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        controlPanel.add(insertAtPositionButton, gbc);

        gbc.gridx = 8;
        gbc.gridwidth = 1;
        controlPanel.add(sizeLabel, gbc);


        // Row 2: Position Label and Input Field
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        controlPanel.add(positionLabel, gbc);
        gbc.gridx = 1;
        controlPanel.add(positionField, gbc);

        // Row 2: Insert at Tail and Delete at Tail Buttons
        gbc.gridx = 2;
        gbc.gridwidth = 2;
        controlPanel.add(insertAtTailButton, gbc);
        gbc.gridx = 4;
        gbc.gridwidth = 2;
        controlPanel.add(deleteAtTailButton, gbc);

        gbc.gridx = 6;
        gbc.gridwidth = 2;
        controlPanel.add(deleteAtPositionButton, gbc);

        gbc.gridx = 8;
        gbc.gridwidth = 1;
        controlPanel.add(reverseButton, gbc);

        Font largerFont = new Font("Arial", Font.BOLD, 14); // Increase font size to 16

        // Apply this font to all components
        valueLabel.setFont(largerFont);
        positionLabel.setFont(largerFont);
        inputField.setFont(largerFont);
        positionField.setFont(largerFont);
        insertAtHeadButton.setFont(largerFont);
        insertAtTailButton.setFont(largerFont);
        deleteAtHeadButton.setFont(largerFont);
        deleteAtTailButton.setFont(largerFont);
        insertAtPositionButton.setFont(largerFont);
        deleteAtPositionButton.setFont(largerFont);
        reverseButton.setFont(largerFont);
        sizeLabel.setFont(largerFont);
        


        // Add components to the frame
        add(linkedListPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

    }

    private void updateSize() {
        sizeLabel.setText("Size: " + linkedList.getSize());
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LinkedListGui().setVisible(true));
    }
}
