package com.atg1wt.editingkeyboard;

import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.util.Log;

public class Atg1wtKeyboard extends Keyboard {

    public Atg1wtKeyboard(Context context, int xmlLayoutResId) {
        super(context, xmlLayoutResId);
    }

    private static final String TAG = Atg1wtKeyboardView.class.getSimpleName();

    @Override
    public int[] getNearestKeys(int x, int y) {
        Log.d(TAG,"getNearestKeys");
        return super.getNearestKeys(x,y);
    }

    static class Atg1wtKey extends Keyboard.Key {

        public Atg1wtKey(Keyboard.Row parent) {
            super(parent);
        }

        @Override
        public boolean isInside(int x, int y) {
            y = y - 10;
            Log.d(TAG,"isInside");
            return super.isInside(x, y);
        }

        @Override
        public int squaredDistanceFrom(int x, int y) {
            Log.d(TAG,"squaredDistanceFrom");
            return super.squaredDistanceFrom(x, y);
        }

        @Override
        public void onPressed() {
            Log.d(TAG,"onPressed");
            super.onPressed();
        }

    }

}
