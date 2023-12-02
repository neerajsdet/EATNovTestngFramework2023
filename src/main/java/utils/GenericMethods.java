package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GenericMethods {

    public static void pauseExecutionFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void click(WebElement element){
        //wait().visibilty(element).click();

    }

    public void click(By element){
        //wait().visibilty(element).click();

    }
}
