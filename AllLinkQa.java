package selenium.amazon;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AllLinkQa {
   static WebDriver driver;
    public void ConfirmDialogueBox() {
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        Alert al = driver.switchTo().alert();
        al.accept();
    }
    public void CancelDialogueBox() {
        driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
       Alert al = driver.switchTo().alert();
       al.dismiss();
   }

        public static void main(String[] args) throws NoSuchElementException
        {
        System.setProperty("webdriver.chrome.driver", "D:\\Browserdrivers\\chromedriver.exe");
         driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/alerts");
        AllLinkQa Qa=new AllLinkQa();
        Qa.ConfirmDialogueBox();
        Qa.CancelDialogueBox();
        //Storing the links in a list and traversing through the links
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // This line will print the number of links and the count of links.
        System.out.println("No of links are " + links.size());
        for (int i = 0; i < links.size(); i++) {
            System.out.println(links.get(i).getAttribute("href"));
            System.out.println(links.get(i).getText());
        }
        for (int i = 0; i < links.size(); i++) {
            WebElement E1 = links.get(i);
            String url = E1.getAttribute("href");
        }

        }



    }






