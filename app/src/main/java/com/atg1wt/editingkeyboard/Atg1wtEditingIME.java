package com.atg1wt.editingkeyboard;

import android.content.Context;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.KeyboardView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.os.IBinder;
import android.app.Dialog;
import android.view.Window;
import android.util.Log;

public class Atg1wtEditingIME extends InputMethodService
    implements KeyboardView.OnKeyboardActionListener {

    private Atg1wtKeyboardView kbview;
    private Atg1wtKeyboard kbrd;

    private boolean shift = false;

    private int action;

    private static final String TAG = Atg1wtEditingIME.class.getSimpleName();

    private IBinder getToken() {
        final Dialog dialog = getWindow();
        if (dialog == null) {
            return null;
        }
        final Window window = dialog.getWindow();
        if (window == null) {
            return null;
        }
        return window.getAttributes().token;
    }

    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        InputMethodManager imm;
        InputConnection ic = getCurrentInputConnection();
        Log.d(TAG,"onKey:" + primaryCode);
        long now = System.currentTimeMillis();
        int shiftmeta;
        if (shift) shiftmeta = KeyEvent.META_SHIFT_ON | KeyEvent.META_SHIFT_LEFT_ON; else shiftmeta = 0;
        // TODO: why only keydown events, not keyup?
        switch(primaryCode){
            case 50011: //bold = Ctrl-B
                ic.sendKeyEvent(new KeyEvent(now, now, KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_B, 0, KeyEvent.META_CTRL_ON | KeyEvent.META_CTRL_LEFT_ON, 0, 0, KeyEvent.FLAG_SOFT_KEYBOARD));
                break;
            case 50012: //italic = Ctrl-I
                ic.sendKeyEvent(new KeyEvent(now, now, KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_I, 0, KeyEvent.META_CTRL_ON | KeyEvent.META_CTRL_LEFT_ON, 0, 0, KeyEvent.FLAG_SOFT_KEYBOARD));
                break;
            case 50013: //underline = Ctrl-U
                ic.sendKeyEvent(new KeyEvent(now, now, KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_U, 0, KeyEvent.META_CTRL_ON | KeyEvent.META_CTRL_LEFT_ON, 0, 0, KeyEvent.FLAG_SOFT_KEYBOARD));
                break;
            case 50014: //strike = Ctrl-D
                ic.sendKeyEvent(new KeyEvent(now, now, KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_D, 0, KeyEvent.META_CTRL_ON | KeyEvent.META_CTRL_LEFT_ON, 0, 0, KeyEvent.FLAG_SOFT_KEYBOARD));
                break;
            case 50015: //code = Ctrl-P
                ic.sendKeyEvent(new KeyEvent(now, now, KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_P, 0, KeyEvent.META_CTRL_ON | KeyEvent.META_CTRL_LEFT_ON, 0, 0, KeyEvent.FLAG_SOFT_KEYBOARD));
                break;
            case 50016: //enter
                // TODO: see alternative handling examples at https://www.programcreek.com/java-api-examples/?class=android.view.inputmethod.InputConnection&method=performEditorAction
                ic.performEditorAction(action);
                break;
            case 50021: //undo = Ctrl-Z
                ic.sendKeyEvent(new KeyEvent(now, now, KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_Z, 0, KeyEvent.META_CTRL_ON | KeyEvent.META_CTRL_LEFT_ON, 0, 0, KeyEvent.FLAG_SOFT_KEYBOARD));
                break;
            case 50022: //save = Ctrl-S
                ic.sendKeyEvent(new KeyEvent(now, now, KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_S, 0, KeyEvent.META_CTRL_ON | KeyEvent.META_CTRL_LEFT_ON, 0, 0, KeyEvent.FLAG_SOFT_KEYBOARD));
                break;
            case 50023: //cut = Ctrl-X
                ic.sendKeyEvent(new KeyEvent(now, now, KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_X, 0, KeyEvent.META_CTRL_ON | KeyEvent.META_CTRL_LEFT_ON, 0, 0, KeyEvent.FLAG_SOFT_KEYBOARD));
                break;
            case 50024: //copy = Ctrl-C
                ic.sendKeyEvent(new KeyEvent(now, now, KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_C, 0, KeyEvent.META_CTRL_ON | KeyEvent.META_CTRL_LEFT_ON, 0, 0, KeyEvent.FLAG_SOFT_KEYBOARD));
                break;
            case 50025: ///paste = Ctrl-V
                ic.sendKeyEvent(new KeyEvent(now, now, KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_V, 0, KeyEvent.META_CTRL_ON | KeyEvent.META_CTRL_LEFT_ON, 0, 0, KeyEvent.FLAG_SOFT_KEYBOARD));
                break;
            case 50026: //delete left (backspace)
                ic.sendKeyEvent(new KeyEvent(now, now, KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL, 0, 0, 0, 0, KeyEvent.FLAG_SOFT_KEYBOARD));
                break;
            case 50031: //datestamp = Ctrl-J
                ic.sendKeyEvent(new KeyEvent(now, now, KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_J, 0, KeyEvent.META_CTRL_ON | KeyEvent.META_CTRL_LEFT_ON, 0, 0, KeyEvent.FLAG_SOFT_KEYBOARD));
                break;
            case 50032: //reserved for future use!
                break;
            case 50033: //home
                ic.sendKeyEvent(new KeyEvent(now, now, KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MOVE_HOME, 0, shiftmeta, 0, 0, KeyEvent.FLAG_SOFT_KEYBOARD));
                break;
            case -1: //select
                shift = !shift;
                kbrd.setShifted(shift);
                kbview.invalidateAllKeys();
                break;
            case 50035: //up
                ic.sendKeyEvent(new KeyEvent(now, now, KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_UP, 0, shiftmeta, 0, 0, KeyEvent.FLAG_SOFT_KEYBOARD));
                break;
            case 50036: //delete right
                ic.sendKeyEvent(new KeyEvent(now, now, KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_FORWARD_DEL, 0, 0, 0, 0, KeyEvent.FLAG_SOFT_KEYBOARD));
                break;
            case 50041: //space
                ic.sendKeyEvent(new KeyEvent(now, now, KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_SPACE, 0, 0, 0, 0, KeyEvent.FLAG_SOFT_KEYBOARD));
                break;
            case 50042: //switch ime
                imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                IBinder token = getToken();
                if (android.os.Build.VERSION.SDK_INT >= 19) {
                    if (imm.shouldOfferSwitchingToNextInputMethod(token)) {
                        imm.switchToNextInputMethod(token, false);
                    } else {
                        imm.showInputMethodPicker();
                    }
                } else {
                    imm.showInputMethodPicker();
                }
                break;
            case 50043: //end
                ic.sendKeyEvent(new KeyEvent(now, now, KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MOVE_END, 0, shiftmeta, 0, 0, KeyEvent.FLAG_SOFT_KEYBOARD));
                break;
            case 50044: //left
                ic.sendKeyEvent(new KeyEvent(now, now, KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_LEFT, 0, shiftmeta, 0, 0, KeyEvent.FLAG_SOFT_KEYBOARD));
                break;
            case 50045: //down
                ic.sendKeyEvent(new KeyEvent(now, now, KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_DOWN, 0, shiftmeta, 0, 0, KeyEvent.FLAG_SOFT_KEYBOARD));
                break;
            case 50046: //right
                ic.sendKeyEvent(new KeyEvent(now, now, KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_RIGHT, 0, shiftmeta, 0, 0, KeyEvent.FLAG_SOFT_KEYBOARD));
                break;
            default:
                Log.d(TAG,"Default fallthrough");
                char code = (char)primaryCode;
                ic.commitText(String.valueOf(code),1);
        }
    }

    @Override
    public void onPress(int primaryCode) {
    }

    @Override
    public void onRelease(int primaryCode) {
    }

    @Override
    public void onText(CharSequence text) {
    }

    @Override
    public void swipeDown() {
    }

    @Override
    public void swipeLeft() {
    }

    @Override
    public void swipeRight() {
    }

    @Override
    public void swipeUp() {
    }

    @Override
    public View onCreateInputView() {
        kbview = (Atg1wtKeyboardView)getLayoutInflater().inflate(R.layout.keyboard, null);
        kbrd = new Atg1wtKeyboard(this, R.xml.buttons);
        kbview.setOnKeyboardActionListener(this);
        kbview.setKeyboard(kbrd);
        kbview.setPreviewEnabled(false);
        return kbview;
    }

    @Override
    public void onStartInputView(EditorInfo edinfo, boolean restarting) {
        action = edinfo.actionId;
    }

}
