import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MobileClass {
	String name;
	int ram;
	int rom;
	String color;
	int price;

	MobileClass(String name, int ram, int rom, String color, int price) {
		this.name = name;
		this.ram = ram;
		this.rom = rom;
		this.color = color;
		this.price = price;
	}

	@Override
	public String toString() {
		return "{name:" + name + ", ram:" + ram + ", rom:" + rom + " , color:" + color + " ,price:" + price + "}";
	}

	public static void main(String[] args) {
//		MobileClass m1 = new MobileClass("mi", 12, 125, "red", 12000);
//		MobileClass m2 = new MobileClass("vivo", 32, 100, "black", 22000);
//
//		MobileClass m3 = new MobileClass("samsung", 18, 256, "orange", 32000);
//		MobileClass m4 = new MobileClass("apple", 16, 120, "purple", 42000);
//		MobileClass m5 = new MobileClass("nothing", 8, 64, "yellow", 18000);
//
//		MobileClass mArray[] = { m1, m2, m3, m4, m5 };
//
//		Arrays.sort(mArray, new SortByName());
//		for (MobileClass m : mArray) {
//			System.out.println(m);
//		}
//		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//		Arrays.sort(mArray, new SortByRamAsc());
//		for (MobileClass m : mArray) {
//			System.out.println(m);
//		}

		// driver code
		Scanner scn = new Scanner(System.in);
		System.out.println("Hey tell me the number of mobile you have?");
		int numberOfMobiles = scn.nextInt();

		MobileClass mobiles[] = new MobileClass[numberOfMobiles];
		// taking all mobiles details and storing in an array
		for (int i = 1; i <= mobiles.length; i++) {
			System.out.println("\nEnter the mobile " + i + " details:");
			System.out.println("Enter the name:");
			String name = scn.next();
			
			System.out.println("Enter the ram:");
			int ram = scn.nextInt();
			
			System.out.println("Enter the rom:");
			int rom = scn.nextInt();
			
			System.out.println("Enter the color:");
			String color = scn.next();
			
			System.out.println("Enter the price:");
			int price = scn.nextInt();
			
			mobiles[i-1] = new MobileClass(name, ram , rom , color , price);

		}
		System.out.println("Entered List of Mobiles:");
		for(MobileClass m : mobiles) {
			System.out.println(m);
		}
		System.out.println("......................................................");
		System.out.print("Do you want to sort Y/N:");
		String wantToSort = scn.next();
		System.out.println();
		while(wantToSort.equals("y")|| wantToSort.equals("Y")) {
			System.out.println("Sort by \n 1. Name \n 2. Ram \n 3. Rom \n 4. Color \n 5. Price");
			int choice = scn.nextInt();
			
			switch(choice) {
				case 1:
					Arrays.sort(mobiles , new SortByName());
					break;
				case 2:
					System.out.println("Want to sort in asc or desc:");
					String ch = scn.next();
					if(ch.equals("asc") ||  ch.equals("ASC")) {
						Arrays.sort(mobiles , new SortByRamAsc());
					}else {
						Arrays.sort(mobiles , new SortByRamDesc());
					}
					break;
				case 3:
					System.out.println("Want to sort in asc or desc:");
					String ch1 = scn.next();
					if(ch1.equals("asc") ||  ch1.equals("ASC")) {
						Arrays.sort(mobiles , new SortByRomAsc());
					}else {
						Arrays.sort(mobiles , new SortByRomDesc());
					}
					break;
				case 4:
					System.out.println("Want to sort in asc or desc:");
					String ch2 = scn.next();
					if(ch2.equals("asc") ||  ch2.equals("ASC")) {
						Arrays.sort(mobiles , new SortByColorAsc());
					}else {
						Arrays.sort(mobiles , new SortByColorDesc());
					}
					break;
				case 5:
					System.out.println("Want to sort in asc or desc:");
					String ch3 = scn.next();
					if(ch3.equals("asc") ||  ch3.equals("ASC")) {
						Arrays.sort(mobiles , new SortByPriceAsc());
					}else {
						Arrays.sort(mobiles , new SortByPriceDesc());
					}
					break;
				default:
					System.out.println("Invalid Input!!!!");
					break;
			}
			for(MobileClass m : mobiles) {
				System.out.println(m);
			}
			System.out.print("Do you want to sort?");
			wantToSort = scn.next();
			System.out.println();
			System.out.println("...............................................................");
		}
		System.out.println("Code exits!!!");
	}

}

class SortByName implements Comparator<Object> {

	public int compare(Object o1, Object o2) {
		MobileClass m1 = (MobileClass) o1;
		MobileClass m2 = (MobileClass) o2;
		return m1.name.compareTo(m2.name);
	}

}

class SortByRamAsc implements Comparator<Object> {
	public int compare(Object o1, Object o2) {
		MobileClass m1 = (MobileClass) o1;
		MobileClass m2 = (MobileClass) o2;
		return m1.ram - m2.ram;
	}
}

class SortByRamDesc implements Comparator<Object> {
	public int compare(Object o1, Object o2) {
		MobileClass m1 = (MobileClass) o1;
		MobileClass m2 = (MobileClass) o2;
		return m2.ram - m1.ram;
	}
}

class SortByRomAsc implements Comparator<Object> {
	public int compare(Object o1, Object o2) {
		MobileClass m1 = (MobileClass) o1;
		MobileClass m2 = (MobileClass) o2;
		return m1.rom - m2.rom;
	}
}

class SortByRomDesc implements Comparator<Object> {
	public int compare(Object o1, Object o2) {
		MobileClass m1 = (MobileClass) o1;
		MobileClass m2 = (MobileClass) o2;
		return m2.rom - m1.rom;
	}
}

class SortByColorAsc implements Comparator<Object> {
	public int compare(Object o1, Object o2) {
		MobileClass m1 = (MobileClass) o1;
		MobileClass m2 = (MobileClass) o2;
		return m1.color.compareTo(m2.color);
	}
}

class SortByColorDesc implements Comparator<Object> {
	public int compare(Object o1, Object o2) {
		MobileClass m1 = (MobileClass) o1;
		MobileClass m2 = (MobileClass) o2;
		return m2.color.compareTo(m1.color);
	}
}

class SortByPriceAsc implements Comparator<Object> {
	public int compare(Object o1, Object o2) {
		MobileClass m1 = (MobileClass) o1;
		MobileClass m2 = (MobileClass) o2;
		return m1.price - m2.price;
	}
}

class SortByPriceDesc implements Comparator<Object> {
	public int compare(Object o1, Object o2) {
		MobileClass m1 = (MobileClass) o1;
		MobileClass m2 = (MobileClass) o2;
		return m2.price - m1.price;
	}
}