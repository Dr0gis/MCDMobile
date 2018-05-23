package team.corpore.`in`.mcdmobile.ui.activites

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ProgressBar
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent

abstract class BaseActivity : AppCompatActivity() {

    protected abstract fun getViewId() : Int?

    protected abstract fun init()

    protected abstract fun onOpenKeyboard()

    protected abstract fun onHideKeyboard()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewId = getViewId()
        if (viewId != null) {
            setContentView(viewId)
        }

        initKeyboardVisibleListener()

        init()
    }

    private fun initKeyboardVisibleListener() {
        KeyboardVisibilityEvent.setEventListener(this, {
            if (it) {
                onOpenKeyboard()
            }
            else {
                onHideKeyboard()
            }
        })
    }
}