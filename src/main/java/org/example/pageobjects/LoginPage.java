package org.example.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public LoginPage enterEmail(String email) {
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);

        return this;
    }

    public LoginPage enter() {
        driver.findElement(By.xpath("//div[@class='FliLIb FmFZVc']")).click();

        return this;
    }

    public LoginPage enterPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);

        return this;
    }

    public HomePage submit() {
        driver.findElement(By.xpath("//div[@class='FliLIb FmFZVc']")).click();

        return new HomePage(driver);
    }

    public boolean isErrorMessageVisible() {
        return driver.findElement(By.xpath("//div[@jsname='B34EJ']//span")).isDisplayed();
    }
}
