package C.c;

import java.util.Optional;

/**
 * @author 周士钰
 * @date 2024/7/20 下午2:42
 */
public abstract class Handler {

    // 这里我们就设计责任链以单链表形式存在，这里存放后继节点
    protected Handler successor;

    public Handler connect(Handler successor) {
        this.successor = successor;
        // 返回后继节点,供链式调用
        return successor;
    }

    /**
     * 执行业务内容
     */
    public void handle() {
        // 由不同的子类实现具体处理过程
        this.doHandle();

        // 责任链上如果还有后继节点，就继续向下传递
        Optional.ofNullable(successor)
                .ifPresent(Handler::handle);
    }

    public abstract void doHandle();
}
