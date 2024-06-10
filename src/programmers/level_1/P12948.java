package programmers.level_1;

public class P12948 {
    public static String solution(String phone_number) {
        //01033334444

        String number1 = phone_number.substring(0, phone_number.length()-4);
        String number2 = phone_number.substring(phone_number.length()-4);
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < number1.length();i++){
            sb.append("*");
        }
        sb.append(number2);
        return sb.toString();

}

    public static void main(String[] args) {
        String s = "01033334444";

        System.out.println(solution(s));

    }
}
