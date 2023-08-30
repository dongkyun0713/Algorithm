package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class B10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            if (arr.length == 2) stack.push(Integer.parseInt(arr[1]));
            else {
                if (arr[0].equals("pop") && stack.size() != 0) {
                    int a = stack.pop();
                    System.out.println(a);
                } else if (arr[0].equals("pop") && stack.size() == 0) {
                    System.out.println(-1);
                } else if (arr[0].equals("size")) {
                    System.out.println(stack.size());
                } else if (arr[0].equals("empty")) {
                    if (stack.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                } else if (arr[0].equals("top") && stack.size() != 0) {
                    System.out.println(stack.get(stack.size() - 1));
                } else if (arr[0].equals("top") && stack.size() == 0) {
                    System.out.println(-1);
                }
            }
        }
    }
}