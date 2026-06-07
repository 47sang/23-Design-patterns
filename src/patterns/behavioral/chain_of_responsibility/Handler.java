package patterns.behavioral.chain_of_responsibility;

/**
 * 抽象处理器（Handler）— 责任链模式的核心抽象角色。
 *
 * <h2>设计意图</h2>
 * <p>定义处理请求的统一接口，并持有对下一个处理器的引用。
 * 每个处理器先判断自己是否能处理该请求，如果能则处理并返回；
 * 如果不能则将请求传递给链中的下一个处理器，直到有人处理为止。</p>
 *
 * <h2>模板方法</h2>
 * <p>{@link #handle(LeaveRequest)} 是模板方法：
 * 先调用 {@link #process(LeaveRequest)} 尝试处理，
 * 如果返回 {@code true} 则表示已处理，流程结束；
 * 否则将请求传给 {@link #next} 继续传递。</p>
 *
 * <h2>具体子类</h2>
 * <ul>
 *   <li>{@link TeamLeaderHandler} — 处理 ≤3 天的请假</li>
 *   <li>{@link DeptManagerHandler} — 处理 ≤7 天的请假</li>
 *   <li>{@link GeneralManagerHandler} — 处理 ≤30 天的请假</li>
 * </ul>
 *
 */
public abstract class Handler {

    /** 责任链中的下一个处理器 */
    protected Handler next;

    /**
     * 设置下一个处理器，构建责任链。
     *
     * @param next 下一个处理者
     * @return 下一个处理者（支持链式调用）
     */
    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    /**
     * 模板方法 — 处理请假请求。
     *
     * <p>先调用 {@link #process(LeaveRequest)} 尝试处理，
     * 如果处理成功则直接返回；否则将请求传递给链中的下一个处理器。
     * 如果链中没有人能处理此请求，则打印提示信息。</p>
     *
     * @param request 请假请求对象
     */
    public final void handle(LeaveRequest request) {
        if (process(request)) {
            return; // 已处理，流程结束
        }
        if (next != null) {
            next.handle(request); // 传递给下一个处理器
        } else {
            System.out.println("【责任链】没有合适的审批人能处理 " + request.getDays()
                + " 天的请假，请向上级反映。");
        }
    }

    /**
     * 处理请假请求的具体逻辑。
     *
     * <p>子类根据自身的审批权限来判断是否能处理该请求。
     * 如果能处理则执行审批操作并返回 {@code true}；否则返回 {@code false}，
     * 将请求传递给下一个处理器。</p>
     *
     * @param request 请假请求对象
     * @return 如果本处理器已处理该请求则返回 true；否则返回 false
     */
    protected abstract boolean process(LeaveRequest request);
}
