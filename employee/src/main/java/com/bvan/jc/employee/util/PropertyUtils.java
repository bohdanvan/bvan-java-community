package com.bvan.jc.employee.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author bvanchuhov
 */
public final class PropertyUtils {

    private PropertyUtils() {}

    public static Properties loadPropertyFromClasspath(String name) {
        try (InputStream inputStream = PropertyUtils.class.getClassLoader().getResourceAsStream(name)) {
            if (inputStream == null) {
                throw new RuntimeException("Properties file not found in classpath: " + name);
            }

            Properties properties = new Properties();
            properties.load(inputStream);

            return properties;
        } catch (IOException e) {
            throw new RuntimeException("Can't load properties from classpath: " + name, e);
        }
    }
}
