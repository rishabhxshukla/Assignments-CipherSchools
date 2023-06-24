package cipherschools;

class ClineLLWithRandomPointers
{
    static class Node
    {
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }


    static Node create(Node head)
    {
        Node original = head;

        if (head == null) {
            return head;
        }

        while (original != null && original.next != null)
        {
            Node cloneNode = new Node(original.data);
            Node next = original.next;
            original.next = cloneNode;
            cloneNode.next = next;
            original = original.next.next;
        }

        original.next = new Node(original.data);

        original = head;

        while (original != null && original.next != null)
        {
            if (original.random != null)
            {
                original.next.random = original.random.next;
            }

            original = original.next;
        }

        original = head;

        Node copy = head.next;
        Node newHead = head.next;

        while (original.next != null && copy.next != null)
        {
            original.next = original.next.next;
            copy.next = copy.next.next;
            original = original.next;
            copy = copy.next;
        }

        original.next = null;

        return newHead;
    }
}