public class TreeIntSet implements IntSet {
	private int value;
	private TreeIntSet left;
	private TreeIntSet right;

	public TreeIntSet(int x) {
		this.value = x;
		this.left = null;
		this.right = null;
	}

	public void add(int x) {
		if (x != this.value) {
			if (x < this.value) {
				if (this.left == null) {
					this.left = new TreeIntSet(x);
				} else {
					this.left.add(x);
				}
			} else {
				if (this.right == null) {
					this.right = new TreeIntSet(x);
				} else {
					this.right.add(x);
				}
			}
		}

	}

	public boolean contains(int x) {
		boolean contains = false;
		if (this.value == x) {
			contains = true;
		} else if (x < this.value) {
			if (this.left == null) {
				contains = false;
			} else {
				contains = this.left.contains(x);
			}
		} else {
			if (this.right == null) {
				contains = false;
			} else {
				contains = this.right.contains(x);
			}
		}
		return contains;
	}

	public boolean containsVerbose(int x) {
		boolean contains = false;
		System.out.println(this.value);
		if (this.value == x) {
			contains = true;
		} else if (x < this.value) {
			if (this.left == null) {
				contains = false;
			} else {
				contains = this.left.containsVerbose(x);
			}
		} else {
			if (this.right == null) {
				contains = false;
			} else {
				contains = this.right.containsVerbose(x);
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
		IntSet start = new TreeIntSet(100);
		start.add(150);
		start.add(190);
		start.add(200);
		start.add(1);
		start.add(4);
		start.add(7);
		start.add(150);
		start.add(95);
		start.add(66);
		if (start.contains(19)) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
		boolean y = start.containsVerbose(1000);
		System.out.println(start.toString());
	}

}