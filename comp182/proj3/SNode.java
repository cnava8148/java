/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

/**
 *
 * @author chris
 * @param <T>
 */

/**
 *
 * @author chris
 * @param <T>
 */
public class SNode <T extends Comparable <T>> implements Comparable <SNode <T>> 
    {
        final T element;
        final SNode <T> next;
        
        SNode (T input, SNode next){
            this.element = input;
            this.next =     next;
        }
        
        SNode(T input)
        {
            this(input, null);
        }
        
        @Override 
        public int compareTo(SNode<T> otherNode)
        {
            return this.element.compareTo(otherNode.element);
        }
    
    
}
