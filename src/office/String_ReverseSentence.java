package office;

import java.util.ArrayList;

/**
 * Time: 2019-04-12
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/3194a4f4cf814f63919d0790578d51f3?tpId=13&tqId=11197&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 翻转单词顺序列
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * */

public class String_ReverseSentence {
    public static String ReverseSentence(String str) {

        if(str.trim().equals("") || str == null){
            return str;
        }
        String[] strs = str.split(" ");
        str = "";
        for(int i = strs.length - 1; i >= 0; i --) {
            str += strs[i];
            if(i != 0)
                str += " ";
        }
        return str;
    }



    public static void main(String[] args) {
        String str = "I am a student.";
        String res = ReverseSentence(str);
        System.out.println(res);
    }
}
