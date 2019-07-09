package leetcode.other.com;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz_412 {
    public static List<String> fizzbuzz(int n) {
        List<String> list = new ArrayList<>();
        if(n <= 0)
            return list;

        for(int i = 1; i <= n; i ++) {
            String res = "";
            if(i % 3 == 0 && i % 5 == 0)
                res += "FizzBuzz";
            else if(i % 3 == 0)
                res += "Fizz";
            else if(i % 5 == 0)
                res += "Buzz";
            else
                res += i;
            list.add(res);
        }

        return list;
    }

    public static void main(String[] args) {
        int n  = 15;
        List<String> res = fizzbuzz(n);
        System.out.println(res);
    }
}
