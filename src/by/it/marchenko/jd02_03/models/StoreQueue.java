package by.it.marchenko.jd02_03.models;

import by.it.marchenko.jd02_03.interfaces.StoreQueueAction;

import java.util.ArrayDeque;
import java.util.Queue;

import static by.it.marchenko.jd02_03.constants.StoreConstant.*;

public class StoreQueue implements StoreQueueAction {
    private final Queue<Customer> storeQueue;

    public StoreQueue() {
        this.storeQueue = new ArrayDeque<>();
    }

    @Override
    public int getSize() {
        synchronized (storeQueue) {
            return storeQueue.size();
        }
    }

    @Override
    public boolean add(Customer customer) {
        synchronized (storeQueue) {
            return storeQueue.add(customer);
        }
    }

    @Override
    public Customer remove() {
        synchronized (storeQueue) {
            return storeQueue.poll();
        }
    }

    @Override
    public int calcExpectedCashierCount(boolean mode) {
        synchronized (storeQueue) {
            int expectedCashierCount = (int) Math.ceil(storeQueue.size() / (double) CUSTOMER_PER_CASHIER);
            return mode ?
                    DEFAULT_CASHIER_COUNT :
                    Math.min(expectedCashierCount, MAX_CASHIER_COUNT);
        }
    }
}
