package cipherschools;

class NQueen
{
    static boolean placeQueens(int board[][], int row)
    {
        if (row == board.length) {
            printBoard(board);
            System.out.println("\n");
            return false;
        }

        for (int i=0; i<board.length; i++)
        {
            if (isSafeToPlace(board, row, i))
            {
                board[row][i] = 1;

                boolean canPlaceQueens = placeQueens(board, row + 1);

                if (canPlaceQueens) {
                    return true;
                }

                board[row][i] = 0;
            }
        }

        return false;
    }


    static boolean isSafeToPlace(int board[][], int currentRow, int currentIndex)
    {
        for (int i=0; i<currentRow; i++)
        {
            if (board[i][currentIndex] == 1) {
                return false;
            }
        }

        int x = currentRow;
        int y = currentIndex;

        while (x >=0 && y >= 0)
        {
            if (board[x][y] == 1) {
                return false;
            }
            x--;
            y--;
        }

        x = currentRow;
        y = currentIndex;

        while (x >=0 && y < board.length)
        {
            if (board[x][y] == 1) {
                return false;
            }
            x--;
            y++;
        }

        return true;
    }


    static void printBoard(int board[][])
    {
        for (int i=0; i<board.length; i++)
        {
            for (int j=0; j<board[0].length; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String args[]) 
    {
        int n = 4;
        int board[][] = new int[n][n];
        placeQueens(board, 0);
    }
}