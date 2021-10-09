/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        HashSet<Node> copied = new HashSet<>();
        return copyNode(node, copied);

    }

    public Node copyNode(Node n, HashSet<Node> copied) {

        if (n == null || copied.contains(n)) {
            return null;
        }

        Node newNode = new Node(n.val);

        ArrayList<Node> newNeighbors = new ArrayList<>();

        for (Node neighbor : n.neighbors) {

            if (!copied.contains(neighbor)) {
                copied.add()
                copyNode(neighbor, copied);

            }
            Node newNeighbor = copyNode(neighbor, copied);
            if (newNeighbor != null) {
                neighbors.add(newNeighbor);
            }
        }

        newNode.neighbors = newNeighbors;

        return newNode;

    }





}