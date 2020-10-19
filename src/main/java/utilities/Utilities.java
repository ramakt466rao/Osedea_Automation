package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;


public class Utilities {

    static WebDriver driver=null;

    public static String generateRandOmName(){
        String result="";
        Random random=new Random();
        for(int i=0;i<7;i++){
            result=result+(char) ('A'+random.nextInt(25));

        }
        return result;
    }

    public static String genearateEmail(){
        StringBuffer email=new StringBuffer();
        email.append("test");
        email.append(generateRandOmName());
        email.append("@test.com");
        return email.toString();
    }

    public static void initializeChromeDriver(String url) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver=new ChromeDriver();
        Thread.sleep(1000);
        driver.get(url);
    }

    public static void  initializeIE(){
        System.setProperty("webdriver.IE.driver", "");
        driver=new ChromeDriver();

    }


    public static void closeDriver(){
        driver.close();
    }

    public static void quitDriver(){
        driver.quit();
    }


    public static void clickElement(By xpath){
        if(isPresent(xpath)==true) {
            WebElement element = driver.findElement(xpath);
            element.click();
        }
    }

    public static void setText(By xpath, String key){
        if(isPresent(xpath)==true) {
            WebElement element = driver.findElement(xpath);
            element.sendKeys(new CharSequence[]{key});
        }
    }

    public static void setTextAndGo(By xpath, String key){
        if(isPresent(xpath)==true) {
            WebElement element = driver.findElement(xpath);
            element.sendKeys(new CharSequence[]{key});
            element.submit();
        }
    }

    public static String getText(By xpath){
        if(isPresent(xpath)==true) {
            WebElement element = driver.findElement(xpath);
            String text = element.getText();
            return text;
        }
        return "";
    }

    public static Boolean isPresent(By xpath){
        try{
            WebElement element = driver.findElement(xpath);
            return element.isDisplayed();
        }catch(Exception var){
            System.out.println("error in finding element"+var);
            return false;
        }
    }

    public static List<WebElement> getElementsList(By xpath){
        List<WebElement> elementsList =  driver.findElements(xpath);
        return elementsList;
    }

    @Test
    public void run() throws InterruptedException {

        initializeChromeDriver("https://www.castlehalldiligence.com/");
        Thread.sleep(1000);
    }

}
