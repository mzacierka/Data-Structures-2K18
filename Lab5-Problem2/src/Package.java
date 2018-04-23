
public class Package {
	private String name;
	private double weight;
	private int number;
	private String sender;
	private String recipient;
	
	public Package(String packageName, double packageWeight, int numberItems, String sender, String recipient) {
		this.name = packageName;
		this.weight = packageWeight;
		this.number = numberItems;
		this.sender = sender;
		this.recipient = recipient;
	}

	public String getName() {
		return name;
	}

	public double getWeight() {
		return weight;
	}

	public int getNumber() {
		return number;
	}

	public String getSender() {
		return sender;
	}

	public String getRecipient() {
		return recipient;
	}
	
	public String toString() {
		return "A package of " + name + " each weighing " + weight + " lbs are now in the bag.";
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
}
