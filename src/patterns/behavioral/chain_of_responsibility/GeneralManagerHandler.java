package patterns.behavioral.chain_of_responsibility;

/**
 * 总经理（GeneralManagerHandler）— 责任链中的最后一个处理器。
 *
 * <h2>审批权限</h2>
 * <p>可审批 ≤30 天的请假申请。超出 30 天的请假无法被责任链处理。</p>
 *
 */
public class GeneralManagerHandler extends Handler {

    /** 总经理可审批的最大天数 */
    private static final int MAX_DAYS = 30;

    /**
     * 处理请假请求：如果请假天数 ≤30 天则审批通过，否则提示无法处理。
     *
     * <p>此处理器是链的末端，如果也无法处理，则责任链结束。</p>
     *
     * @param request 请假请求对象
     * @return 如果能处理则返回 true；否则返回 false
     */
    @Override
    protected boolean process(LeaveRequest request) {
        if (request.getDays() <= MAX_DAYS) {
            System.out.println("【总经理】审批通过：同意 " + request.getApplicant()
                + " 请假 " + request.getDays() + " 天（原因：" + request.getReason() + "）。");
            return true;
        }
        System.out.println("【总经理】无法审批 " + request.getDays() + " 天的请假（最多审批 " + MAX_DAYS + " 天）。");
        return false;
    }
}
