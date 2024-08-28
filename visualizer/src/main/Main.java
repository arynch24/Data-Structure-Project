package main;

import gui.StackGui;
import gui.QueueGui;
import gui.LinkedListGui;
import gui.DequeGui;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String[] options = {"Stack", "Queue", "LinkedList", "Deque"};
            String choice = (String) JOptionPane.showInputDialog(null, "Choose data structure to visualize:", "Data Structure Visualization", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            if (choice != null) {
                switch (choice) {
                    case "Stack":
                        new StackGui().setVisible(true);
                        break;
                    case "Queue":
                        new QueueGui().setVisible(true);
                        break;
                    case "LinkedList":
                        new LinkedListGui().setVisible(true);
                        break;
                    case "Deque":
                        new DequeGui().setVisible(true);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            }
        });
    }
}
