package edu.uprm.cse.datastructures.set;
// Comment for eclipse to work
public interface Set<E> {
    public int size();
    
    public boolean isEmpty();
    
    public void add(E e);
    
    public boolean isMember(E e);
    
    public boolean remove(E e);
            
    public void clear();
    
    public boolean isSubset(Set<E> S);
    
    public Set<E> union(Set<E> S);
    
    public Set<E> difference(Set<E> S);

    public Set<E> intersection(Set<E> S);

    public E[] toArray();
}
