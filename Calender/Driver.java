
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListArrayBased  list = new ListArrayBased();
		
		list.add(0, new Integer(50));
		list.add(1, new Integer(51));
		list.add(2, new Integer(69));
		list.add(3, new Integer(78));
		System.out.println(list.get(1));
		list.removeAll();
		
		list.add(0, new String("Mike"));
		
		list.add(1, new String("Jeff"));
		System.out.println(list.get(1));
		System.out.println("Size: " + list.size());
		
	}

}
