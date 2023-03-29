package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.network.Network;
import org.openqa.selenium.devtools.v107.network.model.Request;
import swaglabbase.BaseTest;

import java.util.Optional;

public class NetworkCall extends BaseTest {
    DevTools devTools;
    public void gg(){
        devTools = ((ChromeDriver)driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(
                Optional.empty(),
                Optional.empty(),
                Optional.empty()));

        devTools.addListener(Network.requestWillBeSent(),
                request ->{
                    System.out.println("Request URL:" +request.getRequest().getUrl());
                    System.out.println("Request type:" +request.getRequest().getMethod());
                });
    }
}
