package com.app.fut;

import java.util.concurrent.Callable;

public class GetOrderTask implements Callable {
    @Override
    public Order call() throws Exception {
        return new Order();
    }
}
