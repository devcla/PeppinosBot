import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class WebCrawler {
    /*
    String baseUrl = "https://www.motogp.com/en/world-standing/";
    public void scan() {
        for (int year = 1949; year <= 2023; year++) {

        }
    }
     */
    private final String baseUrl = "https://www.motogp.com/en/world-standing/1972/500cc/championship-standings";
    public void scan() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        try {
            driver.get(baseUrl);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table.standings-table__table")));

            System.out.println(driver.getPageSource());
        } finally {
            driver.quit();
        }



        /*try {
            Document doc = Jsoup.connect(baseUrl).get();
            System.out.println(doc.outerHtml());

            Element standingTable = doc.selectFirst("table.standings-table__table");
            if (standingTable != null) {
                Elements rows = standingTable.select("tr.standings-table__body-row");
                for (Element row : rows) {
                    Element position = row.selectFirst("td.standings-table__body-cell standings-table__body-cell--pos");
                    Element rider = row.selectFirst("span.standings-table__first-name");
                    Element points = row.selectFirst("td.standings-table__body-cell standings-table__body-cell--points");

                    System.out.println(position.text() + "|" + rider.text() + "|" + points.text());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
