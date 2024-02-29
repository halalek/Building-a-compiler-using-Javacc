package nodes;

import java.util.ArrayList;

public class ConditionNode extends AbstractTreeNode {

	@Override
	public String toString() {
		return "Condition " + operator;
	}

	String operator;

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	ArrayList<String> op = new ArrayList<String>();
	ArrayList<Object> Objectt = new ArrayList<Object>();
	ArrayList<Boolean> booleann = new ArrayList<Boolean>();

	public void addop(String child) {
		op.add(child);
	}

	public ArrayList<String> getop() {
		return op;
	}

	public void addbool(Object child) {
		Objectt.add(child);
	}

	public ArrayList<Object>getbool() {
		return Objectt;
	}

	public void addbool(boolean child) {
		booleann.add(child);
	}

	public ArrayList<Boolean> getboolea() {
		return booleann;
	}

	@Override
	public Object execute(Context context) {

		ArrayList<Object> Objectt=new ArrayList<Object>();
		for (int i = 0; i <= children.size() - 1; i++) {
			Object o = children.get(i).execute(context);

			if (o.getClass().getName().contains("Float")) {
				System.out.println("float");
				Objectt.add((double) children.get(i).execute(context));
			}
			if (o.getClass().getName().contains("Double")) {
				System.out.println("double");
				Objectt.add((double) o);
			}

			if (o.getClass().getName().contains("Integer")) {
				System.out.println("integer");
				Objectt.add((int) children.get(i).execute(context));
			}
			if (o.getClass().getName().contains("String")) {
				System.out.println("string");
				Objectt.add((String) children.get(i).execute(context));
			}
			if (o.getClass().getName().contains("char")) {
				System.out.println("char");
				Objectt.add((String) children.get(i).execute(context));
			}

			if (o.getClass().getName().contains("bool")) {
				System.out.println("bool");
				Objectt.add((Boolean) children.get(i).execute(context));
			}

		}

		int j = 0;
		int o = 0;

		{
			while (j < Objectt.size() || o < op.size()) {
				System.out.println("condiaation");
				if (op.get(o).equals("<")) {
//					 System.out.println((double)bool.get(j) < (double)bool.get(j+1));
					if (Objectt.get(j).getClass().getName().contains("Double")
							&& Objectt.get(j + 1).getClass().getName().contains("Double"))
						booleann.add((double) Objectt.get(j) < (double) Objectt.get(j + 1));
					else if (Objectt.get(j).getClass().getName().contains("Integer")
							&& Objectt.get(j + 1).getClass().getName().contains("Integer"))
						booleann.add((int) Objectt.get(j) < (int) Objectt.get(j + 1));
					else if (Objectt.get(j).getClass().getName().contains("Integer")
							&& Objectt.get(j + 1).getClass().getName().contains("Double"))
						booleann.add((int) Objectt.get(j) < (double) Objectt.get(j + 1));
					else if (Objectt.get(j).getClass().getName().contains("Double")
							&& Objectt.get(j + 1).getClass().getName().contains("Integer"))
						booleann.add((double) Objectt.get(j) < (int) Objectt.get(j + 1));
					else
						throw new NumberFormatException("can't compare two string");

				} else if (op.get(o).equals(">")) {

					if (Objectt.get(j).getClass().getName().contains("Double")
							&& Objectt.get(j + 1).getClass().getName().contains("Double"))
						booleann.add((double) Objectt.get(j) > (double) Objectt.get(j + 1));
					else if (Objectt.get(j).getClass().getName().contains("Integer")
							&& Objectt.get(j + 1).getClass().getName().contains("Integer"))
						booleann.add((int) Objectt.get(j) > (int) Objectt.get(j + 1));
					else if (Objectt.get(j).getClass().getName().contains("Integer")
							&& Objectt.get(j + 1).getClass().getName().contains("Double"))
						booleann.add((int) Objectt.get(j) > (double) Objectt.get(j + 1));
					else if (Objectt.get(j).getClass().getName().contains("Double")
							&& Objectt.get(j + 1).getClass().getName().contains("Integer"))
						booleann.add((double) Objectt.get(j) > (int) Objectt.get(j + 1));

					else
						throw new NumberFormatException("can't compare two string");


				} else if (op.get(o).equals("==")) {

					{

						if (Objectt.get(j).getClass().getName().contains("Double")
								&& Objectt.get(j + 1).getClass().getName().contains("Double"))
							booleann.add((double) Objectt.get(j) == (double) Objectt.get(j + 1));
						else if (Objectt.get(j).getClass().getName().contains("Integer")
								&& Objectt.get(j + 1).getClass().getName().contains("Integer"))
							booleann.add((int) Objectt.get(j) == (int) Objectt.get(j + 1));
						else if (Objectt.get(j).getClass().getName().contains("Integer")
								&& Objectt.get(j + 1).getClass().getName().contains("Double"))
							booleann.add((int) Objectt.get(j) == (double) Objectt.get(j + 1));
						else if (Objectt.get(j).getClass().getName().contains("Double")
								&& Objectt.get(j + 1).getClass().getName().contains("Integer"))
							booleann.add((double) Objectt.get(j) == (int) Objectt.get(j + 1));
						else if (Objectt.get(j).getClass().getName().contains("bool")
								&& Objectt.get(j + 1).getClass().getName().contains("bool"))
							booleann.add((boolean) Objectt.get(j) == (boolean) Objectt.get(j + 1));
						else if (Objectt.get(j).getClass().getName().contains("String")
								&& Objectt.get(j + 1).getClass().getName().contains("String")) {
							booleann.add(((String) Objectt.get(j)).equals(Objectt.get(j + 1)));
						} else
							throw new NumberFormatException();


					}
				}
             else if (((Objectt.get(j)).equals("true")) || ((Objectt.get(j)).equals("false")) )


				{

					if (op.get(o).equals("&&")) {
						System.out.println("lllllllllllllllll");
						Object o1 =Objectt.get(j);
						Object o2 =Objectt.get(j+1);
						if((o1.equals("true")&&o2.equals("false") )|| (o1.equals("false")&&o2.equals("true") ) )
						{
							booleann.add(false);
							System.out.println("false&&true");
						}
						else if((o1.equals("true")&&o2.equals("true") ) )
						{
							booleann.add(true);
							System.out.println("true&&true");
						}
						else if((o1.equals("false")&&o2.equals("false") ) )
						{
							booleann.add(false);
							System.out.println("false&&false");
						}

					}
					else if (op.get(o).equals("||")) {
						Object o1 =Objectt.get(j);
						Object o2 =Objectt.get(j+1);
						if((o1.equals("true")&&o2.equals("false") )|| (o1.equals("false")&&o2.equals("true") ) )
						{
							booleann.add(true);
						}
						else if((o1.equals("true")&&o2.equals("true") ) )
						{
							booleann.add(true);
						}
						else if((o1.equals("false")&&o2.equals("false") ) )
						{
							booleann.add(false);
						}
					}

					else if (op.get(o).equals("!=")) {
						Object o1 =Objectt.get(j);
						Object o2 =Objectt.get(j+1);
						if((o1.equals("true")&&o2.equals("false") )|| (o1.equals("false")&&o2.equals("true") ) )
						{
							booleann.add(true);
						}
						else if((o1.equals("true")&&o2.equals("true") ) )
						{
							booleann.add(false);
						}
						else if((o1.equals("false")&&o2.equals("false") ) )
						{
							booleann.add(false);
						}
					}




				}


				else {
					booleann.add(Objectt.get(j) != Objectt.get(j + 1));

				}
				j += 2;
				o += 1;

			}
		}

		return booleann;

		/*
		 * case "<": //return h= d1 < d2; case ">=": // return h= d1 >= d2; case "<=":
		 * // return h= d1 <= d2; case "<>": // return h= d1 != d2; case "=": // return
		 * h= d1 == d2; }
		 *
		 * return null;
		 */
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}



