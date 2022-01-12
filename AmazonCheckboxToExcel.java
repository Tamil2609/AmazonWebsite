package selenium.amazon;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.time.Duration;
import java.util.List;

public class AmazonCheckboxToExcel
    {
        static WebDriver driver;
        public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "D:\\Browserdrivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get("https://www.amazon.com/gp/goldbox?ref_=nav_cs_gb");
            List<WebElement> list = driver.findElements(By.tagName("a"));
            //System.out.println("Total tags are:" + lisT.size());
            File path = new File("D:\\Checkbox.xlsx") ;
        //  FileInputStream fs = new FileInputStream(path);32
            Workbook wb = new XSSFWorkbook();
             Sheet sheet1 = wb.createSheet("List");

        }
        public void verifyElement()
        {
            List<WebElement> deparments = driver.findElements(By.xpath("//span[@class='CheckboxFilter-module__checkboxLabel_21MUk0e7QdlZKH5Xcwap-F'][contains(text(),'')]"));
            int length = deparments.size();
            int temp = 0;
            String[] data = new String[length];
            // data[0]="prasanna";

            for (WebElement element : deparments)
            {
                data[temp] = element.getText();
                //System.out.println(data[temp]);
                temp++;

            }

            for (int index = 0; index < length; index++)
            {
                try
                {
                    String input = driver.findElement(By.xpath("//span[@class='CheckboxFilter-module__checkboxLabel_21MUk0e7QdlZKH5Xcwap-F'][starts-with(text(),\"" + data[index] + "\")]")).getText();
                    // System.out.println(input);

                    if (data[index].equals(input))
                    {
                        System.out.println(data[index] + " Present in the web page");
                    }
                } catch (NoSuchElementException exception)
                {
                    System.out.println(data[index] + " Not present in the web page");
                }
            }
        }
        public void close(){
            driver.quit();
        }
    }

