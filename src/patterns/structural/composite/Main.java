package patterns.structural.composite;

/**
 * 组合模式演示入口
 *
 * <p>演示餐馆菜单系统的树形结构，
 * 展示组合模式如何让客户端统一操作单个菜品和整个菜单。</p>
 *
 * <h2>菜单树结构</h2>
 * <pre>
 * 餐厅菜单
 *   ├── 主食类
 *   │   ├── 菜品：宫保鸡丁  ￥28.00
 *   │   ├── 菜品：麻婆豆腐  ￥22.00
 *   │   └── 菜品：鱼香肉丝  ￥26.00
 *   ├── 饮料类
 *   │   ├── 菜品：可乐  ￥8.00
 *   │   └── 菜品：橙汁  ￥12.00
 *   └── 甜品类
 *       ├── 菜品：冰淇淋  ￥15.00
 *       └── 菜品：蛋糕  ￥18.00
 * </pre>
 *
 * <h2>修复说明</h2>
 * <p>原代码中存在 Main.java 拼写错误（Mian.java），
 * 本文件已修正为正确的 Main.java。</p>
 *
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("========== 组合模式演示：餐馆菜单系统 ==========");
        System.out.println();

        // ========== 构建菜单树 ==========
        // 创建根菜单（餐厅菜单）
        Menu restaurantMenu = new Menu("餐厅菜单");

        // 创建子菜单：主食类
        Menu stapleFood = new Menu("主食类");
        stapleFood.add(new MenuItem("宫保鸡丁", 28.0));
        stapleFood.add(new MenuItem("麻婆豆腐", 22.0));
        stapleFood.add(new MenuItem("鱼香肉丝", 26.0));

        // 创建子菜单：饮料类
        Menu drinks = new Menu("饮料类");
        drinks.add(new MenuItem("可乐", 8.0));
        drinks.add(new MenuItem("橙汁", 12.0));

        // 创建子菜单：甜品类
        Menu desserts = new Menu("甜品类");
        desserts.add(new MenuItem("冰淇淋", 15.0));
        desserts.add(new MenuItem("蛋糕", 18.0));

        // 将子菜单添加到根菜单
        restaurantMenu.add(stapleFood);
        restaurantMenu.add(drinks);
        restaurantMenu.add(desserts);

        // ========== 打印整个菜单树 ==========
        System.out.println("--- 打印完整菜单 ---");
        restaurantMenu.print();

        System.out.println();
        System.out.println("========== 组合模式优势 ==========");
        System.out.println("1. 客户端只需调用 restaurantMenu.print() 即可打印整棵树");
        System.out.println("2. 新增菜品：只需创建一个 MenuItem 并 add 到对应 Menu");
        System.out.println("3. 新增子菜单：只需创建一个 Menu 并 add 到父 Menu");
        System.out.println("4. 安全组合：MenuItem 没有 add/remove 方法，接口更安全");
    }
}
