package gui;

import main.linkedlist.LinkedList;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents the GUI for visualizing and interacting with a linked list.
 * It uses Swing components to provide controls for inserting, deleting, and reversing the linked list,
 * while visually representing the list on the panel.
 */
public class LinkedListGui extends JFrame {
    private final LinkedList linkedList; // The linked list to be visualized
    private JTextField inputField; // Field for inputting the value of a new node
    private JTextField positionField; // Field for inputting the position for node operations
    private JLabel sizeLabel; // Label to display the size of the linked list
    private LinkedListPanel linkedListPanel; // Custom panel to visualize the linked list

    /**
     * Constructs the LinkedList GUI and initializes the linked list and UI components.
     */
    public LinkedListGui() {
        linkedList = new LinkedList(); // Initialize the linked list
        setupUI(); // Set up the GUI components
    }

    /**
     * Set up the user interface components of the application.
     * This method configures the layout, buttons, text fields, and other UI elements.
     */
    private void setupUI() {
        setTitle("Linked List Visualization"); // Set window title
        setSize(800, 600); // Set initial window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the app when the window is closed
        setLocationRelativeTo(null); // Center the window on the screen

        // Create and configure the panel for linked list visualization
        linkedListPanel = new LinkedListPanel(linkedList);
        linkedListPanel.setBackground(Color.BLACK); // Set background color of the visualization panel
        linkedListPanel.setPreferredSize(new Dimension(800, 400)); // Set panel size

        // Create and configure the input fields for user input
        inputField = new JTextField(10); // Field to input node values
        inputField.setBackground(Color.DARK_GRAY); // Set background color for better visibility
        inputField.setForeground(Color.ORANGE); // Set text color to orange for contrast

        positionField = new JTextField(10); // Field to input positions for node operations
        positionField.setBackground(Color.DARK_GRAY); // Set background color for better visibility
        positionField.setForeground(Color.ORANGE); // Set text color to orange for contrast

        sizeLabel = new JLabel("Size: 0"); // Label to display the current size of the linked list
        sizeLabel.setForeground(Color.WHITE); // Set text color to white for visibility

        // Buttons to trigger linked list operations
        JButton insertAtHeadButton = new JButton("Insert at Head");
        JButton insertAtTailButton = new JButton(" Insert at Tail ");
        JButton insertAtPositionButton = new JButton("Insert at Position ");
        JButton deleteAtPositionButton = new JButton("Delete at Position");
        JButton deleteAtHeadButton = new JButton("Delete at Head");
        JButton deleteAtTailButton = new JButton(" Delete at Tail ");
        JButton reverseButton = new JButton("Reverse List");

        // Set background and text colors for buttons
        Color buttonBackgroundColor = Color.darkGray; // Background color for buttons
        Color buttonForegroundColor = Color.white; // Text color for buttons

        // Apply background and text color to all buttons
        insertAtHeadButton.setBackground(buttonBackgroundColor);
        insertAtTailButton.setBackground(buttonBackgroundColor);
        insertAtPositionButton.setBackground(buttonBackgroundColor);
        deleteAtTailButton.setBackground(buttonBackgroundColor);
        deleteAtHeadButton.setBackground(buttonBackgroundColor);
        deleteAtPositionButton.setBackground(buttonBackgroundColor);
        reverseButton.setBackground(buttonBackgroundColor);

        insertAtHeadButton.setForeground(buttonForegroundColor);
        insertAtTailButton.setForeground(buttonForegroundColor);
        insertAtPositionButton.setForeground(buttonForegroundColor);
        deleteAtTailButton.setForeground(buttonForegroundColor);
        deleteAtHeadButton.setForeground(buttonForegroundColor);
        deleteAtPositionButton.setForeground(buttonForegroundColor);
        reverseButton.setForeground(buttonForegroundColor);

        // Event listeners for button actions, updating the linked list and repainting the panel
        insertAtHeadButton.addActionListener(e -> {
            int value = Integer.parseInt(inputField.getText()); // Get input value
            linkedList.insertAtHead(value); // Insert at the head of the linked list
            updateSize(); // Update the size label
            linkedListPanel.repaint(); // Repaint the panel to reflect changes
        });

        insertAtTailButton.addActionListener(e -> {
            int value = Integer.parseInt(inputField.getText()); // Get input value
            linkedList.insertAtTail(value); // Insert at the tail of the linked list
            updateSize(); // Update the size label
            linkedListPanel.repaint(); // Repaint the panel to reflect changes
        });

        insertAtPositionButton.addActionListener(e -> {
            int value = Integer.parseInt(inputField.getText()); // Get input value
            int position = Integer.parseInt(positionField.getText()); // Get position input
            linkedList.insertAtPosition(position, value); // Insert at the specified position
            updateSize(); // Update the size label
            linkedListPanel.repaint(); // Repaint the panel to reflect changes
        });

        deleteAtPositionButton.addActionListener(e -> {
            int position = Integer.parseInt(positionField.getText()); // Get position input
            linkedList.deleteAtPosition(position); // Delete node at specified position
            updateSize(); // Update the size label
            linkedListPanel.repaint(); // Repaint the panel to reflect changes
        });

        deleteAtHeadButton.addActionListener(e -> {
            linkedList.deleteAtHead(); // Delete the head of the linked list
            updateSize(); // Update the size label
            linkedListPanel.repaint(); // Repaint the panel to reflect changes
        });

        deleteAtTailButton.addActionListener(e -> {
            linkedList.deleteAtTail(); // Delete the tail of the linked list
            updateSize(); // Update the size label
            linkedListPanel.repaint(); // Repaint the panel to reflect changes
        });

        reverseButton.addActionListener(e -> {
            linkedList.reverse(); // Reverse the linked list
            linkedListPanel.repaint(); // Repaint the panel to reflect the reversed list
        });

        // Control panel layout using GridBagLayout for organizing components
        JPanel controlPanel = new JPanel(new GridBagLayout());
        controlPanel.setBackground(Color.BLACK); // Set background color to black
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding between components
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left

        // Create labels for input fields
        JLabel valueLabel = new JLabel("Value:");
        valueLabel.setForeground(Color.white); // Set text color to white for better visibility

        JLabel positionLabel = new JLabel("Position:");
        positionLabel.setForeground(Color.white); // Set text color to white for better visibility

        // Arrange components on the control panel using GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        controlPanel.add(valueLabel, gbc); // Add value label to control panel
        gbc.gridx = 1;
        controlPanel.add(inputField, gbc); // Add input field for node values

        gbc.gridx = 2;
        gbc.gridwidth = 2;
        controlPanel.add(insertAtHeadButton, gbc); // Add insert at head button
        gbc.gridx = 4;
        gbc.gridwidth = 2;
        controlPanel.add(deleteAtHeadButton, gbc); // Add delete at head button

        gbc.gridx = 6;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        controlPanel.add(insertAtPositionButton, gbc); // Add insert at position button

        gbc.gridx = 8;
        gbc.gridwidth = 1;
        controlPanel.add(sizeLabel, gbc); // Add size label to display list size

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        controlPanel.add(positionLabel, gbc); // Add position label to control panel
        gbc.gridx = 1;
        controlPanel.add(positionField, gbc); // Add position input field

        gbc.gridx = 2;
        gbc.gridwidth = 2;
        controlPanel.add(insertAtTailButton, gbc); // Add insert at tail button
        gbc.gridx = 4;
        gbc.gridwidth = 2;
        controlPanel.add(deleteAtTailButton, gbc); // Add delete at tail button

        gbc.gridx = 6;
        gbc.gridwidth = 2;
        controlPanel.add(deleteAtPositionButton, gbc); // Add delete at position button

        gbc.gridx = 8;
        gbc.gridwidth = 1;
        controlPanel.add(reverseButton, gbc); // Add reverse list button

        // Set larger font for better readability
        Font largerFont = new Font("Arial", Font.BOLD, 14);

        // Apply the larger font to all relevant components
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

        // Add components to the main frame
        add(linkedListPanel, BorderLayout.CENTER); // Add visualization panel to the center
        add(controlPanel, BorderLayout.SOUTH); // Add control panel to the bottom
    }

    /**
     * Updates the size label to reflect the current size of the linked list.
     */
    private void updateSize() {
        sizeLabel.setText("Size: " + linkedList.getSize()); // Update size label
    }

    /**
     * Main method to launch the GUI application.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LinkedListGui().setVisible(true)); // Start the GUI
    }
}
