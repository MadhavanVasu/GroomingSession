package com.mv.week5.designpatterns.factory;

public class Windows implements OperatingSystem {

    private String fileSystem;
    private String shell;

    public Windows(String fileSystem, String shell) {
        this.fileSystem = fileSystem;
        this.shell = shell;
    }

    @Override
    public void printFeatures() {
        System.out.println("Windows OS");
        System.out.println("FileSystem : " + fileSystem);
        System.out.println("Shell : " + shell);
    }
}
