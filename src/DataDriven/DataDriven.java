package DataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public static void main(String[] args) throws IOException {
		ArrayList<String> DataArray = new ArrayList<String>();

		// step1 read the file input stream object with argument of excel filename and
		// location
		FileInputStream fis = new FileInputStream("C:\\Users\\91986\\OneDrive\\Desktop\\java programs\\ApiData.xlsx");

		// step2 create the XSSFWorkBook object to open the excel file
		XSSFWorkbook wbk = new XSSFWorkbook(fis);

		// step3 count no of sheets
		int countOfSheets = wbk.getNumberOfSheets();
		System.out.println("Count Of Sheets:" + countOfSheets);

		for (int i = 0; i < countOfSheets; i++) {
			wbk.getSheetName(i);
			String Sheetname = wbk.getSheetName(i);
			System.out.println(Sheetname);

			if (Sheetname.equalsIgnoreCase("PostAPI")) {
				System.out.println("Inside first if loop");
				XSSFSheet sheet = wbk.getSheetAt(i);
				Iterator<Row> Rows = sheet.iterator();
				// Row row=rows.next();
				Row StartRow = Rows.next();
				Iterator<Cell> Cell = StartRow.cellIterator();
				int j = 0;
				int testColumn = 0;
				while (Cell.hasNext()) {
					Cell Cellvalue = Cell.next();
					if (Cellvalue.getStringCellValue().equalsIgnoreCase("TestCaseName")) {
						System.out.println("Inside second if loop");
						testColumn = j;
						System.out.println("Column index from which the testcase name is suppose to be fetch is " + j);
					}
					j++;
				}
				while (Rows.hasNext()) {
					Row R = Rows.next();
					if (R.getCell(testColumn).getStringCellValue().equalsIgnoreCase("TC1")) {
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
	}
}
