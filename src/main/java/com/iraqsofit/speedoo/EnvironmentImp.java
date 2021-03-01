package com.iraqsofit.speedoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class EnvironmentImp {

    @Autowired
    Environment environment;

    private String port;

    private String hostname;

    public String getPort() {
        if (port == null) port = environment.getProperty("local.server.port");
        return port;
    }

    public String getHostname() throws UnknownHostException {
        if (hostname == null) hostname = InetAddress.getLocalHost().getHostAddress();
        return hostname;
    }

    public Integer getPortAsInt() {
        return Integer.valueOf(getPort());
    }

    public String getServerUrlPrefi() throws UnknownHostException {
        return "http://" + getHostname() + ":" + getPort();
    }
}
