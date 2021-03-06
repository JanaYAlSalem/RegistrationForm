package com.example.registrationform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.registrationform.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var LinkXML: ActivityMainBinding // to initializes LinkXML in future time
    lateinit var calendar: Calendar
    lateinit var simpleDateFormat: SimpleDateFormat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LinkXML = ActivityMainBinding.inflate(layoutInflater)  // initializes the binding object
        setContentView(LinkXML.root) // get root of XML
//        thems ()

        LinkXML.buttonShow.setOnClickListener { ShowInformations() } // call fun on button
    }

    private fun ShowInformations() {

        val inputName = LinkXML.inputNameX.text.toString()
        val inputPass1 = LinkXML.inputPass1X.text.toString()
        val inputPass2 = LinkXML.inputPass2X.text.toString()
        val inputBdate = LinkXML.inputBdateX.text.toString()
        var Email = LinkXML.inputEmailX.text.toString()
        var emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

        val Gender = when (LinkXML.rGroup.checkedRadioButtonId) {
            LinkXML.radioButtonMale.id -> LinkXML.radioButtonMale.text.toString()
            LinkXML.radioButtonFemale.id -> LinkXML.radioButtonFemale.text.toString()
            else -> "None"
        } // end when to get the Percentage Of Tip

        if (TextUtils.isEmpty(inputName) == false &&
            TextUtils.isEmpty(inputPass1) == false &&
            TextUtils.isEmpty(inputPass2) == false &&
            TextUtils.isEmpty(inputBdate) == false) {

            if(Email.trim { it <= ' ' }.matches(emailPattern.toRegex()) == false){
                Toast.makeText(applicationContext, "Invalid email address", Toast.LENGTH_SHORT).show()
            }
            else if (inputPass1 == inputPass2) {

                LinkXML.textViewShowInfo.setText(
                    "Your Informations is \n" +
                            "Name: $inputName \n" +
                            "Email: $Email \n" +
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
        Snackbar.make( findViewById(R.id.MainV), "Sorry some info is empty", Snackbar.LENGTH_SHORT).show()
    }  // end Is Null Info

//    private fun IsEmail() {
//        var Email = LinkXML.inputEmail.text.toString()
//        var emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
//
//        if (Email.trim { it <= ' ' }.matches(emailPattern.toRegex()) == false) {
//            Toast.makeText(applicationContext, "Invalid email address", Toast.LENGTH_SHORT).show()
//        }
//    }// end isEmail (Never Use)

    private fun IsSamePassword() {
        Snackbar.make(
            findViewById(R.id.MainV),
            "Sorry the password is not the same",
            Snackbar.LENGTH_SHORT
        ).show()
    }  // end Is Same Password
fun thems (){
//    val themseseses = LinkXML.Them1.setOnClickListener
//    LinkXML.Them1.setOnClickListener{
//        setTheme(R.style.chUser)
//    }
//LinkXML.Them2.setOnClickListener{
//    setTheme(R.style.RegistrationForm)
//}
//
//
}


} // end class