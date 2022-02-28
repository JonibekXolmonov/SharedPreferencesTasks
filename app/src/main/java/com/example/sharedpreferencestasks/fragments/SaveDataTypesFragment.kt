package com.example.sharedpreferencestasks.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.sharedpreferencestasks.R
import com.example.sharedpreferencestasks.SharedPref

class SaveDataTypesFragment : Fragment(R.layout.fragment_save_data_types), View.OnClickListener {

    //long
    private lateinit var edtLongKey: EditText
    private lateinit var edtLong: EditText
    private lateinit var edtGetLong: EditText
    private lateinit var tvLong: TextView

    //boolean
    private lateinit var edtBooleanKey: EditText
    private lateinit var edtBoolean: EditText
    private lateinit var edtGetBoolean: EditText
    private lateinit var tvBoolean: TextView

    //integer
    private lateinit var edtIntegerKey: EditText
    private lateinit var edtInteger: EditText
    private lateinit var edtGetInteger: EditText
    private lateinit var tvInteger: TextView

    //double
    private lateinit var edtDoubleKey: EditText
    private lateinit var edtDouble: EditText
    private lateinit var edtGetDouble: EditText
    private lateinit var tvDouble: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPref = SharedPref(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        edtLongKey = view.findViewById(R.id.edtLongKey)
        edtLong = view.findViewById(R.id.edtLong)
        edtGetLong = view.findViewById(R.id.edtGetLong)
        tvLong = view.findViewById(R.id.tvLong)

        edtBooleanKey = view.findViewById(R.id.edtBooleanKey)
        edtBoolean = view.findViewById(R.id.edtBoolean)
        edtGetBoolean = view.findViewById(R.id.edtGetBoolean)
        tvBoolean = view.findViewById(R.id.tvBoolean)

        edtIntegerKey = view.findViewById(R.id.edtIntegerKey)
        edtInteger = view.findViewById(R.id.edtInteger)
        edtGetInteger = view.findViewById(R.id.edtGetInteger)
        tvInteger = view.findViewById(R.id.tvInteger)

        edtDoubleKey = view.findViewById(R.id.edtDoubleKey)
        edtDouble = view.findViewById(R.id.edtDouble)
        edtGetDouble = view.findViewById(R.id.edtGetDouble)
        tvDouble = view.findViewById(R.id.tvDouble)


        //save
        view.findViewById<Button>(R.id.btnLong).setOnClickListener(this)
        view.findViewById<Button>(R.id.btnBoolean).setOnClickListener(this)
        view.findViewById<Button>(R.id.btnInteger).setOnClickListener(this)
        view.findViewById<Button>(R.id.btnDouble).setOnClickListener(this)

        //get
        view.findViewById<Button>(R.id.btnGetLong).setOnClickListener(this)
        view.findViewById<Button>(R.id.btnGetBoolean).setOnClickListener(this)
        view.findViewById<Button>(R.id.btnGetInteger).setOnClickListener(this)
        view.findViewById<Button>(R.id.btnGetDouble).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnLong -> {
                sharedPref.save(edtLongKey.text.toString(), edtLong.text.toString().toLong())
            }
            R.id.btnBoolean -> {
                sharedPref.save(
                    edtBooleanKey.text.toString(),
                    edtBoolean.text.toString().toBoolean()
                )
            }
            R.id.btnInteger -> {
                sharedPref.save(edtIntegerKey.text.toString(), edtInteger.text.toString().toInt())
            }
            R.id.btnDouble -> {
                sharedPref.save(edtDoubleKey.text.toString(), edtDouble.text.toString().toDouble())
            }
            R.id.btnGetLong -> {
                tvLong.text = sharedPref.get(edtGetLong.text.toString()).toString()
            }
            R.id.btnGetBoolean -> {
                tvBoolean.text = sharedPref.get(edtGetBoolean.text.toString()).toString()
            }
            R.id.btnGetInteger -> {
                tvInteger.text = sharedPref.get(edtGetInteger.text.toString()).toString()
            }
            R.id.btnGetDouble -> {
                tvDouble.text = sharedPref.get(edtGetDouble.text.toString()).toString()
            }
        }
    }

}