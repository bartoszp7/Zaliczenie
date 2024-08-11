package com.course.selenium.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Helpers {
    public static WebElement waitForElementVisible(WebDriver driver, By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return  wait.ignoring(StaleElementReferenceException.class)
                .until(visibilityOfElementLocated(locator));
    }

    public static void waitForPageLoaded(WebDriver driver, By locator, String url){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.ignoring(StaleElementReferenceException.class)
                .until(
                        and(
                                visibilityOfElementLocated(locator)
                                ,urlContains(url)
                        )
                );
    }
}
