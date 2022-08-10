public class Solution5 {
    public static void main(String[] args) {
        System.out.println(isbnConverter("1-85326-158-0"));
    }

    public static String isbnConverter(String isbn) {
        StringBuilder sb = new StringBuilder(isbn);
        sb.setLength(sb.length() - 1);
        sb.insert(0, "978-");

        int checkSum = calculateCheckSum(sb.toString().replace("-", ""));
        sb.append(checkSum);

        return sb.toString();
    }

    private static int calculateCheckSum(String numbers){
        int res = 0;
        for(int i = 0; i < numbers.length(); i++){
            int tmp = Integer.parseInt(numbers.charAt(i) + "");
            if(i % 2 == 0){
               res += tmp;
            }else{
               res = res + tmp * 3; 
            }

        }
        res = res % 10;

        return res == 0 ? 0 : 10 - res;
    }
}
