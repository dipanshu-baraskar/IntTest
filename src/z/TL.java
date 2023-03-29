package z;

public class TL {
    public static class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    Node head;

    public void add(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = n;
    }

    public void reverse() {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head = prev;
    }

    public static void display(Node h) {
        Node temp = h;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static Node add(Node l1, Node l2) {
        Node dummy = new Node(-1);
        Node temp = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum / 10;
            Node node = new Node(sum % 10);
            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        TL ll1 = new TL();
        ll1.add(2);
        ll1.add(4);
        ll1.add(3);
        ll1.reverse();
        TL ll2 = new TL();
        ll2.add(9);
        ll2.add(7);
        ll2.add(6);
        ll2.add(5);
        ll2.reverse();

        ll1.display(ll1.head);
        ll2.display(ll2.head);


        Node res = add(ll1.head, ll2.head);
        display(res);


    }
}
