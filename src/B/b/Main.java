package B.b;

/**
 * @author 周士钰
 * @date 2024/6/19 下午11:33
 */
public class Main {


    public static void main(String[] args) {
        KissTea kissTea = new KissTea(new Large());
        System.out.println(kissTea.getType() +"-"+ kissTea.getSize());


        IceTea iceTea = new IceTea(new Small());
        System.out.println(iceTea.getType() +"-"+ iceTea.getSize());
    }
}
