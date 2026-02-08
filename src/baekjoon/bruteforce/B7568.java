package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7568 {
    static int N;
    
    static class People {
        int h, w, r;
        public People(int h, int w) {
            this.h = h;
            this.w = w;
            this.r = 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        People[] arr = new People[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[i] = new People(h, w);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <N; i++) {
            int rank = 1;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (arr[i].h < arr[j].h && arr[i].w < arr[j].w) rank++;
            }
            sb.append(rank).append(" ");
        }

        System.out.println(sb);
    }
}
