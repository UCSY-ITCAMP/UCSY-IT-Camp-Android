package co.rinda.ucsyitcamp.components

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet


class CustomTextView : AppCompatTextView {

    constructor(context: Context) : super(context) {
        if (!isInEditMode)
            FontUtils.setRegularFont(this, context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        if (!isInEditMode)
            FontUtils.setRegularFont(this, context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        if (!isInEditMode)
            FontUtils.setRegularFont(this, context)
    }

}