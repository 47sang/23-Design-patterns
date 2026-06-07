package patterns.behavioral.interpreter;

import java.util.Map;

/**
 * 数字常量表达式（NumberExpression）— 解释器模式中的终结符表达式。
 *
 * <p>表示算术表达式中的一个数字字面量（如 3、100、-5），
 * 其值在构造时确定，不依赖外部上下文。</p>
 *
 * <h2>设计意图</h2>
 * <p>终结符表达式是表达式树中的叶子节点，不再包含子表达式。
 * NumberExpression 是最简单的表达式类型，直接返回构造时传入的常量值。</p>
 *
 */
public class NumberExpression extends Expression {

    /** 常量数值 */
    private final int value;

    /**
     * 构造一个数字常量表达式。
     *
     * @param value 常量值
     */
    public NumberExpression(int value) {
        this.value = value;
    }

    /**
     * 直接返回构造时传入的常量值，忽略上下文参数。
     *
     * @param context 此参数对数字常量无意义，始终返回预设的常量值
     * @return 常量数值
     */
    @Override
    public int interpret(Map<String, Integer> context) {
        return value;
    }

    /**
     * 返回常量的字符串表示，方便调试时输出表达式树的结构。
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
