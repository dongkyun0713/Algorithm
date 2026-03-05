package baekjoon.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class B17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Deque<Character> deque = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
           if (s.charAt(i) == '<') {
               int j = i;
               while (s.charAt(j) != '>') {
                   sb.append(s.charAt(j));
                   j++;
               }
               sb.append('>');
               i = j;
           } else {
               int j = i;
               while (true) {
                   if (j >= s.length()) {
                       break;
                   }

                   if (s.charAt(j) == '<') {
                       j--;
                       break;
                   }

                   if (s.charAt(j) == ' ') {
                       deque.addFirst(' ');
                       break;
                   }

                   deque.addLast(s.charAt(j));
                   j++;
               }

               while (!deque.isEmpty()) {
                   sb.append(deque.removeLast());
               }
               i = j;
           }
        }

        System.out.println(sb);
    }
}
