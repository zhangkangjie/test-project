package observer;


import java.util.Observable;

public class ObserverableDemo extends Observable {

    public ObserverableDemo(){
        //添加观察者
        this.addObserver(new ObserverDemo());
    }

    void doSomething(){
        this.setChanged();
        //通知观察者，观察者执行update 这一过程是同步的，即在一个线程中执行的
        this.notifyObservers("do something ");//clearChanged
    }



}
class DemoTest{
    public static void main(String[] args) throws InterruptedException {
        ObserverableDemo observerable = new ObserverableDemo();

        observerable.doSomething();
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+" hasChanged:"+observerable.hasChanged());
        observerable.notifyObservers("do something 2 ");
    }

}
