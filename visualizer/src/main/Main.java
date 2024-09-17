package main;

import gui.LinkedListGui;

/**
 * The entry point of the LinkedList visualization application.
 * This class is responsible for launching the GUI of the linked list.
 */
public class Main {

    /**
     * Main method that serves as the entry point of the program.
     * It creates and displays the LinkedList GUI.
     */
    public static void main(String[] args) {
        // Create a new instance of the LinkedListGui and make it visible
        new LinkedListGui().setVisible(true);
    }
}
