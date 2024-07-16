package level_2;
/*
level-2
프로세스
입출력 예
priorities	        location	return
[2, 1, 3, 2]	    2	        1
[1, 1, 9, 1, 1, 1]	0	        5
 */
import java.util.*;

public class P42587 {
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int priority : priorities) {
            queue.offer(priority);  // 2,1,3,2
            priorityQueue.offer(priority);  // 내림차순으로 정렬됨 / 3,2,2,1
        }

        while (!queue.isEmpty()) {
            int currentPriority = queue.poll();

            if (currentPriority < priorityQueue.peek()) {  // 현재 프로세스의 우선순위가 가장 높은 우선순위와 다르다면,
                queue.offer(currentPriority);  // 다시 큐에 추가

                if (location == 0) {  // location이 0이면
                    location = queue.size() - 1;  // location을 맨 끝으로 설정
                } else {  // 0이 아니면
                    location--;  // location 재설정
                }
            } else {  // 현재 프로세스가 우선순위가 가장 높은 큐보다 크거나 같으면
                priorityQueue.poll();  // 우선순위큐 front 삭제
                answer++;  // 카운트

                if (location == 0) {
                    break;
                } else {
                    location--;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] priorities1 = {2, 1, 3, 2};
        int location1 = 2;
        System.out.println(solution(priorities1, location1)); // Output: 1

        int[] priorities2 = {1, 1, 9, 1, 1, 1};
         int location2 = 0;
        System.out.println(solution(priorities2, location2)); // Output: 5
}
}
