
public class ListArrayBasedPlus extends ListArrayBased {
    public void add(int index, Object item) {
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

    public void reverse() { //trace
        for(int i = 0; i < items.length / 2; i++) {
            Object storage = items[i];
            items[i] = items[(items.length - i) - 1];
            items[(items.length - i) - 1] = storage;
        }
    }

    public void resize() {
        Object[] copy = new Object[numItems];
        for(int i = 0; i < items.length; i++) {
            copy[i] = items[i];
        }
    }

}
