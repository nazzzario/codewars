import java.util.*;
import java.util.stream.Collectors;

public class WeightSort {
    public static void main(String[] args) {
        System.out.println(orderWeight(" 56 65  74 100 99 68 86 180 90 "));
    }

    public static String orderWeight(String strng) {
        if(strng.isEmpty()){
            return "";
        }
        return Arrays.stream(strng.trim().split("\\D+"))
        .map(s -> Integer.parseInt(s))
        .map(s -> new WeightValue(s))
        .sorted()
        .map(s -> s.toString())
        .collect(Collectors.joining(" "));
	}
}
class WeightValue implements Comparable<WeightValue>{

    int weight;

    WeightValue(int weight){
        this.weight = weight;
    }

    @Override
    public int compareTo(WeightValue o) {
        int w1 = calculetWeightScore(this.weight);
        int w2 = calculetWeightScore(o.weight);
        if(w1 == w2){
            String s1 = String.valueOf(this.weight);
            String s2 = String.valueOf(o.weight);
            return s1.compareTo(s2);
        }
        return Integer.compare(w1, w2);
    }

    private int calculetWeightScore(int weight){
        int sum = 0;
        while(weight > 0){
            sum += weight % 10;
            weight /= 10;
        }
        return sum;
    }

    public int geteWeight(){
        return weight;
    }

    public String toString(){
        return String.valueOf(weight);
    }
}


