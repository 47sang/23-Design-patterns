package patterns.behavioral.mediator;

/**
 * 中介者模式演示 — 聊天室。
 *
 * <h2>演示场景</h2>
 * <p>创建一个聊天室，多个用户加入后互相发送消息。
 * 所有消息通过聊天室（中介者）中转，用户之间互不直接引用。</p>
 *
 * <h2>设计修复说明</h2>
 * <p>本演示修复了原代码中 User.find() 需要外部传入 Mediator 的设计问题。
 * User 通过构造函数接收 ChatRoom 引用，发送消息时直接委托给 ChatRoom。</p>
 *
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("========== 中介者模式演示：聊天室 ==========");
        System.out.println();

        // ==================== 创建聊天室（中介者） ====================
        ChatRoom chatRoom = new ChatRoom();

        // ==================== 创建用户并加入聊天室 ====================
        User alice = new User("Alice", chatRoom);
        User bob = new User("Bob", chatRoom);
        User charlie = new User("Charlie", chatRoom);
        User diana = new User("Diana", chatRoom);

        chatRoom.register(alice);
        chatRoom.register(bob);
        chatRoom.register(charlie);
        chatRoom.register(diana);

        System.out.println("聊天室创建完成，共有 " + 4 + " 位用户在线。");
        System.out.println();

        // ==================== 演示消息发送 ====================
        System.out.println("===== Alice 发送消息 =====");
        alice.send("大家好！今天天气真不错 ☀️");
        System.out.println();

        System.out.println("===== Bob 回复消息 =====");
        bob.send("是的，适合出去走走 🚶");
        System.out.println();

        System.out.println("===== Charlie 发送消息 =====");
        charlie.send("有人要一起打球吗？🏀");
        System.out.println();

        System.out.println("===== Diana 回复消息 =====");
        diana.send("算我一个！🏐");
        System.out.println();

        // ==================== 演示群聊效果 ====================
        System.out.println("===== 群聊：讨论周末活动 =====");
        alice.send("周末大家有什么计划？");
        System.out.println();
        bob.send("我打算去爬山 🏔️");
        System.out.println();
        charlie.send("我要在家休息 😴");
        System.out.println();
        diana.send("我去逛街购物 🛍️");
        System.out.println();

        System.out.println("========== 中介者模式演示结束 ==========");
    }
}
