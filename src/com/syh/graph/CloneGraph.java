package com.syh.graph;

import java.util.*;

/**
 * https://leetcode.com/problems/clone-graph/
 */
public class CloneGraph {

    public static void main(String[] args) {
        CloneGraph cg = new CloneGraph();
        Node n1, n2, n3, n4, nr;

        n1 = new Node(1);
        n2 = new Node(2);
        n3 = new Node(3);
        n4 = new Node(4);
        n1.addNeightbors(n2, n4);
        n2.addNeightbors(n1, n3);
        n3.addNeightbors(n2, n4);
        n4.addNeightbors(n1, n3);
        nr = cg.cloneGraph(n1);
        System.out.println(nr);

        n1 = new Node(1);
        n2 = new Node(2);
        n3 = new Node(3);
        n4 = new Node(4);
        n1.addNeightbors(n2);
        n2.addNeightbors(n1, n3);
        n3.addNeightbors(n2, n4);
        n4.addNeightbors(n3);
        nr = cg.cloneGraph(n1);
        System.out.println(nr);

        n1 = new Node(1);
        nr = cg.cloneGraph(n1);
        System.out.println(nr);
    }

    public Node cloneGraph(Node node) {
        if(null == node){
            return null;
        }

        Map<Integer, Node> exist = new HashMap<>();
        return dfs(exist, node, node.neighbors);
    }

    private Node dfs(Map<Integer, Node> exist, Node node, List<Node> neighbors) {
        if(exist.containsKey(node.val)){
            return exist.get(node.val);
        }

        Node n = new Node(), subNode;
        n.val = node.val;
        exist.put(n.val, n);

        List<Node> nbs = new ArrayList<>();
        if(null != neighbors)
            for(Node nb : neighbors){
                subNode = dfs(exist, nb, nb.neighbors);

                if(null != subNode)
                    nbs.add(subNode);
            }
        n.neighbors = nbs;

        return n;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public void addNeightbors(Node... nodes){
            this.neighbors = new ArrayList<>();
            this.neighbors.addAll(Arrays.asList(nodes));
        }

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for(Node node : neighbors){
                sb.append(node.val).append(", ");
            }

            return "Node{" +
                    "val=" + val +
                    ", neighbors=" + sb +
                    '}';
        }
    }
}
