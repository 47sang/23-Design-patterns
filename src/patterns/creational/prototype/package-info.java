/**
 * 原型模式（Prototype Pattern）
 *
 * <h2>模式说明</h2>
 * <p>用原型实例指定创建对象的种类，并通过拷贝这些原型创建新的对象。</p>
 *
 * <h2>为什么需要原型模式？</h2>
 * <p>有些对象的创建成本很高（如需要读取数据库、进行复杂计算、加载大量资源）。
 * 如果每次都需要重新创建，会浪费大量时间和资源。
 * 原型模式通过<strong>克隆</strong>一个已有的对象来创建新对象，避免了昂贵的初始化过程。</p>
 *
 * <h2>Java 中的克隆机制</h2>
 * <pre>
 * class Prototype implements Cloneable {
 *     @Override
 *     protected Object clone() throws CloneNotSupportedException {
 *         return super.clone();  // Object.clone() 执行浅拷贝
 *     }
 * }
 * </pre>
 *
 * <h2>浅拷贝 vs 深拷贝</h2>
 * <table>
 *   <tr>
 *     <th>类型</th>
 *     <th>基本类型字段</th>
 *     <th>引用类型字段</th>
 *     <th>性能</th>
 *   </tr>
 *   <tr>
 *     <td>浅拷贝（Shallow Copy）</td>
 *     <td>复制值</td>
 *     <td>复制引用（共享同一个对象）</td>
 *     <td>快</td>
 *   </tr>
 *   <tr>
 *     <td>深拷贝（Deep Copy）</td>
 *     <td>复制值</td>
 *     <td>递归复制（创建新的引用对象）</td>
 *     <td>慢</td>
 *   </tr>
 * </table>
 *
 * <h2>实现深拷贝的方式</h2>
 * <ul>
 *   <li>重写 {@code clone()} 方法，手动复制引用类型字段</li>
 *   <li>实现 {@code Serializable}，通过序列化/反序列化实现深拷贝</li>
 *   <li>使用拷贝构造函数</li>
 *   <li>Java 16+ 的 {@code record} 天然不可变，天然支持安全的"拷贝"语义</li>
 * </ul>
 *
 * <h2>业务场景</h2>
 * <ul>
 *   <li>游戏开发：复制游戏对象（怪物、道具）的属性和状态</li>
 *   <li>文档系统：基于模板创建新文档</li>
 *   <li>数据对象复制：复制复杂的业务对象避免重复初始化</li>
 * </ul>
 *
 */
package patterns.creational.prototype;
