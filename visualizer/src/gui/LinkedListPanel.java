package gui;

import main.linkedlist.LinkedList;
import main.linkedlist.Node;

import javax.swing.*;
import java.awt.*;

/**
 * A JPanel subclass that visualizes a linked list.
 * This panel draws the linked list nodes and arrows indicating the connections between nodes.
 */
public class LinkedListPanel extends JPanel {
    private LinkedList linkedList;

    /**
     * Constructs a LinkedListPanel with the specified linked list.
     */
    public LinkedListPanel(LinkedList linkedList) {
        this.linkedList = linkedList;
        setPreferredSize(new Dimension(800, 400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawLinkedList(g);
    }

    /**
     * Draws the linked list on the panel.
     * Nodes are represented as boxes with their values, current and next addresses.
     * Arrows are drawn to indicate the links between nodes.
     * The drawing direction alternates between left-to-right and right-to-left as needed.
     * g The Graphics object used for drawing.
     */
    private void drawLinkedList(Graphics g) {
        Node current = linkedList.getHead();
        int x = 20; // Initial x position for drawing nodes
        int y = 50; // Initial y position for drawing nodes
        int boxWidth = 150; // Width of each node box
        int boxHeight = 40; // Height of each node box
        int gap = 50; // Gap between nodes

        int panelWidth = getWidth(); // Get the current width of the panel
        boolean leftToRight = true; // Flag to switch drawing direction
        int previousX = x, previousY = y; // Store previous position for green arrow

        while (current != null) {
            // Draw node box
            g.setColor(Color.BLACK);
            g.fillRect(x, y, boxWidth, boxHeight);
            g.setColor(Color.WHITE);
            g.drawLine(x + 10 + boxWidth / 3, y, x + 10 + boxWidth / 3, y + boxHeight);
            g.drawRect(x, y, boxWidth, boxHeight);

            // Draw node value
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.PLAIN, 16));
            g.drawString("" + current.data, x + 10, y + 25);

            // Draw next node address
            String nextAddress = (current.next != null) ? Integer.toHexString(current.next.hashCode()) : "null";
            g.setColor(Color.WHITE);
            g.drawString(nextAddress, x + 70, y + 25);

            // Draw current node address
            String currentAddress = Integer.toHexString(current.hashCode());
            g.setColor(Color.WHITE);
            g.drawString(currentAddress, x + 5, y - 10);

            // Draw arrow to the next node
            if (current.next != null) {
                if (leftToRight) {
                    g.drawLine(x + boxWidth, y + boxHeight / 2, x + boxWidth + gap, y + boxHeight / 2);
                    g.drawLine(x + boxWidth + gap, y + boxHeight / 2, x + boxWidth + gap - 10, y + boxHeight / 2 - 10);
                    g.drawLine(x + boxWidth + gap, y + boxHeight / 2, x + boxWidth + gap - 10, y + boxHeight / 2 + 10);
                } else {
                    g.drawLine(x, y + boxHeight / 2, x - gap, y + boxHeight / 2);
                    g.drawLine(x - gap, y + boxHeight / 2, x - gap + 10, y + boxHeight / 2 - 10);
                    g.drawLine(x - gap, y + boxHeight / 2, x - gap + 10, y + boxHeight / 2 + 10);
                }
            }

            // Draw arrow when switching rows
            if (leftToRight && x + boxWidth + gap > panelWidth) {
                g.drawLine(x + boxWidth, y + boxHeight / 2, x + boxWidth + gap / 2, y + boxHeight + gap / 2);
                g.drawLine(x + boxWidth + gap / 2, y + boxHeight + gap / 2, 20, y + boxHeight + gap / 2);
                g.drawLine(20, y + boxHeight + gap / 2, 20, y + boxHeight + gap);
            }
            else if (!leftToRight && x - gap < 20) {
                g.drawLine(x, y + boxHeight / 2, x - gap / 2, y + boxHeight + gap / 2);
                g.drawLine(x - gap / 2, y + boxHeight + gap / 2, panelWidth - 20, y + boxHeight + gap / 2);
                g.drawLine(panelWidth - 20, y + boxHeight + gap / 2, panelWidth - 20, y + boxHeight + gap);
            }

            // Move to the next node
            current = current.next;

            // Update position for the next node
            if (leftToRight) {
                x += boxWidth + gap;
                if (x + boxWidth > panelWidth) {
                    leftToRight = false; // Switch direction
                    x = panelWidth - boxWidth - 20;
                    y += boxHeight + gap;
                }
            } else {
                x -= boxWidth + gap;
                if (x < 20) {
                    leftToRight = true; // Switch direction
                    x = 20;
                    y += boxHeight + gap;
                }
            }
        }
    }
}
