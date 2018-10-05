package project.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import project.model.ContactData;


public class ContactHelper extends HelperBase {
    public ContactHelper(FirefoxDriver wd){
        super(wd);
    }

    public void initContactCreation() {click(By.linkText("add new"));}

    public void fillContactForm(ContactData contactData) {
        type(By.cssSelector("input[name=\"firstname\"]"), contactData.getFirstName());
        type(By.cssSelector("input[name=\"lastname\"]"), contactData.getLastName());
        type(By.cssSelector("textarea[name=\"address\"]"), contactData.getAddress());
        type(By.cssSelector("input[name=\"mobile\"]"), contactData.getMobile());
        type(By.cssSelector("input[name=\"email\"]"), contactData.getEmail());
    }

    public void submitContactCreation(){
        click (By.cssSelector("input[name=\"submit\"]"));
    }

    public void gotoHomePage() {
        click(By.linkText("home"));
    }

    public void initContactModification(){
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void submitContactModification() {
        click(By.xpath("//input[@name='update']"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void acceptDeleteContact(){
        wd.switchTo().alert().accept();
    }
}

