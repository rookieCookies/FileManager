package test.test;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ManagedFile {
    private File file;
    private FileConfiguration fileConfiguration;
    ManagedFile() {
        fileConfiguration = new YamlConfiguration();
    }
    ManagedFile(File file) {
        setFile(file);
        updateFileConfiguration();
    }

    /**
     * Returns the file, can be null
     * @return Existing file
     */
    public File getFile() { return file; }

    /**
     * Returns the file configuration, can be null
     * @return File configuration
     */
    public FileConfiguration getFileConfiguration() { return fileConfiguration; }

    /**
     * Set the existing file, will require a updateFileConfiguration() to update the file configuration
     */
    public void setFile(File file) { this.file = file; }

    /**
     * Set the existing file configuration to the given value, is not recommended
     */
    public void setFileConfiguration(FileConfiguration fileConfiguration) { this.fileConfiguration = fileConfiguration; }

    /**
     * Update the file configuration based on the existing file
     */
    public void updateFileConfiguration() { loadFile(file); }

    /**
     * Save the file
     */
    public void save() {
        try {
            fileConfiguration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Load the given file to the existing file configuration
     * */
    public void loadFile(File file) {
        fileConfiguration = new YamlConfiguration();
        try {
            fileConfiguration.load(file);
        }
        catch (IOException | InvalidConfigurationException e) { e.printStackTrace(); }
    }
}
