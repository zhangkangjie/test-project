package spi.service;

/**
 * @author kangjie.zhang
 * @date 2021/5/28 14:08
 */
public class SpiServiceA implements SpiService {
    @Override
    public String service(String name) {
        return name+",welcome to use service A";
    }
}
