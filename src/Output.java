public class Output implements Runnable
{
    private Books b;
    Output(Books b){
        this.b = b;
    }
    public void run(){
        while (true){
            b.out();
        }
    }
}
