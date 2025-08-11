package languages;

public class SlavicLanguage extends Language {
    protected String familyName = "Slavic";
    public SlavicLanguage(String name, String originCountry) {
        super(name, originCountry);
    }

    @Override
    public void speak() {
        System.out.println("This is a Slavic language.");
    }

    @Override
    public String getInfo(){
        return super.getInfo() + ", Family: " + familyName;
    }
}
