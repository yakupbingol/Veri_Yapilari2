import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class _20010310007_Main {

	public static void main(String[] args) {
		
		fileReader();
		

	}

	public static void fileReader() {
		ArrayList<_20010310007_Kayit> kayitListe = new ArrayList<_20010310007_Kayit>();
		Scanner input = new Scanner(System.in);

		try {
			File file = new File("kayit_dosyasi.txt");
			Scanner read = new Scanner(file);
			_20010310007_HeapSort heapSort = new _20010310007_HeapSort();

			int temp = 2500;

			for (int i = 0; i < temp; i++) {
				read.hasNextLine();
				String line = read.nextLine();
				String lineArray[] = line.split(",");
				heapSort.insert(new _20010310007_Kayit(Long.parseLong(lineArray[0]), lineArray[1], lineArray[2]));
			}
			
			
			//---------------------------------
			
			System.out.println("Kapasitesi 2500 olan veri yapýsý yaratýlmýþtýr.");
			System.out.println("Insert() metodu kullanýlarak dosyadaki ilk 2500 kayýt veri yapýsýna eklenmiþtir.");
			heapSort.resize();

			for (int i = temp; i < temp * 2; i++) {
				read.hasNextLine();
				String line = read.nextLine();
				String lineArray[] = line.split(",");
				heapSort.insert(new _20010310007_Kayit(Long.parseLong(lineArray[0]), lineArray[1], lineArray[2]));
			}
			
			//-----------------------------

			System.out.println("Insert() metodu kullanýlarak dosyadaki ikinci 2500 kayýt veri yapýsýna eklenmiþtir.");
			System.out.println("returnKayitSayisi   " + heapSort.returnKayitSayisi());
			System.out.println("Delete   ");
			long tc1 = input.nextLong();
			_20010310007_Kayit delete = heapSort.kayitDelete(tc1);
			if (delete != null) {
				System.out.println(delete.getTc() + " " + delete.getName() + " " + delete.getSurname());
			} else
				System.out.println("null");

			System.out.println("returnKayitSayisi   " + heapSort.returnKayitSayisi());
			heapSort.heap_Sort();

			System.out.println("kayitEnBüyükKaydiCikar  ");
			delete = heapSort.kayitEnBüyükKaydiCikar();
			System.out.println(delete.getTc() + " " + delete.getName() + " " + delete.getSurname());
			
			delete = heapSort.kayitDeletePos(6);
			System.out.println(delete.getTc() + " " + delete.getName() + " " + delete.getSurname()
			+ "  silinen kisinin pozisyonu ");
			
			heapSort.heap_Sort();

			System.out.println("Search ");
			long tc = input.nextLong();
			if (heapSort.kayitSearch(tc) != null) {
				System.out.println(heapSort.kayitSearch(tc).getTc() + " " + heapSort.kayitSearch(tc).getName() + " "
						+ heapSort.kayitSearch(tc).getSurname());
			} else
				System.out.println("null");

			System.out.println(" returnSeviyeSayisi  " + heapSort.returnSeviyeSayisi());

			read.close();

		} catch (FileNotFoundException e) {
			System.out.println("Dosya okunurken hata olustu.");
			e.printStackTrace();
		}
	}
}
