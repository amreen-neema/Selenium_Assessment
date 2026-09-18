package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public static String getData(
            String sheetName,
            int row,
            int cell) throws Exception {

        FileInputStream fis = new FileInputStream("./src/test/resources/DDT/saucedemo2.xlsx");
             

        Workbook workbook = WorkbookFactory.create(fis);
        DataFormatter formatter = new DataFormatter();

        String data = formatter.formatCellValue(workbook.getSheet(sheetName).getRow(row).getCell(cell));

        workbook.close();
        fis.close();

        return data;
    }
}


