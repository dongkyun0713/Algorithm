package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B10845_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            if (arr.length == 2) q.add(Integer.parseInt(arr[1]));
            else {
                if (arr[0].equals("pop") && q.size() !=0) {
                    int a = q.poll();
                    System.out.println(a);
                } else if (arr[0].equals("pop") && q.size() == 0) {
                    System.out.println(-1);
                } else if (arr[0].equals("size")) {
                    System.out.println(q.size());
                } else if (arr[0].equals("empty")) {
                    if (q.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                } else if (arr[0].equals("front") && q.size() != 0) {
                    int a = q.peek();
                    System.out.println(a);
                }else if (arr[0].equals("front") && q.size() == 0) {
                    System.out.println(-1);
                }
                else if (arr[0].equals("back") && q.size() != 0) {
                    Integer lastValue = ((LinkedList<Integer>) q).peekLast();
                    System.out.println(lastValue);
                }
                else if (arr[0].equals("back") && q.size() == 0) {
                    System.out.println(-1);
                }
            }
        }
    }
}