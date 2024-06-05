package baekjoon.silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.*;
public class B18870_좌표압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input[] = br.readLine().split(" ");
        int arr[] = new int[n];
        int arr2[] = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            arr[i] = arr2[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr2);
        int rank = 0;
        for(int k : arr2) {
            if(!map.containsKey(k)){
                map.put(k, rank);
                rank++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int key : arr) {
            sb.append(map.get(key)).append(" ");
        }
        System.out.println(sb);
    }
}
