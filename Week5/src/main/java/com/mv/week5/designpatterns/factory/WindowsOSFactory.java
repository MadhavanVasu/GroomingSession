package com.mv.week5.designpatterns.factory;

public class WindowsOSFactory implements OSAbstractFactory {

    private String fileSystem;
    private String shell;

    public WindowsOSFactory(String fileSystem, String shell) {
        this.fileSystem = fileSystem;
        this.shell = shell;
    }

    @Override
    public OperatingSystem createOS() {
        return new Windows(fileSystem, shell);
    }
}
