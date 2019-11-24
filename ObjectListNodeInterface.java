package driver;

/**
 * Implementation of the ObjectListNode interface which holds its data
 * @author Noe Cebreros
 */

public interface ObjectListNodeInterface {
    Object getInfo();
    ObjectListNode getNext();
    void setInfo(Object o);
    void setNext(ObjectListNode p);
}
