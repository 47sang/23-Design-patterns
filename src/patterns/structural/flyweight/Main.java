package patterns.structural.flyweight;

/**
 * 享元模式演示入口
 *
 * <p>演示围棋棋子的享元模式实现，
 * 展示如何通过共享内部状态来大幅减少对象数量。</p>
 *
 * <h2>核心演示点</h2>
 * <ol>
 *   <li>在棋盘上放置 200 颗棋子</li>
 *   <li>通过 hashCode/== 验证：享元池中只有 2 个对象（黑 + 白）</li>
 *   <li>说明内部状态（颜色）共享 vs 外部状态（坐标）不共享</li>
 * </ol>
 *
 * <h2>内部状态 vs 外部状态</h2>
 * <ul>
 *   <li><strong>内部状态（共享）</strong>：棋子的颜色、大小
 *       → 存储在 ConcreteChessPiece 对象内部，不随坐标变化</li>
 *   <li><strong>外部状态（不共享）</strong>：棋子在棋盘上的坐标 (x, y)
 *       → 通过 place(x, y) 方法的参数传入，每次调用可以不同</li>
 * </ul>
 *
 * <h2>为什么能共享？</h2>
 * <p>围棋棋盘上只有两种颜色的棋子。
 * 200 颗黑棋共享同一个"黑子"享元对象，
 * 200 颗白棋共享同一个"白子"享元对象。
 * 坐标通过参数传入，同一个享元可以在不同坐标被"放置"多次。</p>
 *
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("========== 享元模式演示：围棋棋子 ==========");
        System.out.println();

        // ========== 第一阶段：放置棋子 ==========
        System.out.println("--- 第一阶段：在棋盘上放置 200 颗棋子 ---");
        System.out.println("（棋盘大小为 19x19，共 361 个交叉点）");
        System.out.println();

        int totalPieces = 200;
        for (int i = 0; i < totalPieces; i++) {
            // 交替放置黑子和白子
            ConcreteChessPiece.Color color =
                (i % 2 == 0) ? ConcreteChessPiece.Color.BLACK : ConcreteChessPiece.Color.WHITE;

            // 通过工厂获取享元对象（内部状态：颜色，由工厂管理共享）
            ChessPiece piece = ChessPieceFactory.getPiece(color);

            // 计算坐标（外部状态：坐标，每次不同，通过参数传入）
            int x = i % 19;
            int y = i / 19;

            // 放置棋子：坐标作为外部状态传入
            piece.place(x, y);
        }

        System.out.println();
        System.out.println("--- 第二阶段：验证享元共享效果 ---");
        System.out.println("共放置了 " + totalPieces + " 颗棋子");
        System.out.println("享元池中实际创建的对象数量：" + ChessPieceFactory.getPoolSize());
        System.out.println("→ 只有 2 个享元对象（黑子 + 白子），实现了对象共享！");
        System.out.println();

        // ========== 第三阶段：通过 hashCode/== 验证共享 ==========
        System.out.println("--- 第三阶段：通过 hashCode/== 验证享元对象共享 ---");

        ChessPiece blackPiece1 = ChessPieceFactory.getPiece(ConcreteChessPiece.Color.BLACK);
        ChessPiece blackPiece2 = ChessPieceFactory.getPiece(ConcreteChessPiece.Color.BLACK);
        ChessPiece whitePiece1 = ChessPieceFactory.getPiece(ConcreteChessPiece.Color.WHITE);

        System.out.println("黑子1 hashCode：" + blackPiece1.hashCode());
        System.out.println("黑子2 hashCode：" + blackPiece2.hashCode());
        System.out.println("白子1 hashCode：" + whitePiece1.hashCode());
        System.out.println();
        System.out.println("黑子1 == 黑子2：" + (blackPiece1 == blackPiece2) + "  ← 同一对象，共享成功");
        System.out.println("黑子1 == 白子1：" + (blackPiece1 == whitePiece1) + "  ← 不同对象，颜色不同");
        System.out.println();

        // ========== 总结 ==========
        System.out.println("========== 享元模式总结 ==========");
        System.out.println();
        System.out.println("内部状态（共享）：");
        System.out.println("  - 颜色：黑/白，存储在享元对象内部，不随坐标变化");
        System.out.println("  - 大小：大/小，存储在享元对象内部，不随坐标变化");
        System.out.println("  → 由享元工厂管理，相同内部状态只创建一次");
        System.out.println();
        System.out.println("外部状态（不共享）：");
        System.out.println("  - 坐标 (x, y)：每次 place() 调用时通过参数传入");
        System.out.println("  -> 同一个享元对象可以在不同坐标被\"放置\"多次");
        System.out.println();
        System.out.println("效果对比：");
        System.out.println("  不用享元：200 颗棋子 = 200 个对象");
        System.out.println("  使用享元：200 颗棋子 = 2 个对象（黑 + 白），节省 99% 内存");
    }
}
