# BoockManagement<br>
## 功能描述<br>
### Books类<br>
#####   实现了书的借入借出操作，并两个操作都配备监视器。成员变量包括书的数量，库存是否满的标记变量，一个锁对象，对应两个监视器对象。方法：还书set()；借书out()<br>
### Input类<br>
#####   实现Runnable接口，接收一个Books类，执行Books类的set方法，根据set的返回值决定run方法结束<br>
### Output类<br>
#####   实现Runnable接口，接收一个Books类，执行Books类的out方法<br>
### Main类<br>
#####   实例化Books类对象，实例化Input对象，实例化Output对象,开启线程