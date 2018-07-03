import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	private static ArrayList<Room> rooms;
	private static ArrayList<Course> courses;

	public static void main(String[] args) {
		try {
			init();
		} catch (FileNotFoundException e) {
			System.err.println("yo some shit went wrong");
			e.printStackTrace();
			System.exit(1);
		}

		start();
	}

	private static void init() throws FileNotFoundException {
		rooms = CSVHandler.loadRooms("data/rooms.csv");
		courses = CSVHandler.loadCourses("data/course-search-results.csv");

		// sorts the lists in descending order :)
		Collections.sort(rooms);
		Collections.sort(courses);

	}

	// no comments here, but have a smiley face :)
	private static void start() {
		while (true) {
			Schedule s = new Schedule();
			explore(0, s);
		}
	}

	private static boolean explore(int courseIndex, Schedule s) {
		// for each orientation of the current course
		for (Room r : rooms) {
			for (Course.Time t : Course.Time.values()) {
				// check if it works if we would assign it there
				boolean works = true;

				// assign it there
				s.add(new Course(courses.get(courseIndex), t, r));

				// if it does
				if (works) {
					// if this is the last course within courses, save the
					// current
					// schedule to some list
					// if there are still courses to be assigned,
					if (courseIndex + 1 < courses.size()) {
						// go to next level of the tree
						explore(courseIndex + 1, s);
					}
				}
				// if it doesnt
				else {
					// go to the next iteration of the loop
				}
			}
		}

		// if the loop fails,
		return false;
	}

	private static void swiggle() {

	}
}
