package programmers.level_1;

import java.util.*;


public class P12906 {
        public static int[] solution(int []arr) {

            Stack<Integer> stack = new Stack<>();
            stack.push(arr[0]);

            for (int i : arr) {
                int priorIndex = stack.peek();
                if (priorIndex != i) stack.push(i);
            }

            int[] answer = new int[stack.size()];

            for(int i = answer.length -1; i >= 0; i--) {
                answer[i] = stack.pop();
            }
            return answer;
        }

    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        System.out.println(Arrays.toString(solution(arr)));
    }
}
