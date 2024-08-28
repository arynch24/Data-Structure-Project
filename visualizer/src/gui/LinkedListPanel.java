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

        while (current != null) {
            // Draw node box
            //setting color before drawing
            g.setColor(Color.black);
            g.fillRect(x, y, boxWidth, boxHeight);
            //setting color before drawing
            g.setColor(Color.white);
            g.drawLine(x+10+boxWidth/3,y,x+10+boxWidth/3,y+boxHeight);
            g.setColor(Color.white);
            g.drawRect(x, y, boxWidth, boxHeight);

            // Draw node value
            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.PLAIN, 16));
            g.drawString(""+ current.data, x + 10, y + 25);

            // Draw next node address
            String nextAddress = (current.next != null) ? Integer.toHexString(current.next.hashCode()) : "null";
            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.PLAIN, 16));
            g.drawString( nextAddress, x + 70, y + 25);

            // Draw current node address
            String currentAddress =  Integer.toHexString(current.hashCode());
            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.PLAIN, 16));
            g.drawString( currentAddress, x +5 , y - 10);



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
