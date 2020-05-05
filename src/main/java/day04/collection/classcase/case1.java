package day04.collection.classcase;

/**
 * @Author zhaoxg
 * @Date 2020/4/21 22:41
 */

/**case 1: 定义一个Map, key是userId, value是User.
         要求遍历整个Map的数据
         User{userId,name,age,Map<String,List> hobby}
         如: u001,大叔,hobby(文学=[金瓶梅,春闺秘史,如何重整男人雄风], 电影=[岛国动作模仿秀,慈禧的后宫秘史])
 *
 */


public class case1 {
    public static void main(String[] args) {

        User u1 = User.of("u001", "小明").age(18)
                .hobby("文学", "西游记","金瓶梅")
                .hobby("音乐", "古典","流行");
        User u2 = User.of("u002", "小红").age(25)
                .hobby("文学", "西游记","金瓶梅")
                .hobby("音乐", "古典","流行");
        User u3 = User.of("u003", "小绿").age(35)
                .hobby("文学", "西游记","金瓶梅")
                .hobby("音乐", "古典","流行");


        System.out.println(u1);

    }
}
