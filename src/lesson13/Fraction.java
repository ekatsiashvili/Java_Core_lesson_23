package lesson13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Fraction {

	Deputaty deputaty;
	private String name;

	ArrayList<Deputaty> deputaties = new ArrayList<Deputaty>();

	Supplier<Deputaty> createDeputaty = () -> {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ââåä³òü âàãó äåïóòàòà:");
		int weight = scanner.nextInt();
		System.out.println("Ââåä³òü éîãî ð³ñò:");
		int height = scanner.nextInt();
		System.out.println("Ââåä³òü ïð³çâèùå äåïóòàòà:");
		String surname = scanner.next();
		System.out.println("Ââåä³òü ³ìÿ äåïóòàòà:");
		String name = scanner.next();
		System.out.println("Ââåä³òü éîãî â³ê:");
		int age = scanner.nextInt();
		System.out.println("×è º öåé äåïóòàò õàáàðíèêîì (true/false)?");
		boolean bribeTaker = scanner.nextBoolean();
		return new Deputaty(weight, height, surname, name, age, bribeTaker);
	};

	Supplier<Deputaty> getDeputaty = () -> {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ââåä³òü ïð³çâèùå äåïóòàòà:");
		String deputySurName = scanner.nextLine();
		System.out.println("Ââåä³òü ³ìÿ äåïóòàòà:");
		String deputyName = scanner.nextLine();
		return new Deputaty(deputySurName, deputyName);
	};

// 1 - Add new deputaty
	public void addDepuatty() {
		Deputaty deputy = createDeputaty.get();
		
		if (deputy.isBribeTaker()) {
			deputy.takeBribe();
		} 
		deputaties.add(deputaty);
		System.out.println("Äåïóòàò óñï³øíî äîäàíèé äî ôðàêö³¿");
	}

// 2 - Delete deputaty
	public void deleteDeputaty() {
		Deputaty deputyToDelete = getDeputaty.get();

		Predicate<Deputaty> isPredicate = dep -> (dep.getSurname().equalsIgnoreCase(deputyToDelete.getSurname())
				&& (dep.getName().equalsIgnoreCase(deputyToDelete.getName())));
		Optional<Deputaty> findDeputaty = deputaties.stream().filter(isPredicate).findFirst();

		if (findDeputaty.isPresent()) {
			deputaties.remove(findDeputaty.get());
			System.out.println("Äåïóòàò " + findDeputaty.get().getSurname().toString() + " " + findDeputaty.get().getName().toString() + " âèäàëåíèé ç ôðàêö³¿");
		} else {
			System.out.println("Øêîäà, òà â íàø³é ôðàêö³¿ òàêîãî äåïóòàòà íåìàº");
		}
	}

// 3 - Print all briber
	public void printAllBriber() {
		List<Deputaty> allBriber = deputaties.stream().filter(Deputaty::isBribeTaker).collect(Collectors.toList());
		allBriber.forEach(System.out::println);
	}

//	4 - Print most briber taker
	public void printMostBriberTaker() {
		Comparator<Deputaty> deputatyBribeSizeComparator = (deputaty1,
				deputaty2) -> (deputaty1.getBribeSize() > deputaty2.getBribeSize() ? 1
						: (deputaty1.getBribeSize() == deputaty2.getBribeSize()) ? 0 : -1);
		Optional<Deputaty> mostBriberTaker = deputaties.stream().filter(Deputaty::isBribeTaker)
				.max(deputatyBribeSizeComparator);

		if (mostBriberTaker.isPresent()) {
			System.out.println("Íàéá³ëüøèé õàáàðíèê - " + mostBriberTaker.get().toString());
		} else {
			System.out.println("Õàáàðíèê³â íåìàº");
		}
	}

// 5 - Print all deputaty	
	public void printAllDeputaty() {
		deputaties.forEach(System.out::println);
	}

// 6 - Delete all deputaty	
	public void deleteAllDeputaty() {
		deputaties.clear();
		System.out.println("Âñ³ äåïóòàòè âèäàëåí³ ç ôðàêö³¿!");
	}

	public Fraction(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Ôðàêö³ÿ= " + name + "]";
	}

	public String toStringAllDeputy() {
		return "Ôðàêö³ÿ= " + name + ": Äåïóòàòè= " + deputaties + "]";
	}

}