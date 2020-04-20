package com.abu.androiddatabinding.viewmodel

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.databinding.adapters.ListenerUtil
import com.abu.androiddatabinding.R


@BindingAdapter("content")
fun setContent(textView: TextView, content: String) {
    if (textView.text.length == content.length) return
    if (textView.text != content) {
        textView.text = content
    }
}

@InverseBindingAdapter(attribute = "content", event = "contentAttrChanged")
fun getContent(textView: TextView): String {
    return textView.text.toString()
}

/**
 *  the rule: attr_name + “AttrChanged"
 * */
@BindingAdapter("contentAttrChanged")
fun setListeners(editText: EditText, listener: InverseBindingListener) {
    val newValue: TextWatcher?
    newValue = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun afterTextChanged(s: Editable) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            listener.onChange()
        }
    }
    val oldValue =
        ListenerUtil.trackListener<TextWatcher>(editText, newValue, R.id.textWatcher)
    if (oldValue != null) {
        editText.removeTextChangedListener(oldValue)
    }
    if (newValue != null) {
        editText.addTextChangedListener(newValue)
    }
}

