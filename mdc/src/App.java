import entities.MDC;

public class App {
    public static void main(String[] args) {
        
        MDC mdc1 = new MDC(20, 6);
        MDC mdc2 = new MDC(6, 20);
        System.out.println(mdc1.getMDC(20, 6));
        System.out.println(mdc1.getMDC(6, 20));
        System.out.println(mdc1.getMDC());
        System.out.println(mdc2.getMDC());
    }
}
