package nodes;

public class ConstantNode extends ExpressionNode {

	@Override
	public String toString()
	{
		return value + "";
	}
	
	Object value;
	
	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	
	@Override
	public Object execute(Context context) {
		/*if(value.getClass().getName().contains("Integer"))
			value=(Integer)value;
		if(value.getClass().getName().contains("Float"))
			value=(Float)value;
		if(value.getClass().getName().contains("String"))
			value=(String)value;
		if(value.getClass().getName().contains("Character"))
			value=(Character)value;*/
		/*if(this.type=="int")
			{
			System.out.println("def int ");
			return (int)value;}
		if(this.type=="float")
			return (float)value;*/
		
		return value;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}


}
