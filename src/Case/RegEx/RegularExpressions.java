package Case.RegEx;

public class RegularExpressions {
    public boolean isTrueOrFalse(String s) {
        return s.matches("[tT]rue|[fF]alse");
    }

    public boolean isInteger(String s) {
        return s.matches("^-?\\d+$");
    }


}
