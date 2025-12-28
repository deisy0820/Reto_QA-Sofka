package utilis;

import com.github.tomakehurst.wiremock.WireMockServer;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class ApiMockServer {
    private static WireMockServer wireMockServer;

    public static void startServer() {
        wireMockServer = new WireMockServer(8080); // Puerto libre
        wireMockServer.start();

        wireMockServer.stubFor(post(urlEqualTo("/products"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"id\":123,\"name\":\"Test Product\",\"price\":100}")));

        wireMockServer.stubFor(get(urlMatching("/products/\\d+"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"id\":123,\"name\":\"Test Product\",\"price\":100}")));
    }

    public static void stopServer() {
        if (wireMockServer != null) {
            wireMockServer.stop();
        }
    }
}


