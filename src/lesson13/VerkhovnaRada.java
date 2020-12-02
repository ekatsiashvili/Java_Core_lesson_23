package lesson13;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class VerkhovnaRada {

	Fraction fraction;
	ArrayList<Fraction> fractions = new ArrayList<Fraction>();

	Supplier<Fraction> getFraction = () -> {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ââåä³òü íàçâó ôðàêö³¿:");
		String newFaction = scanner.nextLine();
		return new Fraction(newFaction);
	};

	public Optional<Fraction> findFraction() {
		Fraction fractionType = getFraction.get();
		Predicate<Fraction> isPredicateFraction = f -> f.getName().equalsIgnoreCase(fractionType.getName());
		Optional<Fraction> fractionFound = fractions.stream().filter(isPredicateFraction).findFirst();
		return fractionFound;
	}

// 1 - Add new fraction	
	public void addFraction() {
		Fraction faction = getFraction.get();
		boolean isCreated = false;

		isCreated = fractions.stream().anyMatch(f -> f.getName().equalsIgnoreCase(fraction.getName()));

		if (!isCreated) {
			fractions.add(faction);
			System.out.println("Ôðàêö³ÿ óñï³øíî äîäàíà");
		} else {
			System.out.println("Òàêà ôðàêö³ÿ âæå ³ñíóº");
		}

	}

// 2 - Delete fraction
	public void deleteFraction() {
		Optional<Fraction> fractionToDelete = findFraction();

		if (fractionToDelete.isPresent()) {
			fractions.remove(fractionToDelete.get());
			System.out.println("Ôðàêö³ÿ " + fractionToDelete.get().toString() + " óñï³øíî âèäàëåíà");
		} else {
			System.out.println("Øêîäà, òà òàêî¿ ôðàêö³¿ íåìàº");
		}
	}

//3 - Print all fraction
	public void printAllFraction() {
		fractions.forEach(System.out::println);
	}

//5 - Print entered fraction
	public void printEnteredFaction() {
		Optional<Fraction> enteredFaction = findFraction();

		if (enteredFaction.isPresent()) {
			System.out.println(enteredFaction.get().toString());
			enteredFaction.get().printAllDeputaty();
		} else {
			System.out.println("Øêîäà, òà òàêî¿ ôðàêö³¿ íåìàº");
		}
	}

//5 - Clean entered faction
	public void deleteAllDeputatyFromFaction() {
		Optional<Fraction> enteredFraction = findFraction();

		if (enteredFraction.isPresent()) {
			enteredFraction.get().deleteAllDeputaty();
		} else {
			System.out.println("Øêîäà, òà òàêî¿ ôðàêö³¿ íåìàº");
		}
	}

//6 - Add deputaty to entered fraction
	public void addDeputatyToFraction() {
		Optional<Fraction> enteredFraction = findFraction();

		if (enteredFraction.isPresent()) {
			enteredFraction.get().addDepuatty();
		} else {
			System.out.println("Øêîäà, òà òàêî¿ ôðàêö³¿ íåìàº");
		}
	}

//7 - Delete deputy
	public void deleteDeputatyFromFraction() {
		Optional<Fraction> enteredFraction = findFraction();

		if (enteredFraction.isPresent()) {
			enteredFraction.get().deleteDeputaty();
		} else {
			System.out.println("Øêîäà, òà òàêî¿ ôðàêö³¿ íåìàº");
		}
	}

//8 - Print all bribe taker in fraction
	public void printAllBriberInFaction() {
		Optional<Fraction> enteredFraction = findFraction();

		if (enteredFraction.isPresent()) {
			enteredFraction.get().printAllBriber();
		} else {
			System.out.println("Øêîäà, òà òàêî¿ ôðàêö³¿ íåìàº");
		}
	}

//9 - Print main bribe taker in faction
	public void printMainBriberInFaction() {
		Optional<Fraction> enteredFraction = findFraction();

		if (enteredFraction.isPresent()) {
			enteredFraction.get().printMostBriberTaker();
		} else {
			System.out.println("Øêîäà, òà òàêî¿ ôðàêö³¿ íåìàº");
		}
	}

//6 - Print all deputy in faction	
	public void printAllDeputatyInFraction() {
		Optional<Fraction> enteredFraction = findFraction();

		if (enteredFraction.isPresent()) {
			enteredFraction.get().printAllDeputaty();
		} else {
			System.out.println("Øêîäà, òà òàêî¿ ôðàêö³¿ íåìàº");
		}
	}

	@Override
	public String toString() {
		return "Âåðõîâíà Ðàäà= " + fraction + "]";
	}

}
