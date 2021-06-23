package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author fanzhen
 * @version 1.0
 * @date 2021/6/22
 */
public class MyBinaryTree {
    private TreeNode root;

    public MyBinaryTree(Integer[] input) {
        root = buildTree(input, 0);
    }

    private TreeNode buildTree(Integer[] input, int i) {
        if (i >= input.length) {
            return null;
        }

        if (input[i] == null) {
            return null;
        }

        TreeNode root = new TreeNode(input[i]);

        int left = 2 * i + 1;
        int right = 2 * (i + 1);

        root.left = buildTree(input, left);
        root.right = buildTree(input, right);

        return root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public TreeNode getByVal(int val) {
        return getByValRec(root, val);
    }

    private TreeNode getByValRec(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (val == root.val) {
            return root;
        }

        TreeNode node = getByValRec(root.left, val);
        if (node != null) {
            return node;
        }

        return getByValRec(root.right, val);
    }

    public static void print(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            System.out.print("[");
            while (count-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

                System.out.print(node.val + ", ");
            }
            System.out.println("]");
        }
    }
}
