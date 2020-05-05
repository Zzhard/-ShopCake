package letcode;

/**
 * @Author zhaoxg
 * @Date 2020/5/5 11:56
 */

import java.util.Arrays;

/**
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class topic1 {
    public static void main(String[] args) {
        int[] arr= new int[]{5, 6, 11, 5};
        int target=10;
        int[] sum = sum(arr, target);
        System.out.println(Arrays.toString(sum));
    }

    public static int[] sum(int[] arr,int target){
        int[] newArr=new int[2];
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                 int sum=arr[i]+arr[j];
                 if(sum==target&&i!=j){
                     newArr[0]=i;
                     newArr[1]=j;
                     return newArr;
                 }
            }
        }
        return null;

    }
}
