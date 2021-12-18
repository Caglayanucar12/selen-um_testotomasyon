import org.asynchttpclient.util.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

public class beymentest extends BaseTest {
    @Test
    public void TestSearch(){

        /* Arama çubuğunda 'pantalon' ifadesinin aranması */
        WebElement searchBox = driver.findElement(By.id("searchData"));
        searchBox.click();
        searchBox.sendKeys("pantalon");
        driver.findElement(By.className("searchBtn")).click();
        Alert SearchData = null;
        SearchData.sendKeys(String.valueOf(Keys.ENTER));
        driver.findElement(By.id("moreContentButton")).click();
        JavascriptExecutor js = null;
        js.executeScript("window.scrollTo(0,13354)");
        js.executeScript("window.scrollTo(0,19532)");
        /* Arama son sayfalarında 3. sayfanın açılması ve rastgele bir ürünün açılması */
        driver.findElement(By.xpath(".//*[@class='pagination']/a[2]")).click();
        driver.findElement(By.xpath(".//*[@id='p-369374378']/div[1]/a[2]")).click();

        WebElement price= driver.findElement(By.xpath(".//*[@class='newPrice']/ins[1]"));
        String priceText= price.getText();

        /* Açılan ürün sayfasında ürünün sepete eklenmesi*/
        WebElement quantityBox = driver.findElement(By.id("quantity"));
        quantityBox.click();
        quantityBox.clear();
        quantityBox.sendKeys("1");

        WebElement basketBtn = driver.findElement(By.className("btnAddBasket"));
        ((WebElement) basketBtn).click();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.className("iconBasket")).click();

        /* Ürün sayfasındaki fiyat ile sepetteki fiyatın karşılaştırılması */
        WebElement priceBasket= driver.findElement(By.className("price"));
        String priceText2= priceBasket.getText();
        if(priceText.compareTo(priceText2)>0){

            /* Sepetteki ürün adetinin artırılması */
            WebElement quantityBasket = driver.findElement(By.id("quantity_126686985817"));
            quantityBasket.click();
            quantityBasket.clear();
            quantityBasket.sendKeys("1");
            driver.findElement(By.className("spinnerUp")).click();
        }
        /* Sepetteki ürünlerin boşaltılması */
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.className("removeProd")).click();
    }

}             
