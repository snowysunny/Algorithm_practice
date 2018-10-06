package mz.search.com;

/**
 * KMP算法在思想上是一样的，但在具体实现上由于对下标的不同用法，得到的next值不一定是一样的
 * */

public class KMP_algorithm {

    /**
     * Time: 2018-10-05    Author: Snowy
     * 计算字符串的next值
     * */
    public static void getNext(String p, int []next) {
        int p_len = p.length();

        next[0] = -1;

        for (int i = 1; i < p_len; i ++) {
            int j = next[i - 1];
            while (p.charAt( j + 1 ) != p.charAt(i) && j >= 0) {
                j = next[j];
            }
            if (p.charAt(i) == p.charAt(j + 1)) {
                next[i] = j + 1;
            } else {
                next[i] = -1;
            }
            System.out.println("next[" + i + "]: " + next[i] );
        }
    }

    /**
     * 实现KMP算法
     * */
    public static int KMP( String s, String p, int []next) {
        int s_len = s.length();
        int p_len = p.length();
        int s_i = 0, p_i = 0;
        while ( s_i < s_len && p_i < p_len ) {
            if (s.charAt(s_i) == p.charAt(p_i)) {  // 如果相等，指针军向后移动
                s_i ++;
                p_i ++;
            } else {
                if (p_i == 0) {  // 不相等，如果p指针指向p字符串的头部则将s指针向后移动
                    s_i ++;
                } else
                    p_i = next[p_i] + 1;
            }
        }
        if (p_i == p_len)
            return (s_i - p_len);
        return -1;

    }

    // 求解字符串的next，没有用到
    public static void cal_next(String str, int []next)
    {
        int len = str.length();
        next[0] = -1;//next[0]初始化为-1，-1表示不存在相同的最大前缀和最大后缀
        int k = -1;//k初始化为-1
        for (int q = 1; q <= len-1; q++)
        {
            while (k > -1 && str.charAt(k + 1) != str.charAt(q))//如果下一个不同，那么k就变成next[k]，注意next[k]是小于k的，无论k取任何值。
            {
                k = next[k];//往前回溯
            }
            if (str.charAt(k + 1) == str.charAt(q))//如果相同，k++
            {
                k = k + 1;
            }
            next[q] = k;//这个是把算的k的值（就是相同的最大前缀和最大后缀长）赋给next[q]
            System.out.println("next[" + q + "]: " + next[q] );
        }
    }

    public static void get_next(String p, int []next) {
        int j, k;
        next[0] = -1;
        j = 0;
        k = -1;
        while (j < p.length() - 1) {
            if (k == -1 || p.charAt(j) == p.charAt(k)) {
                j ++;
                k ++;
                next[j] = k;
                System.out.println("next[" + j + "]: " + next[j] );
            } else {
                k = next[k];
            }
        }
    }

    public static void main(String[] args) {
        String str = "bacbababadababacambabacaddababacasdsd";
        String ptr = "ababaca";
        int []next = new int[ptr.length()];
        getNext(ptr, next);

        int res = KMP( str, ptr, next );
        System.out.println("result: " + res);
        System.out.println("===================");
        int []new_next = new int[ptr.length()];
        get_next(ptr, new_next);
    }

}
