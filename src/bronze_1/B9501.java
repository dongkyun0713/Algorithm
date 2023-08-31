package bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B9501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while(true) {
            ArrayList<Integer> list = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            if(n == -1) break;
            int measure_sum = 0;
            for(int i = 1; i < n -1; i++) {
                if(n % i == 0) {
                    list.add(i);
                    measure_sum += i;
                }
            }
            if(measure_sum == n) {
                System.out.print(n + " = ");
                for (int i = 0; i < list.size(); i++){
                    if(i == list.size() -1) {
                        System.out.println(list.get(i));
                        break;
                    }
                    System.out.print(list.get(i) + " + ");
                }
            }
            else System.out.println(n + " is NOT perfect.");
        }
    }
}
