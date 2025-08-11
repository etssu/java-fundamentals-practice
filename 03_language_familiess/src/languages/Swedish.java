package languages;

public class Swedish extends GermanicLanguage {
    public Swedish(){
        super("Sweden", "Sweden");
    }

    @Override
    public void speak() {
        System.out.println("Hej hej!");
    }

    @Override
    public String getInfo(){
        return super.getInfo() + ", Writing system: Latin";
    }
}
