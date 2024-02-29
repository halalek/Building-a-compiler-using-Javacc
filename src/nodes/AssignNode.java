package nodes;

public class AssignNode extends AbstractTreeNode {

	@Override
	public String toString()
	{
		return "Assign " + varName;
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

//		if (children.size()!=0 && !(context.getVars().containsKey(varName))) {
//			Object f=children.get(0).execute(context);
//			context.getVars().put(varName, f);
//			System.out.println(varName+" = "+ f);
//		//	System.out.println(varName+"  undefined "+"you must define it");
//		}
//		else if (children.size()==0) {
//			Object f=children.get(0).execute(context);
//			context.getVars().put(varName, f);
//			System.out.println("0");
//		}
		if (children.size()!=0 && !(context.getVars().containsKey(varName))) {

			System.out.println(varName+"  undefined "+"you must define it");
		}
		if (children.size()!=0 &&context.getVars().containsKey(varName))
		{
			System.out.println("replace");
			Object f=children.get(0).execute(context);
			context.getVars().replace(varName, f);
			System.out.println(varName+" = "+ f);


		}


		return null;
	}



	public void  definecheck(Context context,String varn) {

		if (children.size()!=0 && !(context.getVars().containsKey(varn))) {

				System.out.println(varn+"  first ");
		}
		else if (children.size()==0&&!(context.getVars().containsKey(varn))) {
			context.getVars().put(varn, '0');
			System.out.println((context.getVars().containsKey(varn)));
			System.out.println(varn);
			System.out.println("0");
		}
//		System.out.println(varn);
//		System.out.println((context.getVars().containsKey(varn)));
//		if((context.getVars().containsKey(varn)))
//		{
//			System.out.println("yes");
//		}
//		else
//		{ context.getVars().put(varn, '0');
//		//	System.out.println((context.getVars().containsKey(varn)));
//			System.out.println("noooo");
//		}
		else if (children.size()!=0 &&context.getVars().containsKey(varn))
		{
			System.out.println("replace");



		}



	}





	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
