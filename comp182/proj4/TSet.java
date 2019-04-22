/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author chris
 * @param <K>
 */
public class TSet<K extends Comparable<K>> implements Set<K> 
{
    
    private Tree<K,K> MuhTree;
    
    /*TSet(K k)
    {
        this.MuhTree = new Tree<k,k>();
    }
    */
    private TSet() {
        this.MuhTree = new Tree<>();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<K> asList(){
        
        return this.MuhTree.inorderTraversal();
    }
    
    
    
    @Override
    public Object[] toArray() {
        return this.MuhTree.inorderTraversal().toArray();
          
    }

   

    @Override
    public int size() {
            
        return this.MuhTree.inorderTraversal().size();
    }

    @Override
    public boolean isEmpty() {
        return (this.size() == 0);            
    }

    @Override
    public boolean contains(Object o) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (this.MuhTree.inorderTraversal().contains(o));
        
        
    }

    @Override
    public Iterator<K> iterator() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return this.iterator();
    }

    @Override
    public boolean add(K e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //return (this.MuhTree.put(e, e));
        if (this.contains(e))
            return false;
        else
            this.MuhTree.put(e, e);
        return true;
        
    }

    @Override
    public boolean remove(Object o) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            if (this.contains(o)) {
                this.MuhTree.remove((K) o);
                return true;
            } else {
                return false;
            }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return this.MuhTree.postorderTraversal().containsAll(c);
        
    
    
    }

    @Override
    public boolean addAll(Collection<? extends K> c) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Object[] E = c.toArray();
        for (Object e : E)
            this.MuhTree.put((K)e, (K)e);
        return this.containsAll(c);
    
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        ArrayList<K> temp = this.MuhTree.postorderTraversal();
        boolean result = temp.retainAll(c);
        this.MuhTree = new Tree<>();
        this.addAll(temp);
        return result;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> c) {
         ArrayList<K> temp = this.MuhTree.postorderTraversal();
        boolean result = temp.removeAll(c);
        this.MuhTree = new Tree<>();
        this.addAll(temp);
        return result;
             
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    
    }

    @Override
    public void clear() {
        
        this.MuhTree = new Tree<>();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T[] toArray(T[] a) {
//        T[] result = (T[]) Array.newInstance(a[0].getClass(), a.length );
//        for 
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //use in linked list to generate an array
        //toarray, generates a generic array given 
        //the type of first type in input
        //.getclass method
        return this.MuhTree.postorderTraversal().toArray(a);
        
    }
    
}


