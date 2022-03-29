package ir.ciph3r.eris.storage.yml.model;

import ir.ciph3r.eris.Eris;
import lombok.Getter;
import org.simpleyaml.configuration.file.YamlFile;
import org.simpleyaml.exceptions.InvalidConfigurationException;

import java.io.File;
import java.io.IOException;

public abstract class YMLModel {
    @Getter
    private Eris eris;
    @Getter
    private String fileName;
    @Getter
    private File file;
    @Getter
    private YamlFile YMLFile;

    public YMLModel(Eris eris, String fileName) {
        this.eris = eris;
        this.fileName = fileName;
    }

    public void createFile() throws IOException {
        file = new File(getEris().getDataDirectory().toString(), fileName);
        YMLFile = new YamlFile(file);

        if (!(YMLFile.exists())) {
            YMLFile.createNewFile(true);
        }
    }

    public void loadFile() throws InvalidConfigurationException, IOException {
        YMLFile.load();
    }

    public abstract void LoadProperties();

    public abstract void setProperties() throws IOException;
}
