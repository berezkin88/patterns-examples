class Decorator {

    public interface Printer {
        void print(String value);
    }
    
    public static class PrinterImpl implements Printer {
    
        @Override
        public void print(String value) {
            System.out.println(value);
        }
        
    }
    
    public static class PrinterDecorator implements Printer {
    
        private Printer wrappee;
    
        public PrinterDecorator(Printer executor) {
            this.wrappee = executor;
        }
    
        @Override
        public void print(String value) {
            wrappee.print(value);
        }
    }
    
    public static class UppercaseDecorator extends PrinterDecorator {
    
        public UppercaseDecorator(Printer executor) {
            super(executor);
        }
    
        private String toUpper(String value) {
            return value.toUpperCase();
        }
    
        @Override
        public void print(String value) {
            super.print(toUpper(value));
        }
    }

    public static void main(String[] args) {
        Printer uppercase = new UppercaseDecorator(new PrinterImpl());

        uppercase.print("uppercase");
    }

}

