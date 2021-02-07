import com.google.common.collect.Lists;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class TestClass extends TestBase {
    String Name;
    String City;

        public ObjectClass objectClass;

    @BeforeMethod
    public void setUp() {
         Name = "Deepthi Janga";
         City = "Hyderabad";
         objectClass = new ObjectClass(driver);
    }

        @Test
        public void test1() {
            objectClass.getOpenModelButton().click();
            objectClass.getNameTextField().sendKeys(Name);
            objectClass.getCityTextField().sendKeys(City);
            objectClass.getEnterButton().click();
            objectClass.getCloseButton().click();
            Assert.assertEquals(objectClass.getNameValue().getText(), Name, "Name isn't as expected");
            Assert.assertEquals(objectClass.getCityValue().getText(), City, "City isn't as expected");
        }

        @Test
        public void test2() {
            List<String> expectedList = Lists.newArrayList("Java", "C#", "Python", "Angular 2", "Angular");
            List<String> expectedList2 = Lists.newArrayList("Angular 2", "Angular");
            objectClass.getClickMeButton().click();
            Assert.assertEquals(expectedList, objectClass.getActualList(), "List in dropdown isn't as expected");
            System.out.println("Available options in drop down : " +objectClass.getActualList());
            objectClass.getSearchInputField().sendKeys("Angular");
            System.out.println("List is " +objectClass.getActualList());
            Assert.assertEquals(expectedList2, objectClass.getActualList(), "List in dropdown isn't as expected");
            objectClass.getSearchInputField().clear();
            objectClass.getSearchInputField().sendKeys("ReactJs");
            System.out.println("List is " +objectClass.getActualList().get(0));
            //improper array length 1 instead of 0
            Assert.assertEquals(objectClass.getActualList().size(), 1, "List in dropdown isn't as expected");
        }

        @Test
        public void test3() {
            objectClass.getSearchMeInputField().sendKeys("USA");
            int displayedRowCount = objectClass.getTotalRowCount()-objectClass.getHiddenRowCount();
            Assert.assertEquals(displayedRowCount, 2);
            for(int i = 1; i<=displayedRowCount; i++){
                String CountryName = driver.findElement(By.xpath("//*[@id='someTable']/tr["+i+"]/td[3]")).getText();
                Assert.assertEquals(CountryName, "USA");
            }
            objectClass.getSearchMeInputField().clear();
            objectClass.getSearchMeInputField().sendKeys(Keys.BACK_SPACE);
            int rowCount = objectClass.getTotalRowCount()-objectClass.getHiddenRowCount();
            Assert.assertEquals(rowCount, 4);
        }

        @Test
        public void test4() {
            Actions act=new Actions(driver);
//            act.clickAndHold(objectClass.getDragFrom()).perform();
//            act.dragAndDrop(objectClass.getDragFrom(),objectClass.getDragTo()).build().perform();
            Action dragAndDrop = act.clickAndHold(objectClass.getDragFrom()).moveToElement(objectClass.getDragTo()).release(objectClass.getDragTo()).build();
            dragAndDrop.perform();
        }
 }
