package patterns.behavioral.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * 解释器模式演示 — 算术表达式求值。
 *
 * <h2>演示场景</h2>
 * <p>构建表达式树并求值：{@code (a + b) * (c - d)}</p>
 * <p>表达式树的构建过程如下：</p>
 * <pre>
 *    MulExpression
 *    ├── AddExpression
 *    │   ├── VariableExpression("a")
 *    │   └── VariableExpression("b")
 *    └── SubExpression
 *        ├── VariableExpression("c")
 *        └── VariableExpression("d")
 * </pre>
 *
 * <h2>求值过程</h2>
 * <ol>
 *   <li>MulExpression 递归调用左右子表达式</li>
 *   <li>AddExpression 计算 a + b</li>
 *   <li>SubExpression 计算 c - d</li>
 *   <li>最后将两者相乘得到结果</li>
 * </ol>
 *
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("========== 解释器模式演示：算术表达式求值 ==========");
        System.out.println();

        // ==================== 第一步：构建表达式树 ====================
        System.out.println("--- 构建表达式树 ---");

        // 构建 (a + b)
        Expression a = new VariableExpression("a");
        Expression b = new VariableExpression("b");
        Expression addExpr = new AddExpression(a, b);
        System.out.println("加法子表达式: " + addExpr);

        // 构建 (c - d)
        Expression c = new VariableExpression("c");
        Expression d = new VariableExpression("d");
        Expression subExpr = new SubExpression(c, d);
        System.out.println("减法子表达式: " + subExpr);

        // 构建 (a + b) * (c - d)
        Expression mulExpr = new MulExpression(addExpr, subExpr);
        System.out.println("完整表达式:   " + mulExpr);
        System.out.println();

        // ==================== 第二步：设置变量值并求值 ====================
        System.out.println("--- 设置变量值并求值 ---");
        Map<String, Integer> context = new HashMap<>();
        context.put("a", 10);
        context.put("b", 5);
        context.put("c", 20);
        context.put("d", 8);

        System.out.println("变量赋值: a=10, b=5, c=20, d=8");
        System.out.println("计算过程: (a + b) * (c - d) = (10 + 5) * (20 - 8) = 15 * 12 = 180");
        System.out.println("表达式求值结果: " + mulExpr.interpret(context));
        System.out.println();

        // ==================== 第三步：修改变量值，再次求值 ====================
        System.out.println("--- 修改变量值，再次求值 ---");
        context.put("a", 3);
        context.put("b", 7);
        context.put("c", 15);
        context.put("d", 4);

        System.out.println("变量赋值: a=3, b=7, c=15, d=4");
        System.out.println("计算过程: (a + b) * (c - d) = (3 + 7) * (15 - 4) = 10 * 11 = 110");
        System.out.println("表达式求值结果: " + mulExpr.interpret(context));
        System.out.println();

        // ==================== 第四步：演示更复杂的表达式 ====================
        System.out.println("--- 更复杂的表达式 ---");
        // (a + b) / (c - d) + e
        Expression e = new VariableExpression("e");
        Expression divExpr = new DivExpression(addExpr, subExpr);
        Expression complexExpr = new AddExpression(divExpr, e);
        System.out.println("复杂表达式: " + complexExpr);

        context.put("a", 100);
        context.put("b", 50);
        context.put("c", 30);
        context.put("d", 10);
        context.put("e", 5);
        System.out.println("变量赋值: a=100, b=50, c=30, d=10, e=5");
        System.out.println("计算过程: (a+b)/(c-d) + e = (100+50)/(30-10) + 5 = 150/20 + 5 = 7 + 5 = 12");
        System.out.println("表达式求值结果: " + complexExpr.interpret(context));
        System.out.println();

        // ==================== 第五步：演示使用数字常量 ====================
        System.out.println("--- 混合使用变量和常量 ---");
        // (2 + a) * b
        context.put("a", 3);
        context.put("b", 7);
        Expression constTwo = new NumberExpression(2);
        Expression addConst = new AddExpression(constTwo, a);
        Expression mulWithConst = new MulExpression(addConst, b);
        System.out.println("混合表达式: " + mulWithConst);
        System.out.println("计算过程: (2 + a) * b = (2 + 3) * 7 = 5 * 7 = 35");
        System.out.println("表达式求值结果: " + mulWithConst.interpret(context));

        System.out.println();
        System.out.println("========== 解释器模式演示结束 ==========");
    }
}
