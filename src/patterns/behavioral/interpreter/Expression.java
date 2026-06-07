package patterns.behavioral.interpreter;

import java.util.Map;

/**
 * 抽象表达式（Expression）— 解释器模式的核心抽象角色。
 *
 * <p>定义了解释器的统一接口，所有终结符表达式和非终结符表达式
 * 都继承此类。客户端通过调用 {@link #interpret(Map)} 方法
 * 来计算表达式的值。</p>
 *
 * <h2>设计意图</h2>
 * <p>将算术表达式的每一种操作（加减乘除、变量、常量）抽象为
 * 一个独立的类，通过组合形成表达式树。每个节点自行解释自身，
 * 最终递归求值得到结果。</p>
 *
 * <h2>与其他类的关系</h2>
 * <ul>
 *   <li>{@link VariableExpression} — 终结符，从上下文中读取变量值</li>
 *   <li>{@link NumberExpression} — 终结符，表示数字常量</li>
 *   <li>{@link AddExpression} / {@link SubExpression} /
 *       {@link MulExpression} / {@link DivExpression} — 非终结符，
 *       组合两个子表达式进行运算</li>
 * </ul>
 *
 */
public abstract class Expression {

    /**
     * 解释表达式，返回计算结果。
     *
     * @param context 变量上下文，键为变量名，值为变量对应的整数值
     * @return 表达式求值结果
     */
    public abstract int interpret(Map<String, Integer> context);
}
