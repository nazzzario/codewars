import java.util.*;

public class TimeFormatter {
    private static final int SECONDS_IN_YEAR = 31536000;
    private static final int SECONDS_IN_DAY = 86400;
    private static final int SECONDS_IN_HOUR = 3600;
    private static final int SECONDS_IN_MINUTE = 60;

    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        String res = formatDuration(62);
        System.out.println(res);
    }

    public static String formatDuration(int seconds) {
        if(seconds == 0){
            return "now";
        }
        getYears(seconds);
        return print();
    }

    private static void getYears(int seconds){
        if(seconds >= SECONDS_IN_YEAR){
            int res = seconds / SECONDS_IN_YEAR;
            list.add(res > 1 ? res + " years" : "1 year");
            getDays(seconds % SECONDS_IN_YEAR);
        }else{
            getDays(seconds);
        }
    }

    private static void getDays(int seconds){
        if(seconds >= SECONDS_IN_DAY){
            int res = seconds / SECONDS_IN_DAY;
            list.add(res > 1 ? res + " days" : "1 day");
            getHours(seconds % SECONDS_IN_DAY);
        }else{
            getHours(seconds);
        }
    }

    private static void getHours(int seconds){
        if(seconds >= SECONDS_IN_HOUR){
            int res = seconds / SECONDS_IN_HOUR;
            list.add(res > 1 ? res + " hours" : "1 hour");
            getMinutes(seconds % SECONDS_IN_HOUR);
        }else{
            getMinutes(seconds);
        }
    }

    private static void getMinutes(int seconds){
        if(seconds >= SECONDS_IN_MINUTE){
            int res = seconds / SECONDS_IN_MINUTE;
            list.add(res > 1 ? res + " minutes" : "1 minute");
            getSeconds(seconds % SECONDS_IN_MINUTE);
        }else{
            getSeconds(seconds);
        }
    }

    private static void getSeconds(int seconds){
        if(seconds > 0){
            list.add(seconds > 1 ? seconds + " seconds" : "1 second");
        }
    }

    private static String print(){
        StringJoiner res = new StringJoiner(", ");
        if(list.size() == 1){
            return list.get(0);
        }

        for(int i = 0; i < list.size() - 1; i++){
            res.add(list.get(i));
        }
        StringBuilder sb = new StringBuilder(res.toString());
        sb.append(" and ").append(list.get(list.size() - 1));

        return sb.toString();
    }
}
