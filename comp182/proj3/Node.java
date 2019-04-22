/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;
/**
 *
 * @author chris
 * @param <Key>
 * @param <V>
 */
public class Node <Key extends Comparable <Key>, V> implements Comparable <Node<Key,V>>
{
    private Key key;
    private V value;
    private Node <Key,V> leftChild;
    private Node <Key,V> rightChild;
    
    Node(Key key, V value, Node <Key,V> left, Node <Key,V> right)
    {
        this.key = key;
        this.value = value;
    }
    
    Node (Key key, V value)
    {
        this.key = key;
        this.value = value; 
    }
    
    @Override
    public int compareTo(Node <Key,V> o)
    {
        return this.key.compareTo(o.key); 
    }
    
    public V getValue()
    {
        return value;
    }
    public void setValue(V Value)
    {
        this.value = value;
    }
    
    public void changeLeftChild(Node <Key, V> input)
    {
        this.leftChild = input;
    }
    
    public Node<Key, V> getLeftChild()
    {
        return this.leftChild;
    }
    
    public boolean HasLeftChild(){
        return !(leftChild == null);
        
    }
    
    public boolean HasRightChild(){
        return !(rightChild == null);
    }
    
    public void changeRightChild(Node <Key,V> input){
        
        this.rightChild = input;
    }
    
    public Node<Key, V> getRightChild()
    {
        return this.rightChild;
    }
    
    public boolean hasSameKey(Key key)
    {
        return this.key == key;
    }
    
    public V getMin()
    {
        if (this.HasLeftChild())
        {
            return this.leftChild.getMin();
        }
        else 
        {
            return value;
        }
    }
    
    public V getMax(){
        if (this.HasRightChild())
        {
            return this.rightChild.getMax();
        }
        else{
            return value;
        }
    }
    
    //one insert method
//    void insert(Node <Key,V> input )
//    {
//        //
//        if (input.compareTo(this) == 0 )
//        {
//            this.value = input.value;
//        }
//        else if(input.compareTo(this) > 0) 
//        {
//            if (this.rightChild == null){
//                this.rightChild.insert(input);
//            }
//            else {
//                this.rightChild.insert(input); 
//            }
//        }
//        else {
//            if( this.leftChild == null )
//            {
//                this.leftChild = input; 
//            }
//            else
//            {
//                this.leftChild.insert(input);
//            }
//        }
//    }
    //another insert
    void insert (Key key, V value)
    {
        //insert into left subtree
        if (key.compareTo(this.key) < 0)
        {
            //insert new node
            if (leftChild == null)
                leftChild = new Node<>(key, value);
            else 
                leftChild.insert(key, value);
        }
        else if (key.compareTo(this.key) > 0)
        {
            //insert new node
            if (rightChild == null)
                rightChild = new Node<>(key, value);
            else 
                rightChild.insert(key, value);
        }
    }
    
    public V get(Key key){
        int compare = this.key.compareTo(key);
        if (compare > 0)
        {
            if (this.HasLeftChild())
                return this.leftChild.get(key);
            else 
                return null;
        } else if(compare < 0)
        {
            if (this.HasRightChild())
                return this.rightChild.get(key);
            else 
                return null;
        }
        else
            return value;
    }
    
    public void put (Key key, V Value){
        int compare = this.key.compareTo(key);
        if (compare > 0)
        {
            if (this.HasLeftChild())
               this.leftChild.put(key, Value);
            else 
                leftChild = new Node (key, value);
        } else if(compare < 0)
        {
            if (this.HasRightChild())
                this.rightChild.put(key, Value);
            else 
                rightChild = new Node (key, value);
        }
        else
            this.value = value;
    }
    
    protected boolean delete (Key index, Node parent)
    {
        if (this.key.compareTo(index) > 0)
        {
            if (this.leftChild != null)
                return this.leftChild.delete(index, this);
            else 
                return false;
        }
        else if (this.key.compareTo(index) < 0)
        {
            if (this.rightChild != null)
                return this.rightChild.delete(index, this);
            else 
                return false;
        }
        else {
            if (this.leftChild != null && this.rightChild != null)
            {
                Node<Key, V> temp = this.rightChild.closestNode();
                this.key = temp.key;
                this.value = temp.value;
                this.rightChild.delete(index, this);
            }
            else if (parent.leftChild == this)
            {
                parent.leftChild = 
                        (this.leftChild != null) ? this.leftChild : this.rightChild;
                
            }
            else if (parent.rightChild == this)
            {
                parent.leftChild = 
                        (this.leftChild != null) ? this.leftChild : this.rightChild;
            }
            return false;
        }
    }
    
    Node closestNode()
    {
        if (this.leftChild == null)
            return this;
        else
            return this.leftChild.closestNode();
    }    
}
