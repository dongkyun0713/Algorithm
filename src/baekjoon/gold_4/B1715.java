package baekjoon.gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        PriorityQueue <Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            minHeap.add(Integer.parseInt(br.readLine()));

        }
        int sum = 0;
        while (minHeap.size() > 1){
            sum = minHeap.poll() + minHeap.poll();
            answer += sum;
            minHeap.add(sum);
        }

        System.out.println(answer);
    }
}
