package office;

import java.util.Arrays;

/**
 * Time: 2019-04-12
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/762836f4d43d43ca9deb273b3de8e1f4?tpId=13&tqId=11198&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 扑克牌顺子
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),
 * “So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 * */

public class Array_isContinuous {
    public static boolean isContinuous(int[] numbers) {
        if(numbers == null)
            return false;
        Arrays.sort(numbers);  //先排序
        int zero = 0, i = 0;
        for(; i < numbers.length && numbers[i] == 0; i++){
            zero ++;  //统计0的个数
        }
        for(; i < numbers.length - 1 && zero >= 0; i++){
            //有对子，则直接返回false
            if(numbers[i] == numbers[i+1])
                return false;
            if(numbers[i] + 1 + zero >= numbers[i+1])  //可以继续匹配
                zero = zero - (numbers[i+1] - numbers[i] - 1);
            else
                return false;
        }
        if(i != numbers.length -1)
            return false;

        return true;
    }

    public static void main(String[] args) {
        int[] numbers = {0, 1, 4, 3, 5};
        boolean res = isContinuous(numbers);
        System.out.println(res);
    }
}
