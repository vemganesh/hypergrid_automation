package com.hyperGrid.seleniumExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchToTabOrWindow {

    WebDriver driver;

    @Test
    public void isElementSelected3(){
        driver = new ChromeDriver();
        driver.get("https://cogmento.com/en");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String parentWindow = driver.getWindowHandle();

        System.out.println(parentWindow);
        System.out.println("*************************************");
        driver.findElement(By.xpath("//a[text()='Login']")).click();

        Set<String> allWindows = driver.getWindowHandles();

        for (String tab: allWindows){
            System.out.println(tab);
            driver.switchTo().window(tab);
        }

        driver.findElement(By.name("email")).sendKeys("siva@yopmail.com");
        driver.close();
        driver.switchTo().window(parentWindow);
        System.out.println();
    }

    @Test
    public void isElementSelected4() {
        driver = new ChromeDriver();
        driver.get("https://cogmento.com/en");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String parentWindow = driver.getWindowHandle();

        System.out.println(parentWindow);
        System.out.println("*************************************");
        WebElement loginButton = driver.findElement(By.xpath("//a[text()='Login']"));
        jse.executeScript("arguments[0].setAttribute('target','_self')", loginButton);

        loginButton.click();
    }
    }
