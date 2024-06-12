package programmers.level_1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class P42862 {
    public static int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> reverseSet = Arrays.stream(reserve).boxed().collect(Collectors.toSet());
        Set<Integer> lostSet = Arrays.stream(lost).boxed().collect(Collectors.toSet());
        Set<Integer> comapareSet = new HashSet<>(reverseSet);
        comapareSet.retainAll(lostSet);

        reverseSet.removeAll(comapareSet);
        lostSet.removeAll(comapareSet);

        for (int k : reverseSet) {
            if (lostSet.contains(k - 1)) lostSet.remove(k - 1);
            else lostSet.remove(k + 1);
        }

        return n - lostSet.size();
    }

    public static void main(String[] args) {
        int n = 24;
        int[] lost = {12, 13, 16, 17, 19, 20, 21, 22};
        int[] reverse = {1,22, 16, 18, 9, 10};

        System.out.println(solution(n,lost,reverse));
    }
}
