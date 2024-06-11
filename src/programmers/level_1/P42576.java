package programmers.level_1;

import java.util.*;

public class P42576 {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        if (participant.length == 1) return participant[0];

        for (int i = 0; i < completion.length; i++) {
            if (!Objects.equals(participant[i], completion[i])) {
                answer = participant[i];
                break;
            }
            if (i == completion.length - 1) answer = participant[i+1];
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] s = {"marina"};
        String[] s2 = {};

        System.out.println(solution(s, s2));
    }
}
