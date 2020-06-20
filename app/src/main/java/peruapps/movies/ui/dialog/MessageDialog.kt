package peruapps.movies.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import kotlinx.android.synthetic.main.dialog_message.*
import peruapps.movies.R

class MessageDialog(context: Context) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_message)
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        setClick()
    }

    private fun setClick() {
        acceptButton.setOnClickListener {
            dismiss()
        }
    }

    fun setMessage(message: String) {
        messageText.text = message
    }

    fun setButtonText(text: String) {
        acceptButton.text = text
    }

    class Builder(val context: Context) {

        private var buttonText = context.getString(R.string.ok)
        private var message = ""

        fun setMessage(message: String) = apply {
            this.message = message
        }

        fun setButtonText(text: String) = apply {
            buttonText = text
        }

        fun show() {
            val dialog = MessageDialog(context)
            dialog.show()
            dialog.setMessage(message)
            dialog.setButtonText(buttonText)
        }
    }
}