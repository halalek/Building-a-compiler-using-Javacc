package nodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Context {
	
	HashMap<String, Object> vars = new HashMap<String, Object>();
	
	Stack<HashMap<String, Object>> varStack = new Stack<HashMap<String,Object>>();
//	Stack<Double> k=new Stack< Double>();
//	Stack<	String> kk=new Stack< String>();
//	ArrayList<Double> after= new ArrayList<Double>();
//	ArrayList<String> afters= new ArrayList<String>();

	public void startFunction() {
		varStack.push(vars);
		vars = new HashMap<String, Object>();
	}
	
	public void endFunction() {
		vars = varStack.pop();
	}


	public HashMap<String, Object> getVars() {
		return vars;
	}





//	public void setVars(HashMap<String, Object> mkk) {
//		mkk = new HashMap<varName, s.nextDouble()>;
//		this.vars=mkk;
//
//	}



}
