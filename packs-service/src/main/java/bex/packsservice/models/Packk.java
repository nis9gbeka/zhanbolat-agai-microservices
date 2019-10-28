package bex.packsservice.models;

public class Packk {

    private String packkId;
    private String[] includes;
    private String packk;
    private String description;

    public Packk(String packkId, String packk) {
        this.packkId = packkId;
        this.packk = packk;
    }

    public Packk(String packkId, String[] includes, String packk, String description) {
        this.packkId = packkId;
        this.includes = includes;
        this.packk = packk;
        this.description = description;
    }

    public String getPackkId() {
        return packkId;
    }

    public void setPackkId(String packkId) {
        this.packkId = packkId;
    }

    public String[] getIncludes() {
        return includes;
    }

    public void setIncludes(String[] includes) {
        this.includes = includes;
    }

    public String getPackk() {
        return packk;
    }

    public void setPackk(String packk) {
        this.packk = packk;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
