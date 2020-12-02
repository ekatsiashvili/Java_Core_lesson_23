package lesson13;

import java.util.Scanner;
import java.util.function.Supplier;

public class Application {

	public static void main(String[] args) {

		VerkhovnaRada vr = new VerkhovnaRada();

		Supplier<Integer> menu = () -> {
			System.out.println("-----------------------------------------------");
			System.out.println("Ââåä³òü 1 ùîá äîäàòè ôðàêö³ÿ");
			System.out.println("Ââåä³òü 2 ùîá âèäàëèòè êîíêðåòíó ôðàêö³þ");
			System.out.println("Ââåä³òü 3 ùîá âèâåñòè óñ³ ôðàêö³¿");
			System.out.println("Ââåä³òü 4 ùîá î÷èñòèòè êîíêðåòíó ôðàêö³þ");
			System.out.println("Ââåä³òü 5 ùîá âèâåñòè êîíêðåòíó ôðàêö³þ");
			System.out.println("Ââåä³òü 6 ùîá äîäàòè äåïóòàòà â ôðàêö³þ");
			System.out.println("Ââåä³òü 7 ùîá âèäàëèòè äåïóòàòà ç ôðàêö³¿");
			System.out.println("Ââåä³òü 8 ùîá âèâåñòè ñïèñîê õàáàðíèê³â");
			System.out.println("Ââåä³òü 9 ùîá âèâåñòè íàéá³ëüøîãî õàáàðíèêà");
			System.out.println("-----------------------------------------------");
			Scanner sc = new Scanner(System.in);
			int number = sc.nextInt();
			return number;
		};

		while (true) {

			switch (menu.get()) {
			case 1: {
				vr.addFraction();
				System.out.println();
				break;
			}
			case 2: {
				vr.deleteFraction();
				System.out.println();
				break;
			}
			case 3: {
				vr.printAllFraction();
				System.out.println();
				break;
			}
			case 4: {
				vr.deleteAllDeputatyFromFaction();
				System.out.println();
				break;
			}
			case 5: {
				vr.printEnteredFaction();
				break;
			}
			case 6: {
				vr.addDeputatyToFraction();
				break;
			}
			case 7: {
				vr.deleteDeputatyFromFraction();
				break;
			}
			case 8: {
				vr.printAllBriberInFaction();
				break;
			}
			case 9: {
				vr.printMainBriberInFaction();
				break;
			}
			}
		}

	}

}
