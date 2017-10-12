package core;

import org.openqa.selenium.By;

class Locators {
    By data = By.xpath("//*[@id='id_monthly_payment_and_tax']");
    By result = By.xpath("//*[@id='id_annual_payment_with_tax']");
    By validate = By.xpath("//*[@id='id_validate_button']");
    By statement = By.id("id_result");
    By copyright = By.xpath("//*[@id='copyright']");

    String regex = "^(?:\\w{0,})?(?:\\:)?(?:\\s*)?(?:\\$)?((?:\\d{0,4})(?:\\.)(?:\\d{0,2}))(?:\\,)?(?:\\s*)?(?:\\w{0,})?(?:\\:)?(?:\\s*)?((?:\\d{0,2})(?:\\.)(?:\\d{0,2}))(?:\\%)$";

    String finalresult(String actualresult) {
        if (actualresult.toUpperCase().contains("CORRECT")) return actualresult;
        else { System.out.println("Code doesn't work!"); return actualresult;}
    }
}
