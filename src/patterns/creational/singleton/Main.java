package patterns.creational.singleton;

/**
 * 单例模式演示入口
 *
 * <h2>演示内容</h2>
 * <ol>
 *   <li>逐一演示 4 种单例实现方式</li>
 *   <li>验证每种方式返回的实例是否为同一个对象（引用比较）</li>
 *   <li>对比各实现方式的优缺点和适用场景</li>
 * </ol>
 *
 * <h2>四种实现对比</h2>
 * <table>
 *   <tr>
 *     <th>实现方式</th>
 *     <th>线程安全</th>
 *     <th>懒加载</th>
 *     <th>防反射</th>
 *     <th>防序列化</th>
 *     <th>推荐度</th>
 *   </tr>
 *   <tr>
 *     <td>EagerSingleton（饿汉式）</td>
 *     <td>✅</td>
 *     <td>❌</td>
 *     <td>❌</td>
 *     <td>❌</td>
 *     <td>⭐⭐⭐</td>
 *   </tr>
 *   <tr>
 *     <td>LazySingleton（DCL）</td>
 *     <td>✅</td>
 *     <td>✅</td>
 *     <td>❌</td>
 *     <td>❌</td>
 *     <td>⭐⭐⭐⭐</td>
 *   </tr>
 *   <tr>
 *     <td>HolderSingleton（内部类）</td>
 *     <td>✅</td>
 *     <td>✅</td>
 *     <td>❌</td>
 *     <td>❌</td>
 *     <td>⭐⭐⭐⭐⭐ 推荐</td>
 *   </tr>
 *   <tr>
 *     <td>EnumSingleton（枚举）</td>
 *     <td>✅</td>
 *     <td>❌</td>
 *     <td>✅</td>
 *     <td>✅</td>
 *     <td>⭐⭐⭐⭐⭐ 推荐</td>
 *   </tr>
 * </table>
 *
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("===== 单例模式演示（4种实现） =====");
        System.out.println();

        // 1. 饿汉式
        System.out.println("--- 1. 饿汉式（EagerSingleton） ---");
        EagerSingleton eager1 = EagerSingleton.getInstance();
        EagerSingleton eager2 = EagerSingleton.getInstance();
        System.out.println("  同一实例? " + (eager1 == eager2)); // true
        eager1.process("饿汉式测试");
        System.out.println();

        // 2. 懒汉式（双重检查锁）
        System.out.println("--- 2. 懒汉式（LazySingleton, DCL + volatile） ---");
        LazySingleton lazy1 = LazySingleton.getInstance();
        LazySingleton lazy2 = LazySingleton.getInstance();
        System.out.println("  同一实例? " + (lazy1 == lazy2)); // true
        lazy1.process("懒汉式测试");
        System.out.println();

        // 3. 静态内部类（推荐）
        System.out.println("--- 3. 静态内部类（HolderSingleton，推荐） ---");
        HolderSingleton holder1 = HolderSingleton.getInstance();
        HolderSingleton holder2 = HolderSingleton.getInstance();
        System.out.println("  同一实例? " + (holder1 == holder2)); // true
        holder1.process("静态内部类测试");
        System.out.println();

        // 4. 枚举方式（最安全）
        System.out.println("--- 4. 枚举方式（EnumSingleton，最安全） ---");
        EnumSingleton enum1 = EnumSingleton.INSTANCE;
        EnumSingleton enum2 = EnumSingleton.INSTANCE;
        System.out.println("  同一实例? " + (enum1 == enum2)); // true
        enum1.process("枚举方式测试");
        System.out.println();

        // 总结
        System.out.println("===== 总结 =====");
        System.out.println("  日常开发首选：HolderSingleton（懒加载 + 简洁）");
        System.out.println("  安全要求最高：EnumSingleton（防反射/序列化攻击）");
    }
}
