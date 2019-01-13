package com.xlog.blackboxmobile.Sms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.xlog.blackboxmobile.R
import kotlinx.android.synthetic.main.activity_send_sms.*

class SendSms : AppCompatActivity() {


    val myList = arrayListOf<String>()
    private lateinit var mView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_sms)

        autoCompleteTextView.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
//                Toast.makeText(this, autoCompleteTextView.getText(), Toast.LENGTH_SHORT).show()

                myList.add(autoCompleteTextView.getText().toString())
                for (item in myList) addChipToGroup(item, chipGroup2)
                return@OnKeyListener true
            }
            false
        })

    }

    private fun addChipToGroup(person: String, chipGroup: ChipGroup) {
        val chip = Chip(this)
        chip.text = person
        chip.isCloseIconEnabled = true
        chip.setChipIconTintResource(R.color.accent_material_dark)

        // necessary to get single selection working
        chip.isClickable = true
        chip.isCheckable = false
        chipGroup.addView(chip as View)
        chip.setOnCloseIconClickListener {
//            chipGroup.removeView(chip as View)
        }
        }
}

