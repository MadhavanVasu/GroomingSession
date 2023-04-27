package com.mv.week5.behavioraldesignpatterns.template;





public class MainClass {

    public static void main(String[] args)
    {
        OrderProcessTemplate onlineOrder = new OnlineOrder();
        onlineOrder.processOrder(true);
        System.out.println();
        OrderProcessTemplate storeOrder = new StoreOrder();
        storeOrder.processOrder(true);
    }
}
