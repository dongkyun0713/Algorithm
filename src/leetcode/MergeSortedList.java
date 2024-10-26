package leetcode;

import java.util.PriorityQueue;

public class MergeSortedList {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for (int s : scoville) {
            priorityQueue.add(s);
        }
        int answer = 1;
        while (priorityQueue.size() >= 2) {
            priorityQueue.add(priorityQueue.poll() + (priorityQueue.poll() * 2));
            if (priorityQueue.peek() >= K) {
                return answer;
            }
            answer++;
        }

        return -1;
    }
}
