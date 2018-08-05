public class Input implements Runnable
{
    private Books b;
    Input(Books b){
        this.b = b;
    }
    private boolean isFull = false;
    public void run(){
        while (!isFull)//当还书进程返回数已经满了时结束run方法
        {
            isFull = b.set();
        }
        System.out.println("无需还书");
    }
}
