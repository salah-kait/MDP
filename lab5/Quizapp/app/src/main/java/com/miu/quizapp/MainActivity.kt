package com.miu.quizapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import android.view.View
import android.widget.CheckBox
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {


    private var result: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onQ1RadioButtonClicked(view: View) {
        // correct answer: false - B
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked
            when (view.getId()) {
                R.id.radio_q1_b ->
                    if (checked) {
                        result +=50
                    }
            }
        }
    }

    fun onQ2RadioButtonClicked(view: View) {
        // correct answer: true - A
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.q2_1 -> {
                    if (checked) {
                        result +=25
                    }
                }
                R.id.q2_2 -> {
                    if (checked) {
                        result +=25
                    }
                }

            }
        }
    }

    fun resetSolution(view: View) {
        resetAnswer()
    }

    fun resetAnswer(){

        if(this.findViewById<RadioButton>(R.id.radio_q1_b).isSelected()){
            this.findViewById<RadioButton>(R.id.radio_q1_b).setChecked(false);
        }

      this.findViewById<RadioButton>(R.id.radio_q1_a).setChecked(false);
      this.findViewById<RadioButton>(R.id.radio_q1_c).setChecked(false);

        this.findViewById<CheckBox>(R.id.q2_1).setChecked(false);
        this.findViewById<CheckBox>(R.id.q2_2).setChecked(false);
        this.findViewById<CheckBox>(R.id.q2_3).setChecked(false);
    }

    private fun showResultDialog(title: String, message: String){
        val alertDialog: AlertDialog = this.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setPositiveButton("OK")
                { dialog, _ ->
                    resetAnswer()
                    result = 0
                    dialog.dismiss()
                }
            }
            builder.setMessage(message)
                .setTitle(title)
            builder.create()
        }
        alertDialog.show()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun submitSolution(view: View) {
        val current = LocalDateTime.now()

        val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")
        val date = current.format(dateFormatter)
        val time = current.format(timeFormatter)
        val message = if(result > 0)
            "Congratulations! You submitted on current $date and $time, Your achieved $result%"
        else "Please, try again."
        val title = "QuizApp Result"
        showResultDialog(title, message)
    }
}