package stepdefinitions;


import io.cucumber.java.BeforeAll;
import io.cucumber.java.AfterAll;
import utilis.ApiMockServer;

public class Hooks {

    @BeforeAll
    public static void startMock() {
        ApiMockServer.startServer();
    }

    @AfterAll
    public static void stopMock() {
        ApiMockServer.stopServer();
    }
}
