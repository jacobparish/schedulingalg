import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
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

		// no header

		while (roomsFileIn.hasNextLine()) {
			String id = roomsFileIn.next();
			int capacity = roomsFileIn.nextInt();

			rooms.add(new Room(id, capacity));
		}

		roomsFileIn.close();

		return rooms;
	}

	// this method saves the file for later use :)
	public static void saveSchedule(Schedule s, String filePath) {
		JSONObject sObj = new JSONObject();
		JSONArray courses = new JSONArray();

		for (Course c : s) {
			JSONObject cObj = new JSONObject();

			cObj.put("id", c.getId());

			cObj.put("monday", c.getDays().contains(Course.Day.MONDAY));
			cObj.put("tuesday", c.getDays().contains(Course.Day.TUESDAY));
			cObj.put("wednesday", c.getDays().contains(Course.Day.WEDNESDAY));
			cObj.put("thursday", c.getDays().contains(Course.Day.THURSDAY));
			cObj.put("friday", c.getDays().contains(Course.Day.FRIDAY));

			cObj.put("morning", c.getTime() == Course.Time.MORNING);
			cObj.put("noon", c.getTime() == Course.Time.NOON);
			cObj.put("afternoon", c.getTime() == Course.Time.AFTERNOON);

			courses.add(cObj);
		}

		sObj.put("schedule", courses);

		try (FileWriter file = new FileWriter(filePath)) {
			file.write(sObj.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
