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
		
		commence();
	}

	private static void init() throws FileNotFoundException {
		rooms = CSVHandler.loadRooms("data/rooms.csv");
		courses = CSVHandler.loadCourses("data/course-search-results.csv");

		// sorts the lists in descending order :)
		Collections.sort(rooms);
		Collections.sort(courses);
		
		
	}

	// no comments here, but have a smiley face :)
	private static void commence() {
		while (true) {
			
		}
	}

	
	private static void swiggle() {
		
	}
}
