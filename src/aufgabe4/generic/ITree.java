package aufgabe4.generic;
import java.util.Collection;


public interface ITree<T> {
	public boolean isEmpty();
	public T root();
	public ITree<T> getEmptyTree();
	public <O> ITree<O> getEmptyTree(O o);
	public ITree<T> getSubTree(int n);
	public ITree<T> fork(T elem, Collection<ITree<T>> subTrees);
	public Collection<ITree<T>> getSubTrees();
}
