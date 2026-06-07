/**
 * 观察者模式（Observer Pattern）
 *
 * <h2>模式说明</h2>
 * <p>定义对象间的一种一对多的依赖关系，
 * 当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。</p>
 *
 * <h2>现实类比</h2>
 * <p>微信公众号订阅：</p>
 * <pre>
 * 公众号（Subject/被观察者）发布新文章
 *   ↓
 * 所有订阅者（Observer/观察者）自动收到推送通知
 *   ↓
 * 每个订阅者可以自行决定如何处理（阅读、分享、忽略）
 *
 * 关键：公众号不需要知道每个订阅者的具体身份
 *       订阅者可以随时订阅/取消订阅
 * </pre>
 *
 * <h2>推模型 vs 拉模型</h2>
 * <table>
 *   <tr>
 *     <th>推模型（Push）</th>
 *     <th>拉模型（Pull）</th>
 *   </tr>
 *   <tr>
 *     <td>主题主动将变更数据传递给观察者</td>
 *     <td>观察者主动从主题获取需要的详细信息</td>
 *   </tr>
 *   <tr>
 *     <td>观察者不需要了解主题结构</td>
 *     <td>观察者需要持有主题引用，调用 getter 获取数据</td>
 *   </tr>
 * </table>
 *
 * <h2>Java 内置支持</h2>
 * <ul>
 *   <li>{@code java.util.Observable} / {@code java.util.Observer}
 *        —— JDK 内置实现，但从 JDK 9 起已标记为过时（deprecated）</li>
 *   <li>自定义实现更灵活，推荐自己实现观察者模式</li>
 *   <li>Spring 的 {@code ApplicationEventPublisher} —— 基于观察者模式的事件机制</li>
 *   <li>RxJava / Project Reactor —— 响应式编程中的观察者变体</li>
 * </ul>
 *
 * <h2>注意事项</h2>
 * <ul>
 *   <li>观察者链可能导致<strong>级联通知</strong>——要注意避免循环通知</li>
 *   <li>如果观察者执行耗时操作，会阻塞主题线程——考虑异步通知</li>
 *   <li>观察者如果不及时注销，可能导致<strong>内存泄漏</strong>（尤其是匿名内部类持有外部引用时）</li>
 * </ul>
 *
 * @see patterns.behavioral.observer 观察者模式示例（自定义实现）
 */
package patterns.behavioral.observer;
