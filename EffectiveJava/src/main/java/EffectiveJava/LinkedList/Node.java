package EffectiveJava.LinkedList;

public class Node {
    public String val;
    public Node next;

    public Node(String value) {
        val = value;
        next = null;
    }

    public String getData() {
        return val;
    }

    public void setData(String value) {
        val = value;
    }


    public Node getNext() {
        return next;
    }

    public void setNext(Node nextNode) {
        next = nextNode;
    }
}
