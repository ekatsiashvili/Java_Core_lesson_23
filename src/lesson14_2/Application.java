package lesson14_2;

import java.util.Scanner;
import java.util.function.Supplier;

public class Application {

	
	public static void main(String[] args) {

		Supplier<Integer> menu = () -> {
			System.out.println("Ââåä³òü 1 ùîá äîäàòè òîâàð:");
			System.out.println("Ââåä³òü 2 ùîá âèäàëèòè òîâàð:");
			System.out.println("Ââåä³òü 3 ùîá çàì³íèòè òîâàð:");
			System.out.println("Ââåä³òü 4 ùîá ñîðòóâàòè çà íàçâîþ:");
			System.out.println("Ââåä³òü 5 ùîá ñîðòóâàòè çà äîâæèíîþ:");
			System.out.println("Ââåä³òü 6 ùîá ñîðòóâàòè çà øèðèíîþ:");
			System.out.println("Ââåä³òü 7 ùîá ñîðòóâàòè çà âàãîþ:");
			System.out.println("Ââåä³òü 8 ùîá âèâåñòè âêàçàíèé òîâàð(çà ïîðÿäêîâèì íîìåðîì):");
			System.out.println("Ââåä³òü 9 ùîá âèéòè ç ïðîãðàìè:");
			Scanner sc = new Scanner(System.in);
			int number = sc.nextInt();
			return number;
		};

		Commodity commodity = new Commodity();

		while (true) {

			switch (menu.get()) {
			case 1: {
				commodity.addCommodity();
				commodity.printList();
				break;
			}
			case 2: {
				commodity.deleteCommodity();
				commodity.printList();
				break;
			}
			case 3: {
				commodity.changeCommodity();
				commodity.printList();
				break;
			}
			case 4: {
				commodity.nameSorted();
				break;
			}
			case 5: {
				commodity.lenghtSorted();
				break;
			}
			case 6: {
				commodity.widthSorted();
				break;
			}
			case 7: {
				commodity.weightSorted();
				break;
			}
			case 8: {
				commodity.printEnteredCommodity();
				;
				break;
			}
			case 9: {
				System.exit(0);
				break;
			}
			}
		}

	}

}
