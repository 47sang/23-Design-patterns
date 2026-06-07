package patterns.behavioral.interpreter;

import java.util.Map;

/**
 * 除法表达式（DivExpression）— 解释器模式中的非终结符表达式。
 *
 * <p>表示两个子表达式的除法运算：{@code left / right}。
 * 递归调用子表达式的 {@link #interpret(Map)} 方法，将左操作数的结果
 * 除以右操作数的结果后返回整数商。</p>
 *
 * <h2>注意事项</h2>
 * <p>当除数为零时，会抛出 {@link ArithmeticException}，
 * 调用方应确保右操作数的值不为零。</p>
 *
 */
public class DivExpression extends Expression {

    /** 左操作数表达式（被除数） */
    private final Expression left;
    /** 右操作数表达式（除数） */
    private final Expression right;

    /**
     * 构造一个除法表达式。
     *
     * @param left  左操作数表达式（被除数）
     * @param right 右操作数表达式（除数）
     */
    public DivExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * 递归求值：左子表达式的值除以右子表达式的值，返回整数商。
     *
     * @param context 变量上下文，传递给子表达式
     * @return 左右子表达式求值结果的整数商
     * @throws ArithmeticException 当右操作数的值为零时抛出
     */
    @Override
    public int interpret(Map<String, Integer> context) {
        int divisor = right.interpret(context);
        if (divisor == 0) {
            throw new ArithmeticException("除数不能为零");
        }
        return left.interpret(context) / divisor;
    }

    /**
     * 返回表达式的字符串形式，如 "(a / b)"。
     */
    @Override
    public String toString() {
        return "(" + left + " / " + right + ")";
    }
}
