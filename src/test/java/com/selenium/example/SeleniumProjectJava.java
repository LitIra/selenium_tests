package com.selenium.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.*;
import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by ili on 12/26/16.
 */
public class SeleniumProjectJava {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/ili/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void byTextTest() {
        driver.get("http://www.seleniumhq.org/");
        driver.findElement(By.linkText("Selenium Projects")).click();
        assertEquals(driver.getCurrentUrl(), "http://www.seleniumhq.org/projects/");
        assertEquals("Selenium Projects",driver.getTitle());
    }


    @Test
    public void byIdTest() {
        driver.get("http://www.seleniumhq.org/");
        driver.findElement(By.id("menu_download")).click();
        assertEquals(driver.getCurrentUrl(), "http://www.seleniumhq.org/download/");
        assertEquals("Downloads",driver.getTitle());
    }


    @Test
    public void byCSSSelectorTest() {
        driver.get("http://www.seleniumhq.org/");
        driver.findElement(By.cssSelector("#menu_documentation>a")).click();
        assertEquals(driver.getCurrentUrl(), "http://www.seleniumhq.org/docs/");
        assertEquals("Selenium Documentation — Selenium Documentation",driver.getTitle());
    }

    @Test
    public void byXPathTest() {
        driver.get("http://www.seleniumhq.org/");
        driver.findElement(By.xpath("html/body/div[3]/div[1]/ul/li[2]/a")).click();
        assertEquals(driver.getCurrentUrl(), "http://www.seleniumhq.org/support/");
        assertEquals("Getting Help",driver.getTitle());
    }

    @Test
    public void byTextMenu() {
        driver.get("http://www.seleniumhq.org/");
        driver.findElement(By.linkText("About")).click();
        assertEquals(driver.getCurrentUrl(), "http://www.seleniumhq.org/about/");
        assertEquals("About Selenium",driver.getTitle());
    }
}

