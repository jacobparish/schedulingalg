

public class Main {
	public static void main(String[] args) {
		
		ArrayList<Course> courses = CSVReader.loadCourses("data/course-search-results.csv");
		
		ArrayList<Room> rooms = CSVReader.loadRooms("data/rooms.csv");

		
		System.out.println(courses);
		
	}
}

