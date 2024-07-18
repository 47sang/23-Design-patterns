package C.e;

import java.util.Iterator;

/**
 * @author 周士钰
 * @date 2024/7/20 下午3:11
 */
public class ArrayCollection<T> implements Iterable<T>{ //实现Iterable接口表示此类是支持迭代的

    //底层使用一个数组来存放数据
    private final T[] array;

    //自己用
    private ArrayCollection(T[] array) {
        this.array = array;
    }

    //开个静态方法直接吧数组转换成ArrayCollection，
    // 其实和直接new一样，但是这样写好看一点
    public static <T> ArrayCollection<T> of(T[] array){

        return new ArrayCollection<>(array);
    }

    //需要实现iterator方法，此方法会返回一个迭代器，用于迭代我们集合中的元素
    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }


    //这里实现一个，注意别用静态，需要使用对象中存放的数组
    private class ArrayIterator implements Iterator<T> {

        //这里我们通过一个指针表示当前的迭代位置
        private int index = 0;

        /**
         * 判断是否还有下一个元素
         */
        @Override
        public boolean hasNext() {
            //如果指针大于或等于数组最大长度，就不能再继续了
            return index < array.length;
        }

        /**
         * 返回当前指针位置的元素并向后移动一位
         */
        @Override
        public T next() {
            //正常返回对应位置的元素，并将指针自增
            return array[index++];
        }
    }
}
