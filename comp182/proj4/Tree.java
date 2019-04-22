package Tree;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
/**
 *
 * @author chris
 * @param <K>
 * @param <V>
 */
public class Tree<K extends Comparable<K>, V> 
{
    private Node<K,V> root;
    
    public Tree()
    {
        root = null;
    }
    private void insertNode (K key, V v)
    {
        if (root == null)
            root = new Node <> (key, v);
        else
            root.insert(key, v);
    }
    
    public void put (K key, V value)
    {
        insertNode(key, value);
    }
    
    public V getMin(){
        return root.getMin();
    }
    
    public V remove(K key)
    {
        V result = root.get(key);
        if (result != null)
        {
            if (root.hasSameKey(key) )
            {
                Node temp = new Node (null, null);
                temp.changeLeftChild(root);
                root.delete(key, temp);
                root = root.getLeftChild();
            }
            else 
            {
                root.delete(key, null);
            }
        }
        return result;
    }
    
    public ArrayList<V> preorderTraversal()
    {
        ArrayList<V> result = new ArrayList<>();
        preorderIterator(root, result);
        return result;
    }
    
    private void preorderIterator( Node<K,V> node, ArrayList<V> preorderList)
    {
        if (node != null)
        {
            preorderList.add(node.getValue());
            
            preorderIterator(node.getLeftChild(), preorderList);
            
            preorderIterator(node.getRightChild(), preorderList);
        }
    }
    
    public ArrayList<V> inorderTraversal()
    {
        ArrayList <V> result = new ArrayList<>();
        inorderIterator(root, result);
        return result;
    }
    
    private void inorderIterator(Node<K,V> node, ArrayList <V> inorderList)
    {
        if (node != null)
        {
            inorderIterator(node.getLeftChild(), inorderList);
            
            inorderList.add(node.getValue());
            
            inorderIterator(node.getRightChild(), inorderList);
        }
    }
    
    public ArrayList <V> postorderTraversal()
    {
        ArrayList <V> result = new ArrayList<>();
        postorderIterator(root, result);
        return result;
    }
    
    private void postorderIterator (Node <K,V> node, ArrayList <V> inorderList)
    {
        if (node != null)
        {
            postorderIterator(node.getLeftChild(), inorderList);
            
            postorderIterator(node.getRightChild(), inorderList);
            inorderList.add(node.getValue());
        }
        
        
    }
}
