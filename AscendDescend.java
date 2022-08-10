public class AscendDescend {
    public static void main(String[] args) {
        System.out.println(ascendDescend(14, 0, 2));
    }

    public static String ascendDescend(int length, int minimum, int maximum) {
        StringBuilder sb = new StringBuilder();

        while(sb.length() < length){
            for(int i = minimum; i < maximum; i++){
                sb.append(i);
            }

            sb.append(maximum);

            for(int i = maximum - 1; i > minimum; i--){
                sb.append(i);
            }
        }


        return sb.toString().substring(0, length);
      }
}
