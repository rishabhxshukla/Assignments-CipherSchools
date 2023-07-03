package cipherschools;

class PerfectBinaryTree
{
    static class Node
    {
        int data;
        Node left, right;

        Node(int data)
        {
            this.data = data;
            this.left = this.right = null;
        }
    }


    static int deepestLevel(Node root)
    {
        int deepLevel = 0;
        
        while (root != null)
        {
            deepLevel++;
            root = root.left;
        }

        return deepLevel;
    }

    
    static boolean isPerfectBT(Node root, int currentLevel, int deepestLevel)
    {
        if (root.left == null && root.right == null) {
            if (currentLevel == deepestLevel) {
                return true;
            }

            return false;
        }

        if (root.left != null && root.right != null) {
            boolean isLeftPerfectBT = isPerfectBT(root.left, currentLevel + 1, deepestLevel);
            boolean isRightPerfectBT = isPerfectBT(root.right, currentLevel + 1, deepestLevel);

            return (isLeftPerfectBT && isRightPerfectBT);
        }

        return false;
    }


    public static void main(String args[]) 
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(isPerfectBT(root, 1, deepestLevel(root)));
    }
}