import java.util.*;
import java.util.stream.Collectors;

public class Stat {

    public static void main(String[] args) {
        String stats = "02|15|59, 2|47|16, 02|17|20, 2|32|34, 2|17|17, 2|22|00, 2|31|41";
        System.out.println(stat(stats));
        }

    public static String stat(String strg) {
        List<Integer> list = createStatsList(strg);
        int avrage = (int) list.stream().mapToDouble(e -> e).average().getAsDouble();
        int range = getRange(list);
        int median = getMedian(list);
		return String.format("Range: %2s Average: %2s Median: %s", toTime(range), toTime(avrage), toTime(median));
	}

    private static String toTime(int seconds){
        int h = seconds / 3600;
        int m = (seconds % 3600) / 60;
        int s = seconds % 60;

        return String.format("%02d|%02d|%02d", h, m, s);
    }

    private static int getMedian(List<Integer> list){
        List<Integer> soted = list.stream().sorted().collect(Collectors.toList());
        if(soted.size() % 2 != 0){
            return soted.get(soted.size() / 2);
        }
        int h1 = soted.get(soted.size() / 2);
        int h2 = soted.get(soted.size() / 2 + 1);
        return (h1 + h2) / 2;
    }

    private static int getRange(List<Integer> list){
        int min = list.get(0);
        int max = list.get(0);
        for(int i : list){
            if(i < min){
                min = i;
            }
            if(i > max){
                max = i;
            }
        }

        return max - min;
    }

    private static List<Integer> createStatsList(String stats){
       return Arrays.stream(stats.split(", "))
        .map(Stat::toSeconds).collect(Collectors.toList());
    }

    private static int toSeconds(String time){
        String [] str = time.split("\\|");
        int h = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int s = Integer.parseInt(str[2]);

        return h * 3600 + m * 60 + s;
    }
    
}
