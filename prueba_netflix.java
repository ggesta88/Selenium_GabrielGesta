package pruebaSelenium;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class prueba_netflix {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.netflix.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test(priority = 0)
    public void validarTituloTest(){
        driver.getTitle();
        System.out.println("el Titulo es: " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Netflix Uruguay: Ve series online, ve películas online");
    }
    @Test(priority = 1)
    public void iniciarSesionPageTest(){

        driver.findElement(By.xpath("//*[@class='authLinks redButton']")).click();
        System.out.println("el Titulo es: " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.netflix.com/uy/login");

        List<WebElement> losH1 = driver.findElements(By.tagName("h1"));
        System.out.println("los H1 son  : " + losH1.size());
        for(WebElement elemento: losH1){
            if(elemento.getText().isEmpty() == false)
                System.out.println("los H1 son " + elemento.getText());
                Assert.assertEquals(elemento.getText(),"Inicia sesión");
        }
        driver.findElement(By.className("fbBtnText"));
        WebElement palabraFacebook = driver.findElement(By.className("fbBtnText"));
        System.out.println("El sitio contiene: " + palabraFacebook.getText());
        Assert.assertTrue(palabraFacebook.getText().contains("Iniciar sesión con Facebook"));// si coloco assertFalse da error porque si esta es frase en el sitio

    }
    @Test(priority = 2)
    public void loginToNetflixErrorTest(){
        driver.findElement(By.xpath("//*[@class='authLinks redButton']")).click();
        driver.findElement(By.name("userLoginId")).sendKeys("XXX");
        driver.findElement(By.name("password")).sendKeys("holamundo");
        driver.findElement(By.className("login-remember-me-label-text")).click();
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        //Aca no entendi cual mensaje debe aparecer porque al poner
        //la direccion XXX no aparece el mensaje de error solicitado
        //WebElement errormsg = driver.findElement(By.xpath())
    }
    @Test(priority = 3)
    public void fakeEmailTest(){
        Faker faker = new Faker();

        String emailAddress = faker.internet().emailAddress();

       driver.findElement(By.xpath("//*[@type='email']")).sendKeys(emailAddress);
       driver.findElement(By.className("cta-btn-txt")).click();

        WebElement palabraSignup = driver.findElement(By.className("fbBtnText"));
        System.out.println("El sitio contiene: " + palabraSignup.getText());
        Assert.assertFalse(palabraSignup.getText().contains("signup"));

    }



    @AfterMethod
    public void cerrarDriver(){
        driver.close();
    }
}
