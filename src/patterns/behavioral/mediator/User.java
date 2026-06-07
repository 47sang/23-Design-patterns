package patterns.behavioral.mediator;

/**
 * 用户（User）— 中介者模式中的同事类（Colleague）。
 *
 * <h2>设计意图</h2>
 * <p>用户是聊天室的参与者，持有聊天室（中介者）的引用。
 * 用户之间不直接通信，发送消息时委托给聊天室处理，
 * 收到消息时由聊天室回调 {@link #receive(String, User)} 方法。</p>
 *
 * <h2>设计修复说明</h2>
 * <p>本实现修复了原代码中 User.find() 需要外部传入 Mediator 的问题。
 * 改为通过构造函数注入 ChatRoom 引用，确保 User 在创建时就
 * 与中介者建立关联，使用时无需再传递中介者。</p>
 *
 */
public class User {

    /** 用户名称 */
    private final String name;
    /** 聊天室（中介者）引用，通过构造函数注入 */
    private final ChatRoom chatRoom;

    /**
     * 构造一个用户。
     *
     * @param name     用户名称
     * @param chatRoom 用户所在的聊天室
     */
    public User(String name, ChatRoom chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
    }

    /** @return 用户名称 */
    public String getName() {
        return name;
    }

    /**
     * 发送消息 — 委托给聊天室处理。
     *
     * <p>用户不直接与其他用户通信，而是通过聊天室中转消息。
     * 这样可以保证用户之间互不引用，降低耦合。</p>
     *
     * @param message 消息内容
     */
    public void send(String message) {
        System.out.println("  >> " + name + " 发送消息: \"" + message + "\"");
        chatRoom.send(message, this);
    }

    /**
     * 接收消息 — 由聊天室回调。
     *
     * @param message 收到的消息内容
     * @param from    消息发送者
     */
    public void receive(String message, User from) {
        System.out.println("  << " + name + " 收到来自 " + from.getName()
            + " 的消息: \"" + message + "\"");
    }
}
