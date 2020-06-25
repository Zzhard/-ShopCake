package day04.jdbc;

/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/5/29 12:14 上午
 */
public class Accout {
    private int id;
    private String accout_name;

    public Accout(int id, String accout_name) {
        this.id = id;
        this.accout_name = accout_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccout_name() {
        return accout_name;
    }

    public void setAccout_name(String accout_name) {
        this.accout_name = accout_name;
    }

    @Override
    public String toString() {
        return "Accout{" +
                "id=" + id +
                ", accout_name='" + accout_name + '\'' +
                '}';
    }
}
