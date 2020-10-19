import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import utilities.Utilities;

public class Runner {



    @Test
    public void testForQaAutomationPositionUnderCareer() throws InterruptedException {

        Utilities.initializeChromeDriver("https://www.osedea.com/en/careers");
        Thread.sleep(1500);
        Boolean qaAutomationEngineer=Utilities.isPresent(By.xpath("//*[@id=\"content\"]/section[3]/div[1]/a[6]"));
        Assert.assertTrue(qaAutomationEngineer,"QA Automation engineer role is visible under careers section");
        Reporter.log("QA Automation engineer role is visible under careers section");

    }

    @Test
    public void testContactInfoPage()throws InterruptedException{

        Utilities.initializeChromeDriver("https://www.osedea.com/en/contact");
        Thread.sleep(1500);
        Utilities.setText(By.xpath("//*[@id=\"firstName\"]"),Utilities.generateRandOmName());
        Thread.sleep(1000);
        Utilities.setText(By.xpath("//*[@id=\"lastName\"]"),Utilities.generateRandOmName());
        Thread.sleep(1000);
        Utilities.setText(By.xpath("//*[@id=\"subject\"]"),"Ignore this test case");
        Thread.sleep(1000);
        Utilities.setText(By.xpath("//*[@id=\"email\"]"),Utilities.genearateEmail());
        Thread.sleep(1000);
        Utilities.setText(By.xpath("//*[@id=\"note\"]"),"NOTE : this is tested by Automation suite. Ignore this test case");
        Thread.sleep(1000);
        Utilities.clickElement(By.xpath("//*[@id=\"content\"]/div/form/div/div[6]/button"));
        Thread.sleep(1000);
        Boolean successfullySent= Utilities.isPresent(By.xpath("//*[@id=\"content\"]/div/form/div/div/h3"));
        Assert.assertTrue(successfullySent,"message successfully sent");


    }

}
