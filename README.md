# Android Editing Keyboard

## What It Is

This is a custom Android keyboard with editing and formatting functions, that I put together for personal use back in the days before Google's own Android keyboard had editing keys.
Mostly it works by sending Ctrl-*letter* keystrokes. Some of these are pretty widely recognised (bold, italic, cut & paste, etc), others are peculiar to certain software that I use, so probably won't be much use to anyone else.

![](screenshot.png)

## How To Use It

If for some reason you want to use it as-is:

1. Sideload the `.apk` file from this repo's `dist/` folder.
2. You will get a scary warning about how the developer is unknown and/or the app is unsigned. Are you sure you trust me? Like, *really* sure? If so, then install it anyway.
3. Go to *Settings > System > Languages & Input > On-screen Keyboard > Manage On-screen Keyboards*, or wherever the equivalent setting is in your Android version, and activate *atg1wt Editing Keyboard*.
4. You will get a scary warning about how this keyboard might collect all the text you type, buy you a warehouse full of pink leotards, cause a major rift in time and space, etc. Since you've trusted me this far, hit *OK*.
5. You can switch between this and any other input methods you have installed using the little keyboard icon in the bottom-right corner of the screen, or whatever other keyboard-switching methods your Android version offers.

If you want to play with the source code:

1. Open the project in Android Studio.
2. Play with the source code.
3. Compile and run it on your Android device.
4. Sorry, I'm not here to solve your Android Studio problems (unless you want to pay me, maybe?).
5. Go to *Settings > System > Languages & Input > On-screen Keyboard > Manage On-screen Keyboards*, or wherever the equivalent setting is in your Android version, and activate *atg1wt Editing Keyboard*.
6. You _did_ read all the source to make sure it doesn't do anything terrible, right? Then hit *OK*.
7. You can switch between this and any other input methods you have installed using the little keyboard icon in the bottom-right corner of the screen, or whatever other keyboard-switching methods your Android version offers.

## What the Keys Do

| Key label | Keystrokes performed or action performed |
| --------- | -------------- |
| Bold      | Ctrl-B          |
| Italic    | Ctrl-I          |
| U'line    | Ctrl-U          |
| Strike    | Ctrl-D          |
| Code      | Ctrl-P          |
| Enter     | `InputConnection.performEditorAction()` |
| Undo      | Ctrl-Z          |
| Save      | Ctrl-S          |
| Cut       | Ctrl-X          |
| Copy      | Ctrl-C          |
| Paste     | Ctrl-V          |
| Bksp.     | DEL (backspace) |
| Date      | Ctrl-J          |
|           | None; reserved for future use |
| Home      | MOVE_HOME       |
| Select    | Toggles selection mode |
| ???         | DPAD_UP         |
| Delete    | FORWARD_DEL     |
| Space     | SPACE           |
| Switch    | Switches to next available input method if possible, otherwise opens the system IME switcher |
| End       | MOVE_END        |
| ???         | DPAD_LEFT       |
| ???         | DPAD_DOWN       |
| ???         | DPAD_RIGHT      |

## Known Issues

- It was made for a phone in portrait mode, it probably won't look great on a larger device or in landscape mode.
- Hardcoding everything is suboptimal, I should add a configuration screen to change key functions and labels.

## License

Code is copyright by Tyrone C. and made available under the MIT license, the text of which can be found in the LICENSE.md file in this repository.

