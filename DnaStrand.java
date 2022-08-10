public class DnaStrand {

    public static void main(String[] args) {
        System.out.println(makeComplement("TTTT"));
    }


    public static String makeComplement(String dna) {
        StringBuilder sb = new StringBuilder();
        String [] spl = dna.split("");
        for(String s: spl){
            switch(s){
                case "A" : sb.append("T");
                break;
                case "T" : sb.append("A");
                break;
                case "C" : sb.append("G");
                break;
                case "G" : sb.append("C");
                break;
                default: sb.append(s);
            }
        }
        return sb.toString();
      }
    
}
