public class BooLink extends Link {

    @Override
    boolean handle(String value) {

        if (value.equals("foo")) {
            System.out.println("FooLink handling");
            return true;
        } else if (next != null) {
            next.handle(value);
        }
        return false;
    }
}
