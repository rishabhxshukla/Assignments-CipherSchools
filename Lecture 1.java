package cipherschools;

class PeopleMeet
{
    static boolean isMeet(int p1, int p2, int s1, int s2)
    {
        if (p1 > p2 && s1 > s2) {
            return false;
        }

        if (p2 > p1 && s2 > s1) {
            return false;
        }
        
        while (p1 >= p2)
        {
            if (p1 == p2) {
                return true;
            }

            p1 = p1 + s1;
            p2 = p2 + s2;
        }

        return false;

    }

    
    static boolean isMeetOptimized(int p1, int p2, int s1, int s2)
    {
        if (p1 > p2 && s1 > s2) {
            return false;
        }

        if (p2 > p1 && s2 > s1) {
            return false;
        }

        int distanceToBeCovered = Math.abs(p1 - p2);
        int speedToBeUsed = Math.abs(s1 - s2);

        return (distanceToBeCovered % speedToBeUsed == 0);
    }


    public static void main(String args[]) 
    {
        boolean ans;

        int p1 = 3, s1 = 2;
        int p2 = 5, s2 = 7;

        System.out.println("Non-optimized approach : ");
        ans = isMeet(p1, p2, s1, s2);

        if(ans) {
            System.out.println("They meet!");
        }
        else {
            System.out.println("They do not meet!");
        }

        /*----------------------------------------------*/

        System.out.println("Optimized approach : ");
        ans = isMeetOptimized(p1, p2, s1, s2);

        if(ans) {
            System.out.println("They meet!");
        }
        else {
            System.out.println("They do not meet!");
        }
    }
}