import languages.*;

public class Main {
    public static void main(String[] args) {
        Language german = new German();
        Language slovak = new Slovak();
        Language ukrainian = new Ukrainian();
        Language swedish = new Swedish();

        Language[] languages = {german, slovak, ukrainian, swedish};

        for (Language language : languages) {
            language.speak(); // overridden greetings
            System.out.println(language.getInfo());
            System.out.println();
        }
    }
}