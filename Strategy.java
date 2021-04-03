public class Strategy {
    
    public class Poultry {
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

    public class DuckVoice implements Voice {
        @Override
        public void sound() {
            System.out.println("Quack!");
        }
    }

    public class GooseVoice implements Voice {
        @Override
        public void sound() {
            System.out.println("Honk!");
        }
    }

}
