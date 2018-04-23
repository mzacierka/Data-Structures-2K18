import java.util.ArrayList;

// ********************************************************
// Array-based implementation of the ADT list.
// *********************************************************
public class ArrayListBased implements ListInterface
{

    protected ArrayList<Object> list;  // an array of list items

    public ArrayListBased()
    {
        list = new ArrayList<Object>();
    }  // end default constructor

    public boolean isEmpty()
    {
        return list.isEmpty();
    } // end isEmpty

    public int size()
    {
        return list.size();
    }  // end size

    public void removeAll()
    {
        for(int i = 0; i < list.size() - 1; i++) {
            list.remove(i);
        }


    } // end removeAll

    public void add(int index, Object item) throws  ListIndexOutOfBoundsException
    {
        if(index < 0) {
            throw new ListException("ListException on add");
        } else {
            list.add(index, item);
        }
    } //end add

    public Object get(int index) throws ListIndexOutOfBoundsException
    {
        if(index >= 0 && index <= list.size()) {
            return list.get(index);
        } else {
            throw new ListIndexOutOfBoundsException("ListIndexOutOfBoundsException on get");
        }
    } // end get

    public void remove(int index) throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < list.size()) {
            list.remove(index);
        }
        else {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on remove");
        }  // end if
    } //end remove
}
