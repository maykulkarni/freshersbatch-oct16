class DoublyLinkedListNode {
    int data;
    DoublyLinkedListNode prev;
    DoublyLinkedListNode next;

    DoublyLinkedListNode(int data) {
        this.data = data;
    }

}

public class DoublyLinkedList {
    DoublyLinkedListNode head;
    int size = 0;

    public void insert(int data) {
        if (head == null) {
            head = new DoublyLinkedListNode(data);
        } else {
            DoublyLinkedListNode toInsert = new DoublyLinkedListNode(data);
            DoublyLinkedListNode tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = toInsert;
            toInsert.prev = tmp;
        }
        size++;
    }

    public void printList() {
        DoublyLinkedListNode tmp = head;
        while (tmp.next != null) {
            System.out.print(tmp.data + "<->");
            tmp = tmp.next;
        }
        System.out.println(tmp.data);
    }

    public void countNode() {
        System.out.println("Size is : " + size);
    }

    public void deleteNode(int data) {
        DoublyLinkedListNode tmp = head;
        while (tmp != null && tmp.data != data) {
            tmp = tmp.next;
        }
        if (tmp == null) {
            System.out.println("Error, didnt found node");
            return;
        } else {
            DoublyLinkedListNode prev = tmp.prev;
            DoublyLinkedListNode next = tmp.next;
            if (prev == null) {
                head = head.next;
            } else if (next == null) {
                tmp.prev.next = null;
            } else {
                prev.next = next;
                next.prev = prev;
            }
        }
        size--;
    }

    public static void main(String[] args) {
        DoublyLinkedList dl = new DoublyLinkedList();
        dl.insert(1);
        dl.insert(2);
        dl.insert(3);
        dl.insert(4);
        dl.printList();
        dl.deleteNode(4);
        dl.printList();
        dl.countNode();
    }
}

