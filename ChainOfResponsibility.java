public class ChainOfResponsibility {
    
    abstract class Link {
        protected Link next;

        abstract boolean handle(String value);

        public Link add(Link nextLink) {
            this.next = nextLink;
            return next;
        }
    }

    public class FooLink extends Link {

        @Override
        boolean handle(String value) {
            
            if (value.equals("foo")) {
                return true;
            } else if (next != null) {
                next.handle(value);
            }
            return false;
        }
    }

    public class BooLink extends Link {

        @Override
        boolean handle(String value) {
            
            if (value.equals("boo")) {
                return true;
            } else if (next != null) {
                next.handle(value);
            }
            return false;
        }
    }
    
}
