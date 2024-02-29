package nodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class FunctionDef {

	 Stack <HashMap<String,FunctionDef>> functionin = new  Stack<HashMap<String,FunctionDef>> ();
	String name;
	public String getName() {
		return name;
	}
	public  Stack<HashMap<String,FunctionDef>>  getfunctionin() {
		return functionin ;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AbstractTreeNode getRoot() {
		return root;
	}
	public void setRoot(AbstractTreeNode root) {
		this.root = root;
	}
	public ArrayList<String> getParams() {
		return params;
	}
	ArrayList<String> params = new ArrayList<String>();
	AbstractTreeNode root;
	
}
