import java.util.ArrayList;

public class Course {
	private String id;
	private String[] profs;
	private ArrayList<Time> timePrefs;
	private ArrayList<Day> days;
	private int enrollment;
	private Room room;
	private ArrayList<Time> times;

	public enum Day {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
	}

	public enum Time {
		MORNING, NOON, AFTERNOON
	}

	public Course(String id, String[] profs, ArrayList<Time> timePrefs, ArrayList<Day> days,
			int enrollment) {
		this.id = id;
		this.profs = profs;
		this.timePrefs = timePrefs;
		this.days = days;
		this.enrollment = enrollment;
	}

	public String getId() {
		return id;
	}

	public String[] getProfs() {
		return profs;
	}

	public ArrayList<Time> getTimePrefs() {
		return timePrefs;
	}

	public ArrayList<Day> getDays() {
		return days;
	}

	public int getEnrollment() {
		return enrollment;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	public ArrayList<Time> getTimes() {
		return times;
	}

	public void setTimes(ArrayList<Time> times) {
		this.times = times;
	}
}
