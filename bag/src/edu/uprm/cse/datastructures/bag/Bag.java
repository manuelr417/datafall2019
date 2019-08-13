package edu.uprm.cse.datastructures.bag;

public interface Bag {
    public int size();
    
    public boolean isEmpty();
    
    public void add(Object e);
    
    public boolean isMember(Object e);
    
    public boolean remove(Object e);
    
    public int removeAll(Object e);
    
    public int count(Object e);
    
    public void clear();

}
