package java.com.jiker.keju.taxi;

import com.jiker.keju.taxi.ReadFile;
import org.junit.Test;
//import junit.framework.Test;

import java.io.IOException;

//import static junit.framework.Assert.assertEquals;
//import static junit.framework.Assert.assertNull;

public class ReadFileTest {

    @Test
    public void data_normal_load_test() throws IOException {
        ReadFile readFile = new ReadFile("testData.txt");
        assertEquals("1&0,3&0,10&0,2&3",readFile.getDataInfo());
    }

    @Test
    public void data_null_test() throws IOException {
        ReadFile readFile = new ReadFile("testNull.txt");
        assertNull(readFile.getDataInfo());
    }
}
