package com.app.fut;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutService {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        try {
            Future submit = service.submit(new GetOrderTask());
            Order order = (Order) submit.get();
            Future<Order> submit1 = service.submit(enrichTask(order));
            order = submit1.get();
            Future<Order> submit2 = service.submit(performPaymentTask(order));
            order = submit2.get();
            Future<Order> submit3 = service.submit(dispatchOrderTask(order));
            order = submit3.get();
            Future<Order> submit4 = service.submit(sendEmailTask(order));
            order = submit4.get();
        } catch (Exception e) {

        }

        CompletableFuture.supplyAsync(() -> getOrderTask())
                .thenApply(newOrder -> enrichTask(newOrder));
    }

    public static Order getOrderTask() {
        try {
            return new GetOrderTask().call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static EnrichTask enrichTask(Order order) {
        return new EnrichTask();
    }

    public static PerformPaymentTask performPaymentTask(Order order) {
        return new PerformPaymentTask();
    }

    public static DispatchOrderTask dispatchOrderTask(Order order) {
        return new DispatchOrderTask();
    }

    public static SendEmailTask sendEmailTask(Order order) {
        return new SendEmailTask();
    }
}
