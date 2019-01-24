# Brawlhalla Health HUD v2.0

This is an open-source Java application that can overlay the health of your opponents onto your screen. Since dll injection in Java isn't really a thing, it achieves this by making itself an "always on top" window, and tricking windows into thinking a fullscreen application is on the top.

This ia a complete recode over the original Brawlhalla Health HUD (referred to as BHH from here on out), because the original was made very hastily, with an atrocious switch statement to get health from color, using the `getPixelColor` which is extremely slow in Java, and generally not being written with any kind of expandability in mind.

this version runs faster due to the replacement of `getPixelColor`, (now less than 100MB at all times, less than 1% CPU on most machines) is coded much cleaner, has a nicer UI, and has native builds (compiled with Excelsior JET).

![picture](img/1s.png)

![picture](img/2s.png)

**How to use**

1. Download the Java version if you have Java, or the native version if you don't. (the difference between them is minimal)
2. Extract the zip, or put the jar in a folder somewhere
3. Open it
4. Press F2 to close it.


***this program may not work if Brawlhalla is in windowed mode.***


#[All-downloads](https://bitbucket.org/BFCEHF/brawlhalla-health-hud-v2.0/downloads/)

#[Java-Download](https://bitbucket.org/BFCEHF/brawlhalla-health-hud-v2.0/downloads/BHH2.jar)

#[Native-download](https://bitbucket.org/BFCEHF/brawlhalla-health-hud-v2.0/downloads/BHH2-native.7z)


#Contributions

[kristian](https://github.com/kristian) for [system-hook](https://github.com/kristian/system-hook)
