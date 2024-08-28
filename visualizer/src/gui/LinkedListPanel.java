package gui;

import main.linkedlist.LinkedList;
import main.linkedlist.Node;

import javax.swing.*;
import java.awt.*;

public class LinkedListPanel extends JPanel {
    private LinkedList linkedList;

    public LinkedListPanel(LinkedList linkedList) {
        this.linkedList = linkedList;
        setPreferredSize(new Dimension(800, 400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawLinkedList(g);
    }

    private void drawLinkedList(Graphics g) {
        Node current = linkedList.getHead();
        int x = 20;
        int y = 50;
        int boxWidth = 150;
        int boxHeight = 40;
        int gap = 50;

        int panelWidth = getWidth(); // Get the current width of the panel
        boolean leftToRight = true; // Flag to switch direction
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

            // If switching rows,draw the arrow
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
