package patterns.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * 聊天室（ChatRoom）— 中介者模式中的具体中介者。
 *
 * <h2>设计意图</h2>
 * <p>聊天室作为中介者，持有所有用户的引用。
 * 用户之间不直接通信，而是通过聊天室中转消息。
 * 这样用户之间不需要知道彼此的存在，降低了耦合度。</p>
 *
 * <h2>核心机制</h2>
 * <p>当用户调用 {@link User#send(String)} 时，
 * 消息被委托给聊天室的 {@link #send(String, User)} 方法。
 * 聊天室再将消息广播给除发送者之外的所有用户。</p>
 *
 * <h2>与 User 的关系</h2>
 * <p>每个 {@link User} 持有 ChatRoom 的引用，
 * 通过构造函数注入（修复了原代码中 User.find() 需要外部传 Mediator 的设计问题）。
 * 发送消息时，User 委托给 ChatRoom 处理，自身不直接与其他 User 交互。</p>
 *
 */
public class ChatRoom {

    /** 聊天室中的用户列表 */
    private final List<User> users = new ArrayList<>();

    /**
     * 添加一个用户到聊天室。
     *
     * @param user 要添加的用户
     */
    public void register(User user) {
        users.add(user);
    }

    /**
     * 发送消息 — 中介者的核心方法。
     *
     * <p>将消息广播给聊天室中除发送者之外的所有用户。
     * 每个接收者根据自己的逻辑来处理收到的消息。</p>
     *
     * @param message 消息内容
     * @param sender  消息发送者
     */
    public void send(String message, User sender) {
        System.out.println("【聊天室】转发消息，发送者: " + sender.getName());
        for (User user : users) {
            if (user != sender) {
                user.receive(message, sender);
            }
        }
    }
}
