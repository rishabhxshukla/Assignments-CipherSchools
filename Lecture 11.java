package cipherschools;

import java.util.ArrayList;

class GeneratePermutations
{
    static void print(ArrayList<Integer> ans)
    {
        for (int num : ans)
        {
            System.out.print(num + " ");
        }
        System.out.println();
    }


    static void helper(int arr[], ArrayList<Integer> ans)
    {
        if (ans.size() == arr.length) {
            print(ans);
            return;
        }

        for (int i=0; i<arr.length; i++)
        {
            if (ans.contains(arr[i])) {
                continue;
            }

            ans.add(arr[i]);

            helper(arr, ans);

            ans.remove(ans.size() - 1);
        }
    }


    public static void main(String args[]) 
    {
        int arr[] = {1, 2, 3};
        ArrayList<Integer> ans = new ArrayList<>();
        helper(arr, ans);
    }
}