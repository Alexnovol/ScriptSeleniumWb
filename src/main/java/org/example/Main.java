package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.wildberries.ru/");

        setDelay(10);

        try {

            driver.findElement(By.id("searchInput"))
                    .sendKeys("мобильный телефон");

            setDelay(1);

            driver.findElement(By.id("applySearchBtn"))
                    .click();

            setDelay(5);

            driver.findElement(
                            By.xpath("//div[@class='product-card-list']/descendant::article[1]/div/a"))
                    .click();

            setDelay(10);

            driver.findElement(By.cssSelector("button[aria-label='Добавить в корзину']"))
                    .click();

            setDelay(5);

            driver.findElement(By.cssSelector("a[data-wba-header-name='Cart']"))
                    .click();

            setDelay(5);

            try {
                driver.findElement(By.className("list-item__good"));
            } catch (NoSuchElementException e) {
                throw new AssertionError("Товар не найден в корзине");
            } finally {
                driver.quit();
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    public static void setDelay(int sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}