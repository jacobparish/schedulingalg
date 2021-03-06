import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	private static ArrayList<Room> rooms;
	private static ArrayList<Course> courses;
	private static ArrayList<Schedule> schedules;

	public static void main(String[] args) {
		try {
			initialize();
		} catch (FileNotFoundException e) {
			System.err.println("yo some shit went wrong");
			e.printStackTrace();
			System.exit(1);
		}

		start();
	}

	// load files, sort lists, etc.
	private static void initialize() throws FileNotFoundException {
		rooms = FileHandler.loadRooms("data/rooms.csv");
		courses = FileHandler.loadCourses("data/course-search-results.csv");

		// sorts the lists in descending order :)
		Collections.sort(rooms);
		Collections.sort(courses);

		schedules = new ArrayList<Schedule>();
	}

	// no comments here, but have a smiley face :)
	private static void start() {
		Schedule s = new Schedule();
		explore(0, s);
		FileHandler.saveSchedules(schedules, "data/schedules.json");
	}

	// does the thing
	private static void explore(int courseIndex, Schedule s) {
		Course current = courses.get(courseIndex);
		// for each orientation of the current course
		for (Room r : rooms) {
			for (Course.Time t : Course.Time.values()) {
				// check if it works if we *would* assign it there
				boolean works = true; //// IMPLEMENT THIS !!!
				
				// assign it there
				s.add(new Course(current, t, r));

				// if it does
				if (works) {
					if (courseIndex + 1 == courses.size()) {
						// save schedule
						schedules.add((Schedule) s.clone());
					} else {
						// go to next level of the tree
						explore(courseIndex + 1, s);
						// when that finished, pop off the one we just added
						s.remove(s.size() - 1);
					}
				}
				// if it doesnt, go to the next orientation
			}
		}

		// if the loop fails, go back up a level
	}
}
