public class TreeIntSortedList implements IntSortedList {
	private int value;
	private TreeIntSortedList left;
	private TreeIntSortedList right;

	public TreeIntSortedList(int x) {
		this.value = x;
		this.left = null;
		this.right = null;
	}

	public void add(int x) {
		if (x > this.value) {
			if (this.right == null) {
				this.right = new TreeIntSortedList(x);
			} else {
				this.right.add(x);
			}
		} else {
			if (this.left == null) {
				this.left = new TreeIntSortedList(x);
			} else {
				this.left.add(x);
			}
		}
	}

	public boolean contains(int x) {
		boolean contains = false;
		if (this.value == x) {
			contains = true;
		} else if (x > this.value) {
			if (this.right == null) {
				contains = false;
			} else {
				contains = this.right.contains(x);
			}
		} else {
			if (this.left == null) {
				contains = false;
			} else {
				contains = this.left.contains(x);
			}
		}
		return contains;
	}

	public String toString() {
		String result = this.value + ", ";
		if (this.left != null) {
			result = result + this.left.toString();
		}
		if (this.right != null) {
			result = result + this.right.toString();
		}
		return result;
	}

	public static void main(String[] args) {
		IntSortedList start = new TreeIntSortedList(50);
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