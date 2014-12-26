public class ListIntSet implements IntSet {
	private int value;
	private ListIntSet next;

	public ListIntSet(int x) {
		this.value = x;
		this.next = null;
	}

	public void add(int x) {
		if (this.next == null) {
			this.next = new ListIntSet(x);
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

	public boolean containsVerbose(int x) {
		boolean contains = false;
		if (this.value == x) {
				System.out.print(this.value);
				contains = true;
			} else if (this.next == null) {
				contains = false;
			} else {
				System.out.print(this.value + ", ");
				contains = this.next.contains(x);
			}
			return contains;
	}
}