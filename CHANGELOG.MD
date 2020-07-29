**Version 0.1.0**

The engine is designed to work with any forge version: at least from 1.8.9 to 1.16, but it should work with the rest (not tested yet).

Since it's the first version, here is what you need to do to make a hack mod:
1. Create the main class to register your mod with forge
2. Start the engine by giving some information about your mod and the modules that you created
3. Write some modules by extending the Module class
4. That's it. The engine is designed to work for any forge version from 1.8.9 to 1.16.2

Core:
- The modules are automatically created when the engine starts - *you just have to pass the modules' classes to the engine, and it will do everything for you*
- The window is automatically created according to the modules loaded and their settings - *the user can update the modules' settings through that window. He can also see what's hapening with the window's console*
- The settings are automatically saved on startup and when a change occurs - *that way everything is saved, and you don't have to do anything*

Window:
- The window is synchronized with the settings
- It is possible to use different settings file (there is a settings selector in that window)
- You can change the default key to toggle the window and the user can also change it
- You can log some stuff in the console, and the user will see it in the window
- The user knows when there is an update thanks to the update checker

Utility:
- `KeysManager` Keys are handled automatically, and you can use the class to check if a key is pressed or not
- `isInSameTeam` That method is available to modules to compare the given entity with the player and returns if they're in the same team
- `isInGui` That method is available to modules and returns true whether the player is in a GUI
- `KEY_HANDLER` That field is available to module to know if the user is attacking or using an item (it takes the key the user binded to attack and use)

**Version 0.2.0**

The engine takes into account the forge design change in 1.13 and above, and works with all versions of Forge (at least from 1.8.9 to 1.16.1)

**Version 0.3.0**
- Added a friend list fully integrated with the GUI (you can use the Friends utility class)
- Updated material UI from 1.1.1-beta to 1.1.1-rc4 (5 big updates). Fixes a lot of alignment issues.
- Added accessors to the main engine class
- Added a ValueFloatOption class that defines a floating point slider (same as ValueOption, but for decimal numbers)
- Added a lot of logging message during engine's startup. Also improved the way to log messages to the console
- Better config file loader: it automatically updates the config file with the missing fields if there're any. It will prevent weird crashes that are complicated to understand for the user
- Added an utility function to Window class to show a dialog window (Window#dialog)