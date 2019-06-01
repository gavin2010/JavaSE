package com.gavin.generic;

public interface Animal<T> {
    public T next();
}

// class Horse implements Animal<T>{  //要报错实现泛型接口类也是泛型
class Horse<T> implements Animal<T>{
    @Override
    public T next() {
        return null;
    }
}

class Lion implements Animal<String>{ //不会报错，指明了具体的类String
    @Override
    public String next() {
        return null;
    }
}