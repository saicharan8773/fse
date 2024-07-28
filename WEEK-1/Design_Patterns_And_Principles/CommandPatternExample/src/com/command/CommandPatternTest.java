package com.command;

public class CommandPatternTest {
    public static void main(String[] args) {
        // Create the receiver
        Light livingRoomLight = new Light();

        // Create commands
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        // Create invoker
        RemoteControl remote = new RemoteControl();

        // Turn on the light
        remote.setCommand(lightOn);
        remote.pressButton();

        // Turn off the light
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
