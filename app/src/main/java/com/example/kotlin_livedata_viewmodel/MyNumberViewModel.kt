package com.example.kotlin_livedata_viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


enum class ActionType {
    PLUE, MINUS
}
//데이터의 변경
//뷰모델은 데이터의 변경사항을 알려주는 라이브 데이터를 가지고 있고
class MyNumberViewModel : ViewModel(){

    companion object{
        const val TAG : String = "로그"
    }
    //뷰터블 라이브 데이터 - 수정 가능
    //라이브 데이터 - 읽기전용

    //내부에서 설정하는 자료형은 뮤터블
    //변경가능하도록 실행
    private val _currentValue = MutableLiveData<Int>()

    val currentValue : LiveData<Int>
        get() = _currentValue


    //초기값 설정
    init{
        Log.d(TAG, "MyNumberViewModel = 생성자 호출")
        _currentValue.value = 0
    }

    fun updateValue(actionType: ActionType, input : Int){
        when(actionType){
            ActionType.PLUE ->
                _currentValue.value = _currentValue.value?.plus(input)
            ActionType.MINUS ->
                _currentValue.value = _currentValue.value?.minus(input)


        }
    }
}