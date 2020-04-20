package com.abu.androiddatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.abu.androiddatabinding.databinding.ActivityMainBinding
import com.abu.androiddatabinding.viewmodel.MainViewModel

//import com.abu.androiddatabinding.viewmodel.MainViewModel
import com.abu.androiddatabinding.viewmodel.MsgObservable

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel : MainViewModel
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.message = MsgObservable()
    }

    override fun onResume() {
        super.onResume()

    }
}
