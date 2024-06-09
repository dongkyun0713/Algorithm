package programmers.level_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P12935 {
    public List<Integer> solution(int[] arr) {
        List<Integer> list= new ArrayList<>();
        if(arr.length == 1) {
            list.add(-1);
            return list;
        }
        //[4,3,2,1]

        for(Integer num : arr) list.add(num);
        Arrays.sort(arr);
        list.remove(list.indexOf(arr[0]));
        return list;
    }
}
