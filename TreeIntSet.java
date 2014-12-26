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
		if (this.value == x) {
			return true;
		} else if (x < this.value) {
			if (this.left == null) {
				return false;
			} else {
				this.left.contains(x);
			}
		} else {
			if (this.right == null) {
				return false;
			} else {
				this.right.contains(x);
			}
		}

	}

}