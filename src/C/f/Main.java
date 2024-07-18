package C.f;

/**
 * @author 周士钰
 * @date 2024/7/20 下午3:44
 */
public class Main {

    public static void main(String[] args) {
        User zhang = new User("张三", "10086");
        User li = new User("李四", "10010");

        Mediator mediator = new Mediator();
        mediator.register("成都天伦首付",zhang);

        User findUser = li.find("成都硅谷", mediator);
        if (findUser == null) {
            System.out.println("未找到");
        }

        User findUser2 = li.find("成都天伦首付", mediator);
        System.out.println(findUser2);


    }
}
