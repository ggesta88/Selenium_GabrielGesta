package Clase3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class testngSpotify { //ejercicio 1
    public WebDriver driver; // variable de la clase, asi lo ven todos los metodos

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
         driver = new ChromeDriver();
        driver.get("https://www.spotify.com");
    }

    @Test//ejercicio 2
    public  void verificarSoptifyTitle(){

        System.out.println("Title -> " + driver.getTitle());
        String title = driver.getTitle();
        Assert.assertEquals(title, "Escuchar es todo - Spotify");
    }
    //ejercicio 3
    @Test // Xpath absoluto ( no es conveniente porque aveces cambia en el sitio)
    public  void  verificarSingup(){
       driver.findElement(By.xpath("/html/body/div[2]/div/header/div/nav/ul/li[5]/a")).click();
       String currentUrl = driver.getCurrentUrl();
       Assert.assertTrue(currentUrl.contains("signup"));
    }
    @Test //Xpath relativo
    public  void  verificarSingup2(){
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/signup/']")).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("signup"));
    }
    @Test //ejercicio 4
    public void invalidEmailTest(){
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/signup/']")).click();
        driver.findElement(By.name("email")).sendKeys("test.com");
        driver.findElement(By.id("confirm")).sendKeys("test.com");
        WebElement emailErrorMsg = driver.findElement(By.xpath("//*[contains(text(),'Este correo electrónico no es válido.')]"));
        System.out.println("este es el error " + emailErrorMsg.getText());
        Assert.assertEquals(emailErrorMsg.getText(),"Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com");
        //ejemplo de ASSERT
        Assert.assertTrue(emailErrorMsg.getText().contains("ejemplo@email.com"));

    }
    @Test
    public void validateExistingEmail() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/signup/']")).click();
        driver.findElement(By.name("email")).sendKeys("test@test.com");
        driver.findElement(By.id("confirm")).sendKeys("test@test.com");

        Thread.sleep(3000);
        WebElement emailErrorMsg = driver.findElement(By.xpath("//*[contains(text(),'Este correo electrónico ya')]"));
        System.out.println("este es el error: =>" + emailErrorMsg.getText());

        Assert.assertEquals(emailErrorMsg.getText(), "Este correo electrónico ya está conectado a una cuenta. Inicia sesión.");

    }

    @AfterMethod
    public  void cerrarDriver(){
        //driver.close();

    }
}
