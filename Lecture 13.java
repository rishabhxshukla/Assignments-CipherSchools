package cipherschools;

class ReverseLL
{
    static Node head;
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


    static void print()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }


    static void create(int data)
    {
        Node new_node = new Node(data);
        
        if(head == null) {
            head = new_node;
            return;
        }

        Node temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
        }

        temp.next = new_node;
        new_node.next = null;
    }


    static void reverse()
    {
        Node prev = null;
        Node temp = head;
        Node next = null;

        while (temp != null)
        {
            next = temp.next;
            temp.next = prev;

            prev = temp;
            temp = next;
        }
        head = prev;
    }


    public static void main(String args[]) 
    {
        //Create
        create(1);
        create(2);
        create(3);
        create(4);
        create(5);

        //Print
        System.out.print("Original LL : ");
        print();
        System.out.println(", Head : " + head.data);

        //Reversing
        reverse();

        //Print
        System.out.print("New LL : ");
        print();
        System.out.println(", Head : " + head.data);
    }
}