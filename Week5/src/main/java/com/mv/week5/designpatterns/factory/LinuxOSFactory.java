package com.mv.week5.designpatterns.factory;

public class LinuxOSFactory implements OSAbstractFactory {

    private String fileSystem;
    private String shell;

    public LinuxOSFactory(String fileSystem, String shell) {
        this.fileSystem = fileSystem;
        this.shell = shell;
    }

    @Override
    public OperatingSystem createOS() {
        return new Linux(fileSystem, shell);
    }
}
