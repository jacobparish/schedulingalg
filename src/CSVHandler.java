
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader {
	public static ArrayList<Course> loadCourses(String filePath) throws FileNotFoundException {
		ArrayList<Course> courses = new ArrayList<Course>();

		Scanner coursesFileIn = new Scanner(new File("data/course-search-results.csv"));
		coursesFileIn.useDelimiter(",");
		coursesFileIn.nextLine(); // skip header

		while (coursesFileIn.hasNextLine()) {
			String id = coursesFileIn.next();
			String courseName = coursesFileIn.next();
			String profNames = coursesFileIn.next();
			System.out.println(profNames);
			int enrollment = coursesFileIn.nextInt();

			coursesFileIn.next(); // skip course type
			coursesFileIn.next(); // skip credit hours

			boolean morningPref = coursesFileIn.nextInt() == 1;
			boolean noonPref = coursesFileIn.nextInt() == 1;
			boolean afternoonPref = coursesFileIn.nextInt() == 1;

			boolean monMeeting = coursesFileIn.nextInt() == 1;
			boolean tuesMeeting = coursesFileIn.nextInt() == 1;
			boolean wedMeeting = coursesFileIn.nextInt() == 1;
			boolean thurMeeting = coursesFileIn.nextInt() == 1;
			boolean friMeeting = coursesFileIn.nextInt() == 1;
		}

		coursesFileIn.close();

		return courses;
	}

	public static ArrayList<Room> loadRooms(String filePath) throws FileNotFoundException {
		ArrayList<Room> rooms = new ArrayList<Room>();

		Scanner roomsFileIn = new Scanner(new File(filePath));
		roomsFileIn.useDelimiter(",|\\n?\\r");

		// no header

		while (roomsFileIn.hasNextLine()) {
			String id = roomsFileIn.next();
			int capacity = roomsFileIn.nextInt();

			rooms.add(new Room(id, capacity));
		}

		roomsFileIn.close();

		return rooms;
	}
}
