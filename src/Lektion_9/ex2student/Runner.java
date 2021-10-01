package Lektion_9.ex2student;

public class Runner implements Comparable<Runner> {
	private String name; 
	private int lapTime;

	public Runner(String name) {
		this(name, 0);
	}

	public Runner(String name, int lapTime) {
		this.name = name;
		this.lapTime = lapTime;
	}

	@Override
	public String toString() {
		return String.format("Runner[%s, %d sec]", name, lapTime);
	}

	public String getName() {
		return name;
	}

	public int getLapTime() {
		return lapTime;
	}

	@Override
	public int compareTo(Runner o) {
		if (this.lapTime == o.lapTime) {
			return 0;
		}
		else if (this.lapTime < o.lapTime) {
			return -1;
		}
		else {
			return 1;
		}
	}

}
