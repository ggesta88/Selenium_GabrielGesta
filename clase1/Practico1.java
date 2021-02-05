package clase1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;


public class Practico1 {

    public WebDriver getDriver(String URL){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        return driver;
    }
    @Test
    public void ejercicio1y2(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

        System.out.println("El titulo del sitio es: " + driver.getTitle());
        System.out.println("La Url del sitio es " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"Facebook - Inicia sesión o regístrate");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");

    }
    @Test//ejercicio 4
    public void bbcMundoLinks(){
        WebDriver driver = getDriver("https://www.bbc.com/mundo");
        System.out.println("Mostrar todos los links ");
        List<WebElement> todosLosLinks = driver.findElements(By.tagName("a"));

        System.out.println("existen: " + todosLosLinks.size() + " links.");
        for(WebElement element : todosLosLinks){
            if(element.getText().isEmpty() == false)
                System.out.println("Links " +element.getText());
        }

    }
    @Test //ejercicio 5
    public void bbcMundoListas(){
        WebDriver driver = getDriver("https://www.bbc.com/mundo");
        System.out.println("Se mostraran las Listas y su contenido. ");
        List<WebElement> listasBBC = driver.findElements(By.tagName("li"));
        System.out.println("exiten " + listasBBC.size() + " listas.");
        for(WebElement element : listasBBC) {
            if(element.getText().isEmpty() == false)
                System.out.println("listas " + element.getText());
        }
    }
    @Test // ejercicio 6
    public void spotifyTitleTest(){
        WebDriver driver = getDriver("https://www.spotify.com");
        String tituloSpotify = driver.getTitle();
        System.out.println("el titulo es: " + tituloSpotify);

        if(tituloSpotify.equals("Escuchar es todo - Spotify"))
        {
            System.out.println("Test Passed");
        } else
        {
            System.out.println("Test failed");
        }
    }
    @Test //ejercicio7
    public void getWindowsSizeTest(){
        WebDriver driver = getDriver("https://www.google.com");

        int altura =  driver.manage().window().getSize().height;
        int ancho = driver.manage().window().getSize().width;
        System.out.println("la altura es: " + altura);
        System.out.println("El ancho es: " + ancho);

        Dimension dimension = new Dimension(1024,768);
        driver.manage().window().setSize(dimension);

        System.out.println("***** Nuevas medidas *****");

        int altura2 = driver.manage().window().getSize().height;
        int ancho2 = driver.manage().window().getSize().width;

        System.out.println("La nueva altura es: " + altura2);
        System.out.println("el nuevo ancho es: " + ancho2);

    }
    @Test //ejercicio8
    public WebDriver getGoogleDriver(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        return driver;

    }
    @Test //ejercicio9
    public WebDriver getDriver2(String URL){

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        return driver;
    }
    @Test //ejercicio10
    public void searchInGoogle(){
        WebDriver driver =  getGoogleDriver();
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("WebElement" + Keys.ENTER);

    }
    @Test //ejercicio11
    public void searchInGoogleAndGoBack(){
        WebDriver driver = getGoogleDriver();
        driver.get("https://www.google.com");
        System.out.println("El titulo es: " + driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("selenium driver" + Keys.ENTER);
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
    }
}
