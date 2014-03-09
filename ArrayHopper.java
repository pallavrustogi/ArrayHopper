import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/*Program to find the min hop path
 * @author: Pallav Rustogi
 */
public class ArrayHopper
{
	public static void main(String[] args)
	{
		/*Read file from commandline argument*/
		if(args.length<1)
			System.out.println("No file name provided");
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(args[0]));
		} catch (FileNotFoundException e) {
			System.out.println("Error while opening file");
			e.printStackTrace();
		}
		/*Calculate min hop path*/
		minSequenceHop(scanner);
		
		
	}

	private static void minSequenceHop(Scanner scanner) {
		int currentIndex = 0;
		int currentHopRange = 0;
		int nextHopRange = 0;
		/*check if file as a integer value*/
		if(!scanner.hasNextInt())
		{
			System.out.println("failure");
			System.exit(1);
		}
		int nextMaxHopRange = scanner.nextInt();
		int nextHop = 0;
		Boolean flag = true;
		ArrayList<Integer> hopList = new ArrayList<Integer>();
		/*add the first element to hop list*/
		hopList.add(nextHop);
		while(flag)
		{
			nextHop = 0;
			currentHopRange = nextMaxHopRange;
			/*check for the max hop possible in current range*/
			for(int i = currentIndex + 1; i<=currentHopRange; i++)
			{
				if(scanner.hasNextInt())
				{
					nextHopRange = scanner.nextInt() + i;
					/*search for element from which we get max hop*/
					if(nextHopRange > nextMaxHopRange)
					{
						nextMaxHopRange = nextHopRange;
						nextHop = i;
					}
				}
				else
				{
					/*end of hop list, print the hop list*/
					for (int p : hopList)
					{
						System.out.print(Integer.toString(p)+", ");
					}
					System.out.print("out");
					flag = false;
					break;
				}
			}
			if(flag)
			{
				/*Set the next hop range for next iteration and add the hop index to hopList*/
				if(nextMaxHopRange > currentHopRange)
				{
					hopList.add(nextHop);
					currentIndex = currentHopRange;
				}
				/*no valid hop possible*/
				else
				{
					System.out.println("failure");
					flag=false;
				}
			}
		}
	}
}