package patterns.behavioral.interpreter;

import java.util.Map;

/**
 * 乘法表达式（MulExpression）— 解释器模式中的非终结符表达式。
 *
 * <p>表示两个子表达式的乘法运算：{@code left * right}。
 * 递归调用子表达式的 {@link #interpret(Map)} 方法，将两者求值结果相乘后返回。</p>
 *
 */
public class MulExpression extends Expression {

    /** 左操作数表达式 */
    private final Expression left;
    /** 右操作数表达式 */
    private final Expression right;

    /**
     * 构造一个乘法表达式。
     *
     * @param left  左操作数表达式
     * @param right 右操作数表达式
     */
    public MulExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * 递归求值：左右子表达式求值结果相乘。
     *
     * @param context 变量上下文，传递给子表达式
     * @return 左右子表达式求值结果之积
     */
    @Override
    public int interpret(Map<String, Integer> context) {
        return left.interpret(context) * right.interpret(context);
    }

    /**
     * 返回表达式的字符串形式，如 "(a * b)"。
     */
    @Override
    public String toString() {
        return "(" + left + " * " + right + ")";
    }
}
