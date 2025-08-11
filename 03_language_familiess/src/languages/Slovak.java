package languages;

public class Slovak extends SlavicLanguage {

    public Slovak(){
        super("Slovak", "Slovakia");
    }

    @Override
    public void speak() {
        System.out.println("Ahoj!");
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Writing: Latin";
    }
}
