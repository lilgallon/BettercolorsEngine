<h3 align="center">
  <img src=".github/header_engine.png">
</h3>

<p align="center">
  <a href="https://img.shields.io/github/release/n3roo/bettercolorsengine.svg"><img alt="Release" src="https://img.shields.io/github/release/n3roo/bettercolorsengine.svg"/></a>
    <a href="https://img.shields.io/github/issues/n3roo/bettercolorsengine.svg"><img alt="Open issues" src="https://img.shields.io/github/issues/n3roo/bettercolorsengine.svg"/></a>
    <a href="https://img.shields.io/github/workflow/status/N3ROO/BettercolorsEngine/Build"><img alt="Build Status" src="https://img.shields.io/github/workflow/status/N3ROO/BettercolorsEngine/Build" /></a>
</p>

A hacking engine that does the annoying part for you. Designed to work with independently of forge and fabric.
This engine is the one used by the mod [Bettercolors](https://github.com/N3ROO/Bettercolors).

## Support

The engine takes into account the MC input design change of 1.13 and above (glfw vs vk), and works with **all versions of MC** (at least from 1.8.9 to 1.16.2). And should
work with future versions of Minecraft.

## Why?

With that engine, the only thing that you need to do is to implement your modules (aimbot, autoclick, whatever). Then, the rest
is handled by the engine (window, parameters, file saving, version checking, and so on).

Here is what the automatically generated window looks like:

<p align="center">
    <img alt="features" src="https://raw.githubusercontent.com/N3ROO/BettercolorsEngine/master/.github/features_main_crop500.png" />
</p>

## How to use it

- Download the files ([release page](https://github.com/N3ROO/BettercolorsEngine/releases)) and move them in your project
- Here is an example on how you could use the engine:
```java
void yourInitFunction() {
    engine = new BettercolorsEngine();
    engine.init(modules...);
}

void onRender() {
    engine.update();
}

void onKeyPress(k) {
    engine.keyEvent(k.code, k.pressed);
}
```
- Also the [material UI swing](https://github.com/atarw/material-ui-swing) library is needed.
Add these lines to the `build.gradle` file:
```gradle
configurations {
    // ... your stuff if you have something already

    // It defines a new configurration called inJar that we will use later on
    // compile is needed so that the library is recognized by the IDE
	inJar
	compile.extendsFrom inJar
}

dependencies {
    // ... your stuff if you have something already

    // The library with the inJar configuration that we created previously
	inJar "io.github.vincenzopalazzo:material-ui-swing:1.1.1"
}

jar {
    // ... your stuff if you have something already

    // It will extract all the libraries needed for inJar to be working in the root of the .jar
    from {
        configurations.inJar.collect {
            it.isDirectory() ? it : zipTree(it)
        }
    }
}
```

Real examples:
- [Bettercolors 7+ for Forge 1.8.9](https://github.com/N3ROO/Bettercolors/tree/MC_1.8.9)
- [Bettercolors 7+ for Forge 1.16.1](https://github.com/N3ROO/Bettercolors/tree/MC_1.16.1)
- [Bettercolors 7+ for Fabric 1.16.2](https://github.com/N3ROO/Bettercolors/tree/MC_1.16.2_fabric)

## Documentation

*Coming for the first stable release*.
Check [github projects](https://github.com/N3ROO/BettercolorsEngine/projects) to see the roadmap.

## Credits & Acknowledgements

- [@N3ROO](https://github.com/N3ROO) - *Main developer*
- [@shorebre4k](https://github.com/shorebre4k) - *Keymap utility class*
