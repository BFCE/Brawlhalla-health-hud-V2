# Brawlhalla Health HUD v2.0

## Use Java 8 or older for optimal experience (newer versions still work but slower)

This is an open-source Java application that can overlay the health of your opponents onto your screen. Since dll injection in Java isn't really a thing, it achieves this by making itself an "always on top" window, and tricking windows into thinking a fullscreen application is on the top.

this version runs faster due to the replacement of `getPixelColor`, (now less than 100MB at all times, less than 1% CPU on most machines) is coded much cleaner, and has a nicer UI.

![picture](img/1s.png)

![picture](img/2s.png)

## BHH now also supports a Smash bros inspired UI mode

![picture](img/s1s.png)

![picture](img/s2s.png)

**How to use**

1. Download Java
2. Put the jar in a folder somewhere
3. Open it
4. Press F2 to close it.

## Keybinds
* F2 - close
* SHIFT+CTRL+ALT - move health window with mouse

## Linux and MacOS Compatibility
System-hook doesn't provide binaries for the system-hook's native. You can compile them yourself, or use systemhook=0 as a launch argument (will prevent keybinds from working)

> java -jar BHH24.jar systemhook=0

***this program may not work if Brawlhalla is in windowed mode.***

# Contributions

[kristian](https://github.com/kristian) for [system-hook](https://github.com/kristian/system-hook)

[Sasjo](https://github.com/sasjo/) for [multiline](https://github.com/sasjo/multiline) 
