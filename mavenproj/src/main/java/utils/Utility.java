package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	private WebDriver driver;
	private FileInputStream file;
	private static  String value;
	private double d;
	public static void captureScreenshot(WebDriver driver ,int testID) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String timestamp=new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new Date());
		File des=new File("C:\\Users\\PRASAD BANDAL\\OneDrive\\Pictures\\Screenshots\\Test" +testID+""  +timestamp+".jpg");
		FileHandler.copy(src, des);
	}
	public static String getID(int RowIndex, int CellIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\PRASAD BANDAL\\OneDrive\\Desktop\\testing\\sample.xlsx");
		Workbook wb=WorkbookFactory.create(file);
		try
		{
			value = wb.getSheet("Sheet1").getRow(RowIndex).getCell(CellIndex).getStringCellValue();
			
		}
		catch(Exception e)
		{
			double d=wb.getSheet("Sheet1").getRow(RowIndex).getCell(CellIndex).getNumericCellValue();
			String s=Double.toString(d);  
			System.out.println(s);
			
				
	}
	
		return value;
	
		
}
}