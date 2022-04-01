package deque;
import java.util.Iterator;

public class LinkedListDeque<Elem> implements Iterator<Elem>{

    private class DNode{
        Elem data;
        DNode front;
        DNode next;

        private DNode(Elem e){
            data = e;
        }
    }

    int size;
    DNode sentinel;

    public LinkedListDeque(){
        sentinel = new DNode(null);

        sentinel.front = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(Elem e){
        size++;
        DNode p = new DNode(e);

        p.front = sentinel;
        p.next = sentinel.next;

        if(size == 1){
            sentinel.front = p;
        }

        sentinel.next = p;
    }

    public void addLast(Elem e){
        size++;
        DNode p = new DNode(e);

        p.next = sentinel;
        p.front = sentinel.front;
        sentinel.front.next = p;
        sentinel.front = p;
        if(size == 1){
            sentinel.next = p;
        }
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }else{
            return false;
        }
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        DNode p = sentinel.next;
        while( p != sentinel){
            System.out.printf("%s ",p.data);
            p = p.next;
        }
        System.out.printf("\n");
    }

    public Elem removeFirst(){
        if(size == 0){
            return  null;
        }
        size--;
        if(size == 1){
            Elem p = sentinel.next.data;
            sentinel.next = sentinel;
            sentinel.front = sentinel;
            return p;
        }
        Elem p = sentinel.next.data;
        sentinel.next.next.front = sentinel;
        sentinel.next = sentinel.next.next;
        return p;
    }

    public Elem removeLast(){
        if(size<=1){
            removeFirst();
        }
        Elem p = sentinel.front.data;
        sentinel.front.front.next = sentinel;
        sentinel.front = sentinel.front.front;
        return p;
    }


    public Elem get(int index){
        int i = 0;
        DNode p = sentinel;
        while(i!=index){
            i++;
            if(p == null){
                return null;
            }
            p = sentinel.next;
        }
        return p.data;
    }

    DNode index = sentinel;
    public boolean hasNext(){
        if(this.index.next==sentinel){
            return false;
        }
        return true;
    }
    public Elem next(){
        if(hasNext()){
            index = index.next;
            return index.data;
        }
        return null;
    }
    public void remove(){
        index.front.next=index.next;
        index.next.front=index.front;
    }

    public Iterator<Elem> iterator(){
        Iterator itr = new LinkedListDeque();
        return itr;
    }

    public static void main(String args[]){
        LinkedListDeque l1 = new LinkedListDeque();

    }
}