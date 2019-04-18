package observer;

import java.util.Observable;
import java.util.Observer;

public class ObserverDemo implements Observer{
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("----update---"+o+"  "+arg);
        System.out.println(Thread.currentThread().getName()+" "+o.getClass().getName());
        System.out.println(arg);
    }
}
