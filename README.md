<style>
.insert { color: #FFFFFF; }
.format { color: #80C0FF; }
.clipbd { color: #FFC080; }
.config { color: #C0C0C0; }
.navsel { color: #B0FFB0; }
.delete { color: #FF8080; }
.cntrl  { color: #FFFFC0; }
td:first-child { font-weight: bold; };
</style>

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
| <span class='format'>Bold</span>   | Ctrl-B          |
| <span class='format'>Italic</span> | Ctrl-I          |
| <span class='format'>U'line</span> | Ctrl-U          |
| <span class='format'>Strike</span> | Ctrl-D          |
| <span class='format'>Code</span>   | Ctrl-P          |
| <span class='insert'>Enter</span>  | `InputConnection.performEditorAction()` |
| <span class='cntrl' >Undo</span>   | Ctrl-Z          |
| <span class='cntrl' >Save</span>   | Ctrl-S          |
| <span class='clipbd'>Cut</span>    | Ctrl-X          |
| <span class='clipbd'>Copy</span>   | Ctrl-C          |
| <span class='clipbd'>Paste</span>  | Ctrl-V          |
| <span class='delete'>Bksp.</span>  | DEL (backspace) |
| <span class='insert'>Date</span>   | Ctrl-J          |
|                                    | None; reserved for future use |
| <span class='navsel'>Home</span>   | MOVE_HOME       |
| <span class='navsel'>Select</span> | Toggles selection mode |
| <span class='navsel'>▲</span>      | DPAD_UP         |
| <span class='delete'>Delete</span> | FORWARD_DEL     |
| <span class='insert'>Space</span>  | SPACE           |
| <span class='config'>Switch</span> | Switches to next available input method if possible, otherwise opens the system IME switcher |
| <span class='navsel'>End</span>    | MOVE_END        |
| <span class='navsel'>◀</span>      | DPAD_LEFT       |
| <span class='navsel'>▼</span>      | DPAD_DOWN       |
| <span class='navsel'>▶</span>      | DPAD_RIGHT      |

## Known Issues

- It was made for a phone in portrait mode, it probably won't look great on a larger device or in landscape mode.
- Hardcoding everything is suboptimal, I should add a configuration screen to change key functions and labels.

## License

Code is copyright by Tyrone C. and made available under the MIT license, the text of which can be found in the LICENSE.md file in this repository.

