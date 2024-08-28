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
        int boxWidth = 100;
        int boxHeight = 40;
        int gap = 20;

        while (current != null) {
            // Draw node box
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(x, y, boxWidth, boxHeight);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, boxWidth, boxHeight);

            // Draw node value
            g.drawString("Value: " + current.data, x + 10, y + 20);

            // Draw next node address
            String nextAddress = (current.next != null) ? Integer.toHexString(current.next.hashCode()) : "null";
            g.drawString("Next: " + nextAddress, x + 10, y + 35);

            // Draw arrow to the next node
            if (current.next != null) {
                g.drawLine(x + boxWidth, y + boxHeight / 2, x + boxWidth + gap, y + boxHeight / 2);
                g.drawLine(x + boxWidth + gap, y + boxHeight / 2, x + boxWidth + gap - 10, y + boxHeight / 2 - 10);
                g.drawLine(x + boxWidth + gap, y + boxHeight / 2, x + boxWidth + gap - 10, y + boxHeight / 2 + 10);
            }

            current = current.next;
            x += boxWidth + gap;
        }
    }
}
