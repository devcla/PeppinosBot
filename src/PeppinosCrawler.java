import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PeppinosCrawler implements Runnable{
    private Map<String, String> urls;
    public PeppinosCrawler() {
        urls = new HashMap<>();
        //1949
        urls.put("1949C125cc", "https://www.motogp.com/en/world-standing/1949/125cc/championship-standings");
        urls.put("1949C250cc", "https://www.motogp.com/en/world-standing/1949/250cc/championship-standings");
        urls.put("1949C350cc", "https://www.motogp.com/en/world-standing/1949/350cc/championship-standings");
        urls.put("1949C500cc", "https://www.motogp.com/en/world-standing/1949/500cc/championship-standings");
        //1950
        urls.put("1950C125cc", "https://www.motogp.com/en/world-standing/1950/125cc/championship-standings");
        urls.put("1950C250cc", "https://www.motogp.com/en/world-standing/1950/250cc/championship-standings");
        urls.put("1950C350cc", "https://www.motogp.com/en/world-standing/1950/350cc/championship-standings");
        urls.put("1950C500cc", "https://www.motogp.com/en/world-standing/1950/500cc/championship-standings");
        //1951
        urls.put("1951C125cc", "https://www.motogp.com/en/world-standing/1951/125cc/championship-standings");
        urls.put("1951C250cc", "https://www.motogp.com/en/world-standing/1951/250cc/championship-standings");
        urls.put("1951C350cc", "https://www.motogp.com/en/world-standing/1951/350cc/championship-standings");
        urls.put("1951C500cc", "https://www.motogp.com/en/world-standing/1951/500cc/championship-standings");
        //1952
        urls.put("19452C125cc", "https://www.motogp.com/en/world-standing/1952/125cc/championship-standings");
        urls.put("1952C250cc", "https://www.motogp.com/en/world-standing/1952/250cc/championship-standings");
        urls.put("1952C350cc", "https://www.motogp.com/en/world-standing/1952/350cc/championship-standings");
        urls.put("1952C500cc", "https://www.motogp.com/en/world-standing/1952/500cc/championship-standings");
        //1953
        urls.put("1953C125cc", "https://www.motogp.com/en/world-standing/1953/125cc/championship-standings");
        urls.put("1953C250cc", "https://www.motogp.com/en/world-standing/1953/250cc/championship-standings");
        urls.put("1953C350cc", "https://www.motogp.com/en/world-standing/1953/350cc/championship-standings");
        urls.put("1953C500cc", "https://www.motogp.com/en/world-standing/1953/500cc/championship-standings");
        //1954
        urls.put("1954C125cc", "https://www.motogp.com/en/world-standing/1954/125cc/championship-standings");
        urls.put("1954C250cc", "https://www.motogp.com/en/world-standing/1954/250cc/championship-standings");
        urls.put("1954C350cc", "https://www.motogp.com/en/world-standing/1954/350cc/championship-standings");
        urls.put("1954C500cc", "https://www.motogp.com/en/world-standing/1954/500cc/championship-standings");
        //1955
        urls.put("1955C125cc", "https://www.motogp.com/en/world-standing/1955/125cc/championship-standings");
        urls.put("1955C250cc", "https://www.motogp.com/en/world-standing/1955/250cc/championship-standings");
        urls.put("1955C350cc", "https://www.motogp.com/en/world-standing/1955/350cc/championship-standings");
        urls.put("1955C500cc", "https://www.motogp.com/en/world-standing/1955/500cc/championship-standings");
        //1956
        urls.put("1956C125cc", "https://www.motogp.com/en/world-standing/1956/125cc/championship-standings");
        urls.put("1956C250cc", "https://www.motogp.com/en/world-standing/1956/250cc/championship-standings");
        urls.put("1956C350cc", "https://www.motogp.com/en/world-standing/1956/350cc/championship-standings");
        urls.put("1956C500cc", "https://www.motogp.com/en/world-standing/1956/500cc/championship-standings");
        //1957
        urls.put("1957C125cc", "https://www.motogp.com/en/world-standing/1957/125cc/championship-standings");
        urls.put("1957C250cc", "https://www.motogp.com/en/world-standing/1957/250cc/championship-standings");
        urls.put("1957C350cc", "https://www.motogp.com/en/world-standing/1957/350cc/championship-standings");
        urls.put("1957C500cc", "https://www.motogp.com/en/world-standing/1957/500cc/championship-standings");
        //1958
        urls.put("1958C125cc", "https://www.motogp.com/en/world-standing/1958/125cc/championship-standings");
        urls.put("1958C250cc", "https://www.motogp.com/en/world-standing/1958/250cc/championship-standings");
        urls.put("1958C350cc", "https://www.motogp.com/en/world-standing/1958/350cc/championship-standings");
        urls.put("1958C500cc", "https://www.motogp.com/en/world-standing/1958/500cc/championship-standings");
        //1959
        urls.put("1959C125cc", "https://www.motogp.com/en/world-standing/1959/125cc/championship-standings");
        urls.put("1959C250cc", "https://www.motogp.com/en/world-standing/1959/250cc/championship-standings");
        urls.put("1959C350cc", "https://www.motogp.com/en/world-standing/1959/350cc/championship-standings");
        urls.put("1959C500cc", "https://www.motogp.com/en/world-standing/1959/500cc/championship-standings");
        //1960
        urls.put("1960C125cc", "https://www.motogp.com/en/world-standing/1960/125cc/championship-standings");
        urls.put("1960C250cc", "https://www.motogp.com/en/world-standing/1960/250cc/championship-standings");
        urls.put("1960C350cc", "https://www.motogp.com/en/world-standing/1960/350cc/championship-standings");
        urls.put("1960C500cc", "https://www.motogp.com/en/world-standing/1960/500cc/championship-standings");
        //1961
        urls.put("1961C125cc", "https://www.motogp.com/en/world-standing/1961/125cc/championship-standings");
        urls.put("1961C250cc", "https://www.motogp.com/en/world-standing/1961/250cc/championship-standings");
        urls.put("1961C350cc", "https://www.motogp.com/en/world-standing/1961/350cc/championship-standings");
        urls.put("1961C500cc", "https://www.motogp.com/en/world-standing/1961/500cc/championship-standings");
        //1962
        urls.put("1962C50cc", "https://www.motogp.com/en/world-standing/1962/50cc/championship-standings");
        urls.put("1962C125cc", "https://www.motogp.com/en/world-standing/1962/125cc/championship-standings");
        urls.put("1962C250cc", "https://www.motogp.com/en/world-standing/1962/250cc/championship-standings");
        urls.put("1962C350cc", "https://www.motogp.com/en/world-standing/1962/350cc/championship-standings");
        urls.put("1962C500cc", "https://www.motogp.com/en/world-standing/1962/500cc/championship-standings");
        //1963
        urls.put("1963C50cc", "https://www.motogp.com/en/world-standing/1963/50cc/championship-standings");
        urls.put("1963C125cc", "https://www.motogp.com/en/world-standing/1963/125cc/championship-standings");
        urls.put("1963C250cc", "https://www.motogp.com/en/world-standing/1963/250cc/championship-standings");
        urls.put("1963C350cc", "https://www.motogp.com/en/world-standing/1963/350cc/championship-standings");
        urls.put("1963C500cc", "https://www.motogp.com/en/world-standing/1963/500cc/championship-standings");
        //1964
        urls.put("1964C50cc", "https://www.motogp.com/en/world-standing/1964/50cc/championship-standings");
        urls.put("1964C125cc", "https://www.motogp.com/en/world-standing/1964/125cc/championship-standings");
        urls.put("1964C250cc", "https://www.motogp.com/en/world-standing/1964/250cc/championship-standings");
        urls.put("1964C350cc", "https://www.motogp.com/en/world-standing/1964/350cc/championship-standings");
        urls.put("1964C500cc", "https://www.motogp.com/en/world-standing/1964/500cc/championship-standings");
        //1965
        urls.put("1965C50cc", "https://www.motogp.com/en/world-standing/1965/50cc/championship-standings");
        urls.put("1965C125cc", "https://www.motogp.com/en/world-standing/1965/125cc/championship-standings");
        urls.put("1965C250cc", "https://www.motogp.com/en/world-standing/1965/250cc/championship-standings");
        urls.put("1965C350cc", "https://www.motogp.com/en/world-standing/1965/350cc/championship-standings");
        urls.put("1965C500cc", "https://www.motogp.com/en/world-standing/1965/500cc/championship-standings");
        //1966
        urls.put("1966C50cc", "https://www.motogp.com/en/world-standing/1966/50cc/championship-standings");
        urls.put("1966C125cc", "https://www.motogp.com/en/world-standing/1966/125cc/championship-standings");
        urls.put("1966C250cc", "https://www.motogp.com/en/world-standing/1966/250cc/championship-standings");
        urls.put("1966C350cc", "https://www.motogp.com/en/world-standing/1966/350cc/championship-standings");
        urls.put("1966C500cc", "https://www.motogp.com/en/world-standing/1966/500cc/championship-standings");
        //1967
        urls.put("1967C50cc", "https://www.motogp.com/en/world-standing/1967/50cc/championship-standings");
        urls.put("1967C125cc", "https://www.motogp.com/en/world-standing/1967/125cc/championship-standings");
        urls.put("1967C250cc", "https://www.motogp.com/en/world-standing/1967/250cc/championship-standings");
        urls.put("1967C350cc", "https://www.motogp.com/en/world-standing/1967/350cc/championship-standings");
        urls.put("1967C500cc", "https://www.motogp.com/en/world-standing/1967/500cc/championship-standings");
        //1968
        urls.put("1968C50cc", "https://www.motogp.com/en/world-standing/1968/50cc/championship-standings");
        urls.put("1968C125cc", "https://www.motogp.com/en/world-standing/1968/125cc/championship-standings");
        urls.put("1968C250cc", "https://www.motogp.com/en/world-standing/1968/250cc/championship-standings");
        urls.put("1968C350cc", "https://www.motogp.com/en/world-standing/1968/350cc/championship-standings");
        urls.put("1968C500cc", "https://www.motogp.com/en/world-standing/1968/500cc/championship-standings");
        //1969
        urls.put("1969C50cc", "https://www.motogp.com/en/world-standing/1969/50cc/championship-standings");
        urls.put("1969C125cc", "https://www.motogp.com/en/world-standing/1969/125cc/championship-standings");
        urls.put("1969C250cc", "https://www.motogp.com/en/world-standing/1969/250cc/championship-standings");
        urls.put("1969C350cc", "https://www.motogp.com/en/world-standing/1969/350cc/championship-standings");
        urls.put("1969C500cc", "https://www.motogp.com/en/world-standing/1969/500cc/championship-standings");
        //1970
        urls.put("1970C50cc", "https://www.motogp.com/en/world-standing/1970/50cc/championship-standings");
        urls.put("1970C125cc", "https://www.motogp.com/en/world-standing/1970/125cc/championship-standings");
        urls.put("1970C250cc", "https://www.motogp.com/en/world-standing/1970/250cc/championship-standings");
        urls.put("1970C350cc", "https://www.motogp.com/en/world-standing/1970/350cc/championship-standings");
        urls.put("1970C500cc", "https://www.motogp.com/en/world-standing/1970/500cc/championship-standings");
        //1971
        urls.put("1971C50cc", "https://www.motogp.com/en/world-standing/1971/50cc/championship-standings");
        urls.put("1971C125cc", "https://www.motogp.com/en/world-standing/1971/125cc/championship-standings");
        urls.put("1971C250cc", "https://www.motogp.com/en/world-standing/1971/250cc/championship-standings");
        urls.put("1971C350cc", "https://www.motogp.com/en/world-standing/1971/350cc/championship-standings");
        urls.put("1971C500cc", "https://www.motogp.com/en/world-standing/1971/500cc/championship-standings");
        //1972
        urls.put("1972C50cc", "https://www.motogp.com/en/world-standing/1972/50cc/championship-standings");
        urls.put("1972C125cc", "https://www.motogp.com/en/world-standing/1972/125cc/championship-standings");
        urls.put("1972C250cc", "https://www.motogp.com/en/world-standing/1972/250cc/championship-standings");
        urls.put("1972C350cc", "https://www.motogp.com/en/world-standing/1972/350cc/championship-standings");
        urls.put("1972C500cc", "https://www.motogp.com/en/world-standing/1972/500cc/championship-standings");
        //1973
        urls.put("1973C50cc", "https://www.motogp.com/en/world-standing/1973/50cc/championship-standings");
        urls.put("1973C125cc", "https://www.motogp.com/en/world-standing/1973/125cc/championship-standings");
        urls.put("1973C250cc", "https://www.motogp.com/en/world-standing/1973/250cc/championship-standings");
        urls.put("1973C350cc", "https://www.motogp.com/en/world-standing/1973/350cc/championship-standings");
        urls.put("1973C500cc", "https://www.motogp.com/en/world-standing/1973/500cc/championship-standings");
        //1974
        urls.put("1974C50cc", "https://www.motogp.com/en/world-standing/1974/50cc/championship-standings");
        urls.put("1974C125cc", "https://www.motogp.com/en/world-standing/1974/125cc/championship-standings");
        urls.put("1974C250cc", "https://www.motogp.com/en/world-standing/1974/250cc/championship-standings");
        urls.put("1974C350cc", "https://www.motogp.com/en/world-standing/1974/350cc/championship-standings");
        urls.put("1974C500cc", "https://www.motogp.com/en/world-standing/1974/500cc/championship-standings");
        //1975
        urls.put("1975C50cc", "https://www.motogp.com/en/world-standing/1975/50cc/championship-standings");
        urls.put("1975C125cc", "https://www.motogp.com/en/world-standing/1975/125cc/championship-standings");
        urls.put("1975C250cc", "https://www.motogp.com/en/world-standing/1975/250cc/championship-standings");
        urls.put("1975C350cc", "https://www.motogp.com/en/world-standing/1975/350cc/championship-standings");
        urls.put("1975C500cc", "https://www.motogp.com/en/world-standing/1975/500cc/championship-standings");
        //1976
        urls.put("1976C50cc", "https://www.motogp.com/en/world-standing/1976/50cc/championship-standings");
        urls.put("1976C125cc", "https://www.motogp.com/en/world-standing/1976/125cc/championship-standings");
        urls.put("1976C250cc", "https://www.motogp.com/en/world-standing/1976/250cc/championship-standings");
        urls.put("1976C350cc", "https://www.motogp.com/en/world-standing/1976/350cc/championship-standings");
        urls.put("1976C500cc", "https://www.motogp.com/en/world-standing/1976/500cc/championship-standings");
        //1977
        urls.put("1977C50cc", "https://www.motogp.com/en/world-standing/1977/50cc/championship-standings");
        urls.put("1977C125cc", "https://www.motogp.com/en/world-standing/1977/125cc/championship-standings");
        urls.put("1977C250cc", "https://www.motogp.com/en/world-standing/1977/250cc/championship-standings");
        urls.put("1977C350cc", "https://www.motogp.com/en/world-standing/1977/350cc/championship-standings");
        urls.put("1977C500cc", "https://www.motogp.com/en/world-standing/1977/500cc/championship-standings");
        //1978
        urls.put("1978C50cc", "https://www.motogp.com/en/world-standing/1978/50cc/championship-standings");
        urls.put("1978C125cc", "https://www.motogp.com/en/world-standing/1978/125cc/championship-standings");
        urls.put("1978C250cc", "https://www.motogp.com/en/world-standing/1978/250cc/championship-standings");
        urls.put("1978C350cc", "https://www.motogp.com/en/world-standing/1978/350cc/championship-standings");
        urls.put("1978C500cc", "https://www.motogp.com/en/world-standing/1978/500cc/championship-standings");
        //1979
        urls.put("1979C50cc", "https://www.motogp.com/en/world-standing/1979/50cc/championship-standings");
        urls.put("1979C125cc", "https://www.motogp.com/en/world-standing/1979/125cc/championship-standings");
        urls.put("1979C250cc", "https://www.motogp.com/en/world-standing/1979/250cc/championship-standings");
        urls.put("1979C350cc", "https://www.motogp.com/en/world-standing/1979/350cc/championship-standings");
        urls.put("1979C500cc", "https://www.motogp.com/en/world-standing/1979/500cc/championship-standings");
        //1980
        urls.put("1980C50cc", "https://www.motogp.com/en/world-standing/1980/50cc/championship-standings");
        urls.put("1980C125cc", "https://www.motogp.com/en/world-standing/1980/125cc/championship-standings");
        urls.put("1980C250cc", "https://www.motogp.com/en/world-standing/1980/250cc/championship-standings");
        urls.put("1980C350cc", "https://www.motogp.com/en/world-standing/1980/350cc/championship-standings");
        urls.put("1980C500cc", "https://www.motogp.com/en/world-standing/1980/500cc/championship-standings");
        //1981
        urls.put("1981C50cc", "https://www.motogp.com/en/world-standing/1981/50cc/championship-standings");
        urls.put("1981C125cc", "https://www.motogp.com/en/world-standing/1981/125cc/championship-standings");
        urls.put("1981C250cc", "https://www.motogp.com/en/world-standing/1981/250cc/championship-standings");
        urls.put("1981C350cc", "https://www.motogp.com/en/world-standing/1981/350cc/championship-standings");
        urls.put("1981C500cc", "https://www.motogp.com/en/world-standing/1981/500cc/championship-standings");
        //1982
        urls.put("1982C50cc", "https://www.motogp.com/en/world-standing/1982/50cc/championship-standings");
        urls.put("1982C125cc", "https://www.motogp.com/en/world-standing/1982/125cc/championship-standings");
        urls.put("1982C250cc", "https://www.motogp.com/en/world-standing/1982/250cc/championship-standings");
        urls.put("1982C350cc", "https://www.motogp.com/en/world-standing/1982/350cc/championship-standings");
        urls.put("1982C500cc", "https://www.motogp.com/en/world-standing/1982/500cc/championship-standings");
        //1983
        urls.put("1983C50cc", "https://www.motogp.com/en/world-standing/1983/50cc/championship-standings");
        urls.put("1983C125cc", "https://www.motogp.com/en/world-standing/1983/125cc/championship-standings");
        urls.put("1983C250cc", "https://www.motogp.com/en/world-standing/1983/250cc/championship-standings");
        urls.put("1983C500cc", "https://www.motogp.com/en/world-standing/1983/500cc/championship-standings");
        //1984
        urls.put("1984C80cc", "https://www.motogp.com/en/world-standing/1984/80cc/championship-standings");
        urls.put("1984C125cc", "https://www.motogp.com/en/world-standing/1984/125cc/championship-standings");
        urls.put("1984C250cc", "https://www.motogp.com/en/world-standing/1984/250cc/championship-standings");
        urls.put("1984C500cc", "https://www.motogp.com/en/world-standing/1984/500cc/championship-standings");
        //1985
        urls.put("1985C80cc", "https://www.motogp.com/en/world-standing/1985/80cc/championship-standings");
        urls.put("1985C125cc", "https://www.motogp.com/en/world-standing/1985/125cc/championship-standings");
        urls.put("1985C250cc", "https://www.motogp.com/en/world-standing/1985/250cc/championship-standings");
        urls.put("1985C500cc", "https://www.motogp.com/en/world-standing/1985/500cc/championship-standings");
        //1986
        urls.put("1986C80cc", "https://www.motogp.com/en/world-standing/1986/80cc/championship-standings");
        urls.put("1986C125cc", "https://www.motogp.com/en/world-standing/1986/125cc/championship-standings");
        urls.put("1986C250cc", "https://www.motogp.com/en/world-standing/1986/250cc/championship-standings");
        urls.put("1986C500cc", "https://www.motogp.com/en/world-standing/1986/500cc/championship-standings");
        //1987
        urls.put("1987C80cc", "https://www.motogp.com/en/world-standing/1987/80cc/championship-standings");
        urls.put("1987C125cc", "https://www.motogp.com/en/world-standing/1987/125cc/championship-standings");
        urls.put("1987C250cc", "https://www.motogp.com/en/world-standing/1987/250cc/championship-standings");
        urls.put("1987C500cc", "https://www.motogp.com/en/world-standing/1987/500cc/championship-standings");
        //1988
        urls.put("1988C80cc", "https://www.motogp.com/en/world-standing/1988/80cc/championship-standings");
        urls.put("1988C125cc", "https://www.motogp.com/en/world-standing/1988/125cc/championship-standings");
        urls.put("1988C250cc", "https://www.motogp.com/en/world-standing/1988/250cc/championship-standings");
        urls.put("1988C500cc", "https://www.motogp.com/en/world-standing/1988/500cc/championship-standings");
        //1989
        urls.put("1989C80cc", "https://www.motogp.com/en/world-standing/1989/80cc/championship-standings");
        urls.put("1989C125cc", "https://www.motogp.com/en/world-standing/1989/125cc/championship-standings");
        urls.put("1989C250cc", "https://www.motogp.com/en/world-standing/1989/250cc/championship-standings");
        urls.put("1989C500cc", "https://www.motogp.com/en/world-standing/1989/500cc/championship-standings");
        //1990
        urls.put("1990C125cc", "https://www.motogp.com/en/world-standing/1990/125cc/championship-standings");
        urls.put("1990C250cc", "https://www.motogp.com/en/world-standing/1990/250cc/championship-standings");
        urls.put("1990C500cc", "https://www.motogp.com/en/world-standing/1990/500cc/championship-standings");
        //1991
        urls.put("1991C125cc", "https://www.motogp.com/en/world-standing/1991/125cc/championship-standings");
        urls.put("1991C250cc", "https://www.motogp.com/en/world-standing/1991/250cc/championship-standings");
        urls.put("1991C500cc", "https://www.motogp.com/en/world-standing/1991/500cc/championship-standings");
        //1992
        urls.put("1992C125cc", "https://www.motogp.com/en/world-standing/1992/125cc/championship-standings");
        urls.put("1992C250cc", "https://www.motogp.com/en/world-standing/1992/250cc/championship-standings");
        urls.put("1992C500cc", "https://www.motogp.com/en/world-standing/1992/500cc/championship-standings");
        //1993
        urls.put("1993C125cc", "https://www.motogp.com/en/world-standing/1993/125cc/championship-standings");
        urls.put("1993C250cc", "https://www.motogp.com/en/world-standing/1993/250cc/championship-standings");
        urls.put("1993C500cc", "https://www.motogp.com/en/world-standing/1993/500cc/championship-standings");
        //1994
        urls.put("1994C125cc", "https://www.motogp.com/en/world-standing/1994/125cc/championship-standings");
        urls.put("1994C250cc", "https://www.motogp.com/en/world-standing/1994/250cc/championship-standings");
        urls.put("1994C500cc", "https://www.motogp.com/en/world-standing/1994/500cc/championship-standings");
        //1995
        urls.put("1995C125cc", "https://www.motogp.com/en/world-standing/1995/125cc/championship-standings");
        urls.put("1995C250cc", "https://www.motogp.com/en/world-standing/1995/250cc/championship-standings");
        urls.put("1995C500cc", "https://www.motogp.com/en/world-standing/1995/500cc/championship-standings");
        //1996
        urls.put("1996C125cc", "https://www.motogp.com/en/world-standing/1996/125cc/championship-standings");
        urls.put("1996C250cc", "https://www.motogp.com/en/world-standing/1996/250cc/championship-standings");
        urls.put("1996C500cc", "https://www.motogp.com/en/world-standing/1996/500cc/championship-standings");
        //1997
        urls.put("1997C125cc", "https://www.motogp.com/en/world-standing/1997/125cc/championship-standings");
        urls.put("1997C250cc", "https://www.motogp.com/en/world-standing/1997/250cc/championship-standings");
        urls.put("1997C500cc", "https://www.motogp.com/en/world-standing/1997/500cc/championship-standings");
        //1998
        urls.put("1998C125cc", "https://www.motogp.com/en/world-standing/1998/125cc/championship-standings");
        urls.put("1998C250cc", "https://www.motogp.com/en/world-standing/1998/250cc/championship-standings");
        urls.put("1998C500cc", "https://www.motogp.com/en/world-standing/1998/500cc/championship-standings");
        //1999
        urls.put("1999C125cc", "https://www.motogp.com/en/world-standing/1999/125cc/championship-standings");
        urls.put("1999C250cc", "https://www.motogp.com/en/world-standing/1999/250cc/championship-standings");
        urls.put("1999C500cc", "https://www.motogp.com/en/world-standing/1999/500cc/championship-standings");
        //2000
        urls.put("2000C125cc", "https://www.motogp.com/en/world-standing/2000/125cc/championship-standings");
        urls.put("2000C250cc", "https://www.motogp.com/en/world-standing/2000/250cc/championship-standings");
        urls.put("2000C500cc", "https://www.motogp.com/en/world-standing/2000/500cc/championship-standings");
        //2001
        urls.put("2001C125cc", "https://www.motogp.com/en/world-standing/2001/125cc/championship-standings");
        urls.put("2001C250cc", "https://www.motogp.com/en/world-standing/2001/250cc/championship-standings");
        urls.put("2001C500cc", "https://www.motogp.com/en/world-standing/2001/500cc/championship-standings");
        //2002
        urls.put("2002C125cc", "https://www.motogp.com/en/world-standing/2002/125cc/championship-standings");
        urls.put("2002C250cc", "https://www.motogp.com/en/world-standing/2002/250cc/championship-standings");
        urls.put("2002Cmotogp", "https://www.motogp.com/en/world-standing/2002/motogp/championship-standings");
        //2003
        urls.put("2003C125cc", "https://www.motogp.com/en/world-standing/2003/125cc/championship-standings");
        urls.put("2003C250cc", "https://www.motogp.com/en/world-standing/2003/250cc/championship-standings");
        urls.put("2003Cmotogp", "https://www.motogp.com/en/world-standing/2003/motogp/championship-standings");
        //2004
        urls.put("2004C125cc", "https://www.motogp.com/en/world-standing/2004/125cc/championship-standings");
        urls.put("2004C250cc", "https://www.motogp.com/en/world-standing/2004/250cc/championship-standings");
        urls.put("2004Cmotogp", "https://www.motogp.com/en/world-standing/2004/motogp/championship-standings");
        //2005
        urls.put("2005C125cc", "https://www.motogp.com/en/world-standing/2005/125cc/championship-standings");
        urls.put("2005C250cc", "https://www.motogp.com/en/world-standing/2005/250cc/championship-standings");
        urls.put("2005Cmotogp", "https://www.motogp.com/en/world-standing/2005/motogp/championship-standings");
        //2006
        urls.put("2006C125cc", "https://www.motogp.com/en/world-standing/2006/125cc/championship-standings");
        urls.put("2006C250cc", "https://www.motogp.com/en/world-standing/2006/250cc/championship-standings");
        urls.put("2006Cmotogp", "https://www.motogp.com/en/world-standing/2006/motogp/championship-standings");
        //2007
        urls.put("2007C125cc", "https://www.motogp.com/en/world-standing/2007/125cc/championship-standings");
        urls.put("2007C250cc", "https://www.motogp.com/en/world-standing/2007/250cc/championship-standings");
        urls.put("2007Cmotogp", "https://www.motogp.com/en/world-standing/2007/motogp/championship-standings");
        //2008
        urls.put("2008C125cc", "https://www.motogp.com/en/world-standing/2008/125cc/championship-standings");
        urls.put("2008C250cc", "https://www.motogp.com/en/world-standing/2008/250cc/championship-standings");
        urls.put("2008Cmotogp", "https://www.motogp.com/en/world-standing/2008/motogp/championship-standings");
        //2009
        urls.put("2009C125cc", "https://www.motogp.com/en/world-standing/2009/125cc/championship-standings");
        urls.put("2009C250cc", "https://www.motogp.com/en/world-standing/2009/250cc/championship-standings");
        urls.put("2009Cmotogp", "https://www.motogp.com/en/world-standing/2009/motogp/championship-standings");
        //2010
        urls.put("2010C125cc", "https://www.motogp.com/en/world-standing/2010/125cc/championship-standings");
        urls.put("2010Cmoto2", "https://www.motogp.com/en/world-standing/2010/moto2/championship-standings");
        urls.put("2010Cmotogp", "https://www.motogp.com/en/world-standing/2010/motogp/championship-standings");
        //2011
        urls.put("2011C125cc", "https://www.motogp.com/en/world-standing/2011/125cc/championship-standings");
        urls.put("2011Cmoto2", "https://www.motogp.com/en/world-standing/2011/moto2/championship-standings");
        urls.put("2011Cmotogp", "https://www.motogp.com/en/world-standing/2011/motogp/championship-standings");
        //2012
        urls.put("2012Cmoto3", "https://www.motogp.com/en/world-standing/2012/moto3/championship-standings");
        urls.put("2012Cmoto2", "https://www.motogp.com/en/world-standing/2012/moto2/championship-standings");
        urls.put("2012Cmotogp", "https://www.motogp.com/en/world-standing/2012/motogp/championship-standings");
        //2013
        urls.put("2013Cmoto3", "https://www.motogp.com/en/world-standing/2013/moto3/championship-standings");
        urls.put("2013Cmoto2", "https://www.motogp.com/en/world-standing/2013/moto2/championship-standings");
        urls.put("2013Cmotogp", "https://www.motogp.com/en/world-standing/2013/motogp/championship-standings");
        //2014
        urls.put("2014Cmoto3", "https://www.motogp.com/en/world-standing/2014/moto3/championship-standings");
        urls.put("2014Cmoto2", "https://www.motogp.com/en/world-standing/2014/moto2/championship-standings");
        urls.put("2014Cmotogp", "https://www.motogp.com/en/world-standing/2014/motogp/championship-standings");
        //2015
        urls.put("2015Cmoto3", "https://www.motogp.com/en/world-standing/2015/moto3/championship-standings");
        urls.put("2015Cmoto2", "https://www.motogp.com/en/world-standing/2015/moto2/championship-standings");
        urls.put("2015Cmotogp", "https://www.motogp.com/en/world-standing/2015/motogp/championship-standings");
        //2016
        urls.put("2016Cmoto3", "https://www.motogp.com/en/world-standing/2016/moto3/championship-standings");
        urls.put("2016Cmoto2", "https://www.motogp.com/en/world-standing/2016/moto2/championship-standings");
        urls.put("2016Cmotogp", "https://www.motogp.com/en/world-standing/2016/motogp/championship-standings");
        //2017
        urls.put("2017Cmoto3", "https://www.motogp.com/en/world-standing/2017/moto3/championship-standings");
        urls.put("2017Cmoto2", "https://www.motogp.com/en/world-standing/2017/moto2/championship-standings");
        urls.put("2017Cmotogp", "https://www.motogp.com/en/world-standing/2017/motogp/championship-standings");
        //2018
        urls.put("2018Cmoto3", "https://www.motogp.com/en/world-standing/2018/moto3/championship-standings");
        urls.put("2018Cmoto2", "https://www.motogp.com/en/world-standing/2018/moto2/championship-standings");
        urls.put("2018Cmotogp", "https://www.motogp.com/en/world-standing/2018/motogp/championship-standings");
        //2019
        urls.put("2019Cmoto3", "https://www.motogp.com/en/world-standing/2019/moto3/championship-standings");
        urls.put("2019Cmoto2", "https://www.motogp.com/en/world-standing/2019/moto2/championship-standings");
        urls.put("2019Cmotogp", "https://www.motogp.com/en/world-standing/2019/motogp/championship-standings");
        //2020
        urls.put("2020Cmoto3", "https://www.motogp.com/en/world-standing/2020/moto3/championship-standings");
        urls.put("2020Cmoto2", "https://www.motogp.com/en/world-standing/2020/moto2/championship-standings");
        urls.put("2020Cmotogp", "https://www.motogp.com/en/world-standing/2020/motogp/championship-standings");
        //2021
        urls.put("2021Cmoto3", "https://www.motogp.com/en/world-standing/2021/moto3/championship-standings");
        urls.put("2021Cmoto2", "https://www.motogp.com/en/world-standing/2021/moto2/championship-standings");
        urls.put("2021Cmotogp", "https://www.motogp.com/en/world-standing/2021/motogp/championship-standings");
        //2022
        urls.put("2022Cmoto3", "https://www.motogp.com/en/world-standing/2022/moto3/championship-standings");
        urls.put("2022Cmoto2", "https://www.motogp.com/en/world-standing/2022/moto2/championship-standings");
        urls.put("2022Cmotogp", "https://www.motogp.com/en/world-standing/2022/motogp/championship-standings");
        //2023
        urls.put("2023Cmoto3", "https://www.motogp.com/en/world-standing/2023/moto3/championship-standings");
        urls.put("2023Cmoto2", "https://www.motogp.com/en/world-standing/2023/moto2/championship-standings");
        urls.put("2023Cmotogp", "https://www.motogp.com/en/world-standing/2023/motogp/championship-standings");
    }
    public void run() {
        crawl();
    }
    public void crawl() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        for (Map.Entry<String, String> entry : urls.entrySet()) {
            String key = null;
            try {
                key = entry.getKey();
                String value = entry.getValue();
                driver.get(value);

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15), Duration.ofSeconds(10));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("table.standings-table__table:not(div.u-hide table.standings-table__table)")));

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //String pageSource = driver.getPageSource();
                scan(driver.getPageSource(), key);
            }
        }
        driver.quit();
    }

    private void scan(String htmlPage, String key) {
        try {
            Document doc = Jsoup.parse(htmlPage);
            PeppinosDatabase db = new PeppinosDatabase();

            Pattern pattern = Pattern.compile("\\b(\\d{4})\\b");
            Element title = doc.selectFirst("div.standings__hero-text");
            Matcher matcher = pattern.matcher(title.text());
            String year = null;
            if (matcher.find()) {
                year = matcher.group(1);
            }

            String category = key.substring(5);
            System.out.println();
            System.out.println(year + " " +category);


            Element standingTable = doc.selectFirst("table.standings-table__table:not(div.u-hide table.standings-table__table)");
            if (standingTable != null) {
                Elements rows = standingTable.select("tr.standings-table__body-row");
                for (Element row : rows) {
                    Element position = row.selectFirst("td.standings-table__body-cell.standings-table__body-cell--pos");
                    Element rider = row.selectFirst("a.standings-table__rider-link");
                    Element points = row.selectFirst("td.standings-table__body-cell.standings-table__body-cell--points");
                    String pointsToString = points.text();
                    double pointsDouble = Double.parseDouble(pointsToString);
                    int pointsInt = (int) pointsDouble;
                    db.insert(key,Integer.parseInt(position.text()), rider.text(), pointsInt);
                    System.out.println("inserito dato correttamente");
                    System.out.println(position.text() + "|" + points.text() + "|" + rider.text());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
