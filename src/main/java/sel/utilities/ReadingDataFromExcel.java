package sel.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {

	public static void main(String args[]) throws IOException  {
		
		
		try{
			
			File file = new File("testData/interest_rate_data.xlsx");
			
			FileInputStream fileStream= new FileInputStream(file);
			
			XSSFWorkbook workBook = new XSSFWorkbook(fileStream);
			XSSFSheet sheet = workBook.getSheet("sheet1");
			
			int rowCount = sheet.getLastRowNum();
			 int colCount = sheet.getRow(0).getLastCellNum();
			 
//			 System.out.print("Row count " + rowCount);
			 
			 for( int i =0; i < rowCount; i++) {
				 
				 XSSFRow row = sheet.getRow(i);
				 
				 if( row == null)
					 break;
				 
				 for( int j=0; j < row.getLastCellNum(); j++) {
					 System.out.print(row.getCell(j) + " ");
				 }
				 System.out.println();
				
			 }
			
		}
	catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}

