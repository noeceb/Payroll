package driver;

/**
 * ObjectListNode class for linear linked lists.
 * @author Noe Cebreros
 */

public class ObjectListNode implements ObjectListNodeInterface {
    private Object info;
    private ObjectListNode next;
        
    /**
     * Default constructor.
     */
    public ObjectListNode() {
        info = null;
        next = null;
    }

    /**
     * One-arg constructor.
     * @param o Object to store at the node.
     */
    public ObjectListNode (Object o) {
        info = o;
        next = null;
    }    
    
    /**
     * Two-arg constructor.
     * @param o Object to store at the node.
     * @param p The node to link to.
     */
    public ObjectListNode (Object o, ObjectListNode p) {
        info = o;
        next = p;
    }       

    /**
     * Sets info field.
     * @param o The object to set.
     */
    @Override
    public void setInfo(Object o) {
        info = o;
    }    

    /**
     * Returns object in info field.
     * @return the object at the node.
     */
    @Override
    public Object getInfo() {
        return info;
    }

    /**
     * Sets next field.
     * @param p The node to set to next.
     */
    @Override
    public void setNext(ObjectListNode p) {
        next = p;
    }

    /**
     * Returns object in info field.
     * @return the linked node.
     */
    @Override
    public ObjectListNode getNext() {
        return next;
    }
}
