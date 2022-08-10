import java.util.Arrays;
import java.util.stream.Collectors;

public class Meeting {
    public static void main(String[] args) {
        String s = "Alexis:Wahl;John:Bell;Victoria:Schwarz;Abba:Dorny;Grace:Meta;Ann:Arno;Madison:Stan;Alex:Cornwell;Lewis:Kern;Megan:Stan;Alex:Korn";
        String res = meeting(s);

        System.out.println(res);
    }

    public static String meeting(String s) {
       return Arrays.stream(s.split(";"))
                    .map(Person::new)
                    .sorted()
                    .map(Person::toString)
                    .collect(Collectors.joining());
    }
    
}

class Person implements Comparable<Person>{
    private String firstName;
    private String lastName;

    Person(String fullName){
        String [] name = fullName.split(":");
        this.firstName = name[0];
        this.lastName = name[1];
    }

    Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int compareTo(Person o) {
        if(this.lastName.equals(o.lastName)){
            return this.firstName.compareTo(o.firstName);
        }
        
        return this.lastName.compareTo(o.lastName);
    }

    public String toString(){
        return "(" + lastName.toUpperCase() + ", " + firstName.toUpperCase() + ")";
    }


}
 