package cipherschools;

import org.w3c.dom.Node;

class DLLOperations
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

    static class DLLNode
    {
        int data;
        DLLNode next;
        DLLNode prev;

        DLLNode(char c)
        {
            this.data = c;
        }
    }

    DLLNode head;
}


class FirstUniqueCharacter
{
    static void printFirstUniqueCharacter(String str)
    {
        int size = str.length();
        Node charMap[] = new Node[256];
        DLLOperations dll = new DLLOperations();
        boolean repeated[] = new boolean[256];

        for (int i=0; i<size; i++)
        {
            char c = str.charAt(i);

            if (!repeated[c])
            {
                if (charMap[c] == null)
                {
                    dll.append(c);
                    charMap[c] = dll.last;
                }
                else
                {
                    dll.delete(charMap[c]);
                    repeated[c] = true;
                }
            }

            if (dll.head != null) {
                System.out.println("First unique character : ");
                System.out.println(dll.head);
            }
        }
    }
}