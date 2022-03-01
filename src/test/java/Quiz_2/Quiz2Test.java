package Quiz_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;


public class Quiz2Test {

    WebDriver Driver;

    private void chromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        if (Driver == null) {
            WebDriverManager.chromedriver().setup();
            Driver = new ChromeDriver(options);
        }
    }

    @Test()
    public void Task_1() {

        chromeDriver();

        Driver.get("https://demoqa.com/progress-bar");

        var start_btn = Driver.findElement(By.id("startStopButton"));
        start_btn.click();

        // return true if status bar is 100%
        Boolean wait_progress_bar = new WebDriverWait(Driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.attributeToBe(By.cssSelector("#progressBar > div"), "aria-valuenow", String.valueOf(100)));
        if (wait_progress_bar){
            System.out.println("100%");
        }else {
            System.out.println("Something went wrong, Please stay calm :)");
        }

    }

    @Test()
    public void Task_2() {
        chromeDriver();

        Driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");

//        choose programming language  ---> ukve archeulia
//        Select choose_lang = new Select(Driver.findElement(By.id("dropdowm-menu-1")));
//        choose_lang.selectByIndex(3);
//
//        var check_lang = Driver.findElement(By.cssSelector("#dropdowm-menu-1"));
//        System.out.println(check_lang.isSelected());

//        select checkboxes
        var checkBoxes = Driver.findElements(By.xpath("//input[@type='checkbox']"));
//        if input is selected continue, else select
        for (var checkBox : checkBoxes){
            if (!checkBox.isSelected()){
                checkBox.click();
            }
        }

//        select radio input
        var radioBtn = Driver.findElement(By.xpath("//input[@value='yellow']"));
        radioBtn.click();

//        check orange value is disabled || enabled
        var dropdown_option = Driver.findElement(By.cssSelector("#fruit-selects > option:nth-child(2)")).isDisplayed();
            if (dropdown_option) {
                System.out.println("Orange is disabled");
            } else {
                System.out.println("Orange is enabled");
            }
    }

    @Test()
    public void Task_3() {
        chromeDriver();

        Driver.get("http://the-internet.herokuapp.com/iframe");

//        don't work, but why ?
//        Driver.switchTo().frame("mce_0_ifr");
//
//        var element = Driver.findElement(By.cssSelector("#tinymce > p"));
//        element.click();
//        element.sendKeys("Here Goes");
//        System.out.println(element);


        Driver.switchTo().defaultContent();

        var alignElement = Driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[1]/div[2]/div/div[4]/button[2]"));
        alignElement.click();

    }

}
