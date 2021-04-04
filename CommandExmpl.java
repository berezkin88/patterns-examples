public class CommandExmpl {
    
    interface Command {
        void execute();
    }

    class CreateConsentCommand implements Command {

        @Override
        public void execute() {
            // do some stuff
        }
    }

    class StartAuthorizationCommand implements Command {

        @Override
        public void execute() {
            // do some stuff
        }
    }

    // other Commands

    class Flow {
        Command createConsent = new CreateConsentCommand();
        Command startAuth = new StartAuthorizationCommand();
        // other commands

        public void performFlow() {
            createConsent.execute();
            startAuth.execute();
            // etc.
        }
    }
    
}
