package config;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BrowserStackDriver {

    public WebDriver createDriver() {


        Map<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("os", "Windows");
        bstackOptions.put("osVersion", "10");
        bstackOptions.put("local", "false");
        bstackOptions.put("seleniumVersion", "4.10.0");
        bstackOptions.put("userName", "deisymosquera_ZcW2wI");
        bstackOptions.put("accessKey", "mh2MpxpYKNEeEqDpW8t1");
        bstackOptions.put("sessionName", "Contact Us Test");


        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("browserVersion", "117.0");
        caps.setCapability("bstack:options", bstackOptions);

        try {
            return new RemoteWebDriver(
                    new URL("https://hub-cloud.browserstack.com/wd/hub"),
                    caps
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("URL de BrowserStack inválida");
        }
    }
}
