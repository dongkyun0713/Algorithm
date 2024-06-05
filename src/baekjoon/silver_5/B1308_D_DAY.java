package baekjoon.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1308_D_DAY {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1[] = br.readLine().split(" ");
        String input2[] = br.readLine().split(" ");
        int today_year = Integer.parseInt(input1[0]);
        int end_year = Integer.parseInt(input2[0]);
        int today_month = Integer.parseInt(input1[1]);
        int end_month = Integer.parseInt(input2[1]);
        int today_day = Integer.parseInt(input1[2]);
        int end_day = Integer.parseInt(input2[2]);

        int today_total = calcDay(today_year, today_month,today_day);
        int end_total = calcDay(end_year, end_month,end_day);

        if(end_year - today_year > 1000 || end_year - today_year == 1000 && (today_month < end_month || today_month == end_month&& today_day<= end_day)) System.out.println("gg");
        else System.out.println("D-" + (end_total - today_total));
    }
    public static int calcDay(int y, int m, int d) {
        int day[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = 0;
        for(int i = 1; i < y; i++){
            days += 365 + checkYear(i);
        }
        for(int i = 1; i < m; i++){
            if(i == 2) days += checkYear(y);
            days += day[i];
        }

        days += d;
        return days;
    }
    static int checkYear(int y){
        if((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) return 1;
        else return 0;
    }
}
