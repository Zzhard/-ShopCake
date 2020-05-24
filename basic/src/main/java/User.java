import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String name;
    private String age;

    public static void main(String[] args) {
        User user=new User();
        user.setName("xiao");
        System.out.println(user.getName());

    }
}
