package patterns.behavioral.command;

/**
 * 命令模式演示 — 智能家居遥控器。
 *
 * <h2>演示场景</h2>
 * <p>通过遥控器控制客厅的灯和空调，演示命令的发送、执行和撤销。</p>
 * <p>操作序列：开灯 → 开空调 → 关灯 → 撤销关灯（恢复开灯）</p>
 *
 * <h2>设计修复说明</h2>
 * <p>本实现修复了原代码中命令持有具体设备类的问题。
 * 所有命令类统一持有 {@link Device} 接口引用，
 * 通过面向接口编程实现解耦。</p>
 *
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("========== 命令模式演示：智能家居遥控器 ==========");
        System.out.println();

        // ==================== 创建设备（接收者） ====================
        Light livingRoomLight = new Light("客厅灯");
        AirConditioner livingRoomAC = new AirConditioner("客厅空调");
        Fan bedroomFan = new Fan("卧室风扇");

        // ==================== 创建命令对象 ====================
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);
        Command acOn = new ACOnCommand(livingRoomAC);
        Command acOff = new ACOffCommand(livingRoomAC);
        Command fanOn = new FanOnCommand(bedroomFan);
        Command fanOff = new FanOffCommand(bedroomFan);

        // ==================== 创建遥控器（调用者） ====================
        RemoteController remote = new RemoteController();

        // ==================== 演示基本操作 ====================
        System.out.println("===== 场景1：回家，打开客厅灯和空调 =====");
        remote.pressButton(lightOn);
        System.out.println();
        remote.pressButton(acOn);
        System.out.println();
        System.out.println("----- 当前状态：客厅灯已开，空调已开 -----");
        System.out.println();

        // ==================== 演示关灯 ====================
        System.out.println("===== 场景2：离开客厅前关灯 =====");
        remote.pressButton(lightOff);
        System.out.println();
        System.out.println("----- 当前状态：客厅灯已关，空调仍开 -----");
        System.out.println();

        // ==================== 演示撤销 ====================
        System.out.println("===== 场景3：发现客厅太暗，撤销关灯（恢复开灯）======");
        remote.pressUndo();
        System.out.println();
        System.out.println("----- 当前状态：客厅灯已恢复开启 -----");
        System.out.println();

        // ==================== 演示风扇控制 ====================
        System.out.println("===== 场景4：打开卧室风扇 =====");
        remote.pressButton(fanOn);
        System.out.println();

        // ==================== 演示撤销空调开启 ====================
        System.out.println("===== 场景5：有点冷，撤销开空调（关闭空调）======");
        remote.pressUndo();
        remote.pressUndo(); // undo 开灯
        remote.pressUndo(); // undo 开空调
        System.out.println();
        System.out.println("----- 当前状态：灯恢复开、空调已关、风扇仍开 -----");
        System.out.println();

        // ==================== 演示关风扇 ====================
        System.out.println("===== 场景6：睡前关闭卧室风扇 =====");
        remote.pressButton(fanOff);
        System.out.println();

        System.out.println("========== 命令模式演示结束 ==========");
    }
}
