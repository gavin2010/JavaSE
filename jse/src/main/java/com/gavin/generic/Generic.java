package com.gavin.generic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型类测试
 */
public class Generic {

    /**
     * 由于没有添加泛型，会造成类转换异常
     */

    public void generci(){
        List arrayList = new ArrayList();
        arrayList.add("AAA");
        arrayList.add(100);
        for(int i=0;i<arrayList.size();i++){
            String temp = (String)arrayList.get(i);
            System.out.println(temp);
        }
    }

    /**
     * 使用了泛型,类型不一致会报错
     */

    @Test
    public void generciA() {
        List<String> arrList = new ArrayList<>();
        arrList.add("AAA");
       // arrList.add(100);  会报错，编译不通过
        for(int i=0;i<arrList.size();i++){
            String temp = (String)arrList.get(i);
            System.out.println(temp);
        }
    }

    /**
     * 泛型类的测试
     */
    @Test
    public void testGenericClass(){
        GenericClass g = new GenericClass(123);
        GenericClass g1 = new GenericClass("AAA");
        System.out.println(g.getKey());
        System.out.println(g1.getKey());

        GenericClass<Integer> g3 = new GenericClass<>(10);
      //  GenericClass<Integer> g4 = new GenericClass<>("BB"); 报错,泛型限制

        Apple apple = new Apple();
        GenericClass<Apple> g5 = new GenericClass<>(apple);

        if(g5 instanceof GenericClass){}
       // if(g5 instanceof GenericClass<Apple>){}  报错，泛型是编译的事情,instanceof是运行的事
    }

}


//===================== 分隔线 ===========================

/**
 *  泛型类
 * @param <T>
 */
class GenericClass<T>{
    private T key;

    public GenericClass(T key){
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }
}

class Apple{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                '}';
    }
}
