package patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 棋子工厂（享元工厂 / Flyweight Factory）
 *
 * <p>享元模式中的工厂，负责创建和管理享元对象池。
 * 确保相同内部状态的享元对象只被创建一次，之后复用已有实例。</p>
 *
 * <h2>享元工厂的核心职责</h2>
 * <ol>
 *   <li>维护一个享元池（Map），以内部状态的组合作为 key</li>
 *   <li>当客户端请求享元时，先检查池中是否已有相同内部状态的实例</li>
 *   <li>如果有，直接返回已有实例（共享）；如果没有，创建新实例并存入池中</li>
 * </ol>
 *
 * <h2>为什么用工厂管理？</h2>
 * <p>如果不通过工厂管理，客户端可能直接 new 多个相同颜色的棋子，
 * 导致无法共享。工厂确保了"相同内部状态 = 同一个对象"的保证。</p>
 *
 * <h2>内部状态作为 key</h2>
 * <p>key 由内部状态组合而成（在本例中是颜色 + 大小）。
 * 只要内部状态相同，就是同一个享元，可以被共享。
 * 外部状态（坐标）不作为 key，因为它在每次调用时都不同。</p>
 *
 * @see ConcreteChessPiece 具体享元
 * @see ChessPiece 享元接口
 */
public class ChessPieceFactory {

    /**
     * 享元池：存储已创建的享元对象。
     *
     * <p>key 是棋子颜色（内部状态），value 是对应的享元对象。
     * 使用 Map 确保相同颜色的棋子只保存一个实例。</p>
     */
    private static final Map<ConcreteChessPiece.Color, ChessPiece> PIECE_POOL = new HashMap<>();

    /**
     * 获取指定颜色的棋子享元对象。
     *
     * <p>如果池中已有该颜色的棋子，直接返回（共享）；
     * 如果池中没有，创建新棋子并存入池中。</p>
     *
     * <h2>享元池查找逻辑</h2>
     * <pre>
     * if (pool.containsKey(color)) {
     *     return pool.get(color);  // 共享已有对象
     * } else {
     *     ChessPiece piece = new ConcreteChessPiece(color, size);
     *     pool.put(color, piece);   // 存入池中供后续共享
     *     return piece;
     * }
     * </pre>
     *
     * @param color 棋子颜色（内部状态，作为共享的 key）
     * @return 指定颜色的棋子享元对象
     */
    public static ChessPiece getPiece(ConcreteChessPiece.Color color) {
        // 先从享元池中查找是否已有该颜色的棋子
        if (PIECE_POOL.containsKey(color)) {
            System.out.println("[享元工厂] 从享元池获取已有棋子（颜色：" + color + "），实现共享");
            return PIECE_POOL.get(color);
        }

        // 池中没有，创建新棋子并存入池中
        System.out.println("[享元工厂] 创建新棋子（颜色：" + color + "），存入享元池");
        ChessPiece piece = new ConcreteChessPiece(color, ConcreteChessPiece.Size.BIG);
        PIECE_POOL.put(color, piece);
        return piece;
    }

    /**
     * 获取当前享元池中的对象数量。
     *
     * <p>用于演示验证：无论放置多少棋子，享元池中只有 2 个对象（黑 + 白）。</p>
     *
     * @return 享元池中的对象数量
     */
    public static int getPoolSize() {
        return PIECE_POOL.size();
    }

    /**
     * 清空享元池（测试用）。
     */
    public static void clear() {
        PIECE_POOL.clear();
    }
}
