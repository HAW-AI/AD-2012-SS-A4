package aufgabe4.specific;

import java.util.Arrays;

public class Tree implements ITree {

	public static final ITree EMPTY_TREE = new Tree();
	
	private final Object elem;
	
	private final ITree[] subTrees;
	
	public Tree() {
		elem = null;
		subTrees = new ITree[] {};
	}
	
	private Tree(Object elem, ITree... subTrees) {
		this.elem = elem;
		this.subTrees = subTrees;
	}
	
	public boolean isEmpty() {
		return elem == null;
	}

	public Object root() {
		return elem;
	}

	public ITree getEmptyTree() {
		return EMPTY_TREE;
	}
	
	public ITree getSubTree(int n) {
		if (n >= 0 && subTrees.length > n)
			return subTrees[n];
		return null;
	}

	public ITree fork(Object elem, ITree... subTrees) {
		return new Tree(elem, (ITree[]) subTrees.clone());
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof ITree))
			return false;
		ITree t = (ITree) o;
		if (!((elem == null && t.root() == null) || elem.equals(t.root())))
			return false;
		return (Arrays.equals(subTrees, t.getSubTrees()));
	}
	
	public int hashCode() {
		return (new Object[] {elem, subTrees}).hashCode();
	}

	public ITree[] getSubTrees() {
		return subTrees.clone();
	}

}
