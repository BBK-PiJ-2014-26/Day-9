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
		if (this.value == x) {
			System.out.println(this.value + ".");
			contains = true;
		} else if (x < this.value) {
			if (this.left == null) {
				contains = false;
			} else {
				System.out.print(this.left + ", ");
				contains = this.left.contains(x);
			}
		} else {
			if (this.right == null) {
				contains = false;
			} else {
				System.out.print(this.right + ", ");
				contains = this.right.contains(x);
			}
		}
		return contains;
	}

	public String toString() {
		String result = this.value + ", ";
		if (this.left != null) {
			this.left.toString();
		} else if (this.right != null) {
			this.right.toString();
		}
		return result;
	}

}