package nodes;

import java.util.ArrayList;


public class FoorNode extends AbstractTreeNode {
    Boolean k=false;
    Boolean condation=false;
    public boolean f=true;
    @Override
    public String toString()
    {
        return "For";
    }

    ArrayList<Boolean> value=new ArrayList<>();
//    ArrayList<String> boole=new ArrayList<>();
//
//    public ArrayList<String> getboole() {
//        return boole;
//    }

    public void addboole(String child) {
        boole.add(child);
    }
    public void addbool(boolean child) {
        value.add(child);
    }

    public void selgetbool1(boolean k) {
       this.k=k;
    }

    public void selcondation(boolean condation) {
        this.condation=condation;
    }

    public ArrayList<Boolean> getboolea() {
        return value;
    }
    @Override
    public Object execute(Context context) {
        //ArrayList<String> l=new ArrayList<>();
        ArrayList<String> Objectt=new ArrayList<>();
        ArrayList<Boolean> value=new ArrayList<>();
        Boolean typecondation = false;

        do
        {
            Objectt=(ArrayList<String>)children.get(0).getboole();//object
            if(k==false)//first assigment
            {children.get(0).execute(context);
            k=true;
            }

            value=(ArrayList<Boolean>)children.get(1).execute(context);//valuecondation

            int u=1;
            int yy=2;
            int hala =value.size()-1;

            if(Objectt.size()!=0)
            {

                String hh=Objectt.get(1);

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
                    value.add(value.get(hala) && value.get(1));
                }
                else if(hh=="||"&&value.size()==2)
                    value.add(value.get(hala) || value.get(1));
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

            if(condation)
            {
                System.out.println("555555555555555");
                children.get(2).execute(context);
                typecondation=condation;

            }


            else if(value.get(value.size()-1))
            {
                System.out.println("1111111111111111111111");
                typecondation=value.get(value.size()-1);
                children.get(2).execute(context);


            }
            else
            {
                typecondation=value.get(value.size()-1);
            }




        }
        while (typecondation&&f);
        //while(value.get(value.size()-1));
        //context.endFunction();
        return null;
    }

    @Override
    public Object convert(Context context) {
        // TODO Auto-generated method stub
        return null;
    }

}
