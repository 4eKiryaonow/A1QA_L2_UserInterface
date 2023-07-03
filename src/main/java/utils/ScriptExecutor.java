package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static constant.PathConstants.PATH_SCRIPT;


public class ScriptExecutor {

    public static void uploadImage() {
        String path = System.getProperty("user.dir") + PATH_SCRIPT;
        int exitCode;
        try {
            Process process = Runtime.getRuntime().exec(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                LoggerManager.info(line);
            }
            exitCode = process.waitFor();
            LoggerManager.info(String.format("Script exited with code %s", exitCode));
        } catch (IOException | InterruptedException e) {
            LoggerManager.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}