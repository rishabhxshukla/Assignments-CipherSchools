package cipherschools;

import java.util.ArrayList;

class GenerateSubsets
{
    static void print(ArrayList<Integer> ans)
    {
        for (int num : ans)
        {
            System.out.print(num + " ");
        }
        System.out.println();
    }


    static void helper(int arr[], ArrayList<Integer> ans, int begin)
    {
        print(ans);

        for (int i=begin; i<arr.length; i++)
        {
            ans.add(arr[i]);

            helper(arr, ans, i + 1);

            ans.remove(ans.size() - 1);
        }
    }


    public static void main(String args[]) 
    {
        int arr[] = {1, 2, 3};
        ArrayList<Integer> ans = new ArrayList<>();
        helper(arr, ans, 0);
    }
}