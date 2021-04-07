import java.util.ArrayList;
import java.util.List;

public class Strategy {
    
    public static class Poultry {
        // other fields
        private Voice voice;

        public void makeSomeNoise() {
            voice.sound();
        }
        
        public void setVoice(Voice voice) {
            this.voice = voice;
        }
        // other methods
    }

    public interface Voice {
        void sound();
    }

    public static class DuckVoice implements Voice {
        @Override
        public void sound() {
            System.out.println("Quack!");
        }
    }

    public static class GooseVoice implements Voice {
        @Override
        public void sound() {
            System.out.println("Honk!");
        }
    }

    public static class PoultryDemo {
        static Poultry goose = new Poultry();
        static Poultry duck = new Poultry();

        public static void main(String[] args) {
            goose.setVoice(new GooseVoice());
            duck.setVoice(new DuckVoice());

            List.of(goose, duck)
                .forEach(Poultry::makeSomeNoise);
        }
    }
}
