package patterns.behavioral.interpreter;

import java.util.Map;

/**
 * 加法表达式（AddExpression）— 解释器模式中的非终结符表达式。
 *
 * <p>表示两个子表达式的加法运算：{@code left + right}。
 * 非终结符表达式会递归调用其子表达式的 {@link #interpret(Map)} 方法，
 * 将子表达式的求值结果进行运算后返回。</p>
 *
 * <h2>设计意图</h2>
 * <p>非终结符表达式对应文法中的运算符或规则，通过组合终结符和
 * 其他非终结符来构建复杂的表达式树。加法表达式是二元运算符，
 * 持有左操作数和右操作数两个子表达式。</p>
 *
 */
public class AddExpression extends Expression {

    /** 左操作数表达式 */
    private final Expression left;
    /** 右操作数表达式 */
    private final Expression right;

    /**
     * 构造一个加法表达式。
     *
     * @param left  左操作数表达式（可以是变量、常量或其他运算表达式）
     * @param right 右操作数表达式（可以是变量、常量或其他运算表达式）
     */
    public AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * 递归求值：先分别求左右子表达式的值，再将两者相加。
     *
     * @param context 变量上下文，传递给子表达式
     * @return 左右子表达式求值结果之和
     */
    @Override
    public int interpret(Map<String, Integer> context) {
        return left.interpret(context) + right.interpret(context);
    }

    /**
     * 返回表达式的字符串形式，如 "(a + b)"。
     */
    @Override
    public String toString() {
        return "(" + left + " + " + right + ")";
    }
}
