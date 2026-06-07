package patterns.behavioral.iterator;

import java.util.Iterator;

/**
 * 自定义数组集合（ArrayCollection）— 迭代器模式中的聚合对象（Aggregate）。
 *
 * <h2>设计意图</h2>
 * <p>自己实现一个基于数组的集合类，使其支持 for-each 遍历。
 * 关键在于实现 {@link Iterable} 接口并提供 {@link #iterator()} 方法，
 * 返回一个自定义的迭代器。</p>
 *
 * <h2>与迭代器模式的关系</h2>
 * <ul>
 *   <li>{@link ArrayCollection} 是聚合对象（Aggregate），
 *       负责存储数据并创建迭代器</li>
 *   <li>内部类 {@link ArrayIterator} 是具体迭代器（Concrete Iterator），
 *       负责遍历聚合对象中的元素</li>
 *   <li>{@link Iterable} 是 Java 标准库中的聚合接口，
 *       声明了 {@link #iterator()} 工厂方法</li>
 * </ul>
 *
 * <h2>Iterator 接口的三个方法</h2>
 * <ul>
 *   <li>{@link Iterator#hasNext()} — 判断是否还有下一个元素</li>
 *   <li>{@link Iterator#next()} — 返回下一个元素，同时将游标后移</li>
 *   <li>{@link Iterator#remove()} — 删除最近一次通过 {@code next()} 返回的元素
 *       （本实现暂不支持，调用会抛出 UnsupportedOperationException）</li>
 * </ul>
 *
 * <h2>Iterable 接口的作用</h2>
 * <p>{@code Iterable<T>} 是 Java 5 引入的接口，只声明了 {@link #iterator()} 方法。
 * 实现该接口的对象才能用于 for-each 循环（enhanced for loop）。
 * 它的核心作用是"提供迭代器"，与 {@code Iterator} 是合作关系而非继承关系。</p>
 *
 * @param <T> 集合中元素的类型
 *
 */
public class ArrayCollection<T> implements Iterable<T> {

    /** 默认初始容量 */
    private static final int DEFAULT_CAPACITY = 10;
    /** 存储元素的数组 */
    private Object[] elements;
    /** 当前元素个数 */
    private int size;

    /**
     * 构造一个空数组集合，初始容量为 {@value #DEFAULT_CAPACITY}。
     */
    public ArrayCollection() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * 构造一个指定初始容量的数组集合。
     *
     * @param initialCapacity 初始容量
     * @throws IllegalArgumentException 当初始容量小于0时抛出
     */
    public ArrayCollection(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("初始容量不能为负数: " + initialCapacity);
        }
        this.elements = new Object[initialCapacity];
        this.size = 0;
    }

    /**
     * 向集合末尾添加一个元素。
     *
     * @param element 要添加的元素
     */
    public void add(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    /**
     * 根据索引获取元素。
     *
     * @param index 元素索引（0-based）
     * @return 索引对应的元素
     * @throws IndexOutOfBoundsException 当索引越界时抛出
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    /** @return 集合中元素的个数 */
    public int size() {
        return size;
    }

    /**
     * 确保数组容量足够，如果不足则自动扩容（扩容为原来的2倍）。
     */
    private void ensureCapacity() {
        if (size >= elements.length) {
            int newCapacity = elements.length * 2;
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(elements, 0, newArray, 0, size);
            elements = newArray;
        }
    }

    /**
     * 检查索引是否合法。
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                "索引越界: size=" + size + ", index=" + index
            );
        }
    }

    /**
     * 返回集合的迭代器，使 ArrayCollection 支持 for-each 遍历。
     *
     * <p>每次调用 {@code iterator()} 都会创建一个新的 ArrayIterator 实例，
     * 这意味着多个迭代器可以同时独立工作。</p>
     *
     * @return 一个新的数组迭代器
     */
    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    /**
     * 数组迭代器（ArrayIterator）— 迭代器模式中的具体迭代器。
     *
     * <p>内部类持有外部类 {@link ArrayCollection} 的引用，
     * 通过游标（cursor）追踪当前遍历位置。
     * 每次调用 {@link #next()} 后，游标后移一位。</p>
     *
     * <h2>与 ArrayCollection 的关系</h2>
     * <p>ArrayIterator 作为 ArrayCollection 的内部类，
     * 可以直接访问外部类的 {@code elements} 数组和 {@code size} 字段，
     * 无需通过 getter 方法。这符合迭代器模式的"访问内部表示"原则，
     * 同时因为内部类不是 public 的，外部无法直接操作数组，
     * 保持了封装性。</p>
     *
     * @param <T> 集合中元素的类型（继承外部类的类型参数）
     */
    private class ArrayIterator implements Iterator<T> {

        /** 当前游标位置，指向下一个待返回的元素 */
        private int cursor = 0;

        /**
         * 判断是否还有下一个元素。
         *
         * @return 如果游标未到达集合末尾则返回 true
         */
        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        /**
         * 返回下一个元素，同时将游标后移一位。
         *
         * @return 当前位置的元素
         * @throws java.util.NoSuchElementException 当没有更多元素时抛出
         */
        @SuppressWarnings("unchecked")
        @Override
        public T next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException("没有更多元素可遍历");
            }
            return (T) elements[cursor++];
        }

        /**
         * 删除最近一次通过 {@link #next()} 返回的元素。
         *
         * <p>本实现暂不支持此操作。如果需要支持 remove，需要：
         * 1. 记录上一次 {@code next()} 返回的元素索引
         * 2. 将后续元素向前移动一位
         * 3. 处理 cursor 的回退</p>
         *
         * @throws UnsupportedOperationException 始终抛出，表示暂不支持
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException("ArrayIterator 暂不支持 remove 操作");
        }
    }
}
