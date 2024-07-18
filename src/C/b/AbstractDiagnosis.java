package C.b;

/**
 * @author 周士钰
 * @date 2024/7/18 下午10:49
 */
public abstract class AbstractDiagnosis {
    public void test() {
        System.out.println("头晕,不想起床,先跟公司请假");
        System.out.println("去医院看病");
        System.out.println("1 >> 先挂号");
        System.out.println("2 >> 等待叫号");
        // 由于现在不知道该开什么处方，所以只能先定义一下行为，然后具体由子类实现
        // 先定义后面的流程
        this.prescribe();
        this.medicine();
    }

    /**
     * 开处方操作根据具体病症决定了
     */
    public abstract void prescribe();

    /**
     * 拿药也是根据具体的处方去拿
     */
    public abstract void medicine();
}
