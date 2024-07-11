package level_2;

import java.util.HashMap;
import java.util.Map;

public class P42578 {
    public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            if (map.containsKey(clothes[i][1])) map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            else map.put(clothes[i][1], 2);
        }
        for(int k : map.values()){
            answer *= k;
        }
        return answer -1;
    }

    public static void main(String[] args) {
        String[][] arr = {{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(arr));
    }
}
