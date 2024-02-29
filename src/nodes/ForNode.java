package nodes;

public class ForNode extends AbstractTreeNode {

	@Override
	public String toString()
	{
		return "For " + varName;
	}

	String varName;
	String inc;
	String compare;
	public boolean f=true;
	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}

	public void setincrement(String inc) {
		this.inc = inc;
	}
	public void setcompare(String compare) {
		this.compare = compare;
	}

	@Override
	public Object execute(Context context) {
	//	context.startFunction();
		int start = (int)children.get(0).execute(context);
		int end = (int)children.get(1).execute(context);
		int step = 1;
		if (children.size() > 3)
			step = (int)children.get(3).execute(context);
		double current = start;
		while(true){
			//-- large
			//++ small
			if(inc == "--" && current < end)
				break;
			if (step < 0 && current < end)
				break;
			if (inc == "++"&&step > 0 && current > end)
				break;
			context.getVars().put(varName, current);
			children.get(2).execute(context);
			end = (int)children.get(1).execute(context);
			if (children.size() > 3)
				step = (int)children.get(3).execute(context);
			if(inc=="++")
			current += step;
			else{
				current -= step;}
		}
		//context.endFunction();
		return null;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
