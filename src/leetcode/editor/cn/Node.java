package leetcode.editor.cn;

import java.util.List;

/**
 * @author fanzhen
 * @version v1
 * @date 2021/6/15
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }


    // offer 36
//    public int val;
//    public Node left;
//    public Node right;
//
//    public Node() {}
//
//    public Node(int _val) {
//        val = _val;
//    }
//
//    public Node(int _val, Node _left, Node _right) {
//        val = _val;
//        left = _left;
//        right = _right;
//    }
}
