/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;


import java.util.Iterator;


/**
 *
 * @author chris
 * @param <E>
 */
public class MahQueue <E extends Comparable <E>> implements Iterable <E>
{
    private final MyLinkedList<E> MuhList;
    
    MahQueue(E input)
    {
        this.MuhList = new MyLinkedList<>(input);
        
    }
    
    MahQueue ()
    {
        this.MuhList = new MyLinkedList<>();
    }
    
    MahQueue(E[] input)
    {
        this.MuhList = new MyLinkedList<>(input);
    }
    
    @Override
    public Iterator<E> iterator() {
        return this.MuhList.iterator();
    }
    
    //remove first element
    //return the new thing
    //convert it to array
    
    MahQueue<E> deQueue()
    {
        return new MahQueue<>(MyLinkedList.toArray(MuhList.removeFirst()));
    }
    
    MahQueue<E> enQueue(E input)
    {
        return new MahQueue<>(MyLinkedList.toArray(
                MuhList.concat(this.MuhList, (MyLinkedList<E>) input) ) );
    }
    
    
    int size(){
        return MuhList.size;
    }
    
    boolean isEmpty(E input)
    {
        return (0==this.MuhList.size);
    }
    
    MahQueue Empty()
    {
        return new MahQueue();
    }
    
    E atIndex(int index)
    {
        if (index > 0 && index < this.size())
        {
            E[] temp = MyLinkedList.toArray(MuhList);
            return temp[index];//this.MuhList.toArray
        }
        return null;
    }
    
    boolean isEquals(Object o){
        if (o instanceof MahQueue)
        {
            return this.MuhList.equals(o);
        }
        else {
            return false;
        }
    }
}
