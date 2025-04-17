package programmers.level_2;

import java.util.PriorityQueue;

public class P42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            minHeap.add(scoville[i]);
        }

        while (true) {
            if (minHeap.size() == 1) {
                break;
            }
            if (minHeap.peek() >= K) {
                break;
            } else {
                minHeap.add(minHeap.poll() + minHeap.poll() * 2);
                ++answer;
            }
        }

        if (minHeap.size() == 1 && minHeap.peek() < K) {
            return -1;
        }

        return answer;
    }
}
