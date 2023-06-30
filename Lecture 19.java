package cipherschools;
import java.util.Stack;

class SortStack
{
    static void sort(Stack<Integer> s)
    {
        if (s.isEmpty()) {
            return;
        }

        int e = s.pop();
        sort(s);
        addInStack(s, e);
    }


    static void addInStack(Stack<Integer> s, int e)
    {
        if (s.isEmpty() || e > s.peek()) {
            s.push(e);
            return;
        }

        int temp = s.pop();
        addInStack(s, e);
        s.push(temp);
    }


    public static void main(String args[]) 
    {
        Stack<Integer> s = new Stack<>();
        s.push(4);
        s.push(1);
        s.push(2);
        s.push(9);
        s.push(7);

        sort(s);

        System.out.println(s);
    }
}