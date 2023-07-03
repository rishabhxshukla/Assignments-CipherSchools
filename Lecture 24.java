package cipherschools;

class FullBinaryTree
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


    static boolean isFullBT(Node root)
    {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left != null && root.right != null) {
            boolean left = isFullBT(root.left);
            boolean right = isFullBT(root.right);

            return (left && right);
        }

        return false;
    }


    static int countNodes(Node root)
    {
        if (root == null) {
            return 0;
        }

        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return (1 + left + right);
    }


    static boolean isCompleteBT(Node root, int index, int numberOfNodes)
    {
        if (root == null) {
            return true;
        }

        if (index >= numberOfNodes) {
            return false;
        }

        boolean isLeftCompleteBT = isCompleteBT(root.left, 2 * index + 1, numberOfNodes);
        boolean isRightCompleteBT = isCompleteBT(root.right, 2 * index + 2, numberOfNodes);

        return (isLeftCompleteBT && isRightCompleteBT);
    }


    public static void main(String args[]) 
    {
        Node root = new Node(18);
        root.left = new Node(15);
        root.left.left = new Node(40);
        root.left.left.left = new Node(30);
        root.left.left.right = new Node(50);
        root.left.right = new Node(50);
        root.right = new Node(20);

        System.out.println(isFullBT(root));
        System.out.println(isCompleteBT(root, 0, countNodes(root)));
    }
}