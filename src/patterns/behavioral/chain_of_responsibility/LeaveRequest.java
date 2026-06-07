package patterns.behavioral.chain_of_responsibility;

/**
 * 请假请求对象（LeaveRequest）— 责任链模式中的请求实体。
 *
 * <p>封装了一次请假申请的所有信息，作为责任链中传递的数据载体。</p>
 *
 */
public class LeaveRequest {

    /** 请假天数 */
    private final int days;
    /** 申请人姓名 */
    private final String applicant;
    /** 请假原因 */
    private final String reason;

    /**
     * 构造一个请假请求。
     *
     * @param days     请假天数（必须大于0）
     * @param applicant 申请人姓名
     * @param reason   请假原因
     */
    public LeaveRequest(int days, String applicant, String reason) {
        this.days = days;
        this.applicant = applicant;
        this.reason = reason;
    }

    /** @return 请假天数 */
    public int getDays() {
        return days;
    }

    /** @return 申请人姓名 */
    public String getApplicant() {
        return applicant;
    }

    /** @return 请假原因 */
    public String getReason() {
        return reason;
    }
}
