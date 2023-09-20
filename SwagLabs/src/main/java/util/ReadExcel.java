package util;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static String[][] readData(String sheets) throws IOException {
		//set path
		XSSFWorkbook wbook = new XSSFWorkbook("Data/SwagLab.xlsx");
		//get sheet with index
		XSSFSheet wsheet = wbook.getSheet(sheets);
		//get row count
		int lastRowCount = wsheet.getLastRowNum();
		//get column count
		short lastColumnCount = wsheet.getRow(0).getLastCellNum();
		//pass data
		String [][] data = new String [lastRowCount][lastColumnCount];
		//To get entire value of wbook
		for (int i = 1; i <= lastRowCount; i++) {
			//to get all row
			XSSFRow row = wsheet.getRow(i);
			
			for (int j = 0; j < lastColumnCount; j++) {
				//to get all column
				XSSFCell cell = row.getCell(j);
				//read data
				data[i-1][j]=cell.getStringCellValue();			
				//print _ read data
				System.out.println(cell);
			}
		}

		//close wbook
		wbook.close();
		return data;

	}

}
