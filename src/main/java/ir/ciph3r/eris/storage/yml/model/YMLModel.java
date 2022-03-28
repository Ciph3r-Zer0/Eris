package ir.ciph3r.eris.storage.yml.model;

import ir.ciph3r.eris.Eris;
import lombok.Getter;
import org.simpleyaml.configuration.file.YamlFile;

import java.io.IOException;

public abstract class YMLModel {
    @Getter
    private Eris eris;
    @Getter
    private String fileName;
    @Getter
    private YamlFile YMLFile;

    public YMLModel(Eris eris, String fileName) {
        this.eris = eris;
        this.fileName = fileName;
    }

    public void createFile() throws IOException {
        YMLFile = new YamlFile(getEris().getDataDirectory() + "/" + fileName);

        if (!(YMLFile.exists())) {
            YMLFile.createNewFile();
        }
    }

    public void loadFile() throws IOException {
        YMLFile.loadWithComments();
    }

    public abstract void LoadProperties();

    public abstract void setProperties() throws IOException;
}
