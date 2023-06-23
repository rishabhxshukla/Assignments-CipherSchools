package cipherschools;

class KSmallestElements
{
    static void kElements(int arr[], int k)
    {
        for (int i=k; i<arr.length; i++)
        {
            int currentElement = arr[i];
            int max = arr[k - 1];
            int maxPosition = k - 1;

            for(int j=k-2; j>=0; j--)
            {
                if (arr[j] > max)
                {
                    max = arr[j];
                    maxPosition = j;
                }
            }

            if (currentElement < max) 
            {
                while (maxPosition < k - 1)
                {
                    arr[maxPosition] = arr[maxPosition + 1];
                    maxPosition++;
                }
                arr[k - 1] = currentElement;
            }
        }

        for (int i=0; i<k; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }


    public static void main(String args[]) 
    {
        int arr[] = {50, 25, 100, 200, 30};

        kElements(arr, 2);
    }
}