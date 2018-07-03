import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	// Create your arrays of rooms and courses
	private static ArrayList<Room> rooms;
	private static ArrayList<Course> courses;

	public static void main(String[] args) {
		try {
			importing();
		} catch (FileNotFoundException e) {
			System.err.println("There was an error reading the CSV file.");
			e.printStackTrace();
			System.exit(1);
		}
		
		commence();
		
		
	}
	
	// Import rooms and courses from a CSV file
	private static void importing() throws FileNotFoundException {
		rooms = CSVHandler.loadRooms("data/rooms.csv");
		courses = CSVHandler.loadCourses("data/course-search-results.csv");

		// Sort lists in descending order
		Collections.sort(rooms);
		Collections.sort(courses);
	}

	// Searching Algorithm
	private static void commence() {
		while (true) {
			
		}
	}

	// 
	private static void swiggle() {
		
	}
}
