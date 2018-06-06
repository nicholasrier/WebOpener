package com.plusqa.bc.webopener;
import android.text.Editable;
import android.text.TextWatcher;

import java.util.regex.Pattern;
public class BuildCodeValidator implements TextWatcher {

    public static final Pattern BUILD_CODE_PATTERN = Pattern.compile("^[a-zA-Z0-9]*$");

    private boolean mIsValid = false;

    public boolean isValid() {
        return mIsValid;
    }

    public static boolean isValidBuildCode(CharSequence buildCode) {
        return buildCode != null && buildCode.length() <= 8 && BUILD_CODE_PATTERN.matcher(buildCode).matches();
    }

    @Override
    final public void afterTextChanged(Editable editableText) {
        mIsValid = isValidBuildCode(editableText);
    }

    @Override
    final public void beforeTextChanged(CharSequence s, int start, int count, int after) {/*No-op*/}

    @Override
    final public void onTextChanged(CharSequence s, int start, int before, int count) {/*No-op*/}

}
