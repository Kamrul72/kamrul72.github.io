package edu.miu.quizapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeFragmentViewModel : ViewModel() {
    private var score= MutableLiveData<Int>()
    init {
        score.value = 0

    }

    fun initialScore(): MutableLiveData<Int> {


        return  score
    }
    fun currentScore(){

        score.value = (score.value)?.plus(1)

    }
    fun finalScore(): MutableLiveData<Int> {
        return score
    }
}