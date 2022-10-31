package Case.RegEx;

public class App {
    public static void main(String[] args) {
        RegularExpressions re = new RegularExpressions();

        System.out.println(re.isInteger("test"));
        System.out.println(re.isInteger("1"));

        System.out.println(re.isTrueOrFalse("false"));
        System.out.println(re.isTrueOrFalse("False"));
        System.out.println(re.isTrueOrFalse("True"));
        System.out.println(re.isTrueOrFalse("Trueee"));

    }
}
