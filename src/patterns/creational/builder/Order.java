package patterns.creational.builder;

/**
 * 订单类 — 建造者模式的目标产品
 *
 * <p>订单包含多个字段，其中 userId 和 productId 为必填，
 * 其余为可选。通过建造者模式优雅地解决 telescoping constructor 问题。</p>
 *
 * <h2>没有建造者模式的问题（Telescoping Constructor）</h2>
 * <pre>
 * // 问题：当可选参数增多时，构造函数越来越长
 * new Order(userId, productId);                     // 只用必填
 * new Order(userId, productId, 2);                  // 加数量
 * new Order(userId, productId, 2, "北京市...");      // 加地址
 * new Order(userId, productId, 2, "北京市...", "");  // 加备注
 * // ... 越来越难理解哪个参数代表什么
 * </pre>
 *
 * <h2>建造者模式的优雅解决</h2>
 * <pre>
 * Order order = Order.builder()
 *     .userId("U001")
 *     .productId("P100")
 *     .quantity(2)
 *     .address("北京市海淀区...")
 *     .build();
 * </pre>
 *
 * <h2>设计要点（参考 Effective Java 第 2 条）</h2>
 * <ol>
 *   <li>所有参数（包括必填）均通过 Builder 链式方法设置</li>
 *   <li>{@link #build()} 方法中对必填参数进行校验，保证对象始终处于有效状态</li>
 *   <li>目标类构造函数设为 private，强制客户端使用 Builder</li>
 * </ol>
 *
 */
public class Order {

    // ==================== 必填字段 ====================
    private final String userId;
    private final String productId;

    // ==================== 可选字段 ====================
    private final int quantity;
    private final String address;
    private final String remark;
    private final String couponCode;

    /**
     * 私有构造函数 — 只能通过 Builder 创建实例
     *
     * @param builder Builder 实例
     */
    private Order(Builder builder) {
        this.userId = builder.userId;
        this.productId = builder.productId;
        this.quantity = builder.quantity;
        this.address = builder.address;
        this.remark = builder.remark;
        this.couponCode = builder.couponCode;
    }

    // ==================== 静态 Builder 入口 ====================

    /**
     * 获取建造者实例，开始构建订单
     *
     * @return 新的 Builder 实例
     */
    public static Builder builder() {
        return new Builder();
    }

    // ==================== Builder 静态内部类 ====================

    /**
     * 建造者 — 通过链式调用逐步设置订单的所有字段
     *
     * <h2>设计要点</h2>
     * <ol>
     *   <li>Builder 提供无参构造，所有字段通过链式方法设置</li>
     *   <li>每个 setter 方法返回 {@code this}，支持流畅的链式调用</li>
     *   <li>{@link #build()} 方法执行参数校验，保证构建出的对象始终有效</li>
     * </ol>
     *
     */
    public static class Builder {

        // 必填字段（初始为 null，build() 时校验）
        private String userId;
        private String productId;

        // 可选字段（提供默认值）
        private int quantity = 1;
        private String address = "";
        private String remark = "";
        private String couponCode = "";

        /**
         * Builder 无参构造
         *
         * <p>必填参数通过链式方法设置，在 {@link #build()} 时统一校验，
         * 这样可以实现所有字段的链式调用风格一致。</p>
         */
        public Builder() {
        }

        /**
         * 设置用户 ID（必填）
         *
         * @param userId 用户 ID，不允许为 {@code null} 或空字符串
         * @return Builder 自身，支持链式调用
         */
        public Builder userId(String userId) {
            if (userId == null || userId.trim().isEmpty()) {
                throw new IllegalArgumentException("userId 不能为空");
            }
            this.userId = userId;
            return this;
        }

        /**
         * 设置商品 ID（必填）
         *
         * @param productId 商品 ID，不允许为 {@code null} 或空字符串
         * @return Builder 自身，支持链式调用
         */
        public Builder productId(String productId) {
            if (productId == null || productId.trim().isEmpty()) {
                throw new IllegalArgumentException("productId 不能为空");
            }
            this.productId = productId;
            return this;
        }

        /**
         * 设置购买数量（可选，默认 1）
         *
         * @param quantity 数量，必须大于 0
         * @return Builder 自身，支持链式调用
         */
        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        /**
         * 设置收货地址（可选）
         *
         * @param address 收货地址
         * @return Builder 自身，支持链式调用
         */
        public Builder address(String address) {
            this.address = address != null ? address : "";
            return this;
        }

        /**
         * 设置备注信息（可选）
         *
         * @param remark 备注
         * @return Builder 自身，支持链式调用
         */
        public Builder remark(String remark) {
            this.remark = remark != null ? remark : "";
            return this;
        }

        /**
         * 设置优惠码（可选）
         *
         * @param couponCode 优惠码
         * @return Builder 自身，支持链式调用
         */
        public Builder couponCode(String couponCode) {
            this.couponCode = couponCode != null ? couponCode : "";
            return this;
        }

        /**
         * 构建 Order 实例，执行最终校验
         *
         * <h2>校验规则</h2>
         * <ul>
         *   <li>userId 和 productId 必须已设置（必填校验）</li>
         *   <li>quantity 必须大于 0</li>
         *   <li>如果设置了地址，则不能为空字符串</li>
         * </ul>
         *
         * @return 构建完成的 Order 实例
         * @throws IllegalStateException 当必填参数未设置或校验不通过时抛出
         */
        public Order build() {
            // 必填参数校验 — 放在 build() 中统一处理
            if (userId == null || userId.trim().isEmpty()) {
                throw new IllegalStateException("userId 为必填项，请通过 .userId() 设置");
            }
            if (productId == null || productId.trim().isEmpty()) {
                throw new IllegalStateException("productId 为必填项，请通过 .productId() 设置");
            }
            if (quantity <= 0) {
                throw new IllegalStateException("购买数量必须大于 0，当前值: " + quantity);
            }
            if (address != null && !address.trim().isEmpty() && address.trim().length() < 5) {
                throw new IllegalStateException("收货地址过短，请填写完整的地址信息");
            }
            return new Order(this);
        }
    }

    // ==================== Getter 方法 ====================

    public String getUserId() {
        return userId;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getAddress() {
        return address;
    }

    public String getRemark() {
        return remark;
    }

    public String getCouponCode() {
        return couponCode;
    }

    /**
     * 打印订单摘要信息
     */
    public void printSummary() {
        System.out.println("  [订单摘要]");
        System.out.println("    用户ID: " + userId);
        System.out.println("    商品ID: " + productId);
        System.out.println("    数量: " + quantity);
        if (!address.isEmpty()) {
            System.out.println("    地址: " + address);
        }
        if (!remark.isEmpty()) {
            System.out.println("    备注: " + remark);
        }
        if (!couponCode.isEmpty()) {
            System.out.println("    优惠码: " + couponCode);
        }
    }
}
