public class ListIntSortedList implements IntSortedList {
	private int value;
	private ListIntSortedList next;

	public ListIntSortedList(int x) {
		this.value = x;
		this.next = null;
	}

	public void add(int x) {
		if (this.next == null) {
			this.next = new ListIntSortedList(x);
		} else {
			this.next.add(x);
		}
	}

	public boolean contains(int x) {
		boolean contains = false;
		if (this.value == x) {
			contains = true;
		} else if (this.next == null) {
			contains = false;
		} else {
			contains = this.next.contains(x);
		}
		return contains;
	}

	public String toString() {
		String result = this.value + ", ";
		if (this.next != null) {
			result = result + this.next.toString();
		}
		return result;
	}

	public static void main(String[] args) {
		IntSortedList start = new ListIntSortedList(50);
		start.add(30);
		start.add(20);
		start.add(10);
		start.add(100);
		start.add(90);
		start.add(40);
		start.add(40);
		start.add(40);
		start.add(40);
		start.add(40);
		start.add(40);
		start.add(45);
		start.add(45);
		if (start.contains(40)) {
			System.out.println("true.");
		} else {
			System.out.println("false");
		}
		System.out.println(start.toString());
	}
}