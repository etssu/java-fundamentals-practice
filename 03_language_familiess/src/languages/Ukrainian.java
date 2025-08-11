package languages;

public class Ukrainian extends SlavicLanguage{
    public Ukrainian() {
        super("Ukrainian", "Ukraine");
    }

    @Override
    public void speak() {
        System.out.println("Привіт!");
    }
    @Override
    public String getInfo() {
        return super.getInfo() + ", Writing: Cyrillic" ;
    }
}
