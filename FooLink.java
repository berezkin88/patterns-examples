public class FooLink extends Link {
    @Override
    boolean handle(String value) {

        if (value.equals("boo")) {
            System.out.println("BooLink handling");
            return true;
        } else if (next != null) {
            next.handle(value);
        }
        return false;
    }
}
