package aufgabe4.specific;

import static org.junit.Assert.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ITree i = new Tree().fork(7);
		ITree e = new Tree().getEmptyTree();
		ITree p = new Tree().fork("hello", i, e);
		
		Main main = new Main();
		main.testEquality();
		main.testUsability();
	}
	
	ITree empty = Tree.EMPTY_TREE;
	ITree a = empty.fork("a");
	ITree b = empty.fork("b");
	ITree root = empty.fork("root", a, b);
	ITree r1 = empty.fork("root", b, a);
	ITree r2 = empty.fork("SPQR", b, a);
	ITree r3 = empty.fork("root", a, a);

	public void testEquality() {
		assertTrue(!a.equals(b));
		assertTrue(empty.equals(ITree.EMPTY_TREE));
		assertTrue(empty.equals(new Tree()));
		assertTrue(!root.equals(r1));
		assertTrue(!r1.equals(r2));
		assertTrue(!r1.equals(r3));
	}
	
	public void testUsability() {
		assertTrue(empty.root() == null);
		assertTrue(a.root().equals("a"));
		assertTrue(b.root().equals("b"));
		assertTrue(r2.root().equals("SPQR"));
		assertTrue(r3.getSubTree(0).equals(r3.getSubTree(1)));
		assertTrue(!r2.getSubTree(0).equals(r2.getSubTree(1)));
		assertTrue(root.getSubTree(0).equals(r1.getSubTree(1)));
		assertTrue(root.getSubTree(0).root().equals("a"));
		assertTrue(root.getSubTree(0).getSubTree(0) == null);
		assertTrue(root.getSubTree(2) == null);
		assertTrue(root.getSubTree(-1) == null);
	}
}
