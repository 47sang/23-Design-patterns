package patterns.behavioral.interpreter;

import java.util.Map;

/**
 * 变量表达式（VariableExpression）— 解释器模式中的终结符表达式。
 *
 * <p>表示算术表达式中的一个变量（如 a、b、c），其值从上下文中获取。
 * 例如在表达式 "(a + b) * c" 中，a、b、c 都是 VariableExpression。</p>
 *
 * <h2>设计意图</h2>
 * <p>终结符表达式是文法中的最小不可再分单位，不需要再递归解释。
 * 变量表达式的值完全取决于外部传入的上下文（context），
 * 这使得同一个表达式树可以在不同的变量赋值下反复求值。</p>
 *
 * @param name 变量名称，用于在 context Map 中查找对应的值
 *
 */
public class VariableExpression extends Expression {

    /** 变量名称 */
    private final String name;

    /**
     * 构造一个变量表达式。
     *
     * @param name 变量名（如 "a"、"x"、"total"）
     */
    public VariableExpression(String name) {
        this.name = name;
    }

    /**
     * 从上下文中获取该变量的值并返回。
     *
     * <p>如果上下文中不存在该变量，会抛出 {@link IllegalArgumentException}
     * 以提示调用者需要先为变量赋值。</p>
     *
     * @param context 变量上下文，必须包含本变量的值
     * @return 变量对应的整数值
     * @throws IllegalArgumentException 当上下文中缺少该变量的值时
     */
    @Override
    public int interpret(Map<String, Integer> context) {
        Integer value = context.get(name);
        if (value == null) {
            throw new IllegalArgumentException(
                "变量 '" + name + "' 未在上下文中定义，请先为其赋值。"
            );
        }
        return value;
    }

    /**
     * 返回变量名称，方便调试时输出表达式树的结构。
     */
    @Override
    public String toString() {
        return name;
    }
}
