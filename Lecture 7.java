package cipherschools;

class PrintDecoding
{
    static void printAllDecoding(String number, String output)
    {
        if (number.length() == 0) {
            System.out.println(output);
            return;
        }

        String firstCharacter = number.substring(0, 1);
        int firstNumber = Integer.parseInt(firstCharacter);
        
        if (firstNumber != 0) {
            char character = (char) ('a' + firstNumber - 1);
            printAllDecoding(number.substring(1), output + character);
        }

        /*-------------------------------------------------------------------*/

        if (number.length() <= 1) {
            return;
        }

        String firstTwoCharacters = number.substring(0, 2);
        int firstTwoNumbers = Integer.parseInt(firstTwoCharacters);

        if (firstTwoNumbers <= 26) {
            if (firstTwoNumbers <= 0) {
                printAllDecoding(number.substring(2), output + "");
                return;
            }
            char character = (char) ('a' + firstTwoNumbers - 1);
            printAllDecoding(number.substring(2), output + character);
        }
    }


    public static void main(String args[]) 
    {
        printAllDecoding("12371", "");
    }
}