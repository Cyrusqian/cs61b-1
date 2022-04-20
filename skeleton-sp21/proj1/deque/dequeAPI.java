package deque;

import java.util.Iterator;

public interface dequeAPI<Elem> {
    void addFirst(Elem e);

    void addLast(Elem e);

    default boolean isEmpty(){
       return size()==0;
    }

    int size();

    void printDeque();

    Elem removeFirst();

    Elem removeLast();

    Elem get(int index);

    boolean equal(Object o);

    Iterator<Elem> iterator();

}
