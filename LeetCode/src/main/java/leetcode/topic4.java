package leetcode;

/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/5/5 5:52 下午
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *
 * 未完成
 *
 */
public class topic4 {
    public static void main(String[] args) {
        int[] arr={1,1,2,3,4};
        System.out.println("arr.length = " + arr.length);
        System.out.println(removeDup(arr));

    }
    public static int removeDup(int[] nums){
        int a=nums.length;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j <nums.length; j++) {
                if(nums[i]==nums[j]){
                    for (int k = j; k <nums.length-1; k++) {
                    nums[k]=nums[k+1];
                    }
                    nums[a-1]=0;
                }

            }

        }
        System.out.println(Arrays.toString(nums));
        return a;
    }
}
