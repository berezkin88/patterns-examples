public class ChainOfResponsibility {

    static abstract class Link {
        protected Link next;

        abstract boolean handle(String value);

        public Link add(Link nextLink) {
            this.next = nextLink;
            return this;
        }
    }

    public static class FooLink extends Link {

        @Override
        boolean handle(String value) {

            if (value.equals("foo")) {
                System.out.println("FooLink handling");
                return true;
            } else if (next != null) {
                System.out.println("Passing to next handler");
                return next.handle(value);
            }
            System.out.println("No more handlers");
            return false;
        }
    }

    public static class BooLink extends Link {

        @Override
        boolean handle(String value) {

            if (value.equals("boo")) {
                System.out.println("BooLink handling");
                return true;
            } else if (next != null) {
                System.out.println("Passing to next handler");
                return next.handle(value);
            }
            System.out.println("No more handlers");
            return false;
        }
    }

    static class Demo {
        public static void main(String[] args) {
            Link links = new BooLink().add(new FooLink());

            links.handle("foo");
            links.handle("boo");
            links.handle("fooboo");
        }
    }
}
