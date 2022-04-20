package deque;
import java.util.Iterator;

public class LinkedListDeque<Elem> implements Iterator<Elem>,dequeAPI<Elem>{


    /* DequeAPI Interface methods begin: */

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
    DNode index;
    public LinkedListDeque(){
        sentinel = new DNode(null);
        index = this.sentinel;
        sentinel.front = sentinel;
        sentinel.next = sentinel;
    }

    @Override
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


    @Override
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

    @Override
    public int size(){
        return size;
    }

    @Override
    public void printDeque(){
        DNode p = sentinel.next;
        while( p != sentinel){
            System.out.printf("%s ",p.data);
            p = p.next;
        }
        System.out.printf("\n");
    }

    @Override
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

    @Override
    public Elem removeLast(){
        if(size<=1){
            removeFirst();
        }
        Elem p = sentinel.front.data;
        sentinel.front.front.next = sentinel;
        sentinel.front = sentinel.front.front;
        return p;
    }


    @Override
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


    @Override
    public boolean hasNext(){
        if(index.next==sentinel){
            return false;
        }
        return true;
    }

    @Override
    public Elem next(){
        if(hasNext()){
            index = index.next;
            return index.data;
        }
        return null;
    }

    @Override
    public boolean equal(Object o){
        if(!(o instanceof  LinkedListDeque)){
            return false;
        }

        LinkedListDeque x  = (LinkedListDeque)o;
        DNode p =x.sentinel.next;
        DNode q =sentinel.next;
        while(p!=x.sentinel){
            if(p.data!=q.data||x.size!=size){
                return false;
            }
            p=p.next;
            q=q.next;
        }
        return true;
    }

    /* DequeAPI methods End; */





    /* Iterator interface methods Begin*/

    public void remove(){
        index.front.next=index.next;
        index.next.front=index.front;
    }

    public Iterator<Elem> iterator(){
        Iterator itr = this;
        return itr;
    }

    /* Iterator interface methods End */

}