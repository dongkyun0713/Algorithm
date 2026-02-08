package baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class B15659 {
    static int N;
    static int[] arr;
    static int[] op = new int[4]; // +,-,*,/
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) op[i] = Integer.parseInt(st.nextToken());

        List<Integer> nums = new ArrayList<>();
        List<Integer> ops = new ArrayList<>();

        nums.add(arr[0]);
        dfs(0, nums, ops);

        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int idx, List<Integer> nums, List<Integer> ops) {
        if (idx == N - 1) {
            int value = eval(nums, ops);
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }

        nums.add(arr[idx + 1]);

        for (int i = 0; i < 4; i++) {
            if (op[i] == 0) continue;

            op[i]--;
            ops.add(i);

            dfs(idx + 1, nums, ops);

            ops.remove(ops.size() - 1);
            op[i]++;
        }

        nums.remove(nums.size() - 1);
    }

    private static int eval(List<Integer> nums, List<Integer> ops) {
        List<Integer> nums2 = new ArrayList<>();
        List<Integer> ops2 = new ArrayList<>();

        nums2.add(nums.get(0));

        for (int i = 0; i < ops.size(); i++) {
            int oper = ops.get(i);
            int b = nums.get(i + 1);

            if (oper == 2 || oper == 3) {
                int a = nums2.remove(nums2.size() - 1);
                int res = (oper == 2) ? (a * b) : (a / b);
                nums2.add(res);
            } else {
                ops2.add(oper);
                nums2.add(b);
            }
        }

        int result = nums2.get(0);
        for (int i = 0; i < ops2.size(); i++) {
            int oper = ops2.get(i);
            int b = nums2.get(i + 1);
            if (oper == 0) result += b;
            else result -= b;
        }

        return result;
    }
}
