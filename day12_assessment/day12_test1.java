package day12assessment;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.MyInfoPage;
import Pages.RecurimentPage;
import Pages.Vacancy;
import Pages.loginPage;
import base.BaseTest;
import junit.framework.Assert;

public class day12_test1 extends BaseTest {
	
	@DataProvider
	public Object[][] excel() throws EncryptedDocumentException, IOException {
	FileInputStream ex = new FileInputStream("./src/test/resources/DDT/Vacency.xlsx");
	Workbook wb = WorkbookFactory.create(ex);
	Sheet sh = wb.getSheet("Sheet1");
	int rc = sh.getLastRowNum();
	int cc = sh.getRow(0).getLastCellNum();
	Object[][] obj = new Object[rc][cc];
	for (int r = 1 ; r<=rc;r++) {
		for(int c=0; c<cc;c++) {
			obj[r-1][c]=sh.getRow(r).getCell(c).getStringCellValue();
		}
		
	}
	return obj;
	}
	
	@Test(dataProvider = "excel")
	public void Base(String Vname,String Desc,String HireMa) throws IOException, AWTException, InterruptedException {
		FileInputStream fil = new FileInputStream("./src/test/resources/DDT/config.properties");
		Properties p = new Properties();
		p.load(fil);
		 String browser = p.getProperty("browser");
		 String url = p.getProperty("url");
		 String uname = p.getProperty("username");
		 String pass = p.getProperty("password");
		 
		//Pom Login -----------------------------------
		loginPage p1 = new loginPage(driver);
		p1.getUname(uname);
		p1.getPass(pass);
		p1.getLogin();
		
		Thread.sleep(3000);
		//click on vacancie buttom
		RecurimentPage p2 = new RecurimentPage(driver);
		p2.getRbutton();
		p2.getVacy();
		p2.getAdd();
		
		
		Thread.sleep(3000);
		//fill vacancy
		Vacancy p3 = new Vacancy(driver);
		p3.getVname(Vname);
		p3.getJtite();
		p3.getDesc(Desc);
		p3.getHireM(HireMa);
		p3.getPos("50");
		p3.getsave();
		
		Thread.sleep(5000);
		MyInfoPage p4 = new MyInfoPage(driver);
		p4.getProfile();
	    Thread.sleep(3000);
	    p4.getLout();
		
		
	}
	
	@DataProvider
	public Object[][] myinfo() throws EncryptedDocumentException, IOException {
		FileInputStream fil = new FileInputStream("./src/test/resources/DDT/myinfo.xlsx");
		Workbook wb = WorkbookFactory.create(fil);
		Sheet sh = wb.getSheet("Sheet1");
		int rc = sh.getLastRowNum();
		 int cc = sh.getRow(0).getLastCellNum();
		 Object[][] obj = new Object[rc][cc];
		 for(int row=1;row<=rc;row++) {
			 for(int c=0;c<cc;c++) {
				 obj[rc-1][c]=sh.getRow(row).getCell(c).getStringCellValue();
			 }
		 }
		 return obj;
	}
	
	@Test(dataProvider = "myinfo")
	public void testcase2(String Fname,String Mname,String Lname,String EMpid) throws IOException, InterruptedException {
		
		FileInputStream f = new FileInputStream("./src/test/resources/DDT/config.properties");
		Properties p = new Properties();
		p.load(f);
		 String browser = p.getProperty("browser");
		 String url = p.getProperty("url");
		 String uname = p.getProperty("username");
		 String pass = p.getProperty("password");
		 
		//Pom Login -----------------------------------
		loginPage p1 = new loginPage(driver);
		p1.getUname(uname);
		p1.getPass(pass);
		p1.getLogin();
		
		//click on myinfo
		MyInfo p2 = new MyInfo(driver);
		p2.getMyinfo();
		
		//change first ,middle,last NAME AND emp Id
		
		MyInfoPage p3 = new MyInfoPage(driver);
		p3.getFname(Fname);
		p3.getMname(Mname);
		p3.getLname(Lname);
		p3.getEmpId(EMpid);
		Thread.sleep(3000);
		p3.getSave();
		Thread.sleep(2000);
		p3.getProfile();
		Thread.sleep(3000);
		p3.getLout();
		
		//Login again
		
		p1.getUname(uname);
		p1.getPass(pass);
		p1.getLogin();
		
		//click my info
		p2.getMyinfo();
		
		//verification
        Thread.sleep(5000);
		Assert.assertEquals(p3.verifyFname(), Fname);
		Assert.assertEquals(p3.verifyMname(), Mname);
		Assert.assertEquals(p3.verifyLname(), Lname);
		Assert.assertEquals(p3.verifyEmpId(), EMpid);
		System.out.println("✔️🤗✔️");
		System.out.println("Verifed succesfully 😀😀 My data is updated");
		System.out.println("✔️🤗✔️");
	
		
		
	}

}
