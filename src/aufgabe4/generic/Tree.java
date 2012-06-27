package aufgabe4.generic;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class Tree<T> implements ITree<T> {

	//public static final Tree<?> EMPTY_TREE = new Tree();
	
	private final T elem;
	
	private final Collection<ITree<T>> subTrees;
	
	public Tree() {
		elem = null;
		subTrees = Collections.unmodifiableCollection(new ArrayList<ITree<T>>());
	}
	
	private Tree(T elem, Collection<ITree<T>> subTrees) {
		this.elem = elem;
		this.subTrees = subTrees;
	}
	
	public boolean isEmpty() {
		return elem == null;
	}

	public T root() {
		return elem;
	}

	public ITree<T> getEmptyTree() {
		return new Tree<T>();
	}
	
	public <O> ITree<O> getEmptyTree(O o) {
		return new Tree<O>();
	}

	private static <T> T get(Collection<T> c, int i) {
		for (T o : c)
			if (i-- == 0)
				return o;
		return null;
	}
	
	public ITree<T> getSubTree(int n) {
		return get(subTrees, n);
	}

	public ITree<T> fork(T elem, Collection<ITree<T>> subTrees) {
		return new Tree<T>(elem, Collections.unmodifiableCollection(subTrees));
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof ITree<?>))
			return false;
		ITree<?> t = (ITree<?>) o;
		if (!((elem == null && t.root() == null) || elem.equals(t.root())))
			return false;
		return (subTrees.equals(t.getSubTrees()));
	}

	public int hashCode() {
		return (new Object[] {elem, subTrees}).hashCode();
	}

	public Collection<ITree<T>> getSubTrees() {
		return subTrees;
	}

}
