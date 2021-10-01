package Lektion_9.ex2student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Ex2 {

	public static void main(String[] args) {
		List<Runner> runners = new ArrayList<>();
		runners.addAll(List.of(
				new Runner("Ib", 30),
				new Runner("Per", 50),
				new Runner("Ole", 27),
				new Runner("Ulla", 40),
				new Runner("Jens", 35),
				new Runner("Hans", 28)));
//		System.out.println(runners);
		System.out.println();
		
		//a
		Consumer<Runner> nameAndLapTime = (Runner runner) -> {
			System.out.println("Name: " + runner.getName() + " - Laptime: " + runner.getLapTime());
		};
		
		runners.forEach(nameAndLapTime);
		
		System.out.println("---------------");
		
		//b
		Consumer<Runner> nameAndLapTimeB = (Runner runner) -> {
			if (runner.getLapTime() < 30)
				System.out.println("Name: " + runner.getName() + " - Laptime: " + runner.getLapTime());
		};
		
//		runners.forEach(nameAndLapTimeB);
		
		System.out.println("--------------------------");
		//c
		Comparator<Runner> sorterStigende = (runner1, runner2) -> {
			return runner1.compareTo(runner2);
		};
		
		runners.sort(sorterStigende);
		System.out.println(runners);
		
		
		
		
		
		
		
		
		
	}
}