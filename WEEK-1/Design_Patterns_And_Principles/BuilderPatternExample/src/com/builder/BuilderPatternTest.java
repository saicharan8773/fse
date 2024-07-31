package com.builder;

public class BuilderPatternTest {
    public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("8GB")
                .setStorage("500GB SSD")
                .build();
        System.out.println("Basic Computer:");
        System.out.println("CPU: " + basicComputer.getCPU());
        System.out.println("RAM: " + basicComputer.getRAM());
        System.out.println("Storage: " + basicComputer.getStorage());
        System.out.println("Graphics Card Enabled: " + basicComputer.isGraphicsCardEnabled());
        System.out.println("Bluetooth Enabled: " + basicComputer.isBluetoothEnabled());
        Computer highEndComputer = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("16GB")
                .setStorage("1TB SSD")
                .enableGraphicsCard(true)
                .enableBluetooth(true)
               .build();
        System.out.println("\nHigh-End Computer:");
        System.out.println("CPU: " + highEndComputer.getCPU());
        System.out.println("RAM: " + highEndComputer.getRAM());
        System.out.println("Storage: " + highEndComputer.getStorage());
        System.out.println("Graphics Card Enabled: " + highEndComputer.isGraphicsCardEnabled());
        System.out.println("Bluetooth Enabled: " + highEndComputer.isBluetoothEnabled());
    }
}
