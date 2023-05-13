package EffectiveJava.LinkedList;

public class LinkedList {
    public Node head;
    public int count;
    public LinkedList(Node headNode) {
        head = headNode;
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public void insert(String data) {
        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
        count++;
    }

    public Node find(String val) {
        Node item = head;
        while(item != null) {
            if(item.getData() == val) {
                return item;
            } else {
                item = item.getNext();
            }
        }
        return item;
    }

    public void deleteAt(int index) {
        if (index > count-1) {
            return;
        }

        if(index == 0 ) {
            head = head.getNext();
        } else {
            var tempIndex = 0;
            Node currentNode = head;
            while(tempIndex < index -1) {
                currentNode = currentNode.getNext();
                tempIndex+=1;
            }
            currentNode.setNext(currentNode.getNext().getNext());
            count-=1;
        }

    }

    public void dumpList() {
        Node tempNode = head;
        while(tempNode != null) {
            System.out.println("Node: " + tempNode.getData());
            tempNode = tempNode.getNext();
        }
    }
}
