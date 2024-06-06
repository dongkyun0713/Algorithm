package programmers.level_0;

import java.util.ArrayList;
import java.util.List;

public class P181931 {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        List<Boolean> incl = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int count = 0;
        for(boolean b : included){
            incl.add(b);
        }
        for (Boolean aBoolean : incl) {
            if (aBoolean) {
                res.add(count);
                count++;
            } else {
                count++;
            }
        }
        for (Integer re : res) {
            answer += (a + d * re);
        }
        return answer;
    }
}
