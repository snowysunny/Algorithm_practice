package leetcode.string.com;

public class ValidNumber_65 {
    public static boolean isNumber(String s) {

//        return s.matches("\\s*[+-]?(\\d+(\\.\\d*)?|\\.\\d+)(e[+-]?\\d+)?\\s*");

        if(s == null)
            return false;
        s = s.trim();

        if(s.length() < 1)
            return false;

        boolean eflag = false, dotflag = false, flag = false, numflag = false;

        for(int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if(c == ' ')
                return false;

            if(c == '+' || c == '-') {
                if(flag || (eflag==false&&numflag) || (dotflag && eflag==false))
                    return false;
                else
                    flag = true;
            }else if(c == '.'){
                if(dotflag || eflag)
                    return false;
                else
                    dotflag = true;
            } else if(c == 'e') {
                if(eflag || numflag == false)
                    return false;
                else {
                    eflag = true;
                    flag = false;
                }
            } else if(c >= '0' && c <= '9'){
                numflag = true;
            } else
                return false;
        }
        if(s.charAt(s.length() - 1) == 'e'|| s.charAt(s.length()-1)=='+' || s.charAt(s.length()-1)=='-')
            return false;
        return numflag;
    }

    public static void main(String[] args) {
        String[] strs = {"0", " 0", "0.1", "a", "95a54e53", "", ".", "-90e3   ", ".1", "3.", "3e", "3e.1", "46.e3", " ", "", "e9", "6+1", "6+", ".-4"};
        for(String s : strs) {
            boolean res = isNumber(s);
            System.out.println(s + ": " + res);
        }

    }
}
