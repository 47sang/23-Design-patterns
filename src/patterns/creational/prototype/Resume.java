package patterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * 简历 — 原型模式的核心类
 *
 * <h2>模式角色</h2>
 * <p>简历包含<strong>不可变</strong>的基本信息（姓名、年龄等基本类型/String）
 * 和<strong>可变</strong>的工作经历列表（引用类型，需要深拷贝）。
 * 通过重写 {@link #clone()} 方法实现原型复制。</p>
 *
 * <h2>🔑 浅拷贝 vs 深拷贝</h2>
 * <table>
 *   <tr>
 *     <th>类型</th>
 *     <th>基本类型/String 字段</th>
 *     <th>List&lt;WorkExperience&gt; 字段</th>
 *     <th>结果</th>
 *   </tr>
 *   <tr>
 *     <td>浅拷贝（super.clone）</td>
 *     <td>复制值</td>
 *     <td>复制引用（共享同一个 List）</td>
 *     <td>修改克隆体会影响原对象 → ❌ 危险</td>
 *   </tr>
 *   <tr>
 *     <td>深拷贝（手动复制）</td>
 *     <td>复制值</td>
 *     <td>新建 List + 逐个复制元素</td>
 *     <td>互不影响 → ✅ 正确</td>
 *   </tr>
 * </table>
 *
 * <h2>为什么 WorkExperience 列表需要深拷贝？</h2>
 * <p>{@code List} 是一个可变集合。如果浅拷贝，原对象和克隆对象
 * 共享同一个 List 引用。任何一方对 List 的修改（add/remove/clear）
 * 都会影响到另一方。</p>
 *
 * @see WorkExperience 工作经历值对象
 */
public class Resume implements Cloneable {

    // ==================== 不可变字段（浅拷贝即可） ====================
    private String name;
    private int age;
    private String email;
    private String phone;

    // ==================== 可变字段（必须深拷贝） ====================
    private List<WorkExperience> workExperiences;

    /**
     * 构造一份新简历（原型）
     *
     * @param name    姓名
     * @param age     年龄
     * @param email   邮箱
     * @param phone   电话
     */
    public Resume(String name, int age, String email, String phone) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.workExperiences = new ArrayList<>();
    }

    /**
     * 添加工作经历
     *
     * @param experience 工作经历对象
     */
    public void addWorkExperience(WorkExperience experience) {
        workExperiences.add(experience);
    }

    // ==================== 浅拷贝（问题演示） ====================

    /**
     * ⚠️ 浅拷贝 — 演示问题所在
     *
     * <p>使用 {@code super.clone()} 执行 Object 级别的浅拷贝：</p>
     * <ol>
     *   <li>基本类型字段（name, age）→ 复制值，安全</li>
     *   <li>引用类型字段（workExperiences List）→ 仅复制引用，原对象和克隆对象共享同一个 List</li>
     * </ol>
     *
     * <p><strong>问题</strong>：修改克隆对象的 workExperiences（add/remove），
     * 原对象也会被影响！</p>
     *
     * @return 浅拷贝的 Resume 实例
     * @throws CloneNotSupportedException 当类未正确实现 Cloneable 时抛出（本类已实现）
     */
    public Resume shallowClone() throws CloneNotSupportedException {
        return (Resume) super.clone();
    }

    // ==================== 深拷贝（正确实现） ====================

    /**
     * ✅ 深拷贝 — 正确实现
     *
     * <p>在浅拷贝的基础上，手动复制所有引用类型字段：</p>
     * <ol>
     *   <li>调用 {@code super.clone()} 完成浅拷贝（基本类型字段已复制）</li>
     *   <li>对 {@code workExperiences} 字段：新建一个 ArrayList，遍历原 List 逐个添加元素</li>
     * </ol>
     *
     * <p>由于 {@link WorkExperience} 是不可变值对象（所有字段 final），
     * 可以直接复用引用，无需再逐个复制 WorkExperience 的内部字段。
     * 如果 WorkExperience 是可变的，则需要在循环中也调用 {@code experience.clone()}。</p>
     *
     * @return 深拷贝的 Resume 实例
     * @throws CloneNotSupportedException 当类未正确实现 Cloneable 时抛出
     */
    @Override
    public Resume clone() throws CloneNotSupportedException {
        // 1. 先执行浅拷贝（复制基本类型字段）
        Resume cloned = (Resume) super.clone();

        // 2. 手动深拷贝引用类型字段：创建新的 List 并复制所有元素
        cloned.workExperiences = new ArrayList<>();
        for (WorkExperience exp : this.workExperiences) {
            // WorkExperience 是不可变对象，可以直接添加原引用
            cloned.workExperiences.add(exp);
        }

        return cloned;
    }

    // ==================== Getter 方法 ====================

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public List<WorkExperience> getWorkExperiences() {
        // 防御性拷贝：返回不可修改的视图，防止外部直接修改内部 List
        return new ArrayList<>(workExperiences);
    }

    /**
     * 打印简历完整内容
     */
    public void printResume() {
        System.out.println("  ===== 简历 =====");
        System.out.println("  姓名: " + name + " | 年龄: " + age);
        System.out.println("  邮箱: " + email + " | 电话: " + phone);
        System.out.println("  工作经历:");
        if (workExperiences.isEmpty()) {
            System.out.println("    （无）");
        }
        for (WorkExperience exp : workExperiences) {
            exp.printDetail();
        }
        System.out.println("  =================");
    }
}
