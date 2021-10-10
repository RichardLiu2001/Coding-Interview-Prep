/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {

    // Solution 1 
    public Node connect(Node root) {
        
        if (root == null) {
            return root;
        }

        // initialize a queue which contains the root
        Queue<Node> Q = new LinkedList<Node>();
        Q.add(root);

        // outer loop iterates over each level
        while(Q.size() > 0) {

            // note the size of the queue
            int size = Q.size();

            // Iterate over nodes on the current level
            for (int i = 0; i < size; i ++) {

                // Pop a node from the front of the queue
                Node currentNode = Q.poll();

                // check if it's not the last one. Last one does not have it's next field updated
                if (i < size - 1) {
                    currentNode.next = Q.peek();
                }

                if (currentNode.left != null) {
                    Q.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    Q.add(currentNode.right);
                }

            }

        }
        return root;

    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        // Start with the root node, no next pointers need to be established on the first level
        Node leftmost = root;

        while (leftmost.left != null) {
            // Iterate the "linked list" starting from the head node and using the next pointers,
            // establish the corresponding links for the next level

            Node head = leftmost;

            while (head != null) {

                // Connection 1
                head.left.next = head.right;

                // Connection 2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                head = head.next;

            }

            leftmost = leftmost.left;

        }

        return root; 

    }

}
