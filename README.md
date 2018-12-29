# Brawlhalla Health HUD v2.0

This is an open-source Java application that can overlay the health of your opponents onto your screen. Since dll injection in Java isn't really a thing, it achieves this by making itself an "always on top" Window and killing explorer.exe. After closing the program, explorer.exe will be returned.

This ia a complete recode over the original Brawlhalla Health HUD (referred to as BHH from here on out), because the original was made very hastily, with an atrocious switch statement to get health from color, using the `getPixelColor` which is extremely slow in Java, and generally not being written with any kind of expandability in mind.

~~Currently this program is actually less optimized than the original, despite how much cleaner the code of this version is.~~ The code runs faster due to the replacement of `getPixelColor`, ~~but it creates and destroys objects for no reason frequently. ~~

If you want a Jar file you can download it here: https://drive.google.com/open?id=1g05o70IrOFJJj06yoT-TkfaIjX973bQm

If you don't want to install Java, you can get a binary that was pre-compiled using Excelsior JET here: http://NOT_COMPILED_YET/