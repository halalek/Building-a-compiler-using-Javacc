package nodes;

import java.util.HashMap;

public class FuncCallNode extends ExpressionNode {

	String functionName;
	
	HashMap<String, FunctionDef> functions = new HashMap<String, FunctionDef>();
	
	
	
	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public HashMap<String, FunctionDef> getFunctions() {
		return functions;
	}

	public void setFunctions(HashMap<String, FunctionDef> functions) {
		this.functions = functions;
	}

	@Override
	public Object execute(Context context) {
		if (!functions.containsKey(functionName))
			throw new RuntimeException("function not found");
		FunctionDef f = functions.get(functionName);
	//	System.out.print("keysat"+f.functionin.peek().keySet());
		for(int i=0;i<f.functionin.size();i++)
		functions.put(f.functionin.get(i).keySet().toString(),f.functionin.get(i).get(f.functionin.peek().keySet().toString()));

		if (f.getParams().size() != this.children.size())
			throw new RuntimeException("Invalid params");
		HashMap<String, Object> tmp = new HashMap<String, Object>();
		for(int i=0;i<f.getParams().size();i++)
			tmp.put(f.getParams().get(i), (Object)this.getChildren().get(i).execute(context));
		context.startFunction();
		context.getVars().putAll(tmp);
	//	System.out.print("mariam"+f.getfunctionin());
		f.root.execute(context);
		Object res = (Object)context.getVars().get("ret");
		for(int i=0;i<f.functionin.size();i++)
		{
		
			if(functions.containsKey(f.functionin.get(i).keySet().toString()));
			{
				
			    functions.remove(f.functionin.get(i).keySet().toString());
			}
		}
		
		context.endFunction();
		return res;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
