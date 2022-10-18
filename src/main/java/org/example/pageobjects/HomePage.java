package org.example.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    protected WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getGreetings() {
        return driver.findElement(By.xpath("//h1[@class='XY0ASe']")).getText();
    }
}
