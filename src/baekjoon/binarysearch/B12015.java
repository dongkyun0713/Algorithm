package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> list = new ArrayList<>();

        list.add(arr[0]);

        for (int i = 1; i < N; i++) {
            int key = arr[i];
            if (key > list.get(list.size() - 1)) {
                list.add(key);
            } else {
                int left = 0;
                int right = list.size() - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (list.get(mid) >= key) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                list.set(left, key);
            }
        }
        System.out.println(list.size());
    }
}
