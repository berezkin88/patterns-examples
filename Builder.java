public class Builder {

    static class Pizza {
        private String dough = "";
        private String sauce = "";
        private String topping = "";
    
        public void setDough(String dough) {
            this.dough = dough;
        }
    
        public void setSauce(String sauce) {
            this.sauce = sauce;
        }
    
        public void setTopping(String topping) {
            this.topping = topping;
        }

        @Override
        public String toString() {
            return "Pizza{" +
                "dough='" + dough + '\'' +
                ", sauce='" + sauce + '\'' +
                ", topping='" + topping + '\'' +
                '}';
        }
    }
    
    abstract static class PizzaBuilder {
        protected Pizza pizza;
    
        public Pizza getPizza() {
            return pizza;
        }
    
        public void createNewPizzaProduct() {
            pizza = new Pizza();
        }
    
        public abstract void buildDough();
        public abstract void buildSauce();
        public abstract void buildTopping();
    }
    
    static class SpicyPizzaBuilder extends PizzaBuilder {
        public void buildDough() {
            pizza.setDough("pan baked");
        }
    
        public void buildSauce() {
            pizza.setSauce("hot");
        }
    
        public void buildTopping() {
            pizza.setTopping("pepperoni+salami");
        }
    }
    
    static class Waiter {
        private static PizzaBuilder pizzaBuilder;
    
        public void setPizzaBuilder(PizzaBuilder pb) {
            pizzaBuilder = pb;
        }
    
        public Pizza getPizza() {
            constructPizza();
            return pizzaBuilder.getPizza();
        }
    
        private static void constructPizza() {
            pizzaBuilder.createNewPizzaProduct();
            pizzaBuilder.buildDough();
            pizzaBuilder.buildSauce();
            pizzaBuilder.buildTopping();
        }
    }

    public static class Demo {

        public static void main(String[] args) {
            Waiter waiter = new Waiter();
            waiter.setPizzaBuilder(new SpicyPizzaBuilder());

            System.out.println(waiter.getPizza());
        }
    }
}

