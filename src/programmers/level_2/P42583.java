package level_2;
/*
level-2
다리를 지나는 트럭
입출력 예
bridge_length	weight	truck_weights	return
2	            10	    [7,4,5,6]	    8
100	            100    	[10]	        101
 */
import java.util.LinkedList;
import java.util.Queue;

public class P42583 {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;  // 걸린 시간
        Queue<Integer> queue = new LinkedList<>();
        int weightSum = 0;  // 트럭 무게 합
        
        for (int truck : truck_weights) {
            while (true) {
                if (queue.isEmpty()) {  // 다리 위에 트럭이 없을 경우
                    queue.add(truck);  // 다리에 트럭 추가
                    weightSum += truck;  // 트럭 무게 추가
                    time++;  // 걸린 시간 증가
                    break;
                }
                // 다리 위에 트럭이 다 올라가있을 때
                else if (queue.size() == bridge_length) {
                    weightSum -= queue.poll();
                }
                //
                else {
                    if (weightSum + truck > weight) { // 현재 다리위의 트럭 무게와 다음 들어올 트럭 무게 합이 다리가 버틸 수 있는 무게보다 크다면
                       queue.add(0);
                        time++;
                    } else {  // 다음 트럭이 다리 위에 올라갈 수 있다면
                        queue.add(truck);
                        weightSum += truck;
                        time++;
                        break;
                    }
                }
            }
        }
        int answer = time + bridge_length;  // 걸린 시간 + 마지막 트럭 통과시간
        return answer;
    }
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};

        System.out.println(solution(bridge_length, weight, truck_weights));
    }
}
