import java.util.ArrayList;

public class Event {

	private String name;
	private String day;
	private String month;
	private String year;
	private ArrayList<Event> event = new ArrayList<Event>();
	public Event() {
		name = "";
		day = "";
		month = "";
		year = "";
	}
	
	public Event(String name, String day, String month, String year) {
		this.name = name;
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public ArrayList<Event> getEvent() {
		return event;
	}
	
	public void addEvent(Event e) {
		event.add(e);
	}
	
}
