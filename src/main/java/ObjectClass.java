import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectClass {

        WebDriver driver;

        @FindBy(xpath = "//button[contains(text(),'Open Modal')]")
        private WebElement openModelButton;

        @FindBy(xpath = "//*[@id='name']")
        private WebElement nameTextField;

        @FindBy(xpath = "//*[@id='city']")
        private WebElement cityTextField;

        @FindBy(xpath = "//*[@id='enter']")
        private WebElement enterButton;

        @FindBy(xpath = "//button[contains(text(),'Close')]")
        private WebElement closeButton;

        @FindBy(xpath = "//*[@id='nameVal']")
        private WebElement nameValue;

        @FindBy(xpath = "//*[@id='cityVal']")
        private WebElement cityValue;

        @FindBy(xpath = "//button[contains(text(),'Click Me!')]")
        private WebElement clickMeButton;

        @FindBy(xpath = "//*[@id='myInput']")
        private WebElement searchInputField;

        @FindBy(xpath = "//*[@id='searchMe']")
        private WebElement searchMeInputField;

        @FindBy(xpath = "//*[@id='div1']")
        private WebElement dragTo;

        @FindBy(xpath = "//*[@id='drag1']")
        private WebElement dragFrom;

        /**
         * ObjectClass Page Constructor.
         *
         * @param driver WebDriver.
         */
        public ObjectClass(WebDriver driver) {
                this.driver = driver;
                PageFactory.initElements(driver, this);
        }

        /**
         * Method to getElement
         * @return WebElement
         */
        public WebElement getOpenModelButton(){ return openModelButton;}
        public WebElement getNameTextField(){ return nameTextField;}
        public WebElement getCityTextField(){ return cityTextField;}
        public WebElement getEnterButton(){ return enterButton;}
        public WebElement getCloseButton(){ return closeButton;}
        public WebElement getNameValue(){ return nameValue;}
        public WebElement getCityValue(){ return cityValue;}
        public WebElement getClickMeButton(){ return clickMeButton;}
        public WebElement getSearchInputField(){ return searchInputField;}
        public WebElement getSearchMeInputField(){ return searchMeInputField;}
        public WebElement getDragFrom(){ return dragFrom;}
        public WebElement getDragTo(){ return dragTo;}

        /**
         * Read dropdown list into array
         *
         * @return
         */
        public List<String> getActualList() {
            List<String> actualList = new ArrayList<String>();
            List<WebElement> elements = driver.findElements(By.xpath("//*[@class='dropdown-menu show']"));

            for (int i = 0; i < elements.size(); i++) {
                String str = elements.get(i).getText();
                String[] strparts = str.split("\n", -1);
                List<String> wordList = Arrays.asList(strparts);
                actualList.addAll(wordList);
            }
            return actualList;
        }

        public int getTotalRowCount(){
                List<WebElement> rows = driver.findElements(By.xpath("//*[@id='someTable']/tr"));
                return rows.size();
        }

        public int getHiddenRowCount(){
                List<WebElement> rows = driver.findElements(By.xpath("//*[@id='someTable']/tr[@style = 'display: none;']"));
                return rows.size();
        }
}
