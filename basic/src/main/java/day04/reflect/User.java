package day04.reflect;

/**
 * @Author zhaoxg
 * @Date 2020/5/7 22:39
 */
public class User {

    private String name1;
    private String name2;
    private String name3;
    private String name4;
    private String name5;

    public User(String name1, String name2, String name3, String name4, String name5) {
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
        this.name4 = name4;
        this.name5 = name5;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getName4() {
        return name4;
    }

    public void setName4(String name4) {
        this.name4 = name4;
    }

    public String getName5() {
        return name5;
    }

    public void setName5(String name5) {
        this.name5 = name5;
    }

    private void say(String str,int b){
        System.out.println("hello world");
    }
}
