package com.frost_byte;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Settings class is responsible for loading and saving application settings.
 * It uses a singleton design pattern so that configuration is available
 * globally throughout the application.
 */
public class Settings {
    private static final String PROPERTIES_FILE = "frost_byte/src/main/java/com/model/app.properties";
    private static Settings instance = null;
    private final Properties properties;

    // Private constructor loads the properties from the file or applies defaults if not found.
    private Settings() {
        properties = new Properties();
        try (FileInputStream in = new FileInputStream(PROPERTIES_FILE)) {
            properties.load(in);
        } catch (IOException e) {
            System.err.println("Unable to load properties file; using default settings.");
            setDefaultProperties();
            saveProperties();
        }
    }

    /**
     * Returns the single instance of Settings.
     * Uses lazy initialization with synchronization to be thread-safe.
     *
     * @return the Settings instance.
     */
    public static synchronized Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }

    /**
     * Gets the property associated with the specified key.
     *
     * @param key the property key.
     * @return the property value or null if not found.
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    /**
     * Sets a property key/value pair.
     *
     * @param key   the property key.
     * @param value the property value.
     */
    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }

    /**
     * Saves current properties to the application properties file.
     */
    public void saveProperties() {
        try (FileOutputStream out = new FileOutputStream(PROPERTIES_FILE)) {
            properties.store(out, "Application Settings");
        } catch (IOException e) {
            System.err.println("Failed to save properties file.");
            e.printStackTrace();
        }
    }

    // Applies default configuration settings.
    private void setDefaultProperties() {
        properties.setProperty("app.title", "Frost Byte Music App");
        properties.setProperty("app.version", "1.0");
        properties.setProperty("user.file", "json/users.json");
        properties.setProperty("song.file", "json/songs.json");
        properties.setProperty("lesson.file", "json/lessons.json");
        // Add more default properties as needed.
    }

    /**
     * Main method for basic testing of Settings functionality.
     */
    public static void main(String[] args) {
        System.out.println("Starting Settings tests...");

        Settings settings = Settings.getInstance();

        // Test 1: Read existing properties
        String appTitle = settings.getProperty("app.title");
        String appVersion = settings.getProperty("app.version");

        System.out.println("Test 1: Read properties");
        System.out.println("app.title = " + appTitle);
        System.out.println("app.version = " + appVersion);

        // Test 2: Update and save a property
        settings.setProperty("app.testProperty", "TestValue123");
        settings.saveProperties();

        System.out.println("\nTest 2: Updated app.testProperty and saved.");

        // Test 3: Reload Settings to verify the saved change
        Settings settingsReloaded = new Settings();
        String testProperty = settingsReloaded.getProperty("app.testProperty");

        System.out.println("\nTest 3: Reloaded Settings");
        System.out.println("app.testProperty = " + testProperty);

        // Final test result summary
        if ("TestValue123".equals(testProperty)) {
            System.out.println("\nAll Settings tests passed successfully!");
        } else {
            System.out.println("\nSettings tests failed. Check your property file paths and permissions.");
        }
    }
}
