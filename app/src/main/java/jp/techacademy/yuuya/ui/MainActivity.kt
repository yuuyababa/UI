package jp.techacademy.yuuya.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import android.app.TimePickerDialog
import android.app.DatePickerDialog


class MainActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }

     override fun onClick(p0: View) {
      when(p0.id){
          R.id.button1 -> textView.text = editText.text.toString()
          R.id.button2 -> showAlertDialog()
          R.id.button3 -> showTimePickerDialog()
          R.id.button4 -> showDataPickerDialog()

      }
     }

    private fun showAlertDialog(){
         //AlertDialog.Builderクラスを使ってAlertDialogの準備をする。
         val alertDialogBuilder = AlertDialog.Builder(this)
         alertDialogBuilder.setTitle("タイトル")
         alertDialogBuilder.setMessage("メッセージ")

         //肯定ボタンに表示される文字列、押したときのリスナーを設定する。
        alertDialogBuilder.setPositiveButton("肯定"){dialog,which ->
            Log.d("UI_PARTS", "肯定ボタン")
        }

         // 中立ボタンに表示される文字列、押したときのリスナーを設定する。
         //使わない引数の場合は「_」と記述するのがkotlinの慣習
        alertDialogBuilder.setNeutralButton("中立"){_,_->
            Log.d("UI_PARTS","中立ボタン")
        }

         alertDialogBuilder.setNegativeButton("否定ボタン"){_,_ ->
             Log.d("UI_PARTS","否定ボタン")
         }

         //AlertDialogを作成して表示する。
         val alertDialog = alertDialogBuilder.create()
         alertDialog.show()
     }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                Log.d("UI_PARTS", "$hour:$minute")
            },
            13, 0, true)
        timePickerDialog.show()
    }

    private fun showDataPickerDialog(){
        val dataPickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener(){view, year, month, dayOfMonth ->
                Log.d("UI_PARTS", "$year/${month+1}/$dayOfMonth")
            },
            2018,
            4,
            1
        )
        dataPickerDialog.show()
    }
}