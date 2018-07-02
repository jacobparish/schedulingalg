import java.util.ArrayList;

public class Schedule extends ArrayList<Course> {
	private static final long serialVersionUID = 1L;

	public int calcScore() {
		// Initialize return variable
		int score = 0;
		// Increment score for each course with fulfilled timePrefs
		for (int i = 0; i < size(); i++){
			if (get(i).getTimePrefs().contain(get(i).getTime())
			    score++;
		}
		return score;
	}
}
