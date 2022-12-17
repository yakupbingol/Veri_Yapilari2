import java.util.ArrayList;
import java.util.List;

public class _20010310007_HeapSort {
	List<_20010310007_Kayit> kayitListe;
	private int heap_size;

	public _20010310007_HeapSort(List<_20010310007_Kayit> kayitListe) {
		this.kayitListe = kayitListe;
		this.heap_size = kayitListe.size();

	}

	public int getHeap_size() {
		return heap_size;
	}

	public void setHeap_size(int heap_size) {
		this.heap_size = heap_size;
	}

	public _20010310007_HeapSort() {
		kayitListe = new ArrayList<_20010310007_Kayit>();
	}

	public int left(int i) {
		return 2 * i + 1;
	}

	public int right(int i) {
		return 2 * i + 2;
	}

	public int parent(int i) {
		return (i - 1) / 2;
	}

	public void max_heapify(int i) {
		int largest = i;
		int left = left(i);
		int right = right(i);
		if (left < heap_size && kayitListe.get(left).getTc() > kayitListe.get(largest).getTc()) {
			largest = left;
		}
		if (right < heap_size && kayitListe.get(right).getTc() > kayitListe.get(largest).getTc()) {
			largest = right;
		}
		if (largest != i) {
			_20010310007_Kayit temp = kayitListe.get(i);
			kayitListe.set(i, kayitListe.get(largest));
			kayitListe.set(largest, temp);
			max_heapify(largest);
		}

	}

	public void heap_Sort() {
		build_max_heapify();
		for (int i = kayitListe.size(); i < 2; i--) {
			kayitListe.set(0, kayitListe.get(i));
			heap_size--;
			max_heapify(i);
		}

	}

	private void build_max_heapify() {
		for (int i = heap_size / 2; i >= 0; i--) {
			max_heapify(i);
		}

	}

	public void printList() {
		for (int i = 0; i <= this.heap_size; i++) {
			max_heapify(i);

		}
		for (_20010310007_Kayit kayit : kayitListe) {
			System.out.println(kayit.getTc() + " " + kayit.getName() + " " + kayit.getSurname());
		}
	}

	public void insert(_20010310007_Kayit kayit) {

		kayitListe.add(kayit);
		heap_size++;

	}

	public _20010310007_Kayit kayitSearch(long tc) {

		for (int i = 0; i < kayitListe.size(); i++) {
			if (kayitListe.get(i).getTc() == tc) {
				return kayitListe.get(i);
			}

		}
		return null;

	}

	public _20010310007_Kayit kayitEnBüyükKaydiCikar() {
		_20010310007_Kayit kayit = kayitListe.get(0);
		kayitListe.set(0, kayitListe.get(heap_size - 1));
		max_heapify(0);
		return kayit;

	}

	public _20010310007_Kayit kayitDelete(long tc) {
		for (int i = 0; i < kayitListe.size(); i++) {
			if (kayitListe.get(i).getTc() == tc) {
				_20010310007_Kayit temp = kayitListe.get(i);
				kayitListe.remove(kayitListe.get(i));
				heap_size--;
				return temp;
			}

		}
		heap_Sort();
		return null;

	}

	public _20010310007_Kayit kayitDeletePos(int pozisyon) {
		_20010310007_Kayit poz = kayitListe.get(pozisyon);
		kayitListe.set(pozisyon, kayitListe.get(heap_size - 1));
		heap_size--;
		max_heapify(pozisyon);
		return poz;

	}

	public int returnKayitSayisi() {
		return heap_size;

	}

	public int returnSeviyeSayisi() {
		return (int) (Math.ceil(Math.log(heap_size + 1) / Math.log(2)) - 1);

	}

	public void resize() {
		System.out.println("Resize() metodu kullanilarak veri yapisinin boyutu 2 katina çikarilmistir");

	}

}
