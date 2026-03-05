package baekjoon.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class B16120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Deque<Character> dq = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            dq.addLast(s.charAt(i));
            if (dq.size() >= 4) {
                char d = dq.removeLast();
                char c = dq.removeLast();
                char b = dq.removeLast();
                char a = dq.removeLast();
                if (a == 'P' && b == 'P' && c == 'A' && d == 'P') {
                    dq.addLast('P');
                } else {
                    dq.addLast(a);
                    dq.addLast(b);
                    dq.addLast(c);
                    dq.addLast(d);
                }
            }
        }

        if (dq.size() == 1 && dq.peekLast() == 'P') System.out.println("PPAP");
        else System.out.println("NP");
    }
}
