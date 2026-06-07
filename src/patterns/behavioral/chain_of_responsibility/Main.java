package patterns.behavioral.chain_of_responsibility;

/**
 * 责任链模式演示 — 请假审批流程。
 *
 * <h2>责任链结构</h2>
 * <pre>
 * 团队负责人 (≤3天) → 部门经理 (≤7天) → 总经理 (≤30天)
 * </pre>
 *
 * <h2>演示场景</h2>
 * <p>创建不同天数的请假请求，观察请求如何在责任链中传递，
 * 直到被合适的处理器审批。</p>
 *
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("========== 责任链模式演示：请假审批流程 ==========");
        System.out.println();

        // ==================== 构建责任链 ====================
        Handler teamLeader = new TeamLeaderHandler();
        Handler deptManager = new DeptManagerHandler();
        Handler generalManager = new GeneralManagerHandler();

        // 链式组装：团队负责人 → 部门经理 → 总经理
        teamLeader.setNext(deptManager).setNext(generalManager);

        // ==================== 测试不同天数的请假 ====================
        System.out.println("===== 测试1：请假1天（团队负责人审批）=====");
        LeaveRequest request1 = new LeaveRequest(1, "张三", "感冒发烧，需要休息");
        teamLeader.handle(request1);
        System.out.println();

        System.out.println("===== 测试2：请假5天（部门经理审批）=====");
        LeaveRequest request2 = new LeaveRequest(5, "李四", "家中有事，需要回家处理");
        teamLeader.handle(request2);
        System.out.println();

        System.out.println("===== 测试3：请假15天（总经理审批）=====");
        LeaveRequest request3 = new LeaveRequest(15, "王五", "出国旅游");
        teamLeader.handle(request3);
        System.out.println();

        System.out.println("===== 测试4：请假45天（超出所有权限）=====");
        LeaveRequest request4 = new LeaveRequest(45, "赵六", "环游世界");
        teamLeader.handle(request4);
        System.out.println();

        System.out.println("===== 测试5：请假3天（恰好是团队负责人的上限）=====");
        LeaveRequest request5 = new LeaveRequest(3, "孙七", "牙疼，需要看牙医");
        teamLeader.handle(request5);
        System.out.println();

        System.out.println("===== 测试6：请假7天（恰好是部门经理的上限）=====");
        LeaveRequest request6 = new LeaveRequest(7, "周八", "陪护住院家属");
        teamLeader.handle(request6);
        System.out.println();

        System.out.println("========== 责任链模式演示结束 ==========");
    }
}
