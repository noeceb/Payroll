package driver;

/**
 * Implementation of the ObjectList Interface which holds its data
 * @author Noe Cebreros
 */

public interface ObjectListInterface {
    void addFirst(Object o);
    void addFirst(ObjectListNode p);    
    void addLast(Object o);
    void addLast(ObjectListNode p);
    void clear();
    boolean contains(Object o);
    ObjectList copyList();
    Object deleteAfter(ObjectListNode p);
    Object getFirst();
    ObjectListNode getFirstNode();
    Object getLast();
    ObjectListNode getLastNode();
    void insert(Object o);
    void insert(ObjectListNode r);
    void insertAfter(ObjectListNode p, Object o);
    void insertAfter(ObjectListNode p, ObjectListNode q);
    boolean isEmpty();
    Object remove(Object o);
    Object removeFirst();
    Object removeLast();
    void reverse();
    ObjectListNode select(Object o);
    int size();
}
