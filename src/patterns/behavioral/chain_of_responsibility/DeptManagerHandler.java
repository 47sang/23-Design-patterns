package patterns.behavioral.chain_of_responsibility;

/**
 * 部门经理（DeptManagerHandler）— 责任链中的第二个处理器。
 *
 * <h2>审批权限</h2>
 * <p>可审批 ≤7 天的请假申请。超出 7 天的请假需要传递给总经理。</p>
 *
 */
public class DeptManagerHandler extends Handler {

    /** 部门经理可审批的最大天数 */
    private static final int MAX_DAYS = 7;

    /**
     * 处理请假请求：如果请假天数 ≤7 天则审批通过，否则传递给下一个处理器。
     *
     * @param request 请假请求对象
     * @return 如果能处理则返回 true；否则返回 false
     */
    @Override
    protected boolean process(LeaveRequest request) {
        if (request.getDays() <= MAX_DAYS) {
            System.out.println("【部门经理】审批通过：同意 " + request.getApplicant()
                + " 请假 " + request.getDays() + " 天（原因：" + request.getReason() + "）。");
            return true;
        }
        System.out.println("【部门经理】无法审批 " + request.getDays() + " 天的请假（最多审批 " + MAX_DAYS + " 天），转交上级...");
        return false;
    }
}
