package com.example.yoshiki.databindingsample

import android.databinding.BaseObservable
import android.databinding.Bindable

class User(first: String, last: String): BaseObservable() {

    @get:Bindable
    var firstName = first
        set(value) {
            field = value
            notifyPropertyChanged(BR.firstName)
        }

    @get:Bindable
    var lastName = last
        set(value) {
            field = value
            notifyPropertyChanged(BR.lastName)
        }
}