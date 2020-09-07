package jp.techacademy.yuuya.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
    }

     override fun onClick(p0: View) {
         if(p0.id==R.id.button1){
             textView.text = editText.text.toString()
         }else if(p0.id==R.id.button2) {
             showAlertDialog()
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

}