package core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) throws InterruptedException {
        Functionality operate = new Functionality();
        Locators locate = new Locators();
        Simplemath calculate = new Simplemath();

        operate.open("", "http://alex.academy/exe/payment_tax/index.html");
        String montlywithtax = operate.gatherText(locate.data);
        Pattern p = Pattern.compile(locate.regex);Matcher m = p.matcher(montlywithtax);m.find();
        double montlypayment = Double.parseDouble(m.group(1));
        double taxmultiplier = Double.parseDouble(m.group(2));
        double taxvalue = calculate.percentege(montlypayment, taxmultiplier);
        double totalmontly = montlypayment + taxvalue;
        double annualwithtax = calculate.totalyearly(totalmontly);
        operate.senddata(locate.result, annualwithtax);
        operate.click(locate.validate);
        String actualresult = operate.gatherText(locate.statement);
        String actual_result = locate.finalresult(actualresult);
        System.out.println("Url: " + operate.returnUrl());
        System.out.println("And your result is: " + actual_result + "\nCopyright:" + operate.gatherText(locate.copyright));
        operate.quit();
    }
}
