package programmers.level_1;

import java.util.Arrays;

public class P86051 {
    public int solution(int[] numbers) {
        int answer = 0;
        String s = Arrays.toString(numbers);

        if(!s.contains("1"))
            answer += 1;
        if(!s.contains("2"))
            answer += 2;
        if(!s.contains("3"))
            answer += 3;
        if(!s.contains("4"))
            answer += 4;
        if(!s.contains("5"))
            answer += 5;
        if(!s.contains("6"))
            answer += 6;
        if(!s.contains("7"))
            answer += 7;
        if(!s.contains("8"))
            answer += 8;
        if(!s.contains("9"))
            answer += 9;
        return answer;
    }
}
