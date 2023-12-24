package com.ou1box.metrojourney;
import java.util.ArrayList;

public class DoubleLinkedList {
    public class Node {
        ArrayList<String> value;
        Node next;
        Node previous;

        public Node(ArrayList<String> value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }

    Node head;
    Node tail;

    public void add(ArrayList<String> value) {
        Node current = head;
        head = new Node(value, current, null);
        if (current != null) {
            current.previous = head;
        } else {
            tail = head;
        }
    }

    public Node getFirst() {
        return head;
    }

    public void append(ArrayList<String> value) {
        Node current = tail;
        tail = new Node(value, null, current);
        if (current != null) {
            current.next = tail;
        } else {
            head = tail;
        }
    }

    public Node getLast() {
        return tail;
    }

    public int length() {
        Node current = head;
        int listLength = 0;
        while (current != null) {
            current = current.next;
            listLength += 1;
        }
        return listLength;
    }

    public void insert(ArrayList<String> value, int index) throws Exception {
        if (index > this.length() - 1) {
            throw new Exception("List index out of range");
        }
        Node current = head;
        int currentIndex = 0;
        while (currentIndex < index) {
            current = current.next;
            currentIndex += 1;
        }
        Node prevNode = current.previous;
        current.previous = new Node(value, current, current.previous);
        prevNode.next = current.previous;
    }

    public Node getMiddle(int index) throws Exception {
        if (index > this.length() - 1) {
            throw new Exception("List index out of range");
        }
        Node current = head;
        int currentIndex = 0;
        while (currentIndex < index) {
            current = current.next;
            currentIndex += 1;
        }
        return current;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            for (String info : current.value) {
                System.out.println(info);
            }
            current = current.next;
        }
    }

    // MTA use only!
    public void announceUptown() {
        Node current = head;
        while (current != null) {
            
            System.out.println("This is " + current.value.get(0));
            System.out.print("Transfer is available to the ");
            for (int i = 1; i < current.value.size(); i++) {
                System.out.print(current.value.get(i) + " ");
            }
            System.out.println("trains.");
            
            // This is a _____ bound __ train.

            current = current.next;

            if (current != null) {
                System.out.println("The next stop is " + current.value.get(0));
                System.out.println("Stand Clear of the Closing Doors Please");
                System.out.println("Ding Dong!");
                System.out.println("*clickety-clack clickety-clack*");
                System.out.println("");
            } else {
                System.out.println("This is the last stop of this train");
                System.out.println("Everyone please leave the train");
                System.out.println("Thank you for riding with MTA New York City transport!");
            }
        }
    }
}
