import org.jsoup.Jsoup;
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

public class PeppinosCrawler {
    private final String baseUrl = "https://www.motogp.com/en/world-standing/1972/500cc/championship-standings";
    public void crawl() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        try {
            driver.get(baseUrl);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement tableElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("table.standings-table__table")));

            // Now, wait for a specific number of rows to be present
            int expectedRowCount = 20; // Adjust this value based on your needs
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("tr.standings-table__body-row"), expectedRowCount));

            //System.out.println(driver.getPageSource());
        } finally {
            String pageSource = driver.getPageSource();
            driver.quit();
            scan(pageSource);
        }
    }

    private void scan(String htmlPage) {
        try {
            Document doc = Jsoup.parse(htmlPage);

            Element standingTable = doc.selectFirst("table.standings-table__table");
            if (standingTable != null) {
                Elements rows = standingTable.select("tr.standings-table__body-row");
                for (Element row : rows) {
                    Element position = row.selectFirst("td.standings-table__body-cell.standings-table__body-cell--pos");
                    Element rider = row.selectFirst("a.standings-table__rider-link");
                    //Element rider = row.selectFirst("td.standings-table__body-cell.standings-table__body-cell--rider .standings-table__rider-name .standings-table__body-cell--full-name span.standings-table__first-name");
                    Element tdPointsElement = row.selectFirst("td.standings-table__body-cell.standings-table__body-cell--points");

                    System.out.println(position.text() + "|" + tdPointsElement.text() + "|" + rider.text());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
