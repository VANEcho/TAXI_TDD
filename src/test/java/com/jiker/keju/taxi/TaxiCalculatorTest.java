package java.com.jiker.keju.taxi;

import com.jiker.keju.taxi.TaxiCalculator;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TaxiCalculatorTest {
    @Test
    public void taxi_calculator_test(){
        TaxiCalculator taxiCalculator = new TaxiCalculator("1&0,3&0,10&0,2&3");
        assertEquals("收费6元\\n收费7元\\n收费13元\\n收费7元",taxiCalculator.getReceipt());
    }
}
