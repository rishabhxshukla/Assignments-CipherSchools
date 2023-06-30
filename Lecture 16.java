package cipherschools;

class MergeKLinkedLists
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


    
    static Node mergeKLists(Node arr[])
    {
        int remaining = arr.length - 1;
        
        while (remaining != 0)
        {
            int i = 0;
            int k = remaining;

            while (i < k)
            {
                arr[i] = mergeTwoSortedLL(arr[i], arr[k]);
                i++;
                k--;

                if (i >= k) {
                    remaining = k;
                }
            }
        }

        return arr[0];
    }


    static Node mergeTwoSortedLL(Node l1, Node l2)
    {
        Node sortedResult = null;
        
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.data <= l2.data)
        {
            sortedResult = l1;
            sortedResult.next = mergeTwoSortedLL(l1.next, l2);
        }
        else
        {
            sortedResult = l2;
            sortedResult.next = mergeTwoSortedLL(l1, l2.next);
        }

        return sortedResult;
    }


    public static void main(String args[]) 
    {
        Node arr[] = new Node[4];

        Node n1 = new Node(1);
        n1.next = new Node(3);
        n1.next.next = new Node(5);
        n1.next.next.next = new Node(8);
        n1.next.next.next.next = new Node(11);

        arr[0] = n1;

        Node n2 = new Node(2);
        n2.next = new Node(6);
        n2.next.next = new Node(10);

        arr[1] = n2;


        Node n3 = new Node(4);
        n3.next = new Node(8);
        n3.next.next = new Node(11);

        arr[2] = n3;

        mergeKLists(arr);

        print();
    }
}