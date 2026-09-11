package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources", // Ozellik dosyalarinizin yolu
        glue = "stepDefinitions", // Adim tanimlari ve Hooks class'inin oldugu paketimiz
        tags = "@Test", // Calistirilacak testlerin etiketleri
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"},
        monochrome = true

)
public class Runner extends AbstractTestNGCucumberTests {
    // Burada herhangi bir ozel kod bulunmasina gerek yok
}
