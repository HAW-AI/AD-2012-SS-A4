package aufgabe4.specific;

public interface ITree {
	public static final ITree EMPTY_TREE = Tree.EMPTY_TREE;
	public boolean isEmpty();
	public Object root();
	public ITree getEmptyTree();
	public ITree getSubTree(int n);
	public ITree fork(Object elem, ITree... subTrees);
	public ITree[] getSubTrees();
}
