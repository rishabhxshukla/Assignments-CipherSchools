package cipherschools;

class SearchInSortedMatrix2
{
    static boolean isExist(int matrix[][], int target)
    {
        int i = 0;
        int j = matrix[0].length - 1;

        while (i < matrix.length && j >=0)
        {
            int current = matrix[i][j];

            if (current == target) {
                return true;
            }
            if (current > target)
                j--;
            else
                i++;
        }

        return false;
    }


    public static void main(String args[])
    {
        boolean ans;

        int matrix[][] = {
                          {1, 2, 3, 4}, 
                          {5, 6, 7, 8},
                          {9, 10, 11, 12},
                          {13, 14, 15, 16}
                         };
        
        ans = isExist(matrix, 8);
        System.out.println(ans);

        ans = isExist(matrix, -1);
        System.out.println(ans);
    }
}