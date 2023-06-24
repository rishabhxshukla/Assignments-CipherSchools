package cipherschools;

class LargestNumberAfterKSwaps
{
    static String max = "0";

    static String swap(String s, int i, int j)
    {
        char ith = s.charAt(i);
        char jth = s.charAt(j);

        String left = s.substring(0, i);
        String middle = s.substring(i + 1, j);
        String right = s.substring(j + 1);

        return left + jth + middle + ith + right;
    }


    static void findMaximum(String str, int k)
    {
        if (Integer.parseInt(str) > Integer.parseInt(max)) {
            max = str;
        }

        if (k == 0) {
            return;
        }

        for (int i=0; i<str.length(); i++)
        {
            for (int j=(i+1); j<str.length(); j++)
            {
                if (str.charAt(i) < str.charAt(j))
                {
                    str = swap(str, i, j);
                    findMaximum(str, k - 1);
                    str = swap(str, i, j);
                }
            }
        }
    }


    public static void main(String args[]) 
    {
        String str = "254";
        int k = 2;
        findMaximum(str, k);
        System.out.println(max);
    }
}