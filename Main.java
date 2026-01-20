class DoublyLinkedListDemo {

    // Node class
    static class Node {
        int value;
        Node next, prev;
        Node(int value) { this.value = value; }
    }

    Node head, tail;

    // 1️⃣ Insert at beginning → O(1)
    void insertAtBeginning(int value) {
        Node newNode = new Node(value);
        if (head == null) { head = tail = newNode; }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // 2️⃣ Insert at end → O(1)
    void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (tail == null) { head = tail = newNode; }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // 3️⃣ Display forward → O(n)
    void displayForward() {
        System.out.print("Forward: ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Display backward → O(n)
    void displayBackward() {
        System.out.print("Backward: ");
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    // 4️⃣ Delete first node → O(1)
    void deleteFirst() {
        if (head == null) return;
        if (head == tail) { head = tail = null; return; }
        head = head.next;
        head.prev = null;
    }

    // Delete last node → O(1)
    void deleteLast() {
        if (tail == null) return;
        if (head == tail) { head = tail = null; return; }
        tail = tail.prev;
        tail.next = null;
    }

    // 5️⃣ Delete node by value → O(n)
    void deleteByValue(int value) {
        Node temp = head;
        while (temp != null && temp.value != value) temp = temp.next;
        if (temp == null) return; // value not found
        if (temp == head) deleteFirst();
        else if (temp == tail) deleteLast();
        else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    // 6️⃣ Delete node before a given value → O(n)
    void deleteBeforeValue(int value) {
        Node temp = head;
        while (temp != null && temp.value != value) temp = temp.next;
        if (temp == null || temp.prev == null) return; // no node before
        deleteByValue(temp.prev.value);
    }

    // 7️⃣ Delete node after a given value → O(n)
    void deleteAfterValue(int value) {
        Node temp = head;
        while (temp != null && temp.value != value) temp = temp.next;
        if (temp == null || temp.next == null) return; // no node after
        deleteByValue(temp.next.value);
    }

    // 8️⃣ Find minimum → O(n)
    int findMin() {
        if (head == null) return -1;
        int min = head.value;
        Node temp = head.next;
        while (temp != null) {
            if (temp.value < min) min = temp.value;
            temp = temp.next;
        }
        return min;
    }

    // Find maximum → O(n)
    int findMax() {
        if (head == null) return -1;
        int max = head.value;
        Node temp = head.next;
        while (temp != null) {
            if (temp.value > max) max = temp.value;
            temp = temp.next;
        }
        return max;
    }
    public static void main(String[] args) {
        DoublyLinkedListDemo dll = new DoublyLinkedListDemo();

        // Insert at beginning
        dll.insertAtBeginning(10);
        dll.insertAtBeginning(20);

        // Insert at end
        dll.insertAtEnd(30);
        dll.insertAtEnd(40);
        dll.insertAtEnd(5);
        dll.insertAtEnd(50);

        // Display
        dll.displayForward();
        dll.displayBackward();

        // Delete operations
        dll.deleteFirst();
        dll.deleteLast();
        dll.deleteByValue(20);
        dll.deleteBeforeValue(30);
        dll.deleteAfterValue(20);

        // Display after deletions
        System.out.print("After deletions Forward: ");
        dll.displayForward();
        System.out.println("Minimum value: " + dll.findMin());
        System.out.println("Maximum value: " + dll.findMax());

        // Time complexity summary
        System.out.println("\nTime Complexities:");
        System.out.println("Insert at beginning/end: O(1)");
        System.out.println("Delete first/last: O(1)");
        System.out.println("Delete by value / before / after: O(n)");
        System.out.println("Find min/max: O(n)");
    }
}
