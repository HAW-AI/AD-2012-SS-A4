package aufgabe4.specific;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ITree i = new Tree().fork(7, new ITree[] {});
		ITree e = new Tree().getEmptyTree();
		ITree p = new Tree().fork("hello", i, e);
	}

}
