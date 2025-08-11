package languages;

public class GermanicLanguage extends Language{
    protected String familyName = "Germanic";

    public GermanicLanguage(String name, String originCountry) {
        super(name, originCountry);
    }

    @Override
    public void speak() {
        System.out.println("This is a Germanic language.");
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Family: " + familyName;
    }
}
