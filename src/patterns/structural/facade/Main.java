package patterns.structural.facade;

/**
 * 外观模式演示入口
 *
 * <p>演示智能家居控制场景，
 * 展示使用外观模式前后客户端代码的差异。</p>
 *
 * <h2>演示内容</h2>
 * <ol>
 *   <li>先展示没有外观模式时，客户端需要逐个调用子系统方法</li>
 *   <li>再展示使用外观模式后，客户端只需调用一个方法</li>
 *   <li>对比两种方式的代码量和可维护性</li>
 * </ol>
 *
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("========== 外观模式演示：智能家居控制 ==========");
        System.out.println();

        // 创建子系统
        Light livingRoomLight = new Light("客厅灯");
        AirConditioner livingRoomAC = new AirConditioner("客厅空调");
        Curtain livingRoomCurtain = new Curtain("客厅窗帘");
        MusicPlayer livingRoomPlayer = new MusicPlayer("客厅音响");

        // 创建外观类
        SmartHomeFacade smartHome = new SmartHomeFacade(
            livingRoomLight, livingRoomAC, livingRoomCurtain, livingRoomPlayer
        );

        // ========== 使用外观模式 ==========
        System.out.println("--- 使用外观模式：一键回家 ---");
        smartHome.comeHome();
        System.out.println();

        System.out.println("--- 使用外观模式：一键离家 ---");
        smartHome.leaveHome();
        System.out.println();

        // ========== 对比：没有外观模式时的复杂调用 ==========
        System.out.println("========== 没有外观模式时的对比 ==========");
        System.out.println("如果不用外观模式，回家需要逐个调用：");
        System.out.println("  livingRoomLight.on();");
        System.out.println("  livingRoomAC.on();");
        System.out.println("  livingRoomCurtain.open();");
        System.out.println("  livingRoomPlayer.play();");
        System.out.println();
        System.out.println("→ 客户端需要知道所有子系统的接口和调用顺序");
        System.out.println("→ 如果子系统发生变化（如新增设备），客户端代码也要改");
        System.out.println();
        System.out.println("使用外观模式后：");
        System.out.println("  smartHome.comeHome();  // 一行搞定");
        System.out.println();
        System.out.println("→ 客户端只需知道外观类的一个接口");
        System.out.println("→ 子系统变化只影响外观类内部，不影响客户端");
    }
}
