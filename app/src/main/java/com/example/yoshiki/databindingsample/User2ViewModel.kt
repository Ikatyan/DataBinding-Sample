package com.example.yoshiki.databindingsample

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField

class User2ViewModel: ViewModel() {
    val user = ObservableField<Name>(Name("amazon", "wassyoi"))

    data class Name(var name: String, var name2: String)
}