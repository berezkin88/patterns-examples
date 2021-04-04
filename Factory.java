public class Factory {
    
    interface Pizza { 
        String getTopping();
    }

    class NYPizza implements Pizza {
        String topping = "cheese, pepperoni, onion";

        @Override
        public String getTopping() {
            return this.topping;
        }
    }

    class ChicagoPizza implements Pizza {
        String topping = "cheese, mushrooms, beacon";

        @Override
        public String getTopping() {
            return this.topping;
        }
    }

    abstract class PizzaFactory {
        void serve() {
            Pizza pizza = cook();
            bringOrder(pizza);
        }

        abstract Pizza cook();

        void bringOrder(Pizza pizza) {
            System.out.println("Pizza with " + pizza.getTopping());
        }
    }

    class NYPizzaFactory extends PizzaFactory {

        @Override
        Pizza cook() {
            return new NYPizza();
        }
    }

    class ChicagoPizzaFactory extends PizzaFactory {

        @Override
        Pizza cook() {
            return new ChicagoPizza();
        }
    }
    
}
