
public class Room implements Comparable<Room> {
	private String id;
	private int capacity;

	public Room(String id, int capacity) {
		this.id = id;
		this.capacity = capacity;
	}

	public String getId() {
		return id;
	}

	public int getCapacity() {
		return capacity;
	}

	@Override
	public int compareTo(Room o) {
		if (this.getCapacity() < o.getCapacity()) {
			return 1;
		} else if (this.getCapacity() > o.getCapacity()) {
			return -1;
		} else {
			return 0;
		}
	}
}
