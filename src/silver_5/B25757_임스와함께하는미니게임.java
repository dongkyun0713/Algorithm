package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class B25757_임스와함께하는미니게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        String game = input[1];

        Set<String> set = new HashSet<>();
        while (n-- > 0) {
            String name = br.readLine();
            set.add(name);
        }
        if(game.equals("Y")) System.out.println(set.size());
        else if(game.equals("F")) System.out.println(set.size() / 2);
        else System.out.println(set.size() / 3);
    }
}
