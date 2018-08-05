import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Books {

    private int count = 1;//书的数量
    private boolean flag = false;//判断是否有进程在操作的标记变量
    private boolean isFull = false;//库存是否
    private int runN = 0;

    Lock lock = new ReentrantLock();
    Condition set_con = lock.newCondition();
    Condition out_con = lock.newCondition();

    public boolean set(){
        lock.lock();
        try{
             while (count>=3){
              isFull = true;
              return isFull;
           }
            count++;
            runN++;
             System.out.println("还书线程"+Thread.currentThread().getName()+"图书剩余："+count+"本");
            out_con.signal();
            if(runN<5)
                set_con.await();
        }catch (InterruptedException e){}
        finally {
            lock.unlock();
            while (runN > 10)
            {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }
        return isFull;
    }
    public void out(){
        lock.lock();
        try{
            while (count<=0){
                try{
                    System.out.println("暂时无书本可以借出");
                    out_con.await();
                }catch (InterruptedException e){}
            }
            count--;
            System.out.println("借书线程"+Thread.currentThread().getName()+"图书剩余："+count+"本");
            set_con.signal();
        }finally {
            lock.unlock();
        }
    }

}
