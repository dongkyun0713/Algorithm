package programmers.level_1;

import java.util.ArrayList;
import java.util.List;

public class P42840 {
    public int[] solution(int[] answers) {

        int[] p1 = {1, 2, 3, 4, 5};  // 5
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};  // 8
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};  // 10

        int p1Answer = 0;
        int p2Answer = 0;
        int p3Answer = 0;

        for (int i = 0; i < answers.length; ++i) {
            if (answers[i] == p1[i % 5]) ++p1Answer;
            if (answers[i] == p2[i % 8]) ++p2Answer;
            if (answers[i] == p3[i % 10]) ++p3Answer;
        }


        int maxCount = Math.max(p1Answer, Math.max(p2Answer, p3Answer));

        List<Integer> list = new ArrayList<>();

        if (p1Answer == maxCount) list.add(1);
        if (p2Answer == maxCount) list.add(2);
        if (p3Answer == maxCount) list.add(3);

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); ++i) {
            answer[i] = list.get(i);
        }


        return answer;
    }
}
