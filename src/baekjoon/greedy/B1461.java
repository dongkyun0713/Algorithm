package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> posBooks = new ArrayList<>();
        List<Integer> negBooks = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int book = Integer.parseInt(st.nextToken());
            if (book > 0) {
                posBooks.add(book);
            } else {
                negBooks.add(book);
            }
        }

        Collections.sort(posBooks, Collections.reverseOrder());
        Collections.sort(negBooks);

        int answer = 0;

        for (int i = 0; i < posBooks.size(); i += M) {
            answer += posBooks.get(i) * 2;
        }

        for (int i = 0; i < negBooks.size(); i += M) {
            answer += Math.abs(negBooks.get(i)) * 2;
        }

        int posMax = 0;
        int negMax = 0;
        if (!posBooks.isEmpty()) posMax = posBooks.get(0);
        if (!negBooks.isEmpty()) negMax = Math.abs(negBooks.get(0));
        answer -= Math.max(posMax, negMax);

        System.out.println(answer);
    }
}
