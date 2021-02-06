package pruebaSelenium;


import org.testng.annotations.Test;

public class DataProviderNetflix {
    @Test(dataProvider = "email", dataProviderClass = DataProviderGenerator.class)
    public void testEmail(String email, String pass){
        System.out.println("Cuenta: "+ email + " Pass: "+ pass);
    }
    @Test(dataProvider = "cuentasNetflix", dataProviderClass = pruebaSelenium.DataProviderGenerator.class)
    public void registro(String email, String pass, boolean validInfo) {

        if (validInfo == true){
            System.out.println(" la informacion es valida!! ");
            System.out.println("Cuenta: "+ email + " Pass: " + pass);
        }else {
            System.out.println("la informacion  es Invalida!! ");
            System.out.println("Cuenta: "+ email + " Pass: " + pass);

        }
    }
}
