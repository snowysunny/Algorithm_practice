package office;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Time: 2019-04-07
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=13&tqId=11182&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 最小的K个数
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * */

public class Array_getTopK {
    public static ArrayList<Integer> getTopK(int[] input, int k) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        //检查输入的特殊情况
        if(input==null || input.length<=0 || input.length<k){
            return list;
        }
        //构建最大堆
        for(int len=k/2; len>=0; len--){
            Adjust(input,len,k);
        }
        //从第k个元素开始分别与最大堆的最大值做比较，如果比最大值小，则替换并调整堆。
        //最终堆里的就是最小的K个数。
        int tmp;
        for(int i=k; i<input.length; i++){
            if(input[i]<input[0]){
                tmp=input[0];
                input[0]=input[i];
                input[i]=tmp;
                Adjust(input,0,k);
            }
        }
        for(int j=0; j<k; j++){
            list.add(input[j]);
        }
        return list;
    }

    public static void Adjust(int[] array, int parent, int length) {

        int child = 2 * parent + 1;

        int cur = array[parent];

        while(child < length) {
            if(child + 1 < length && array[child] < array[child + 1])
                child += 1;

            if(cur >= array[child])
                break;

            array[parent] = array[child];

            parent = child;

            child = 2 * parent + 1;
        }

        array[parent] = cur;

    }

    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> res = getTopK(input, 4);
        System.out.println(res);
    }

}
