package cipherschools;
import java.util.Stack;

class CelebrityProblem
{
    static boolean findCelebrity(int matrix[][])
    {
        Stack<Integer> s = new Stack<>();

        for (int i=0; i<matrix.length; i++)
        {
            s.push(i);
        }

        while (s.size() >= 2)
        {
            int person1 = s.pop();
            int person2 = s.pop();

            if (matrix[person1][person2] == 1) {
                s.push(person2);
            }
            else {
                s.push(person1);
            }
        }

        int remaining = s.pop();

        for (int i=0; i<matrix.length; i++)
        {
            if (i != remaining) 
            {
                if (matrix[i][remaining] == 0 || matrix[remaining][i] == 1) {
                    return false;
                }
            }
        }

        return true;
    }


    public static void main(String args[]) 
    {
        int matrix[][] = {
                          {0, 0, 1, 0}, 
                          {0, 0, 1, 0},
                          {0, 0, 0, 0},
                          {0, 0, 1, 0}
                         };
        
        System.out.println(findCelebrity(matrix));
    }
}