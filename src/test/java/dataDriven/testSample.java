package dataDriven;

import java.io.IOException;
import java.util.ArrayList;

public class testSample {
	
	public static void main(String[] args) throws IOException
	{
		excelDatadriven d=new excelDatadriven();
		
		ArrayList<String>p=d.getData("Purchase");
		System.out.println(p.get(0));
		System.out.println(p.get(1));
		System.out.println(p.get(2));
		
	}

}
