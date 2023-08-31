package bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B2501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        for(int i = 1; i <= N; i++) {
            if(N % i == 0) list.add(i);
        }
        if(list.size() < K) System.out.println(0);
        else System.out.println(list.get(K-1));
    }
}
