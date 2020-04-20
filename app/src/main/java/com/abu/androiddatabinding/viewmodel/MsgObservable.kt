package com.abu.androiddatabinding.viewmodel

import android.util.Log
import android.widget.EditText
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import com.abu.androiddatabinding.BR

class MsgObservable : BaseObservable() {
    val TAG = "MsgObservable"
    @get:Bindable
    var msg: String = "Input..."
        set(value) {
            field = value
            notifyPropertyChanged(BR.msg)
        }
}