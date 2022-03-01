package Quiz_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.net.MalformedURLException;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementsTest {

    @Test
    public void openTab() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        var el = driver.findElement(By.xpath("//*[@id=\"content\"]/div/button"));
//        click button 3 times
        for (int i=0; i<3; i++){
            el.click();
        }

        var lastEl = driver.findElement(By.xpath("//*[@id=\"elements\"]/button[3]"));

        System.out.println(lastEl.getText());

        var elList = driver.findElements(By.cssSelector("[class^=added]"));
        var lastElTxt = elList.get(2).getText();

        System.out.println(lastElTxt);

        Thread.sleep(1000);

        driver.navigate().to("http://the-internet.herokuapp.com/challenging_dom");

        var loremVal1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/table/tbody/tr[10]/td[2]"));

        System.out.println(loremVal1.getText());

        var loremVal2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/table/tbody/tr[10]/td[2]/following::td"));

        System.out.println(loremVal2.getText());


        driver.quit();

    }

}
