package baekjoon.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B2238_경매 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int u = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        Map<Integer, Integer> prices = new HashMap<>();
        List<Auction> auctions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] nameAndPrices = br.readLine().split(" ");
            String name = nameAndPrices[0];
            int price = Integer.parseInt(nameAndPrices[1]);

            auctions.add(new Auction(name, price, i));

            prices.put(price, prices.getOrDefault(price, 0) + 1);
        }

        int minFrequency = Collections.min(prices.values());
        int minPrice = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : prices.entrySet()) {
            if (entry.getValue() == minFrequency) {
                minPrice = Math.min(minPrice, entry.getKey());
            }
        }


        String winnerName = "";
        int earliestIndex = n;

        for (Auction auction : auctions) {
            if (auction.price == minPrice && auction.index < earliestIndex) {
                winnerName = auction.name;
                earliestIndex = auction.index;
            }
        }

        // 출력
        System.out.println(winnerName + " " + minPrice);
    }
}

class Auction {
    String name;
    int price;
    int index;

    public Auction(String name, int price, int index) {
        this.name = name;
        this.price = price;
        this.index = index;
    }
}