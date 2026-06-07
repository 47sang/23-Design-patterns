/**
 * 模板方法模式（Template Method Pattern）
 *
 * <h2>模式说明</h2>
 * <p>定义一个操作中的算法骨架，而将一些步骤延迟到子类中，
 * 使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。</p>
 *
 * <h2>现实类比</h2>
 * <p>就像冲泡饮料的流程：</p>
 * <pre>
 * 冲泡饮料的通用步骤：
 *   1. 烧开水
 *   2. 将饮料倒入杯中
 *   3. 用热水冲泡
 *   4. 加入调料
 *
 *  冲泡咖啡：将"饮料"替换为咖啡粉，"调料"替换为糖和牛奶
 *  冲泡茶：  将"饮料"替换为茶叶，"调料"替换为柠檬
 *
 *  步骤 1 和 3 是通用的（模板），步骤 2 和 4 由子类决定（钩子）
 * </pre>
 *
 * <h2>结构</h2>
 * <pre>
 *              ┌─────────────────────┐
 *              │ AbstractClass       │
 *              │  + templateMethod() │  ← 定义算法骨架（调用以下方法）
 *              │  - step1()          │  ← 通用步骤（具体方法）
 *              │  - step2()          │  ← 抽象方法（子类实现）
 *              │  - step3()          │  ← 钩子方法（子类可选覆盖）
 *              └──────────┬──────────┘
 *                         │ 继承
 *              ┌──────────┴──────────┐
 *              │                     │
 *         ┌────┴────┐           ┌───┴───┐
 *         │ConcreteA│           │ConcrB│  ← 具体子类
 *         └─────────┘           └──────┘
 * </pre>
 *
 * <h2>三种方法类型</h2>
 * <ul>
 *   <li><strong>具体方法（Concrete）</strong>：父类实现，子类不关心</li>
 *   <li><strong>抽象方法（Abstract）</strong>：父类声明，子类<strong>必须</strong>实现</li>
 *   <li><strong>钩子方法（Hook）</strong>：父类提供默认实现，子类<strong>可选</strong>覆盖</li>
 * </ul>
 *
 * <h2>业务场景</h2>
 * <ul>
 *   <li>数据导入导出：读取 → 处理 → 转换 → 写入（骨架固定，具体逻辑可变）</li>
 *   <li>测试框架：setup → execute → verify → teardown</li>
 *   <li>Web 请求处理：解析请求 → 鉴权 → 处理 → 返回响应</li>
 * </ul>
 *
 * @see patterns.behavioral.template_method 模板方法示例
 */
package patterns.behavioral.template_method;
