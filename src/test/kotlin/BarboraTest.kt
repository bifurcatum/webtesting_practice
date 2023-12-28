import com.codeborne.selenide.Condition.*
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.logevents.SelenideLogger.addListener
import io.qameta.allure.selenide.AllureSelenide
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.openqa.selenium.By
import org.slf4j.Logger
import java.io.FileReader
import java.nio.file.Files.newBufferedReader
import java.nio.file.Path

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BarboraTest {

    @BeforeAll fun setUp() {
        addListener("AllureSelenide", AllureSelenide().screenshots(true).savePageSource(true))
        Configuration.timeout = 8000
        open("https://barbora.ee/")
        element("#CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll").click()
    }
    companion object {
        val logger: Logger = org.slf4j.LoggerFactory.getLogger("logger")
    }

    @Test fun findGoods() {
        
        elements("#fti-search").findBy(visible).click()
        elements("#fti-search").findBy(editable).setValue("Hommikuhelbed NESTLE Cini-Minis 645g").pressEnter()
        elements(By.className("tw-block")).findBy(text("Hommikuhelbed NESTLE Cini-Minis 645g")).click()
        element(".b-product-info--title").shouldHave(text("Hommikuhelbed NESTLE Cini-Minis 645g"))
        if (element("#fti-product-info-price > div > div:nth-child(2) > span").exists()) {
            val discPrice = element("#fti-product-info-price > div > div:nth-child(2) > div > span").ownText
            logger.info("Discounted price is $discPrice")
        }
        else {
            val regPrice = element("#fti-product-info-price > div > div:nth-child(2) > div > span").ownText
            logger.info("Regular price is $regPrice")
        }
    }
}
/* fun getData() :List<List<String>> {
    val data:List<List<String>> = emptyList()
    val row:List<String> = emptyList()
    val filePath = "src/test/resources/data.csv"
    val inputStream = FileReader(filePath)
    val parser = CSVParser(inputStream, CSVFormat.DEFAULT)
    for (record in parser) {
        for (cell in record) {
            row.addLast(cell)
        }
        data.addLast(row)
    }
    parser.close()
    return data
} */