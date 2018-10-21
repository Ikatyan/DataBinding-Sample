package com.example.yoshiki.databindingsample.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.yoshiki.databindingsample.R
import com.example.yoshiki.databindingsample.User
import com.example.yoshiki.databindingsample.User2ViewModel
import com.example.yoshiki.databindingsample.databinding.MainFragmentBinding
import kotlinx.android.synthetic.main.main_fragment.view.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var viewModel2: User2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val mainFragmentBinding = MainFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java).apply {
            user.firstName = "Tamureio"
            user.lastName = "Yoshinio"
        }
        mainFragmentBinding.user = viewModel
        viewModel2 = User2ViewModel()

        mainFragmentBinding.user2 = viewModel2
        mainFragmentBinding.setLifecycleOwner(this)

        mainFragmentBinding.root.button.setOnClickListener { _ ->
            run {
                viewModel.user.firstName = "wassyoi"
                viewModel.user.lastName = "otokomatsuri"
                Log.d("私です", viewModel.user.firstName)
            }
        }

        mainFragmentBinding.root.button2.setOnClickListener {
                _ -> viewModel2.user.get()?.name = "Hanage" }
        return mainFragmentBinding.root
    }
}
