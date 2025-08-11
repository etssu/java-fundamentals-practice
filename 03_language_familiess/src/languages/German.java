package languages;

public class German extends GermanicLanguage {
    public German(){
        super("German", "Germany");
    }

    @Override
    public void speak() {
        System.out.println("Hallo!");
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Writing system: Latin";
    }
}
