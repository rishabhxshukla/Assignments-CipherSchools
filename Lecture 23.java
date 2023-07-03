package cipherschools;
import java.util.ArrayList;

class DiameterOfTree
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


    static int getHeight(Node root)
    {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);

        int ans = Math.max(left, right);
        return (ans + 1);
    }


    static int max = 0;
    static int getDiameter(Node root)
    {
        if (root == null) {
            return 0;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        max = Math.max(max, 1+left+right);

        int ans = Math.max(left, right);
        return (ans + 1);
    }


    class LongestPathRootToLeaf
    {
        static ArrayList<Integer> longestPath(Node root)
        {
            ArrayList<Integer> path = new ArrayList<>();

            path.add(root.data);
            ArrayList<Integer> leftLongest = longestPath(root.left);
            ArrayList<Integer> rightLongest = longestPath(root.right);

            ArrayList<Integer> result = getMax(leftLongest, rightLongest);
            if (result == null) {
                path.addAll(result);
            }

            return path;
        }


        static ArrayList<Integer>getMax (ArrayList<Integer> leftLongest, ArrayList<Integer> rightLongest) 
        {
            if (leftLongest.size() == 0 && rightLongest.size() == 0) {
                return null;
            }
            if (leftLongest == null) {
                return rightLongest;
            }
            if (rightLongest == null) {
                return leftLongest;
            }
            if (leftLongest.size() > rightLongest.size()) {
                return leftLongest;
            } 
            else {
                return rightLongest;
            }
}
    }


    public static void main(String args[]) 
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.left = new Node(7);

        System.out.println(getDiameter(root));
    }
}