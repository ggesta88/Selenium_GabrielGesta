package pruebaSelenium;


import org.testng.annotations.DataProvider;


public class DataProviderGenerator {

        @DataProvider(name ="email" )
            public Object[][]cargarEmail(){
            return new Object[][]{
                    {"test1@test.com","holamundo"},
                    {"test2@test.com","holamundo123"},
                    {"test3@test.com","holamundo456"},
            };
        }
    public Object[][] email() {
        return new Object[][]{
                {"test1@test.com","holamundo"},
                {"test2@test.com","holamundo123"},
                {"test3@test.com","holamundo456"},

        };


    }
}
