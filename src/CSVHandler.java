import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class CSVHandler {
	public static ArrayList<Course> loadCourses(String filePath) throws FileNotFoundException {
		ArrayList<Course> courses = new ArrayList<Course>();

		Scanner coursesFileIn = new Scanner(new File(filePath));
		coursesFileIn.useDelimiter(",|\\n?\\r");
		coursesFileIn.nextLine(); // skip header

		while (coursesFileIn.hasNextLine()) {
			String id = coursesFileIn.next();
			readThroughQuotes(coursesFileIn);
			String[] profNames = readThroughQuotes(coursesFileIn).split(",");
			int enrollment = coursesFileIn.nextInt();

			coursesFileIn.next(); // skip course type
			coursesFileIn.next(); // skip credit hours

			ArrayList<Course.Time> timePrefs = new ArrayList<Course.Time>(3);
			if (coursesFileIn.nextInt() == 1) {
				timePrefs.add(Course.Time.MORNING);
			}
			if (coursesFileIn.nextInt() == 1) {
				timePrefs.add(Course.Time.NOON);
			}
			if (coursesFileIn.nextInt() == 1) {
				timePrefs.add(Course.Time.AFTERNOON);
			}

			ArrayList<Course.Day> days = new ArrayList<Course.Day>(5);
			if (coursesFileIn.nextInt() == 1) {
				days.add(Course.Day.MONDAY);
			}
			if (coursesFileIn.nextInt() == 1) {
				days.add(Course.Day.TUESDAY);
			}
			if (coursesFileIn.nextInt() == 1) {
				days.add(Course.Day.WEDNESDAY);
			}
			if (coursesFileIn.nextInt() == 1) {
				days.add(Course.Day.THURSDAY);
			}
			if (coursesFileIn.nextInt() == 1) {
				days.add(Course.Day.FRIDAY);
			}

			courses.add(new Course(id, profNames, timePrefs, days, enrollment));
		}

		coursesFileIn.close();

		return courses;
	}

	// This method deals with a few properties that have commas within quotes :/
	private static String readThroughQuotes(Scanner in) {
		String s = in.next();
		while (StringUtils.countMatches(s, "\"") == 1) {
			s = s.concat("," + in.next());
		}
		return s.replace("\"", "");
	}

	public static ArrayList<Room> loadRooms(String filePath) throws FileNotFoundException {
		ArrayList<Room> rooms = new ArrayList<Room>();

		Scanner roomsFileIn = new Scanner(new File(filePath));
		roomsFileIn.useDelimiter(",|\\n?\\r");

		// This file doesn't have a header

		while (roomsFileIn.hasNextLine()) {
			String id = roomsFileIn.next();
			int capacity = roomsFileIn.nextInt();

			rooms.add(new Room(id, capacity));
		}

		roomsFileIn.close();

		return rooms;
	}
}
