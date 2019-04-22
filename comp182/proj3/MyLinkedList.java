/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author chris
 */
class MyLinkedList<E extends Comparable<E>> implements Iterable<E> 
{
    final int size;
    final SNode <E> head; 
    //final SNode <E> tail;
    
    MyLinkedList()
    {
        this.head = new SNode<>(null);
        this.size = 0;
    }
    
    MyLinkedList(E input){
        this.head = new SNode(null, new SNode(input));
        this.size = 1;
    }
    MyLinkedList (E[] input)
    {
        Arrays.sort(input);

        if (input.length >= 1){
            this.head = new SNode(null, Helper(input));
            this.size = input.length;
            
        }
        else {
            this.head = new SNode(null, null);
            this.size = 0;
        }
    }
    private SNode Helper(E[] input){
        if (input.length == 1){
            return new SNode(input[0], null);
        }
        else {
            return new SNode (input[0], Helper(Arrays.copyOfRange(input,1, input.length) )) ;
        }
    }
   
    E getFirst(){
        return head.next.element;
    }
    
    MyLinkedList<E> removeFirst()
    {
        return new 
        MyLinkedList(Arrays.copyOfRange(MyLinkedList.toArray(this), 1, this.size));
        //    MyLinkedList(MyLinkedList.<E>toArray(this));
    }
    
    MyLinkedList<E> concat (MyLinkedList <E> input1, MyLinkedList <E> input2)
    {
        E[] self = MyLinkedList.toArray(input1);
        E[] other = MyLinkedList.toArray(input2);
        E[] result = (E[]) Array.newInstance(self[0].getClass(), self.length + other.length);
        for (int i = 0; i < self.length; i+=1)
        {
            result[i] = self[i];
        }
        int offset = self.length;
        for (int i = 0; i < other.length; i+=1)
        {
            result [i+offset] = other[i];
        }
        return new MyLinkedList<>(result);
        
    }
    
    
    static <E extends Comparable<E>>E[] toArray (MyLinkedList<E> input)
    {
        E[] result = (E[]) Array.newInstance(input.getFirst().getClass(), input.size);
        SNode temp = input.head;
        for (int i = 0; i < input.size; i+=1)
        {
            temp = temp.next;
            result[i] = (E)temp.element;
      
        }
        return result;
    }
    
    MyLinkedList<E> addToFront(E input)
    {
        MyLinkedList<E> Add = new MyLinkedList<>(input);
        return concat(Add, this);
    }
    
    /*MyLinkedList<E> addToFront(E input)
    {
        MyLinkedList<E> Add = new MyLinkedList<>(input);
        return concat(Add, this);
    }
    */
    E atIndex(int x)
    {
        if (x > 0 && x < this.size){
            SNode temp = this.head;
            for (int i = 0; i <= x; i+= 1)
            {
                temp = temp.next;
            }
            return (E) temp.element;
        }
        else {
            return null;
        }
    }
    
    @Override
    public Iterator <E> iterator(){
        List <E> MahList;
        MahList = Arrays.asList( (E[]) MyLinkedList.toArray(this) );
        return MahList.iterator(); 
    }
    
    public boolean isEqual(Object obj){
        boolean tempBool = false;
        if (obj instanceof MyLinkedList)
        {
            MyLinkedList<E> tempList = (MyLinkedList<E>) obj;
            if (tempList.size == this.size)
            {
                E[] tempArr1 = MyLinkedList.toArray(this);
                E[] tempArr2 = MyLinkedList.toArray(tempList);
                tempBool = true;
                for (int i = 0; i < this.size; i+=1)
                {
                    if (tempArr1[i].compareTo(tempArr2[i]) != 1)
                    {
                        tempBool = false;
                    }
                }
            }
            
            
            
        }
        return tempBool;
    }
    
}
