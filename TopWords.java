import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopWords {
    public static void main(String[] args) {
        String text = """ 
            gcP gcP gcP JdiiT'yjK JdiiT'yjK:JdiiT'yjK/gcP kx'Vo gcP gcP_gcP gcP.JdiiT'yjK gcP gcP-JdiiT'yjK gcP gcP kx'Vo gcP gcP gcP:gcP JdiiT'yjK gcP!gcP JdiiT'yjK:JdiiT'yjK:kx'Vo/JdiiT'yjK;kx'Vo JdiiT'yjK kx'Vo;kx'Vo!JdiiT'yjK gcP.JdiiT'yjK JdiiT'yjK!gcP/JdiiT'yjK JdiiT'yjK JdiiT'yjK_JdiiT'yjK.JdiiT'yjK.gcP;  """;
        System.out.println(top3(text));
    }

    public static List<String> top3(String s) {
        var strArr = s.replaceAll("[.,/\\:#;?_!]", " ").split(" ");
        var res = Arrays.stream(strArr)
                           .map(st -> st.trim())
                           .filter(st -> !st.matches("'+") && !st.isBlank())
                           .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                           .entrySet().stream()
                           .sorted(Map.Entry.<String, Long>comparingByValue().reversed()
                                    .thenComparing(Map.Entry.<String, Long>comparingByKey()))
                           .limit(3)
                        //    .map(e -> e.getKey().toLowerCase())
                           .collect(Collectors.toList()); 
                           System.out.println(res);   
        return null;
    }
    
}
