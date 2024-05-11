
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Appium {

    /// launch the appium
    // connect the device to the machine


@Test
    public  void dd() throws IOException, InterruptedException {

            String[] command = {"adb", "devices"};
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.environment().put("ANDROID_ADB_SERVER_HOST", "host.docker.internal");
            Process process = processBuilder.start();

            // Read the output of the command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line);
            }

            // Wait for the command to finish and get the exit code
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                String devicesInfo = output.toString();
                System.out.println(devicesInfo);

                UiAutomator2Options cap = new UiAutomator2Options();
                cap.setCapability("devicename", "Lenovo");
                cap.setCapability("automationName", "UiAutomator2");
                cap.setCapability("udid", "HGR4T8AG");
                cap.setCapability("platformName", "Android");
                cap.setCapability("platformVersion", "13");
                cap.setCapability("appPackage", "com.google.android.apps.youtube.music");
                cap.setCapability("appActivity", "com.google.android.apps.youtube.music.activities.MusicActivity");
//               cap.setCapability("remoteAdbHost", "host.docker.internal");
               cap.setCapability("wdaLocalPort", 8100);
                cap.setCapability("mjpegServerPort", 9100);
                cap.setCapability("mjpegScreenshotUrl", "http://localhost:9100");
                // Initialize Appium driver
                WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
//                WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.134:4444/wd/hub"), cap);

//                driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
            }

            System.out.println("driver initiated");


    }

}