package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B1920_보류 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N= Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        String input[] = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(input[i]));
        }
        int M = Integer.parseInt(br.readLine());
        String input2[] = br.readLine().split(" ");
        for(int i = 0; i < M; i++) {
            if(list.contains(Integer.parseInt(input2[i]))) System.out.println(1);
            else System.out.println(0);
        }
    }
}
