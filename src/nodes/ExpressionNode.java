package nodes;

public class ExpressionNode extends AbstractTreeNode {

	@Override
	public String toString()
	{
		return "Expression " + operator;
	}
	
	
	String operator;
    
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}



	@Override
	public Object execute(Context context) {
		System.out.println("execute");
	Object o=children.get(0).execute(context);
	Object o1=children.get(1).execute(context);
//	System.out.println(children.get(0).getClass().getName());
	System.out.println("object1:"+o+"  "+o.getClass().getName());
	System.out.println("object2:"+o1+"  "+o1.getClass().getName());
//	System.out.println("object1:"+o+"  "+o.getClass().getName()+"////"+children.get(0).getClass().getName());
//	System.out.println("object2:"+o1+"  "+o1.getClass().getName()+"////"+children.get(1).getClass().getName());
	/*if (children.get(0).getClass().getName().contains("VariableNode"))
	{
		System.out.println("const");
		if(((VariableNode)(children.get(0))).getType().equals("int"))
		{
			System.out.println("VariableNode type :"+((VariableNode)(children.get(0))).getType());
			
			
		}
		
	}
	else {
		
		
		
	}*/
	
	if(o.getClass().getName().contains("Float")&& o1.getClass().getName().contains("Float"))
	{
		float d1 =(float) o;
		float d2 =(float) o1;
		switch(operator) {
		case "+":

			return d1+d2;
		case "-":
			return d1 - d2;
		case "*":
			return d1 * d2;
		case "/":
			return d1 / d2;
		}
		return null;
		
	}
	if(o.getClass().getName().contains("Float")&& o1.getClass().getName().contains("Double"))
	{
		float d1 =(float) o;
		double d2 =(double) o1;
		switch(operator) {
		case "+":
			return d1+d2;
		case "-":
			return d1 - d2;
		case "*":
			return d1 * d2;
		case "/":
			return d1 / d2;
		}
		return null;
		
	}
	if(o.getClass().getName().contains("Float")&& o1.getClass().getName().contains("Int"))
	{
		float d1 =(float) o;
		int d2 =(int) o1;
		switch(operator) {
		case "+":
			return d1+d2;
		case "-":
			return d1 - d2;
		case "*":
			return d1 * d2;
		case "/":
			return d1 / d2;
		}
		return null;
		
	}
	if(o.getClass().getName().contains("Double")&& o1.getClass().getName().contains("Float"))
	{
		double d1 =(double) o;
		float d2 =(float) o1;
		switch(operator) {
		case "+":
			return d1+d2;
		case "-":
			return d1 - d2;
		case "*":
			return d1 * d2;
		case "/":
			return d1 / d2;
		}
		return null;
		
	}
	if(o.getClass().getName().contains("Integer")&& o1.getClass().getName().contains("Float"))
	{
		int d1 =(int) o;
		float d2 =(float) o1;
		switch(operator) {
		case "+":
			return d1+d2;
		case "-":
			return d1 - d2;
		case "*":
			return d1 * d2;
		case "/":
			return d1 / d2;
		}
		return null;
		
	}
		if(o.getClass().getName().contains("Double")&& o1.getClass().getName().contains("Double"))
		{
			double d1 =(double) o;
			double d2 =(double) o1;
			switch(operator) {
			case "+":
				return d1+d2;
			case "-":
				return d1 - d2;
			case "*":
				return d1 * d2;
			case "/":
				return d1 / d2;
			}
			return null;
			
		}
		else if(o.getClass().getName().contains("Integer") && o1.getClass().getName().contains("Integer"))
		{
			int d1 =(int) o;
			int d2 =(int) o1;
			switch(operator) {
			case "+":
				System.out.println(d1+d2);
				return d1+d2;
			case "-":
				System.out.println(d1-d2);
				return  d1 - d2;
			case "*":
				System.out.println(d1*d2);
				return d1 * d2;
			case "/":
				System.out.println(d1/d2);
				return d1 / d2;
			}
			return null;		
		}
		else if(o.getClass().getName().contains("Integer") && o1.getClass().getName().contains("Double"))
		{
			int d1 =(int) o;
			double d2 =(double) o1;
			switch(operator) {
			case "+":
				return d1+d2;
			case "-":
				return d1 - d2;
			case "*":
				return d1 * d2;
			case "/":
				return d1 / d2;
			}
			return null;		
		}
		else if(o.getClass().getName().contains("Double") && o1.getClass().getName().contains("Integer"))
		{
			double d1 =(double) o;
			int d2 =(int)o1;
			switch(operator) {
			case "+":
				return d1+d2;
			case "-":
				return d1 - d2;
			case "*":
				return d1 * d2;
			case "/":
				return d1 / d2;
			}
			return null;		
		}
		else if(o.getClass().getName().contains("String") &&o1.getClass().getName().contains("String"))
		{
			String d1 =(String) children.get(0).execute(context);
			String d2 =(String) children.get(1).execute(context);
			switch(operator) {
			case "+":
				return d1+d2;
			case "-":
				return null; //d1 - d2;
	
			}
			return null;
		}
		else if(o.getClass().getName().contains("Char") &&o1.getClass().getName().contains("Char"))
		{
			char d1 =(char) children.get(0).execute(context);
			char d2 =(char) children.get(1).execute(context);
			switch(operator) {
			case "+":
				return d1+d2;
			case "-":
				return null; //d1 - d2;
	
			}
			return null;
		}
		else if(o.getClass().getName().contains("Char") &&o1.getClass().getName().contains("String"))
		{
			char d1 =(char) children.get(0).execute(context);
			String d2 =(String) children.get(1).execute(context);
			switch(operator) {
			case "+":
				return d1+d2;
			case "-":
				return null; //d1 - d2;
	
			}
			return null;
		}

		else if(o.getClass().getName().contains("String") &&o1.getClass().getName().contains("Char"))
		{
			String d1 =(String) children.get(0).execute(context);
			char d2 =(char) children.get(1).execute(context);
			switch(operator) {
			case "+":
				return d1+d2;
			case "-":
				return null; //d1 - d2;
	
			}
			return null;
		}

		return null;
	}
		@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
