package office;

/**
 * Time: 2019-03-18
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 替换空格
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * */

public class String_ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        if (str == null)
            return str.toString();
        for (int i = 0; i < str.length(); i ++) {
            if (str.charAt(i) == ' ')
                str.replace(i, i + 1, "%20");
        }
        return str.toString();
    }

    public static void main(String[] args){
        String_ReplaceSpace rs = new String_ReplaceSpace();
        StringBuffer str = new StringBuffer("We Are Happy.");
        String res = rs.replaceSpace(str);
        System.out.println(res);
    }
}
