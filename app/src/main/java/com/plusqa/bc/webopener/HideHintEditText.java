package com.plusqa.bc.webopener;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;

public class HideHintEditText extends android.support.v7.widget.AppCompatEditText {
    CharSequence hint;

    public HideHintEditText(Context context) {
        super(context);
        hint = this.getHint();
    }

    public HideHintEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        hint = this.getHint();
    }

    public HideHintEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        hint = this.getHint();
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);

        this.setHint(focused ? "" : hint);
    }

}
