package dataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelDatadriven {
	
	public ArrayList<String> getData(String testcaseName) throws IOException {
		ArrayList<String>list=new ArrayList<String>();
		FileInputStream fis = new FileInputStream("C:\\Users\\Public\\Java Projects\\dataDriven\\ajayFile.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int totalSheets = workbook.getNumberOfSheets();

		for (int i = 0; i < totalSheets; i++) {
			if (workbook.getSheetName(i).equals("testdata")) {
				// identify the testcase coulmn by scanning entire row
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator(); // sheet is collection of rows
				Row firstRow = rows.next();

				Iterator<Cell> cells = firstRow.cellIterator();// row is collection of cells
				int k = 0;
				int coulmn = 0;
				while (cells.hasNext()) {
					Cell cellValue = cells.next();

					if (cellValue.getStringCellValue().equalsIgnoreCase("Testcases")) {
						coulmn = k;

					}
					k++;
				}

				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(coulmn).getStringCellValue().equalsIgnoreCase(testcaseName)) {
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							
							Cell c=cv.next();
							if(c.getCellType()==CellType.STRING)
							{
								list.add(c.getStringCellValue());
							}
							else
							{
								
								list.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
							
						}
					}

				}
				
			}
			
		}
		return list;
		
	}

	

}
