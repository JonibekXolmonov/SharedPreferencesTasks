package com.example.sharedpreferencestasks.fragments

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.sharedpreferencestasks.R
import com.example.sharedpreferencestasks.SharedPref
import com.example.sharedpreferencestasks.model.User
import com.google.android.material.button.MaterialButton


class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var tvSavedUser: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPref = SharedPref(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvSavedUser = view.findViewById(R.id.tvSavedUser)

        view.findViewById<MaterialButton>(R.id.btnLogin).setOnClickListener {
            sharedPref.save(
                "user",
                User(
                    view.findViewById<EditText>(R.id.edtUsername).text.toString(),
                    view.findViewById<EditText>(R.id.edtPassword).text.toString()
                )
            )
        }

        view.findViewById<MaterialButton>(R.id.btnSavedUser).setOnClickListener {
            tvSavedUser.text = sharedPref.getUser("user").toString()
        }
    }
}