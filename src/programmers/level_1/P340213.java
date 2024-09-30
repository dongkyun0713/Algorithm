package programmers.level_1;

public class P340213 {
    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // "mm:ss" 형식의 문자열을 초 단위로 변환
        int videoLenSec = timeToSeconds(video_len);
        int posSec = timeToSeconds(pos);
        int opStartSec = timeToSeconds(op_start);
        int opEndSec = timeToSeconds(op_end);

        // 초기 위치가 오프닝 구간에 있으면 오프닝 종료 위치로 이동
        if (opStartSec <= posSec && posSec <= opEndSec) {
            posSec = opEndSec;
        }

        // 각 명령어를 순차적으로 처리
        for (String command : commands) {
            if (command.equals("prev")) {
                // 10초 전으로 이동, 10초 미만이면 처음 위치로 이동
                posSec = Math.max(0, posSec - 10);
            } else if (command.equals("next")) {
                // 10초 후로 이동, 영상의 길이 이상이면 마지막 위치로 이동
                posSec = Math.min(videoLenSec, posSec + 10);
            }

            // 명령어 수행 후, 현재 위치가 오프닝 구간에 속해 있으면 오프닝 종료 위치로 이동
            if (opStartSec <= posSec && posSec <= opEndSec) {
                posSec = opEndSec;
            }
        }

        // 최종 위치를 "mm:ss" 형식으로 변환하여 반환
        return secondsToTime(posSec);
    }

    // "mm:ss" 형식을 초 단위 정수로 변환
    private static int timeToSeconds(String timeStr) {
        String[] parts = timeStr.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 + seconds;
    }

    // 초 단위 정수를 "mm:ss" 형식으로 변환
    private static String secondsToTime(int seconds) {
        int minutes = seconds / 60;
        seconds = seconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}
