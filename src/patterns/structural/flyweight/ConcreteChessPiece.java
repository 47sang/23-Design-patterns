package patterns.structural.flyweight;

/**
 * 具体围棋棋子（具体享元 / Concrete Flyweight）
 *
 * <p>享元模式中的具体享元，存储棋子的<strong>内部状态</strong>（颜色、大小），
 * 这些状态不随坐标变化，因此可以在多个位置之间共享。</p>
 *
 * <h2>内部状态（存储在对象内部）</h2>
 * <ul>
 *   <li><strong>color</strong>：棋子颜色（BLACK / WHITE），不可变，可共享</li>
 *   <li><strong>size</strong>：棋子大小（big / small），不可变，可共享</li>
 * </ul>
 *
 * <h2>外部状态（不存储在对象内部）</h2>
 * <ul>
 *   <li><strong>坐标 (x, y)</strong>：由 {@link ChessPiece#place(int, int)} 方法的参数传入，
 *       每次调用可以传入不同的坐标，同一个享元对象可以在不同坐标"出现"</li>
 * </ul>
 *
 * <h2>共享机制</h2>
 * <p>具体享元对象由 {@link ChessPieceFactory} 创建和管理。
 * 工厂根据内部状态（颜色）作为 key，确保相同颜色的棋子只创建一个实例。
 * 客户端通过工厂获取享元对象，而不是直接 new。</p>
 *
 * @see ChessPiece 享元接口
 * @see ChessPieceFactory 享元工厂
 */
class ConcreteChessPiece implements ChessPiece {

    /**
     * 棋子颜色枚举。
     *
     * <p>颜色是内部状态，不随坐标变化，因此可以共享。</p>
     */
    enum Color {
        /** 黑棋 */
        BLACK,
        /** 白棋 */
        WHITE
    }

    /**
     * 棋子大小枚举。
     *
     * <p>大小是内部状态，不随坐标变化，因此可以共享。</p>
     */
    enum Size {
        /** 大棋（用于演示区分） */
        BIG,
        /** 小棋 */
        SMALL
    }

    /**
     * 棋子颜色（内部状态，不可变）。
     *
     * <p>这个字段在所有同颜色的棋子之间共享，
     * 因此使用 {@code final} 保证不可变。</p>
     */
    private final Color color;

    /**
     * 棋子大小（内部状态，不可变）。
     */
    private final Size size;

    /**
     * 构造器：创建一个具体棋子。
     *
     * <p>注意：通常不直接 new  ConcreteChessPiece，
     * 而是通过 {@link ChessPieceFactory#getPiece(Color)} 获取，
     * 以确保相同颜色的棋子被共享。</p>
     *
     * @param color 棋子颜色
     * @param size  棋子大小
     */
    ConcreteChessPiece(Color color, Size size) {
        this.color = color;
        this.size = size;
    }

    @Override
    public void place(int x, int y) {
        // 坐标是外部状态，通过参数传入，不存储在对象内部
        String colorName = color == Color.BLACK ? "黑子" : "白子";
        String sizeName = size == Size.BIG ? "大" : "小";
        System.out.printf("  放置 %s%s 到坐标 (%d, %d)%n", sizeName, colorName, x, y);
    }

    /**
     * 获取棋子颜色。
     *
     * <p>用于工厂的 key 比较和演示验证。</p>
     *
     * @return 棋子颜色
     */
    Color getColor() {
        return color;
    }

    /**
     * 获取棋子大小。
     *
     * @return 棋子大小
     */
    Size getSize() {
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ConcreteChessPiece that = (ConcreteChessPiece) obj;
        return color == that.color && size == that.size;
    }

    @Override
    public int hashCode() {
        // 内部状态（color + size）决定 hashCode，用于享元池的 key 比较
        int result = color.hashCode();
        result = 31 * result + size.hashCode();
        return result;
    }
}
