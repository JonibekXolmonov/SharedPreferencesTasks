package com.example.sharedpreferencestasks.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.sharedpreferencestasks.R
import com.google.android.material.button.MaterialButton

class MainFragment : Fragment(R.layout.fragment_main), View.OnClickListener {

    lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        view.findViewById<MaterialButton>(R.id.btnDataType).setOnClickListener(this)
        view.findViewById<MaterialButton>(R.id.btnLogin).setOnClickListener(this)
        view.findViewById<MaterialButton>(R.id.btnObject).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnDataType -> navController.navigate(R.id.action_mainFragment_to_saveDataTypesFragment)
            R.id.btnLogin -> navController.navigate(R.id.action_mainFragment_to_loginFragment)
            R.id.btnObject -> navController.navigate(R.id.action_mainFragment_to_saveObjectFragment)
        }
    }

}