
public class LinkedList implements LinkedListFunctions {
	
	private ListItem startList;
	private int noOfItems;
	
	public LinkedList()
	{
		this.startList = null;
		this.noOfItems = 0;
	}
		
	public int getNoOfItems()
	{
		return this.noOfItems;
	}
	
	public ListItem getStart()
	{
		return this.startList;
	}
	
	public void add(Type item)
	{
		ListItem myItem = new ListItem();
		myItem.item = item;
		myItem.next = null;
		myItem.prev = null;
		if(this.startList == null) {
			this.startList = myItem;
			this.noOfItems = 1;
		}
		else if(this.noOfItems == 1)
		{
			if((int) (this.startList.item.getValue()) <= (int) (item.getValue()))
			{
				this.startList.next = myItem;
				myItem.prev = this.startList;
			}
			else
			{
				myItem.next = this.startList;
				this.startList.prev = myItem;
				this.startList = myItem;
			}
			this.noOfItems++;
		}
		else {
			int pos = 0;
			ListItem temp = this.startList;
			while((int) (this.startList.item.getValue()) <= (int) (item.getValue()))
			{
				temp = this.startList;
				this.startList = this.startList.next;
				pos++;
				if(pos == this.noOfItems)
					break;
			}
			if(pos == this.noOfItems)
			{
				temp.next = myItem;
				myItem.prev = temp;
				if(temp.prev != null)
					this.startList = temp.prev;
				while(this.startList.prev != null)
					this.startList = this.startList.prev;	
			}
			else
			{
				myItem.prev = this.startList.prev;
				myItem.next = this.startList;
				this.startList.prev.next = myItem;
				this.startList.prev = myItem;
				this.startList = myItem;
				while(this.startList.prev != null)
					this.startList = this.startList.prev;				
			}
			this.noOfItems++;
		}
	}
	
	public Type remove(int position)
	{
		if(position > this.noOfItems)
		{
			System.out.println("Index out of bound");
			return null;
		}
		else {
			int i = 1;
			while(i != position)
			{
				this.startList = this.startList.next;
				i++;
			}
			ListItem deletedItem = this.startList;
			ListItem join1 = this.startList.prev == null ? null : this.startList.prev;
			ListItem join2 = this.startList.next == null ? null : this.startList.next;
			if(join1 != null)
				join1.next = join2;
			if(join2 != null)
				join2.prev = join1 == null ? null : join1;
			this.startList = join2 == null ? null : join2;
			if(this.startList != null)
			{
				while(this.startList.prev != null)
					this.startList = this.startList.prev;
			}
			this.noOfItems--;
			return deletedItem.item;
		}
	}
	
	public void print()
	{
		ListItem tempStart = this.startList;
		while(tempStart != null)
		{
			System.out.print(tempStart.item.getValue() + " ");
			tempStart = tempStart.next;
		}
	}
	public int search(Type item)
	{
		int pos = 1;
		ListItem tempStart = this.startList;
		while(tempStart.next != null)
		{
			if((int) tempStart.item.getValue() == (int) item.getValue())
			{
				return pos;
			}
			tempStart = tempStart.next;
			pos++;
		}
		return -1;
	}
}
