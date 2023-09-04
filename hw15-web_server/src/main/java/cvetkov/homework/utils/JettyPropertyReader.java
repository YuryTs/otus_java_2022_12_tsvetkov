package cvetkov.homework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.util.Properties;

public class JettyPropertyReader {
    private int port;
    private final String PROP_FILE_NAME = "jetty.properties";
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public JettyPropertyReader() {
        try {
            readProperties();
        } catch (Exception ex) {
            log.error("fail to read '" + PROP_FILE_NAME + "' file", ex);
        }
    }
    public void readProperties() throws Exception {

        Properties properties = new Properties();

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PROP_FILE_NAME)) {
            properties.load(inputStream);
            port = Integer.parseInt(properties.getProperty("port"));
        }
    }

    public int getPort() {
        return port;
    }
}
