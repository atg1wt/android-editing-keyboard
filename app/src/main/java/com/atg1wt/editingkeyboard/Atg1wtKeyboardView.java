package com.atg1wt.editingkeyboard;

import android.graphics.Typeface;
import android.inputmethodservice.KeyboardView;
import android.content.Context;
import android.util.AttributeSet;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.inputmethodservice.Keyboard.Key;
import java.util.List;
import android.graphics.RectF;

public class Atg1wtKeyboardView extends KeyboardView {
    Context context;
    private static final String TAG = Atg1wtKeyboardView.class.getSimpleName();
    private Paint paint = new Paint();
    private RectF rect = new RectF(0, 0, 0, 0);

    private static final int KEY_PADDING = 4;
    private static final int KEY_CORNER_RADIUS = 8;
    private static final int KEY_OFFSET = 8;

    private static final int COLOR_INSERT = 0xFFFFFFFF;
    private static final int COLOR_FORMATTING = 0xFF80C0FF;
    private static final int COLOR_CLIPBOARD = 0xFFFFC080;
    private static final int COLOR_SETTINGS = 0xFFC0C0C0;
    private static final int COLOR_NAVIGATION = 0xFFB0FFB0;
    private static final int COLOR_SELECT = 0xFF20FF20;
    private static final int COLOR_DELETE = 0xFFFF8080;
    private static final int COLOR_CONTROL = 0xFFFFFFC0;
    // dark colours get lightened by dev option "force-dark override"
    // so use light colours with low opacity instead
    private static final int BACKGND_NORMAL = 0x33888888;
    private static final int BACKGND_SELECT = 0x3388CC88;
    private static final int BACKGND_PRESSED = 0x55FFFFFF;

    private static final int[] LABEL_COLORS = {
            COLOR_FORMATTING, COLOR_FORMATTING, COLOR_FORMATTING, COLOR_FORMATTING, COLOR_FORMATTING, COLOR_INSERT,
            COLOR_CONTROL, COLOR_CONTROL, COLOR_CLIPBOARD, COLOR_CLIPBOARD, COLOR_CLIPBOARD, COLOR_DELETE,
            COLOR_INSERT, COLOR_SETTINGS, COLOR_NAVIGATION, COLOR_NAVIGATION, COLOR_NAVIGATION, COLOR_DELETE,
            COLOR_INSERT, COLOR_SETTINGS, COLOR_NAVIGATION, COLOR_NAVIGATION, COLOR_NAVIGATION, COLOR_NAVIGATION
    };

    @Override
    public void onDraw(Canvas canvas) {

        if (true) { // make false to use default renderer
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setStrokeWidth(0);
            paint.setStyle(Paint.Style.FILL);

            int index = 0;

            List<Key> keys = getKeyboard().getKeys();
            for (Key key : keys) {
                // calculate key background area
                rect.left = key.x + KEY_PADDING;
                rect.top = key.y + KEY_PADDING + KEY_OFFSET;
                rect.right = key.x + key.width - KEY_PADDING * 2;
                rect.bottom = key.y + key.height + KEY_OFFSET - KEY_PADDING * 2;
                // set key background colour
                if (key.pressed) {
                    paint.setColor(BACKGND_PRESSED);
                } else {
                    if (isShifted() && LABEL_COLORS[index] == COLOR_NAVIGATION) {
                        paint.setColor(BACKGND_SELECT);
                    } else {
                        paint.setColor(BACKGND_NORMAL);
                    }
                }
                // draw key background
                canvas.drawRoundRect(rect, KEY_CORNER_RADIUS, KEY_CORNER_RADIUS, paint);
                // set text size and weight for key label; larger for arrow keys
                // possible alternative: if (key.label.length() > 1 && key.codes.length < 2) {
                if (index == 16 || index >= 21) {
                    paint.setTextSize(60);
                    paint.setTypeface(Typeface.DEFAULT);
                } else {
                    paint.setTextSize(40);
                    paint.setTypeface(Typeface.DEFAULT_BOLD);
                }
                // set colour for key label
                if (isShifted() && LABEL_COLORS[index] == COLOR_NAVIGATION) {
                    paint.setColor(COLOR_SELECT);
                } else {
                    paint.setColor(LABEL_COLORS[index]);
                }
                // draw the key label
                canvas.drawText(key.label.toString(), key.x + (key.width >> 1) - 2, key.y + (key.height + paint.getTextSize()) / 2 - 2, paint);
                index++;
            }
        } else {
            super.onDraw(canvas);
        }
    }

    // at least one constructor required, as constructors aren't inherited
    public Atg1wtKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

}
