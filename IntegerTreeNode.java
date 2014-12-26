public class IntegerTreeNode {
	int value;
	IntegerTreeNode left;
	IntegerTreeNode right;

	public IntegerTreeNode(int newNumber) {
		this.value = newNumber;
		this.left = null;
		this.right = null;
	}

	public void add(int newNumber) {
		if (newNumber > this.value) {
			if (right == null) {
				right = new IntegerTreeNode(newNumber);
			} else {
			right.add(newNumber);
			}
		} else {
			if (left == null) {
				left = new IntegerTreeNode(newNumber);
			} else {
			left.add(newNumber);
			}
		}
	}

	public boolean contains(int n) {
		if (n == this.value) {
			return true;
		} else if (n > this.value) {
			if (right == null) {
				return false;
			} else {
				return right.contains(n);
			}
		} else {
			if (left == null) {
				return false;
			} else {
				return left.contains(n);
			}
		}
	}

	public int getMax() {
		if (this.right == null) {
			return this.value;
		} else {
			return right.getMax();
		}
	}

	public int getMin() {
		if (this.left == null) {
			return this.value;
		} else {
			return left.getMin();
		}
	}

	public void toStringTree() {
		System.out.print("[" + this.value + " ");
		if (this.left == null) {
			System.out.print("[] ");
		} else {
			System.out.print("L" + this.left.value + " ");
		}
		if (this.right == null) {
			System.out.print("[] ]\n");
		} else {
			System.out.print("R" + this.right.value + "]\n");
		}
		if (this.left != null) {
			this.left.toStringTree();
		}
		if (this.right != null) {
			this.right.toStringTree();
		}
	}

	public int depth(int x){
		int leftDepth = x;
		int rightDepth = x;
		if(this.left != null){
	        leftDepth = this.left.depth(x + 1);
	    }
	    if(this.right != null){
	        rightDepth = this.right.depth(x + 1);
	    }
		if (leftDepth > rightDepth) {return leftDepth;}
		else {return rightDepth;}
	}

	public static void main(String[] args) {
		IntegerTreeNode n1 = new IntegerTreeNode(6);
		n1.add(3);
		n1.add(96);
		n1.add(75);
		n1.add(1);
		n1.add(789);
		n1.add(78);
		n1.add(14);
		n1.add(19);
		n1.add(4);
		n1.add(5);
		n1.add(6);
		if (n1.contains(4)) {
			System.out.println("True.");
		} else {
			System.out.println ("False");
		}
		System.out.println(n1.getMax() + " " + n1.getMin());
		n1.toStringTree();
		n1.add(20);
		n1.add(8);
		n1.add(10);
		n1.add(11);
		n1.add(12);
		n1.add(13);
		System.out.println(n1.depth(0));
		n1.toStringTree();
	}
}