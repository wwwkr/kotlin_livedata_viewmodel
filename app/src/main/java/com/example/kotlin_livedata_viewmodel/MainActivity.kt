package com.example.kotlin_livedata_viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , View.OnClickListener{

    companion object{
        const val TAG : String = "로그"
    }

    lateinit var myNumberViewModel : MyNumberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myNumberViewModel = ViewModelProvider(this).get(MyNumberViewModel::class.java)

        myNumberViewModel.currentValue.observe(this, Observer {


            Log.e(TAG , "값 변경 ${it}")
            number_textview.text = it.toString()
        })

        plus_btn.setOnClickListener(this)
        minus_btn.setOnClickListener(this)
    }

    //클릭
    override fun onClick(view: View?) {
        val userInput = userinput_edittext.text.toString().toInt()

        //뷰모델에 라이브데이터 값을 변경하는 메소드 실행
        when(view){
            plus_btn ->
                myNumberViewModel.updateValue(actionType = ActionType.PLUE, userInput)
            minus_btn ->
                myNumberViewModel.updateValue(actionType = ActionType.MINUS, userInput)
        }
    }
}