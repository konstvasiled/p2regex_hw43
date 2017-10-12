package core;

import java.math.BigDecimal;
import java.math.RoundingMode;

class Simplemath {
    double percentege(double value, double multiplier) {
        double percentegevalue = new BigDecimal((value / 100) * multiplier).setScale(2, RoundingMode.HALF_UP).doubleValue();
        return percentegevalue;
    }
    double totalyearly(double income) {
        double yearly = new BigDecimal(income * 12).setScale(2, RoundingMode.HALF_UP).doubleValue();
        return yearly;
    }
}
