package cipherschools;

class MaximumElement
{
    static int max(int arr[], int index)
    {
        if (index < 0) {
            return Integer.MIN_VALUE;
        }

        int temp = max(arr, index - 1);
        int max = Math.max(temp, arr[index]);

        return max;
    }


    static void helper(int left, int right, String output)
    {
        if (left > right) {
            return;
        }

        if (left == 0 && right == 0) {
            System.out.println(output);
            return;
        }

        if (left > 0) {
            helper(left - 1, right, output + "(");
        }
        
        if (right > 0) {
            helper(left, right - 1, output + ")");
        }
    }


    static void generateParenthesis(int n)
    {
        helper(n, n, "");
    }


    static int factorial(int n)
    {
        if (n == 1 || n == 0) {
            return 1;
        }

        int factorialAns = factorial(n - 1);
        int biggerProblemAns = factorialAns * n;

        return biggerProblemAns;
    }


    static int factorialUsingTailCall(int n, int ans)
    {
        if (n == 1) {
            return ans;
        }

        return factorialUsingTailCall(n - 1, ans * n);
    }


    public static void main(String[] args) 
    {
        int arr[] = {5, 2, 17, 13, 12, 15};
        int ans;

        //Max element
        ans = max(arr, arr.length-1);
        System.out.println("Max : " + ans);

        //Parenthesis
        System.out.println("Parenthesis :");
        generateParenthesis(3);

        //Factorial
        ans = factorial(5);
        System.out.println("Factorial : " + ans);

        //Factorial using tail
        ans = factorialUsingTailCall(5, 1);
        System.out.println("Factorial using tail : " + ans);
    }
}