package programmers.level_0;

public class P181920 {
    public String solution(String myString) {
        myString = myString.toLowerCase();
        myString = myString.replaceAll("a", "A");
        return myString;
    }
}
