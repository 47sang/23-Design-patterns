/**
 * 装饰模式（Decorator Pattern）
 *
 * <h2>模式说明</h2>
 * <p>动态地给一个对象添加额外的职责，
 * 就增加功能来说，装饰模式比生成子类更为灵活。</p>
 *
 * <h2>装饰器 vs 继承</h2>
 * <pre>
 * 继承方式：每增加一种功能就需要新增一个子类
 *   Component → ComponentA (功能1)
 *             → ComponentB (功能2)
 *             → ComponentAB (功能1+功能2)  ← 类爆炸！
 *
 * 装饰方式：每个功能是一个独立的装饰器类，可以灵活组合
 *   Component → DecoratorA (功能1) → DecoratorB (功能2) → 组合灵活
 * </pre>
 *
 * <h2>结构</h2>
 * <pre>
 *              ┌───────────────┐
 *              │  Component    │  ← 抽象组件（定义核心接口）
 *              │  + operation() │
 *              └───────┬───────┘
 *                      ▲ 继承
 *          ┌───────────┼───────────┐
 *          │           │           │
 *     ┌────┴────┐ ┌───┴────────┐ ┌┴──────────┐
 *     │Concrete │ │  Decorator │ │ Concrete   │
 *     │Component│ │  (装饰器)   │ │ Decorator  │
 *     │(核心实现)│ │- Component │ │ (具体装饰) │
 *     └─────────┘ │ + operation │ │+ operation │
 *                 └──────┬──────┘ │(增强逻辑)  │
 *                        │ 组合     └───────────┘
 *                   ┌────┴────┐
 *                   │ wrapped │
 *                   │component│
 *                   └─────────┘
 * </pre>
 *
 * <h2>装饰器链</h2>
 * <p>多个装饰器可以层层嵌套，形成一条链：</p>
 * <pre>
 * Component component = new ConcreteComponent();
 * component = new DecoratorA(component);
 * component = new DecoratorB(component);
 * component = new DecoratorC(component);
 * component.operation();  // 按装饰顺序依次执行
 * </pre>
 *
 * <h2>业务场景</h2>
 * <ul>
 *   <li>Java I/O 流：{@code BufferedInputStream} 装饰 {@code FileInputStream}，
 *       {@code DataInputStream} 再装饰 {@code BufferedInputStream} —— 经典应用</li>
 *   <li>Web 请求处理：请求的日志记录 → 权限验证 → 缓存处理 → 业务逻辑</li>
 *   <li>订单系统：基础订单 + 会员折扣 + 优惠券 + 积分抵扣</li>
 * </ul>
 *
 * @see patterns.structural.decorator 装饰模式示例
 */
package patterns.structural.decorator;
