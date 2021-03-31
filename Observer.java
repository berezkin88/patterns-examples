import java.util.ArrayList;
import java.util.List;

public class Observer {

    public interface Publisher {
        void subscribe(Subscriber subscriber);
        void unsubscribe(Subscriber subscriber);
        void notify(String value);
    }

    public interface Subscriber {
        void update(String value);
    }
    
    public static class PublisherImpl implements Publisher {

        private List<Subscriber> subscribers = new ArrayList<>();

        @Override
        public void subscribe(Subscriber subscriber) {
            subscribers.add(subscriber);
        }

        @Override
        public void unsubscribe(Subscriber subscriber) {
            subscribers.remove(subscriber);
        }

        @Override
        public void notify(String value) {
            subscribers.forEach(sub -> sub.update(value));
        }
        
    }

    public static class SilentSubscriber implements Subscriber {

        @Override
        public void update(String value) {
            System.out.println("Shh!!! I've been notified with " + value);
        }
        
    }

    public static class LoudSubscriber implements Subscriber {

        @Override
        public void update(String value) {
            System.out.println("HEY!!! I'VE GOT A NOTIFICATION: " + value);
        }
        
    }

    public static void main(String[] args) {
        Publisher publisher = new PublisherImpl();

        Subscriber silent = new SilentSubscriber();
        Subscriber loud = new LoudSubscriber();

        publisher.subscribe(silent);
        publisher.subscribe(loud);

        publisher.notify("Message");
    }
}
