package pruebaSelenium;


import org.testng.annotations.Factory;

public class factoryPruebaNetflix {
    @Factory
    public Object[] factoryPruebaNetflix(){
        return new Object[]{

                new prueba_netflix (),
                new prueba_netflix ()
                };
    }
}
