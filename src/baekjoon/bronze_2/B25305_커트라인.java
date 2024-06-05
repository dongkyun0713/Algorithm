package baekjoon.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class B25305_커트라인 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        String input2[] = br.readLine().split(" ");

        Integer arr[] = Stream
                .of(input2)
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);

        Arrays.sort(arr, Comparator.reverseOrder());
        System.out.println(arr[Integer.parseInt(input[1])-1]);

    }
}
