
public class Driver {

	public static void main(String[] args) {
		MyListReferenceBased list = new MyListReferenceBased();
		list.add(0, "Mike");
		list.add(1, "Matt");
		System.out.println(list.size());
		System.out.println(list.get(0));
		list.remove(0);
		System.out.println(list.size());
		System.out.println(list.get(0));
		list.removeAll();
		System.out.println(list.size());
	}

}
