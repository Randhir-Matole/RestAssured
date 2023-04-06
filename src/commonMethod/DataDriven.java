package commonMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public static ArrayList<String> FetchDataExcel(String SheetName, String TestCaseName) throws IOException {
		ArrayList<String> DataArray = new ArrayList<String>();

		// step1 read the fileinput stream object with argument of excel filename and
		// location
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\91986\\Downloads\\Desktop\\Randhir\\java programs\\ApiData.xlsx");

		// step2 create the XSSFWorkbook object to open the excel file
		XSSFWorkbook WBK = new XSSFWorkbook(fis);

		// step3 count number of sheet
		int countOfSheet = WBK.getNumberOfSheets();
		System.out.println("count of sheets: " + countOfSheet);

		for (int i = 0; i < countOfSheet; i++) {
			WBK.getSheetName(i);
			String Sheetname = WBK.getSheetName(i);
			System.out.println(SheetName);

			if (Sheetname.equalsIgnoreCase(SheetName)) {
				System.out.println("Inside first if loop");
				XSSFSheet sheet = WBK.getSheetAt(i);
				Iterator<Row> Rows = sheet.iterator();

				Row startRow = Rows.next();
				Iterator<Cell> cell = startRow.cellIterator();
				int j = 0;
				int testColumn = 0;
				while (cell.hasNext()) {
					Cell cellValue = cell.next();
					if (cellValue.getStringCellValue().equalsIgnoreCase("TestCaseName")) {
						System.out.println("Inside Second if loop");
						testColumn = j;
						System.out.println("column index from which the testcase name is supppose to be fetch is " + j);
					}
					j++;
				}
				while (Rows.hasNext()) {
					Row R = Rows.next();
					if (R.getCell(testColumn).getStringCellValue().equalsIgnoreCase(TestCaseName)) {
						Iterator<Cell> TestData = R.cellIterator();
						while (TestData.hasNext()) {
							String param = TestData.next().getStringCellValue();
							DataArray.add(param);

						}
						System.out.println(DataArray);
					}
				}

			}
		}
		return DataArray;

	}

}
