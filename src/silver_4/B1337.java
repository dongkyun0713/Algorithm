package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class B1337 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        int cnt[] = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < 5; j++) {
                if (!list.contains(list.get(i) + j)) {
                    cnt[i]++;
                };
            }
        }
        Arrays.sort(cnt);
        System.out.println(cnt[0]);

    }
}
