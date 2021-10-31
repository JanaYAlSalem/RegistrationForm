package com.example.registrationform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.example.registrationform.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var LinkXML: ActivityMainBinding // to initializes LinkXML in future time

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        LinkXML = ActivityMainBinding.inflate(layoutInflater)  // initializes the binding object
        setContentView(LinkXML.root) // get root of XML

        LinkXML.buttonShow.setOnClickListener { ShowInformations() } // call fun on button
    }

    private fun ShowInformations() {
        val inputName = LinkXML.inputName.text.toString()
        val inputPass1 = LinkXML.inputPass1.text.toString()
        val inputPass2 = LinkXML.inputPass2.text.toString()
        val inputBdate = LinkXML.inputBdate.text.toString()

        val Gender = when (LinkXML.rGroup.checkedRadioButtonId) {
            LinkXML.radioButtonMale.id -> LinkXML.radioButtonMale.text.toString()
            LinkXML.radioButtonFemale.id -> LinkXML.radioButtonFemale.text.toString()
            else -> "None"
        } // end when to get the Percentage Of Tip


//                inputName != null &&
//                inputPass1 != null &&
//                inputPass2 != null &&
//                inputBdate != null
        TextUtils.isEmpty(inputPass1) &&
                TextUtils.isEmpty(inputPass2) &&
                TextUtils.isEmpty(inputBdate)
//
        if (TextUtils.isEmpty(inputName) == false &&
            TextUtils.isEmpty(inputPass1) == false &&
            TextUtils.isEmpty(inputPass2) == false &&
            TextUtils.isEmpty(inputBdate)== false ) {

            if (inputPass1 == inputPass2) {

                LinkXML.textViewShowInfo.setText(
                    "Your Informations is \n" +
                            "Name: $inputName \n" +
                            "Date: $inputBdate \n" +
                            "Gender: $Gender \n"
                )
            } // end if pass
            else
                IsSamePassword()
        } // end if are not null
        else
            IsNullInfo()

    } // end fun of Show Informations


    private fun IsNullInfo() {
        Snackbar.make(
            findViewById(R.id.MainV),
            "Sorry some info is empty",
            Snackbar.LENGTH_SHORT
        ).show()
    }  // end Is Null Info

    private fun IsSamePassword() {
        Snackbar.make(
            findViewById(R.id.MainV),
            "Sorry the password is not the same",
            Snackbar.LENGTH_SHORT
        ).show()
    }  // end Is Same Password

} // end class