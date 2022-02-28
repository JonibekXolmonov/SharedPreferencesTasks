package com.example.sharedpreferencestasks.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.sharedpreferencestasks.model.Member
import com.example.sharedpreferencestasks.R
import com.example.sharedpreferencestasks.SharedPref
import com.google.android.material.button.MaterialButton

@SuppressLint("StaticFieldLeak")
internal lateinit var sharedPref: SharedPref

class SaveObjectFragment : Fragment(R.layout.fragment_save_object), View.OnClickListener {

    private lateinit var tvObject: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPref = SharedPref(requireContext())

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvObject = view.findViewById(R.id.tvObject)

        view.findViewById<MaterialButton>(R.id.btnObject).setOnClickListener(this)
        view.findViewById<MaterialButton>(R.id.btnSavedObject).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnObject -> {
                sharedPref.save("member", Member(123, "Just Member"))
            }
            R.id.btnSavedObject -> {
                val member = sharedPref.getMember("member")
                tvObject.text = member.toString()
            }
        }
    }
}
