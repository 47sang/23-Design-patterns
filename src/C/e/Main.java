package C.e;

/**
 * @author 周士钰
 * @date 2024/7/20 下午3:12
 */
public class Main {

    public static void main(String[] args) {
        String[] strings = {"aaa", "bbb", "ccc", "ddd"};
        ArrayCollection<String> stringArrayCollection = ArrayCollection.of(strings);

        for (String string : stringArrayCollection) {            
            System.out.println(string);
        }
    }
}
