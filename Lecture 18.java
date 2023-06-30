package cipherschools;
import java.util.Stack;

class DuplicateParenthesis
{
    static boolean containsDuplicateParenthesis(String str)
    {
        Stack<Character> s = new Stack<>();

        for (int i=0; i<str.length(); i++)
        {
            char ch = str.charAt(i);

            if (ch != ')')
            {
                s.push(ch);
            }
            else
            {
                int removeElementsCount = 0;
                char top = s.pop();

                while (top != '(')
                {
                    top = s.pop();
                    removeElementsCount++;
                }

                if (removeElementsCount < 1) {
                    return true;
                }
            }
        }

        return false;
    }
}