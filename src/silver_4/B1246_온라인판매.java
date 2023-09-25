package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class B1246_온라인판매 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        Map<Integer, Integer> map = new HashMap<>();
        int arr[] = new int[m];
        for(int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int max = 0;
        int key = arr[0];
        if(m < n) max =  arr[0] * m;
        else max = arr[0] * n;
        if (n > m) {
            for (int i = 1; i < m; i++) {
                if (arr[i] == arr[i - 1]) continue;
                if (max < arr[i] * (m - i)) {
                    key = arr[i];
                    max = arr[i] * (m - i);
                }
            }
        }
        else {
            for (int i = 1; i < m; i++){
                if (arr[i] == arr[i - 1]) continue;
                int cnt = m-i;
                if(cnt >= n) {
                    if(max < arr[i] * n) {
                        key = arr[i];
                        max = arr[i] * n;
                    }
                }
                else {
                    if(max < arr[i] * cnt){
                        key = arr[i];
                        max = arr[i] * cnt;
                    }
                }
            }
        }
        System.out.println(key + " " +max);
    }
}
