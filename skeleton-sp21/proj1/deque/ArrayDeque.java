package deque;

import java.util.Iterator;

public class ArrayDeque<Elem> implements dequeAPI<Elem>,Iterator<Elem>{
    int size;
    int length = 8;
    Elem[] data = (Elem[]) new Object[length];

    public ArrayDeque() {
        size = 0;
    }

    /* DequeAPI interface methods start */

    @Override
    public void addFirst(Elem e) {

        checkSize();
        Elem[] Copy = (Elem[]) new Object[length];
        Copy[0] = e;
        System.arraycopy(data,0,Copy,1,size);
        data = Copy;
        size++;

    }

    @Override
    public void addLast(Elem e) {

        checkSize();

        data[size] = e;
        size++;

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = 1; i <= size; i++) {
            System.out.printf("%s\n", data[i - 1]);
        }
    }


    @Override
    public Elem removeFirst() {
        Elem p = data[0];
        System.arraycopy(data, 1, data, 0, size);
        size--;
        return p;
    }

    @Override
    public Elem removeLast() {
        size--;
        return data[size];
    }

    @Override
    public Elem get(int index) {
        if (index >= 1) {
            return data[index - 1];
        } else {
            return null;
        }
    }

    @Override
    public boolean equal(Object o){
        if(!(o instanceof ArrayDeque))return false;
           ArrayDeque x = (ArrayDeque)o;
        for (int i = 0;i<size;i++){
            if(data[i]!=x.data[i]||x.size!=size){
                return false;
            }
        }
        return true;
    }

    public void mulResize(int z) {
        length *= z;
        Elem[] p = (Elem[]) new Object[length];
        System.arraycopy(data, 0, p, 0, size);
        data = p;
    }



    public void checkSize() {
        if (size == length) {
            mulResize(2);
        }
    }

    public Iterator<Elem> iterator(){
        Iterator<Elem> itr = new ArrayDeque<>();
        return itr;
    }
    /* DequeAPI interface methods End */


    /* Iterator interface methods start */
   int index = -1;
   public boolean hasNext(){
        return index<size-1;
   }

   public Elem next(){
       if(hasNext()){
           index++;
           return data[index];
       }
       return null;
   }








}
