package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1991 {
    static class Node {
        char value;
        Node left;
        Node right;

        public Node(char value) {
            this.value = value;
        }
    }

    static Node[] tree;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new Node[N + 1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char rootVal = st.nextToken().charAt(0);
            char leftVal = st.nextToken().charAt(0);
            char rightVal = st.nextToken().charAt(0);

            if (tree[rootVal - 'A'] == null) {
                tree[rootVal - 'A'] = new Node(rootVal);
            }

            if (leftVal != '.') {
                tree[leftVal - 'A'] = new Node(leftVal);
                tree[rootVal - 'A'].left = tree[leftVal - 'A'];
            }

            if (rightVal != '.') {
                tree[rightVal - 'A'] = new Node(rightVal);
                tree[rootVal - 'A'].right = tree[rightVal - 'A'];
            }

        }

        sb = new StringBuilder();
        preOrder(tree[0]);
        sb.append("\n");
        inOrder(tree[0]);
        sb.append("\n");
        postOrder(tree[0]);

        System.out.print(sb);

    }

    private static void preOrder(Node node) {
        if (node != null) {
            sb.append(node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private static void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            sb.append(node.value);
            inOrder(node.right);
        }
    }

    private static void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            sb.append(node.value);
        }
    }
}
