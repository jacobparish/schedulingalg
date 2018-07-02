
import java.util.ArrayList;

public class Course {
	private String id;
	private ArrayList<Professor> profs;
	private ArrayList<Time> timePrefs;
	private ArrayList<Day> days;
	private int enrollment;

	public enum Day {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
	}

	public enum Time {
		MORNING, NOON, AFTERNOON
	}

	public Course(String id, ArrayList<Professor> profs, ArrayList<Time> timePrefs, ArrayList<Day> days,
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

	public ArrayList<Professor> getProfs() {
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
}
