package leetcode.editor.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2022/11/10
 * @update:修改内容
 * @author: fesine
 * @updateTime:2022/11/10
 */
public class CovariantArrays {
    public static void main(String[] args) {
        //上界，不可以add，但可以get，用父类fruit接受任何一个子类
        List<? extends Fruit> flistTop = new ArrayList<Apple>();
        //flistTop.add(new Fruit());
        //flistTop.add(new Apple());
        flistTop.add(null);
        Fruit fruit = flistTop.get(0);
        //下界，可以添加本身及子类
        List<? super Apple> flistBottem = new ArrayList<Apple>();
        flistBottem.add(new Apple());
        flistBottem.add(new Jonathan());
        //flistBottem.add(new Fruit());
        //get Apple对象会报错，取出的对象是apple的父类，用apple接收必须要强转
        //Apple apple = flistBottem.get(0);
    }
}

class Fruit {
}

class Apple extends Fruit {
}

class Jonathan extends Apple {
}

class Orange extends Fruit {
}
