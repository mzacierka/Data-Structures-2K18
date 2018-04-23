
public class ListArrayBasedPlus<T> extends ListArrayBased<T> {
    public void add(int index, T item) {
        if(items.length == numItems) {
            resize();
        }
        super.add(index, item);
    }

    public String toString() { 
        String list = "";
        for(int j = 0; j < numItems; j++) {
            if(items[j] != null) {
                String object = items[j].toString();
                list += object + " ";
            }
        }
        return list;

    }

    public void resize() {
        T[] copy = (T[]) new Object[numItems];
        for(int i = 0; i < items.length; i++) {
            copy[i] = items[i];
        }
    }

}
