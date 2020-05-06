package leetcode;

/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/5/5 7:33 下午
 */

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 所有输入只包含小写字母 a-z
 *  未完成
 */
public class topic5 {
    public static void main(String[] args) {

    }
    public static String longtestCommonPrefix(String[] str){
        if(str.length<=1){
            return "";
        }
        char[] chars1 = str[0].toCharArray();
        char[] chars2 = str[1].toCharArray();
        for (int i = 0; i <chars1.length ; i++) {
            for (int j = 0; j <chars2.length ; j++) {
                return null;
            }

        }

        return null;

    }
}
