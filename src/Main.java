public class Main {
    public static void main(String[] args) {
        Books b = new Books();
        Input in = new Input(b);
        Output out = new Output(b);
        Thread t0 = new Thread(in);
        Thread t1 = new Thread(out);
        t1.start();
        t0.start();

    }
}
