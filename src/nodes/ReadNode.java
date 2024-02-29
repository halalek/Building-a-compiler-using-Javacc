package nodes;

import java.util.Scanner;

public class ReadNode extends AbstractTreeNode {

	
	@Override
	public String toString()
	{
		return "Read " + varName;
	}
	
	String varName;
	
	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}

	@Override
	public Object execute(Context context) {
		System.out.println("please cin ");
		Scanner s = new Scanner(System.in);
		//System.out.println(varName +"="+ s.nextDouble());

     	//context.getVars().put(varName, s.nextDouble());
		context.getVars().put(varName, s.nextDouble());

//		if (children.size()!=0 && !(context.getVars().containsKey(varName))) {
//			context.getVars().put(varName, children.get(0).execute(context));
//			System.out.println(varName+" = "+ children.get(0));
//		}
//		else if (children.size()==0) {
//			context.getVars().put(varName, 0);
//			System.out.println("0");
//		}
//		else if (children.size()!=0 &&context.getVars().containsKey(varName))
//		{
//			System.out.println("replace");
//			System.out.println(children.get(0));
//			context.getVars().replace(varName, children.get(0).execute(context));
//
//
//		}



		return null;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return "cin >> " + varName + ";";
	}

}
