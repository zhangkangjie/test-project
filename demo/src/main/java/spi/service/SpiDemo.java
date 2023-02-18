package spi.service;


import java.util.ServiceLoader;

/**
 * @author kangjie.zhang
 * @date 2021/5/28 14:09
 */
public class SpiDemo {

    public static void main(String[] args) {
        ServiceLoader<SpiService> services = ServiceLoader.load(SpiService.class);

        for (SpiService spiService : services) {
            String service = spiService.service("tom");
            System.out.println(service);
        }


    }
}
