package co.rinda.ucsyitcamp.components

import android.content.Context
import android.graphics.Typeface
import android.widget.TextView


class FontUtils {

    companion object {

        private var mmTypeFace: Typeface? = null

        fun setRegularFont(view: TextView, context: Context) {
            mmTypeFace = Typeface.createFromAsset(context.getAssets(), "fonts/Pyidaungsu-Regular.ttf")
            view.typeface = mmTypeFace
        }

        fun setBoldFont(view: TextView, context: Context) {
            mmTypeFace = Typeface.createFromAsset(context.getAssets(), "fonts/Pyidaungsu-Bold.ttf")
            view.typeface = mmTypeFace
        }

    }


}