package properties.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {
    @Test
    public void systemPropertyTest() {
        System.setProperty("browser", "Chrome");
        String browser = System.getProperty("browser");
        System.out.println(browser);
    }
    @Test
    @Tag("property")
    public void systemPropertyDefTest() {
        String browser = System.getProperty("browser", "Microsoft Edge");
        System.out.println(browser);
    }
    @Test
    public void systemPropertyFullTest() {
        System.setProperty("browser", "Chrome");
        String browser = System.getProperty("browser", "Microsoft Edge");
        System.out.println(browser);
    }
}
