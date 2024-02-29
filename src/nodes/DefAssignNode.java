package nodes;



public class DefAssignNode extends AbstractTreeNode {

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

        if(!(context.getVars().containsKey(varName)))
        {
            context.getVars().put(varName, '0');
            System.out.println("Defin first");
        }
        else
        {

            System.out.println("Variable has already been defined,please change is name");}
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
