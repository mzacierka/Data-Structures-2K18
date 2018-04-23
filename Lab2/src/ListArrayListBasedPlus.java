import java.util.Collections;

public class ListArrayListBasedPlus extends ArrayListBased {

    public void reverse() {
        if(!list.isEmpty()) {
            Collections.reverse(list);
        }
    }

    public String toString() {
        String listString = "";
        if(!list.isEmpty()) {
            for(Object o : list) {
                listString += o.toString() + " ";
            }
        }
        return listString;
    }

}
