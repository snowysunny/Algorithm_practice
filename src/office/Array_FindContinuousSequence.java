package office;

import java.util.ArrayList;

/**
 * Time: 2019-04-12
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/c451a3fd84b64cb19485dad758a55ebe?tpId=13&tqId=11194&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 和为S的连续正数序列
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * */

public class Array_FindContinuousSequence {
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(sum < 1)
            return res;
        // 记录序列
        ArrayList<Integer> midRes = new ArrayList<>();

        // 用于list中的值
        int count = 0;
        // 从前向后进行遍历
        for(int i = 1; i < sum; i ++) {
            count += i;

            midRes.add(i);

            if(count == sum) {      // 满足条件则将其添加到结果中
                ArrayList<Integer> mid = new ArrayList<>();     // 如果res直接添加midRes，当midRes发生变化是，res中也会发生变化，所以需要一个新的数组
                mid.addAll(midRes);
                res.add(mid);
            } else if(count > sum) {

                while(count > sum && midRes.size() > 0) {
                    count = count - midRes.get(0);

                    midRes.remove(0);
                }
                if (count == sum) {
                    ArrayList<Integer> mid = new ArrayList<>();
                    mid.addAll(midRes);
                    res.add(mid);
                }

            }

        }

        return res;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = FindContinuousSequence(9);
        for(ArrayList<Integer> num : res)
            System.out.println(num);
    }
}
