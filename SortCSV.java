import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class SortCSV {

    public static void main(String[] args) {
        String preSorting = "myjinxin2015;raulbc777;smile67;Dentzil;SteffenVogel_79\n"
        + "17945;10091;10088;3907;10132\n"
        + "2;12;13;48;11";
String postSorting = "Dentzil;myjinxin2015;raulbc777;smile67;SteffenVogel_79\n"
         + "3907;17945;10091;10088;10132\n"
         + "48;2;12;13;11";

         //System.out.println(sortCsvColumns(preSorting).equals(postSorting));

         sortCsvColumns(preSorting);
    }

    public static String sortCsvColumns(String csvFileContent){
        List<String []> list = Arrays.stream(csvFileContent.split("\\n"))
        .map(s -> s.split(";")).collect(Collectors.toList());
        List<Column> columns = new ArrayList<>();
        
        list.stream().forEach(s -> System.out.println(Arrays.toString(s)));


      return csvFileContent;
    }

    static class Column implements Comparable<String>{
        String header;
        List<String> values;

        public Column(){
            this.values = new ArrayList<>();
        }

        public void addValue(String val){
            values.add(val);
        }
    
        @Override
        public int compareTo(String str){
            return header.compareToIgnoreCase(str);
        }
    }
}


