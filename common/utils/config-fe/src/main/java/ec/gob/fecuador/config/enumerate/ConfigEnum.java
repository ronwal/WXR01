package ec.gob.fecuador.config.enumerate;

/**
 * Created by Walter on 1/2/17.
 */
public enum ConfigEnum {
    PATH_CONFIG("config.file"),
    PATH_REPORT("path.report"),
    PATH_IMAGES("path.images"),
    IMAGES_PORTAL("images.portal"),
    IMAGES_INICIO("images.inicio"),
    FRASE_1("frase.1"),
    FRASE_2("frase.2");

    private String val;

    ConfigEnum(String val) {
        this.val = val;
    }

    public String val() {
        return val;
    }
}
