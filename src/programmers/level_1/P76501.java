package programmers.level_1;

public class P76501 {
    // signs가 [true,false,true] 이므로, 실제 수들의 값은 각각 4, -7, 12입니다.
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0; i < absolutes.length; i++) {
            if(signs[i] == false) absolutes[i] *= -1;

            answer += absolutes[i];
        }
        return answer;
    }
}
