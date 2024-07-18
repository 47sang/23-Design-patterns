package B.g;

/**
 * @author 周士钰
 * @date 2024/7/18 下午10:38
 */
public class Main {

    public static void main(String[] args) {
        String str1 = "abcdefg";
        String str2 = "abcd";

        a();

        b();

        UserService userService = new UserService();
        userService.service();
    }

    static void a() {
        String str1 = "efg";
        String str2 = "abcd";
        System.out.println("str1 = " + str2 + str1);
    }

    /**
     * 猜猜这三个对象是不是都是同一个？
     */
    static void b() {
        String str1 = "abcd";
        String str2 = "abcd";
        String str3 = "ab" + "cd";
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
    }


}
