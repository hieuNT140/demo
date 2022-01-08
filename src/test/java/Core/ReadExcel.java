package Core;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcel {
    static Workbook book;
    static Sheet sheet;
    //public static String path = "D:\\TuHoc_Selenium\\src\\test\\resources\\TestLogin.xlsx";


    public static Object[][] getTestData(String path, String sheetName){
        FileInputStream file = null;
        try {
            file = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()] [sheet.getRow(0).getLastCellNum()];

        System.out.println(sheet.getLastRowNum());
        System.out.println(sheet.getRow(1).getLastCellNum());

        for (int i = 0; i < sheet.getLastRowNum(); i++){
            for (int j = 0; j <sheet.getRow(0).getLastCellNum();j++){
                data[i][j] = sheet.getRow(i+1).getCell(j).toString();
            }
        }
        return data;
    }

}
