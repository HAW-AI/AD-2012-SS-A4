package aufgabe4.generic;
import java.util.Collection;


public interface ITree<T> {
	public boolean isEmpty();
	public T root();
	public ITree<T> getEmptyTree(); // ensures every Tree can have its emptyTree (depending on its generic type)
	public <O> ITree<O> getEmptyTree(O o); // yield an emptyTree specific for a type (in a similar manner like in a constructor)
	public ITree<T> getSubTree(int n);
	public ITree<T> fork(T elem, Collection<ITree<T>> subTrees); // fork is an instance method despite not using the object. Can be simply called on emptyTree.
	public Collection<ITree<T>> getSubTrees(); // while ((obj = getSubTree(n++)) != null) result.add(obj);
}
