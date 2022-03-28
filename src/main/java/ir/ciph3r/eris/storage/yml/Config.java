package ir.ciph3r.eris.storage.yml;

import ir.ciph3r.eris.Eris;
import ir.ciph3r.eris.storage.yml.model.YMLModel;

import java.io.IOException;

public class Config extends YMLModel {
    public Config(Eris eris) {
        super(eris, "config.yml");

        try {
            createFile();
            setProperties();
            loadFile();
            LoadProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void LoadProperties() {

    }

    @Override
    public void setProperties() throws IOException {
        getYMLFile().addDefault("booleanTest", true);
        getYMLFile().addDefault("integerTest", 1);
        getYMLFile().addDefault("StringTest", "test");
        getYMLFile().options().copyDefaults(true);
        getYMLFile().save();
    }
}
