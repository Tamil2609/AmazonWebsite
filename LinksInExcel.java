package selenium.amazon;
import java.io.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LinksInExcel
{

    public static void main(String[] args) throws IOException
    {
        System.setProperty("webdriver.chrome.driver", "D:\\Browserdrivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com/");
        List<WebElement> list = driver.findElements(By.tagName("a"));
        System.out.println("Total tags are:" + list.size());
            File path = new File("D:\\new.xlsx") ;
          //  FileInputStream fs = new FileInputStream(path);32
            Workbook wb = new XSSFWorkbook();
            Sheet sheet1 = wb.createSheet("Link");


                for (int i = 0; i < list.size(); i++)
                {
                    WebElement E1 = list.get(i);
                    String url = E1.getAttribute("href");
                    Row row = sheet1.createRow(i);
                    Cell cell = row.createCell(0);
                    cell.setCellValue(url);
                }

            FileOutputStream fos = new FileOutputStream(path);
            wb.write(fos);
            //fos.close();

    }
}