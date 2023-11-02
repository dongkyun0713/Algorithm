package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B28278_스택2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String[] command = br.readLine().split(" ");
            if (command[0].equals("1")) stack.push(command[1]);
            else if (command[0].equals("2") && !stack.isEmpty()) sb.append(stack.pop()).append("\n");
            else if (command[0].equals("2")) sb.append("-1").append("\n");
            else if (command[0].equals("3")) sb.append(stack.size()).append("\n");
            else if (command[0].equals("4") && stack.isEmpty()) sb.append("1").append("\n");
            else if (command[0].equals("4")) sb.append("0").append("\n");
            else if (command[0].equals("5") && !stack.isEmpty()) sb.append(stack.peek()).append("\n");
            else sb.append("-1").append("\n");
        }
        System.out.println(sb);
    }
}
