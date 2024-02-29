package nodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IfNode extends AbstractTreeNode {
	public boolean breakk=true;
	public boolean continuee=true;
	@Override
	public String toString()
	{
		return "If";
	}
	ArrayList<Boolean> valueofcond=new ArrayList<>();
	ArrayList<Boolean> valueofcond2=new ArrayList<>();
	ArrayList<String> boole=new ArrayList<>();
	public void addbool(boolean child) {
		valueofcond.add(child);
	}
	public ArrayList<Boolean> getboolea() {
		return valueofcond;
	}
	public ArrayList<String> getboole() {
		return boole;
	}
	
	public void addboole(String child) {
		boole.add(child);
	}
	
	@Override
	public Object execute(Context context) {
		System.out.println("ifffff");
		ArrayList<String> booleanop=new ArrayList<>();
		booleanop=(ArrayList<String>)children.get(0).getboole();
	    valueofcond=(ArrayList<Boolean>)children.get(0).execute(context);
	  int u=0;
	  int y=1;//start of secound index in booleanop
	  int lastindex =valueofcond.size()-1;

	  if(booleanop.size()!=0)
	  {
	
	  String mar=booleanop.get(0);  

		while(u<valueofcond.size()-1&&y<booleanop.size())
		{
	      if(booleanop.get(y)=="&&")//and
	      {
	 
	    	valueofcond.add(valueofcond.get(u)&&valueofcond.get(u+1));
	 
	      }
	      else if(booleanop.get(y)=="||")//or
	      {
	   
	    	valueofcond.add(valueofcond.get(u)||valueofcond.get(u+1));
	      }
	      else if(booleanop.get(y)=="!")//not
	      { 
	    	;
	    	  valueofcond.add(!(valueofcond.get(u)));
	      }
	      y++;
	      u+=2;   
		} 
		if(mar=="&&"&&valueofcond.size()==2)
		{
			valueofcond.add(valueofcond.get(lastindex) && valueofcond.get(0));
		}
		else if(mar=="||"&&valueofcond.size()==2)
			valueofcond.add(valueofcond.get(lastindex) || valueofcond.get(0));
		else if(mar=="!"&&valueofcond.size()==2)
			valueofcond.add(!(valueofcond.get(lastindex)) );
		if(mar=="&&")
		{
			valueofcond.add(valueofcond.get(lastindex) && valueofcond.get(valueofcond.size()-1));
		}
	  
		else if(mar=="||")
			valueofcond.add(valueofcond.get(lastindex) || valueofcond.get(valueofcond.size()-1));
		else if(mar=="!")
			valueofcond.add(!(valueofcond.get(lastindex)));
	  }

		if(valueofcond.get(valueofcond.size()-1))
		{
			System.out.println("1111");
			children.get(1).execute(context);
			
		}

//		else if(valueofcond.get(valueofcond.size()-2))
//		{
//			System.out.println("2222222");
//
//			children.get(3).execute(context);
//
//		}

		else if (children.size() > 2)
		{children.get(2).execute(context);
			System.out.println("22222222");
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
