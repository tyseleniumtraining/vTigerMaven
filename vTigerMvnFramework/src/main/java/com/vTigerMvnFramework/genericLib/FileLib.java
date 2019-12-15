package com.vTigerMvnFramework.genericLib;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib 
{
	public Properties prop = null;
	public Cell cd = null;
	
	public String getPropertyKeyValue(String key)
	{
		try 
		{
			FileInputStream ip = new FileInputStream("./src\\test\\resources\\commonData.properties");
			prop = new Properties();
			prop.load(ip);
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
		}
		
		return prop.getProperty(key);
	}
	
	public String getExcelData(String sheetName, int rowNum, int cellNum)
	{
		try 
		{
			FileInputStream ip = new FileInputStream("./src\\com\\vTiger\\Data\\testData.xlsx");
			cd = WorkbookFactory.create(ip).getSheet(sheetName).getRow(rowNum).getCell(cellNum);
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
		}
		return cd.getStringCellValue();
	}
	
}
