package org.example.section1;

public class GenericClass<T> {
    private final T value;

    public GenericClass(T initialValue){
        this.value = initialValue;
    }

    public T getValue() {
        return value;
    }
}
