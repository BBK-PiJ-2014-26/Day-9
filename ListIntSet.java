public class ListIntSet implements IntSet {
	private int value;
	private ListIntSet next;

	public ListIntSet(int x) {
		this.value = x;
		this.next = null;
	}

	public void add(int x) {
		if (this.value != x) {
			if (this.next == null) {
				this.next = new ListIntSet(x);
			} else {
				this.next.add(x);
			}
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

	public boolean containsVerbose(int x) {
		boolean contains = false;
		System.out.println(this.value);
		if (this.value == x) {
			contains = true;
		} else if (this.next == null) {
			contains = false;
		} else {
			contains = this.next.containsVerbose(x);
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
		IntSet start = new ListIntSet(10);
		start.add(4);
		start.add(5);
		start.add(4);
		start.add(70);
		start.add(2);
		start.add(1);
		if (start.contains(19)) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
		boolean y = start.containsVerbose(70);
		System.out.println(start.toString());
	}
}