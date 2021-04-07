import java.util.List;

public class Adapter {

    interface Cat {
        void meow();
    }

    static class Kitty implements Cat {
        public void meow() {
            System.out.println("Meow!");
        }
    }

    interface Dog {
        void bark();
    }

    static class Hound implements Dog {
        public void bark() {
            System.out.println("Waf-waf!");
        }
    }

    static class CatAdapter implements Dog {

        private Cat cat;

        public CatAdapter(Cat cat) {
            this.cat = cat;
        }

        @Override
        public void bark() {
            cat.meow();
        }
        
    }

    static class Demo {

        public static void main(String[] args) {
            List<Dog> flock = List.of(new Hound(), new CatAdapter(new Kitty()));

            flock.forEach(Dog::bark);
        }
    }
    
}
