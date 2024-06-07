package programmers.level_1;

import java.util.HashSet;
import java.util.Set;

public class P1845 {
    public static int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();

        for (int k : nums) {
            set.add(k);
        }

        return Math.min(set.size(), nums.length / 2);
    }

    public static void main(String[] args) {
        int[] arr = {3,1,2,3};
        System.out.println(solution(arr));
    }
}
