import java.util.ArrayList;
import java.io.*;


public class lab13 
{
	public ArrayList<Integer> arrList = new ArrayList<>();
	
	public void readData(String filename)
	{
		try
		{
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			String line;
			while((line = input.readLine()) != null)
			{
				arrList.add(Integer.valueOf(line.trim()));
			}
			input.close();
		}
		catch(Exception e)
		{
			System.out.println("An Exception Has Occurred");
		}
		
	}
	
	public long getTotalCount()
	{
		return arrList.stream().count();
	}

	public long getOddCount()
	{
		return arrList.stream().filter(x -> x % 2 != 0).count();
	}
	
	public long getEvenCount()
	{
		return arrList.stream().filter(x -> (x % 2) == 0).count();
	}
	
	public long getDistinctGreaterThanFiveCount()
	{
		return arrList.stream().filter(x -> x > 5).distinct().count();
	}
	
	public Integer[] getResult1()
	{
		return arrList.stream().filter(x -> (x % 2) == 0).filter(x -> x > 5).filter(x -> x < 50).sorted().toArray(Integer[]::new);
	}
	
	public Integer[] getResult2()
	{
		return arrList.stream().limit(50).map(x -> (x*x)*3).toArray(Integer[]::new);
	}
	
	public Integer[] getResult3()
	{
		return arrList.stream().filter(x -> x % 2 != 0).map(x -> x*2).sorted().skip(20).distinct().toArray(Integer[]::new);
	}

}
