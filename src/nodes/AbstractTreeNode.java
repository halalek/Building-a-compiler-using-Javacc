package nodes;

import java.util.ArrayList;

public abstract class AbstractTreeNode {
	protected String name;

	public String getName() {
		return name;
	}

	ArrayList<String> boole=new ArrayList<String>();

	protected ArrayList<AbstractTreeNode> children = new ArrayList<AbstractTreeNode>();
	public void addboole(String child) {
		boole.add(child);
	}

//	ArrayList<Object> numberofchildren=new ArrayList<Object>();
//
//	public ArrayList<Object> getbool() {
//		return numberofchildren;
//	}
//
//	public void addbool(Double child) {
//		numberofchildren.add(child);
//	}

	public ArrayList<String> getboole() {
		return boole;
	}

	public ArrayList<AbstractTreeNode> getChildren() {
		return children;
	}
	
	public void addChild(AbstractTreeNode child) {
		children.add(child);
	}

	public abstract Object execute(Context context);
	
	public abstract Object convert(Context context);
	
//	public void print(String prefix) {
//		System.out.println(prefix + this);
//		for(AbstractTreeNode n : children)
//			n.print(prefix + "---");
//	}
	
}
