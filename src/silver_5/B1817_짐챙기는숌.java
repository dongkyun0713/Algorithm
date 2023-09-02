package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1817_짐챙기는숌 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        if(N == 0) System.out.println(0);

        else {
            String input2[] = br.readLine().split(" ");
            Stack<Integer> stack = new Stack<>();
            stack.push(M - Integer.parseInt(input2[0]));
            for (int i = 1; i < N; i++) {
                int b = Integer.parseInt(input2[i]);
                if (stack.peek() >= b) {
                    stack.push(stack.pop() - b);
                } else stack.push(M - b);
            }
            System.out.println(stack.size());
        }
    }
}
