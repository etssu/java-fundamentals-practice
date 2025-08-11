package languages;

public abstract class Language {
    protected String name;
    protected String originCountry;

    public Language(String name, String originCountry) {
        this.name = name;
        this.originCountry = originCountry;
    }

    public abstract void speak();

    public String getInfo() {
        return "Language: " + name + ", Origin: " + originCountry;
    }
}
