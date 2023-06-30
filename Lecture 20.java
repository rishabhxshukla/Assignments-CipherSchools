package cipherschools;
import java.util.Stack;

class LargestAreaHistogram
{
    static int maxAreaInHistogram(int arr[])
    {
        Stack<Integer> s = new Stack<>();

        int maxArea = 0;
        int i = 0;

        while (i < arr.length)
        {
            int currentBuilding = arr[i];

            if (s.isEmpty() || currentBuilding >= arr[s.peek()])
            {
                s.push(i);
                i++;
            }
            else
            {
                int previousBar = s.pop();
                int height = arr[previousBar];
                int width;

                if (s.isEmpty()) {
                    width = i;
                }
                else {
                    width = i - s.peek() - 1;
                }

                int area = height * width;
                maxArea = Math.max(area, maxArea);
            }
        }

        while (!s.isEmpty())
        {
            int previousBar = s.pop();
            int height = arr[previousBar];
            int width;

            if (s.isEmpty()) {
                width = i;
            }
            else {
                width = i - s.peek() - 1;
            }

            int area = height * width;
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }


    public static void main(String args[]) 
    {
        int arr[] = {7, 6, 2, 4, 3, 5, 10};
        
        System.out.println(maxAreaInHistogram(arr));
    }
}