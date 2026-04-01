/*
Definition for a Node.
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
        Map<Integer, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    private Node dfs(Node src, Map<Integer, Node> map) {
        if(src == null) {
            return src;
        }
        if(map.containsKey(src.val)) {
            return map.get(src.val);
        }
        Node node = new Node(src.val);
        map.put(node.val, node);
        for(Node neighbour: src.neighbors) {
            node.neighbors.add(dfs(neighbour, map));
        }
        return node;
    }
}