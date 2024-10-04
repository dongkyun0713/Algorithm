package level_2;
/*
level-2
기능개발
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class P42586 {
    public static int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> s = new Stack<>();
        List<Integer> l = new ArrayList<>();

        for(int i = progresses.length -1; i >=0; i--){
            s.push((int) Math.ceil(((double)100 - progresses[i]) / speeds[i]));
        }

        // 9 3 7
        while(!s.empty()) {
            int count = 1;
            int day = s.pop();  // 걸리는 날짜
            while(!s.empty() && s.peek() <= day){
                s.pop();
                count++;
            }
            l.add(count);
        }

        int[] answer = new int[l.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = l.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {93, 30, 55};
        int[] arr2 = {1, 30, 5};
        System.out.println(Arrays.toString(solution(arr, arr2)));
    }
}
