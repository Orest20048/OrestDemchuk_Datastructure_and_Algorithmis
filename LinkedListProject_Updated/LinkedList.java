public class LinkedList {
    private Node head;

    private class Node {
        int data;
        Node next;
        Node(int data) { 
            this.data = data; 
            this.next = null;
        }
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) { 
            head = newNode; 
            return; 
        }
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    public void insertAfter(Node prev, int data) {
        if (prev == null) { 
            System.out.println("Prev node is null"); 
            return; 
        }
        Node newNode = new Node(data);
        newNode.next = prev.next;
        prev.next = newNode;
    }

    public void deleteNode(int pos) {
        if (head == null) { 
            System.out.println("Empty list"); 
            return; 
        }
        if (pos < 0) {
            System.out.println("Invalid position");
            return;
        }
        if (pos == 0) { 
            head = head.next; 
            System.out.println("Deleted head"); 
            return; 
        }
        Node temp = head;
        for (int i = 0; temp != null && i < pos - 1; i++) temp = temp.next;
        if (temp == null || temp.next == null) { 
            System.out.println("Invalid position"); 
            return; 
        }
        temp.next = temp.next.next;
        System.out.println("Deleted node at position " + pos);
    }

    public void deleteAtEnd() {
        if (head == null) { 
            System.out.println("Empty list"); 
            return; 
        }
        if (head.next == null) { 
            head = null; 
            System.out.println("Deleted the only node"); 
            return; 
        }
        Node temp = head;
        while (temp.next.next != null) temp = temp.next;
        temp.next = null;
        System.out.println("Deleted last node");
    }

    public boolean search(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) return true;
            current = current.next;
        }
        return false;
    }

    public void printList() {
        if (head == null) { 
            System.out.println("Empty list"); 
            return; 
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtEnd(1);
        list.insertAtBeginning(2);
        list.insertAtBeginning(3);
        list.insertAtEnd(4);
        list.insertAfter(list.head.next, 5);

        System.out.println("Initial list:");
        list.printList();

        list.deleteNode(0);
        list.deleteNode(1);
        list.deleteNode(5);
        list.deleteAtEnd();

        System.out.println("After deletions:");
        list.printList();

        System.out.println("Searching for 2: " + (list.search(2) ? "Found" : "Not Found"));
        System.out.println("Searching for 5: " + (list.search(5) ? "Found" : "Not Found"));
    }
}
