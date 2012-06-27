package aufgabe4.specific;

public interface ITree {
	public static final ITree EMPTY_TREE = Tree.EMPTY_TREE;
	public boolean isEmpty();
	public Object root();
	public ITree getEmptyTree(); // ensures every Tree can have its emptyTree
	public ITree getSubTree(int n);
	public ITree fork(Object elem, ITree... subTrees); // fork is an instance method despite not using the object. Can be simply called on emptyTree.
	public ITree[] getSubTrees(); // while ((obj = getSubTree(n++)) != null) result.add(obj);
}
