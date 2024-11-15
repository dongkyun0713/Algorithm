package leetcode;

import java.util.HashMap;
import java.util.Map;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] time : times) {
            if (!graph.containsKey(time[0])) {
                graph.put(time[0], new HashMap<>());
            }
            graph.get(time[0]).put(time[1], time[2]);
        }
        return 0;
    }
}
