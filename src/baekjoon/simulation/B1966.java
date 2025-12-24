package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int c = Integer.parseInt(br.readLine());

        for (int i = 0; i < c; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            Queue<Document> queue = new ArrayDeque<>();
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int importance = Integer.parseInt(st.nextToken());
                Document document = new Document(j, importance);
                queue.add(document);
                list.add(importance);
            }

            list.sort(Collections.reverseOrder());
            int count = 0;
            while (true) {

                int importance = list.get(count);
                Document document = queue.remove();
                if (document.importance != importance) {
                    queue.add(document);
                }
                else {
                    if (document.index == m) {
                        sb.append(count + 1).append("\n");
                        break;
                    }
                    else {
                        ++count;
                    }
                }
            }
        }
        System.out.println(sb);
    }

    private static class Document {
        int index;
        int importance;

        public Document(int index, int importance) {
            this.index = index;
            this.importance = importance;
        }
    }
}
