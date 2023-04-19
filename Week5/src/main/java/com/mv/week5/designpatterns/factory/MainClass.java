package com.mv.week5.designpatterns.factory;

public class MainClass {

    public static void main(String[] args) {
        OperatingSystem os1 = new OSFactory().getOperatingSystem(new WindowsOSFactory("NTFS", "cmd"));
        os1.printFeatures();
        System.out.println();
        OperatingSystem os2 = new OSFactory().getOperatingSystem(new LinuxOSFactory("ext", "bash"));
        os2.printFeatures();
    }

}
