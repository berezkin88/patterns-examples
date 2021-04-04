public class Adapter {

    interface Cat {
        void meow();
    }

    class Kitty implements Cat {
        public void meow() {
            System.out.println("Meow!");
        }
    }

    interface Dog {
        void bark();
    }

    class Hound implements Dog {
        public void bark() {
            System.out.println("Waf-waf!");
        }
    }

    class CatAdapter implements Dog {

        private Cat cat;

        public void setCat(Cat cat) {
            this.cat = cat;
        }

        @Override
        public void bark() {
            cat.meow();
        }
        
    }
    
}
