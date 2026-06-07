package patterns.creational.prototype;

/**
 * 原型模式演示入口
 *
 * <h2>演示内容</h2>
 * <ol>
 *   <li>构建一份简历模板（原型），包含多条工作经历</li>
 *   <li>使用深拷贝克隆出多份简历，各自独立修改工作经历</li>
 *   <li>使用浅拷贝演示问题：修改克隆体的工作经历会影响原对象</li>
 *   <li>对比浅拷贝和深拷贝的行为差异</li>
 * </ol>
 *
 */
public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("===== 原型模式演示 =====");
        System.out.println();

        // 1. 构建简历模板（原型）
        System.out.println("--- 1. 构建简历原型 ---");
        Resume prototype = new Resume("张三", 28, "zhangsan@example.com", "138-0000-0001");
        prototype.addWorkExperience(new WorkExperience(
                "字节跳动", "高级后端工程师", "2021.06 - 至今",
                "负责推荐系统核心模块开发，日均处理请求 10 亿+"
        ));
        prototype.addWorkExperience(new WorkExperience(
                "美团", "后端工程师", "2019.07 - 2021.05",
                "参与外卖配送调度系统开发"
        ));
        prototype.printResume();
        System.out.println();

        // 2. 深拷贝 — 正确做法
        System.out.println("--- 2. 深拷贝（clone）— 各自独立 ---");
        Resume deepCopy1 = prototype.clone();
        Resume deepCopy2 = prototype.clone();

        // 修改克隆体的工作经历
        deepCopy1.addWorkExperience(new WorkExperience(
                "阿里巴巴", "技术专家", "2023.09 - 至今",
                "负责云原生平台架构设计"
        ));
        deepCopy2.addWorkExperience(new WorkExperience(
                "腾讯", "高级工程师", "2022.03 - 2023.08",
                "参与微信支付核心链路开发"
        ));

        System.out.println("  [原简历] 工作经历数量: " + prototype.getWorkExperiences().size());
        System.out.println("  [深拷贝1] 工作经历数量: " + deepCopy1.getWorkExperiences().size());
        System.out.println("  [深拷贝2] 工作经历数量: " + deepCopy2.getWorkExperiences().size());
        System.out.println("  → 三个对象互不影响，深拷贝 ✅");
        System.out.println();

        // 3. 浅拷贝 — 问题演示
        System.out.println("--- 3. 浅拷贝（shallowClone）— 共享引用，危险！ ---");
        Resume shallowCopy = prototype.shallowClone();

        // 修改浅拷贝的工作经历
        shallowCopy.addWorkExperience(new WorkExperience(
                "百度", "工程师", "2018.07 - 2019.06",
                "搜索引擎广告系统开发"
        ));

        System.out.println("  [原简历] 工作经历数量: " + prototype.getWorkExperiences().size());
        System.out.println("  [浅拷贝]  工作经历数量: " + shallowCopy.getWorkExperiences().size());
        System.out.println("  → 浅拷贝修改了 List，原对象的 List 也被改变了！");
        System.out.println("  → 这就是浅拷贝的危险之处 ❌");
        System.out.println();

        // 4. 总结
        System.out.println("===== 总结 =====");
        System.out.println("  浅拷贝：快速但危险 — 引用类型字段共享，修改互相影响");
        System.out.println("  深拷贝：安全但稍慢 — 引用类型字段独立复制，互不干扰");
        System.out.println("  原型模式的核心：clone() 方法中必须对可变引用类型字段进行深拷贝");
    }
}
