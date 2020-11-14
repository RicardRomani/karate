package com.intuit.karate.runtime;

import com.intuit.karate.Logger;
import com.intuit.karate.server.HttpClient;
import com.intuit.karate.server.HttpRequest;
import com.intuit.karate.server.Response;
import com.intuit.karate.server.ServerHandler;

/**
 *
 * @author pthomas3
 */
public class MockClient implements HttpClient {

    private final ServerHandler handler;
    private Config config = new Config();
    private final Logger logger = new Logger();

    public MockClient(ServerHandler handler) {
        this.handler = handler;
    }

    @Override
    public void setConfig(Config config, String key) {
        this.config = config;
    }

    @Override
    public Config getConfig() {
        return config;
    }

    @Override
    public Response invoke(HttpRequest request) {
        return handler.handle(request.toRequest());
    }

    @Override
    public Logger getLogger() {
        return logger;
    }

}