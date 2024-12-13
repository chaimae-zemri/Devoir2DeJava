package org.example.devoirdejava;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Object mutex= new Object();
        List<Order> Orders = new ArrayList<>();
        Insert2OrdersListThread thread = new Insert2OrdersListThread(mutex, Orders);
        ReadFromOrderListThread thread2 = new ReadFromOrderListThread(mutex, Orders);
        thread.start();
        thread2.start();
    }
}