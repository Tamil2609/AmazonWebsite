package selenium.amazon;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ACheckbox {
    static WebDriver driver;

    public static void main(String[] args) throws IOException
    {
        System.setProperty("webdriver.chrome.driver", "D:\\Browserdrivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");

        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[1]"));
        element2.click();
        List<WebElement> elements = driver.findElements(By.xpath("//span[@class='CheckboxFilter-module__checkboxLabel_21MUk0e7QdlZKH5Xcwap-F']"));
        int count = elements.size();
        System.out.println("count is " + count);
        File path = new File("D:\\test.xlsx") ;
        //  FileInputStream fs = new FileInputStream(path);32
        Workbook wb = new XSSFWorkbook();
        Sheet sheet1 = wb.createSheet("List");
        for (int i = 0; i <= count; i++)
        {
            List<WebElement> element = driver.findElements(By.xpath("//*[@id=\"slot-15\"]/div/div/div[2]/div[2]/span[3]/span/div[2]//div/label/span"));
            WebElement E1 = elements.get(i);
            String s = E1.getText();
            Row row = sheet1.createRow(i);
            Cell cell = row.createCell(0);
            cell.setCellValue(s);
        }
        FileOutputStream fos = new FileOutputStream(path);
        wb.write(fos);

    }
}