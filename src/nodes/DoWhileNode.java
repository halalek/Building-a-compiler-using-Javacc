package nodes;

import java.util.ArrayList;


public class DoWhileNode extends AbstractTreeNode {

    @Override
    public String toString()
    {
        return "DOWhile";
    }

    public String breakk="";
    public boolean f=true;
    public boolean continu=true;
    public boolean dowhile=true;
    ArrayList<Boolean> value=new ArrayList<>();
    //ArrayList<String> boole=new ArrayList<>();

//	public ArrayList<String> getboole() {
//		return boole;
//	}
//
//	public void addboole(String child) {
//		boole.add(child);
//	}

    public void addbool(boolean child) {
        value.add(child);
    }
    public ArrayList<Boolean> getboolea() {
        return value;
    }
    @Override
    public Object execute(Context context) {
        ArrayList<String> l=new ArrayList<>();
        ArrayList<String> Objectt=new ArrayList<>();
        ArrayList<Boolean> value=new ArrayList<>();

        if(dowhile)
        {children.get(1).execute(context);
            dowhile=false;
            System.out.println("dddddddddddddd");
        }
        do
        {

            Objectt=(ArrayList<String>)children.get(0).getboole();//object
            value=(ArrayList<Boolean>)children.get(0).execute(context);//valuecondation


            int u=0;
            int yy=1;
            int hala =value.size()-1;

            if(Objectt.size()!=0)
            {

                String hh=Objectt.get(0);

                while(u<value.size()-1&&yy<Objectt.size())
                {
                    if(Objectt.get(yy)=="&&")
                    {
                        value.add(value.get(u)&&value.get(u+1));

                    }
                    else if(Objectt.get(yy)=="||")
                    {

                        value.add(value.get(u)||value.get(u+1));
                    }
                    else if(Objectt.get(yy)=="!")
                    {

                        value.add(!(value.get(u)));
                    }
                    yy++;
                    u+=2;
                }
                if(hh=="&&"&&value.size()==2)
                {
                    value.add(value.get(hala) && value.get(0));
                }
                else if(hh=="||"&&value.size()==2)
                    value.add(value.get(hala) || value.get(0));
                else if(hh=="!"&&value.size()==2)
                    value.add(!(value.get(hala)));
                if(hh=="&&")
                {
                    value.add(value.get(hala) && value.get(value.size()-1));
                }
                else if(hh=="||")
                    value.add(value.get(hala) || value.get(value.size()-1));
                else if(hh=="!")
                {
                    value.add(!(value.get(hala)));

                }
            }

            if(value.get(value.size()-1))
            {

                children.get(1).execute(context);

            }

        }
        while(value.get(value.size()-1)&&f);
        //context.endFunction();
        return null;
    }

    @Override
    public Object convert(Context context) {
        // TODO Auto-generated method stub
        return null;
    }

}
