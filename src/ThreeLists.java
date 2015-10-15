
public class ThreeLists {
	
	private LinkedList[] List = new LinkedList[3];
	
	public ThreeLists()
	{
		List[0] = new LinkedList();
		List[1] = new LinkedList();
		List[2] = new LinkedList();
	}
	
	public int shortestListNo()
	{
		if(List[0].getNoOfItems() == List[1].getNoOfItems() && List[0].getNoOfItems() == List[2].getNoOfItems())
			return 0;
		else if(List[0].getNoOfItems() <= List[1].getNoOfItems() && List[0].getNoOfItems() <= List[2].getNoOfItems())
			return 0;
		else if(List[1].getNoOfItems() <= List[0].getNoOfItems() && List[1].getNoOfItems() <= List[2].getNoOfItems())
			return 1;
		else 
			return 2;
	}
	
	public void add(Type item)
	{
		int listNo = this.shortestListNo();
		List[listNo].add(item);
		System.out.println("Added " + item.getValue() + " to queue List" + (int) (listNo+1));
	}
		
	public void cancel(Type item)
	{
		int pos,listNo;
		pos = List[0].search(item);
		listNo = 0;
		if(pos == -1) 
		{
			pos = List[1].search(item);
			listNo = 1;
			if(pos == -1) {
				pos = List[2].search(item);
				listNo = 2;
			}
		}
		if(pos == -1)
			System.out.println("Error!! Element not found");
		else {
			List[listNo].remove(pos);
			System.out.println("Deleted " + item.getValue());
		}
	}
	
	public void remove()
	{
		int L1,L2,L3;
		Type itemRemoved;
		if(List[0].getNoOfItems() == 0 && List[1].getNoOfItems() == 0 && List[2].getNoOfItems() == 0) {
			System.out.println("Remove called on empty queues");
			return;
		}
		else if(List[0].getNoOfItems() == 0 && List[1].getNoOfItems() == 0)
			itemRemoved = List[2].remove(1);
		else if(List[1].getNoOfItems() == 0 && List[2].getNoOfItems() == 0)
			itemRemoved = List[0].remove(1);
		else if(List[0].getNoOfItems() == 0 && List[2].getNoOfItems() == 0)
			itemRemoved = List[1].remove(1);
		else if(List[0].getNoOfItems() == 0)
		{
			L2 = (int) List[1].getStart().item.getValue();
			L3 = (int) List[2].getStart().item.getValue();
			if(L2 <= L3)
				itemRemoved = List[1].remove(1);
			else
				itemRemoved = List[2].remove(1);
		}
		else if(List[1].getNoOfItems() == 0)
		{
			L1 = (int) List[0].getStart().item.getValue();
			L3 = (int) List[2].getStart().item.getValue();
			if(L1 <= L3)
				itemRemoved = List[0].remove(1);
			else
				itemRemoved = List[2].remove(1);
		}
		else if(List[2].getNoOfItems() == 0)
		{
			L1 = (int) List[0].getStart().item.getValue();
			L2 = (int) List[1].getStart().item.getValue();		
			if(L1 <= L2)
				itemRemoved = List[0].remove(1);
			else
				itemRemoved = List[1].remove(1);
		}
		else
		{
			L1 = (int) List[0].getStart().item.getValue();
			L2 = (int) List[1].getStart().item.getValue();
			L3 = (int) List[2].getStart().item.getValue();
			if(L1 <= L2 && L1 <= L3)
				itemRemoved = List[0].remove(1);
			else if(L2 <= L1 && L2 <= L3)
				itemRemoved = List[1].remove(1);
			else
				itemRemoved = List[2].remove(1);
		}
		System.out.println("Removed " + itemRemoved.getValue());
	}
	public void print()
	{
		System.out.print("[ ");
		List[0].print();
		System.out.print("]");
		System.out.println();
		System.out.print("[ ");
		List[1].print();
		System.out.print("]");
		System.out.println();
		System.out.print("[ ");
		List[2].print();
		System.out.print("]");
		System.out.println();
	}
}
