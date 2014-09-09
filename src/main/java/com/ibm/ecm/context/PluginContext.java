package com.ibm.ecm.context;

import com.ibm.ecm.extension.PluginLogger;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * This class provides common interfaces such as resource bundles for i18n, config parameters and etc.
 */
public class PluginContext {

    private static final String messageBundleName = "messages";
    private static final String configFileName = "plugin.properties";

    static  PluginContext instance;
    private Properties configs;

    public PluginLogger logger = null;

    public PluginContext(PluginLogger logger) {
        this.logger = logger;
        instance = this;
    }

    public static PluginContext getIntstance(){
        if(instance == null){
            instance = new PluginContext(null);
        }
        return instance;
    }

    public ResourceBundle getResBundle(Locale locale){
        return ResourceBundle.getBundle(messageBundleName, locale);
    }

    public String getI18nLabel(Locale locale, String key){
        return getResBundle(locale).getString(key);
    }

    public String getConfigParam(String key){
        if(configs == null) {
            configs = new Properties();
            InputStream inputStream = null;
            try {
                inputStream = getClass().getClassLoader().getResourceAsStream(configFileName);
                if (inputStream == null) {
                    throw new FileNotFoundException("Plugin configuration file '" + configFileName + "' not found in the classpath");
                }
                configs.load(inputStream);
            } catch (Exception ex) {
                // TODO log it
            } finally {
                try {
                    assert inputStream != null;
                    inputStream.close();
                } catch (Exception ignored) {
                }
            }
        }
        return configs.getProperty(key);
    }


}
