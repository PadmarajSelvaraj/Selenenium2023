package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class readExcel {
	
	@DataProvider(name = "exceldata")
	public Iterator<Object[]> getexceldata() {
		
		List<Map<String, String>> datavalue = readExcelData();
		
		List<Object[]> maplist = new ArrayList<>();
		for (Map<String, String> map : datavalue) {
		
			maplist.add(new Object[] {map});
		}
		
		return maplist.iterator();
	}
	
    
	public  List<Map<String, String>> readExcelData() {
        // Path to your Excel file
        String excelFilePath = System.getProperty("user.dir")+"\\src\\main\\resources\\customerDetails.xlsx";
        List<Map <String,String>> testdatlist = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(excelFilePath);
             
        	Workbook workbook = new XSSFWorkbook(fis)) {      
        	Sheet sheet = workbook.getSheetAt(0);
      	    int headerrow = sheet.getFirstRowNum();
        	Row headerRow  = sheet.getRow(headerrow);
        	
            int Lastrow = sheet.getLastRowNum();
        	for(int j=1; j<=Lastrow;j++) {
        		Map <String,String> data = new HashMap<>();
        	for(int i = 0;i < headerRow .getLastCellNum();i++) {
        		
        		String key =	headerRow .getCell(i).getStringCellValue();
        		String value =	sheet.getRow(j).getCell(i).getStringCellValue();
        	 	data.put(key, value);
        		}
        		
        		testdatlist.add(data);
        	}
        	
           
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return testdatlist;
    }
}
