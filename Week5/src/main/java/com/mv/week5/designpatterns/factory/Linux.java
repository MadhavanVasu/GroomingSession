package com.mv.week5.designpatterns.factory;

import java.nio.file.FileSystem;

public class Linux implements OperatingSystem {

    private String fileSystem;
    private String shell;

    public Linux(String fileSystem, String shell) {
        this.fileSystem = fileSystem;
        this.shell = shell;
    }


    @Override
    public void printFeatures() {
        System.out.println("Linux OS");
        System.out.println("FileSystem : " + fileSystem);
        System.out.println("Shell : " + shell);
    }
}
