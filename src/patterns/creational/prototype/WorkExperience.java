package patterns.creational.prototype;

/**
 * 工作经历 — 不可变值对象
 *
 * <p>描述简历中的一段工作经历。
 * 作为值对象设计为不可变（所有字段 final，无 setter），
 * 在深拷贝时可以直接复用（值对象本身不需要递归拷贝）。</p>
 *
 * <h2>为什么设计为不可变？</h2>
 * <p>工作经历是简历的组成部分，一旦写入不应被修改。
 * 不可变对象天然线程安全，且深拷贝时可以直接传递引用（无需递归复制）。</p>
 *
 */
public class WorkExperience {

    private final String company;
    private final String position;
    private final String period;
    private final String description;

    /**
     * 构造一段工作经历
     *
     * @param company     公司名称，不允许为 {@code null} 或空
     * @param position    职位名称
     * @param period      在职时间段（如 "2020.03 - 2023.08"）
     * @param description 工作描述
     */
    public WorkExperience(String company, String position, String period, String description) {
        if (company == null || company.trim().isEmpty()) {
            throw new IllegalArgumentException("公司名称不能为空");
        }
        this.company = company;
        this.position = position;
        this.period = period;
        this.description = description;
    }

    public String getCompany() {
        return company;
    }

    public String getPosition() {
        return position;
    }

    public String getPeriod() {
        return period;
    }

    public String getDescription() {
        return description;
    }

    /**
     * 打印工作经历详情
     */
    public void printDetail() {
        System.out.println("    " + company + " | " + position + " | " + period);
        System.out.println("      描述: " + description);
    }
}
