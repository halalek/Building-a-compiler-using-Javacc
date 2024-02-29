package nodes;


import java.util.ArrayList;


public class SwitchNode extends AbstractTreeNode {

    @Override
    public String toString()
    {
        return "If";
    }
    public String basicvalue;


    ArrayList<String> valueofcase=new ArrayList<String>();
    ArrayList<String> valueofbreak=new ArrayList<String>();



    public void valueofcase(String casee) {
        valueofcase.add(casee);
    }

    public void valueofbreak(String casee) {
        valueofbreak.add(casee);
    }

    public ArrayList<String> getcasee() {
        return valueofcase;
    }



    @Override
    public Object execute(Context context) {
        boolean defaultt=false;
        System.out.println("switch");
        System.out.println(children.size());
        System.out.println(valueofcase.size());
        for(int i=0;i<valueofcase.size();i++) {
            if (basicvalue.equals(valueofcase.get(i))) {
                defaultt=true;
                children.get(i).execute(context);
                 if(valueofbreak.get(i).equals("break"))
                 {
                     System.out.println(valueofbreak.get(i));

                     break;}
            }
        }

        if(defaultt==false)
        {
            children.get(children.size()-1).execute(context);
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
