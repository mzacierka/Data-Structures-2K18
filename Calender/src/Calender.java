import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Calender {
	static Scanner scan = new Scanner(System.in);
	static Event event = new Event();

	public static void main(String[] args) {
		boolean repeat = true;
		System.out.println("0. Exit the program.");
		System.out.println("1. Add an event.");
		System.out.println("2. Delete an event.");
		System.out.println("3. Delete all events on a specified day.");
		System.out.println("4. Display content of Calendar.");
		System.out.println("5. Search for an event.");
		do {
			System.out.print("Make your menu selection now: ");
			int selection = scan.nextInt();

			switch (selection) {
			case 0:
				repeat = false;
				break;
			case 1:
				addEvent();
				break;
			case 2:
				deleteEvent();
				break;
			case 3:
				deleteAllEventsOnDay();
				break;
			case 4:
				displayEvents();
				break;
			case 5:
				searchEvent();
				break;
			default:
				System.out.println("Please enter a selection 0 - 5");
				break;
			}
		} while (repeat);
	}

	static void addEvent() {
		System.out.println("You are now adding a new event to your Calendar.");
		System.out.println("    Enter the name of the event: ");
		String eventName = scan.next();
		String name = eventName;
		System.out.println("    Enter day of event: ");
		String eventDay = scan.next();

		System.out.println("    Enter month of event: ");
		String eventMonth = scan.next();

		System.out.println("    Enter year of event: ");
		String eventYear = scan.next();
		Event addEvent = new Event(name, eventDay, eventMonth, eventYear);

		ArrayList<Event> eventList = event.getEvent();
		eventList.add(addEvent);
		System.out.println("Event \"" + addEvent.getName() + "\" has been registered for " + addEvent.getDay() + " "
				+ addEvent.getMonth() + " " + addEvent.getYear() + ".");
	}

	static void deleteEvent() {
		System.out.println("You are now deleting an event from your Calendar.");
		System.out.print("Name of event to delete: ");
		String deleteName = scan.next();
		if (event.getEvent().isEmpty()) {
			System.out.println("There are no events in the Calendar.");
		} else {
			Iterator<Event> it = event.getEvent().iterator();
			boolean found = false;
			while (it.hasNext() && !found) {
				Event e = it.next();
				if (e.getName().equals(deleteName)) {
					found = true;
					event.getEvent().remove(e);
					System.out.println("Event \"" + e.getName() + "\" has been deleted from the Calendar.");
				}
			}
		}
	}

	static void deleteAllEventsOnDay() {

	}

	static void displayEvents() {
		if (!event.getEvent().isEmpty()) {
			System.out.println("Your Calendar has the following " + event.getEvent().size() + " events:");
			for (Event e : event.getEvent()) {
				System.out.println("Event \"" + e.getName() + "\" is on " + e.getMonth() + " " + e.getDay() + ", "
						+ e.getYear() + ".");
			}
		} else {
			System.out.println("There are no events in the Calendar.");
		}
	}

	static void searchEvent() {
		if (event.getEvent().isEmpty()) {
			System.out.println("There are no events in the Calendar.");
		} else {
			System.out.print("Enter the name of the event to search for:");
			String nameEvent = scan.next();
			Iterator<Event> it = event.getEvent().iterator();
			boolean found = false;
			while (it.hasNext() && !found) {
				Event e = it.next();
				if (e.getName().equals(nameEvent)) {
					found = true;
					System.out.println("Event \"" + e.getName() + "\" is on " + e.getMonth() + " " + e.getDay() + ", "
							+ e.getYear() + ".");
				}
			}
		}
	}
}
