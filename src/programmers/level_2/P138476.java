package programmers.level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class P138476 {
    public int solution(int k, int[] tangerine) {
        //[1, 3, 2, 5, 4, 5, 2, 3]
        int answer = 0;
        int count = 1;
        Arrays.sort(tangerine);
        // 1, 2, 2, 3, 3, 4, 5, 5
        ArrayList<Integer> a = new ArrayList<>();
        for(int i =0; i < tangerine.length; i++) {  // 같은 값이 나온 횟수를 arraylist에 저장
            if(i == tangerine.length-1) {
                a.add(count);
                break;
            }
            if(tangerine[i] != tangerine[i+1]){
                a.add(count);
                count = 1;
            }
            else{
                count++;
            }
        }
        // 리스트a {1, 2, 2, 1, 2)
        Collections.sort(a, Collections.reverseOrder());  // 내림차순 정렬{2, 2, 2, 1, 1}
        Iterator<Integer> it = a.iterator();
        while (it.hasNext()){
            k -= it.next();
            answer++;
            if(k<=0) break;
        }
        if(answer ==0) return 1;
        return answer;
    }
}