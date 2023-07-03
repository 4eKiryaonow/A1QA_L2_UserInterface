package hoard;

import static constant.KeyConstants.URL_KEY;

public abstract class ConfigManager {
    public static String getUrl() {
        return SettingsManager.getConfig().getValue(URL_KEY).toString();
    }
}