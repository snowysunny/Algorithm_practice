package office;

public class String_LeftRotateString {
    public static String LeftRotateString(String str, int n) {
        if(str.length() < n || str.trim().equals("") )
            return str;

        str = str.substring(n, str.length()) + str.substring(0, n);

        return str;
    }

    public static void main(String[] args) {
        String str = "abcXYZdef";
        int n = 3;
        String res = LeftRotateString(str, n);
        System.out.println(res);
    }
}
