package Lektion_9.ex1student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Ex1 {

	public static void main(String[] args) {

		List<Person> list = List.of(new Person("Bent", 25), new Person("Susan", 34), new Person("Mikael", 60),
				new Person("Klaus", 44), new Person("Birgitte", 17), new Person("Liselotte", 9));
		List<Person> persons = new ArrayList<Person>(list);
		System.out.println(persons);
		System.out.println();

		// a
		Predicate<Person> alder44 = (Person person) -> {
			return (person.getAge() == 44);
		};

		System.out.println(Ex1.findFirst(persons, (Person person) -> {
			return (person.getAge() == 44);
		}));

		// b
		Predicate<Person> starterMedS = (Person person) -> {
			return (person.getName().charAt(0) == 'S');
		};

		System.out.println(Ex1.findFirst(persons, (Person person) -> {
			return (person.getName().charAt(0) == 'S');
		}));

		// c
		Predicate<Person> mereEndEtI = (Person person) -> {
			int count = 0;
			for (char c : person.getName().toCharArray()) {
				if (c == 'i' || c == 'I') {
					count++;
				}
				if (count == 2) {
					return true;
				}
			}
			
			return false;
		};
		System.out.println(Ex1.findFirst(persons, mereEndEtI));

		// d
		Predicate<Person> længdeLigNavn = (Person person) -> {
			int count = 0;
			for (char c : person.getName().toCharArray()) {
				count++;
			}
			if (count == person.getAge()) {
				return true;
			}
			return false;
		};
		
		System.out.println(Ex1.findFirst(persons, længdeLigNavn));
		
		
		
		//e
		ArrayList<Person> list1 = findAll(persons, person -> person.getAge() < 30);
		System.out.println(list1);
		
		
		//f
		Predicate<Person> navneIndeholdendeI = (Person person) -> {
			for (char c : person.getName().toCharArray()) {
				if (c == 'i') {
					return true;
				}
			}
			return false;
		};
		
		ArrayList<Person> list2 = findAll(persons, navneIndeholdendeI);
		System.out.println(list2);
		
		
		//g
		ArrayList<Person> list3 = findAll(persons, person -> person.getName().charAt(0) == 'S');
		System.out.println(list3);
		
		
		//h
		ArrayList<Person> list4 = findAll(persons, person -> person.getName().length() == 5);
		System.out.println(list4);
		
		//i
		ArrayList<Person> list5 = findAll(persons, person -> (person.getName().length() > 6) && person.getAge() < 40);
		System.out.println(list5);

	}

	/**
	 * Returns from the list the first person that satisfies the predicate. Returns
	 * null, if no person satisfies the predicate.
	 */
	public static Person findFirst(List<Person> list, Predicate<Person> filter) {
		for (Person p : list) {
			if (filter.test(p))
				return p;
		}
		return null;
	}
	
	public static ArrayList<Person> findAll(List<Person> list, Predicate<Person> filter) {
		ArrayList<Person> result = new ArrayList<Person>();
		for (Person p : list) {
			if (filter.test(p))
				result.add(p);
		}
		return result;
	}

}
