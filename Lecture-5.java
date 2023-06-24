package cipherschools;

class TrappingRainwater
{
    static int getWaterUnits(int arr[])
    {
        int waterUnits = 0;
        int left[] = new int[arr.length];
        int right[] = new int[arr.length];

        left[0] = arr[0];
        for (int i=1; i<left.length; i++)
        {
            left[i] = Math.max(left[i - 1], arr[i]);
        }

        right[arr.length-1] = arr[arr.length-1];
        for (int i=(arr.length-2); i>=0; i--)
        {
            right[i] = Math.max(right[i + 1], arr[i]);
        }

        for (int i=0; i<arr.length; i++)
        {
            waterUnits = waterUnits + (Math.min(left[i], right[i]) - arr[i]);
        }

        return waterUnits;
    }


    public static void main(String args[]) 
    {
        int arr[] = {5, 0, 5, 3, 2, 1, 4};

        int ans = getWaterUnits(arr);
        System.out.println(ans);
    }
}