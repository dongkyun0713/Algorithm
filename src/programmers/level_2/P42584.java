package level_2;

/*
level-2
주식가격
prices	        return
[1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
큐 안쓰고 배열로만 풀 수 있지만.. 억지로 큐 썼음 ㅋㅋ
*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P42584 {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> queue = new LinkedList<>();

        for (int price : prices) {
            queue.add(price);
        }
        for (int i = 0; i < prices.length; i++){
            int currentPrice = queue.remove();
            int count = 0;
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j] < currentPrice) {
                    count++;
                    break;
                }
                else count++;
            }
            answer[i] = count;

        }
        return answer;
    }
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};

        System.out.println(Arrays.toString(solution(prices)));
    }
}
