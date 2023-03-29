package com.mv.week1.part1.questions;

interface MyInterface {

    public void setStatus(String orderStatus);

}

// Enum can implement interface
enum OrderStatus implements MyInterface {
    DISPATCHED,
    SHIPPED,
    OUT_FOR_DELIVERY,
    DELIVERED;

    String orderStatus;

    @Override
    public void setStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}

// Cannot extend from enum. Causes compilation error
//class A extends OrderStatus{
//
//}


public class EnumExtendAndInterface {

    public static void main(String[] args) {
        OrderStatus delivered = OrderStatus.DELIVERED;
        delivered.setStatus("Package Delivered");
        System.out.println(delivered);
        System.out.println(delivered.orderStatus);

        // ordinal() method returns the position of the enum constant
        for (OrderStatus status : OrderStatus.values())
            System.out.println(status + " " + status.ordinal());
//        DISPATCHED 0
//        SHIPPED 1
//        OUT_FOR_DELIVERY 2
//        DELIVERED 3
    }

}
