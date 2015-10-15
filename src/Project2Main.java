import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class Project2Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
		System.setOut(out);
		String line = null;
		ThreeLists outputLists = new ThreeLists();
		while((line = br.readLine()) != null)
		{
			String str[] = line.split(" ");
			switch(str[0])
			{
			case "A": int t = Integer.parseInt(str[1]);
					Type<Integer> x = new Type<Integer>(t);
					outputLists.add(x);
					break;
			case "C": int u = Integer.parseInt(str[1]);
					Type<Integer> y = new Type<Integer>(u);
					outputLists.cancel(y);
					break;
			case "P": outputLists.print();
					break;
			case "R": outputLists.remove();
					break;
			}
		}
	}

}
