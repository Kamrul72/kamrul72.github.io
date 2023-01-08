package edu.miu.quizapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import edu.miu.quizapp.R
import edu.miu.quizapp.db.Question
import edu.miu.quizapp.db.QuestionDatabase
import edu.miu.quizapp.utils.toast
import kotlinx.coroutines.launch

class HomeFragment : BaseFragment() {

    private lateinit var tvQuestion: TextView

    private lateinit var radioGroup: RadioGroup
    private lateinit var questions: List<Question>
    private var qIndex = 0
     private var homeFragmentViewModel: HomeFragmentViewModel? = null
    private var answerSelection: String? = null
    private var answers: MutableList<String> = mutableListOf()
    private lateinit var currentQ: Question
    private var questionStatus = true
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val skipBtn = view.findViewById<Button>(R.id.btn_skip)
        val nextBtn = view.findViewById<Button>(R.id.btn_next)
        val homeBtn = view.findViewById<Button>(R.id.btn_home)
        tvQuestion = view.findViewById(R.id.tv_question)

        homeFragmentViewModel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)
        val scoreLiveData: MutableLiveData<Int> = homeFragmentViewModel!!.initialScore()

        launch {
            context?.let {
                questions = QuestionDatabase(it).getQuestionDao().getAllQuestions()
                nextQuestion(view)
            }
        }
        skipBtn.setOnClickListener {
            nextQuestion(view)
        }
        homeBtn.setOnClickListener {

            Navigation.findNavController(requireView()).navigate(R.id.action_homeFragment_to_splashFragment)

        }
        nextBtn.setOnClickListener {
            if (answerSelection != null){

                if (currentQ.answer == answerSelection) {
                    homeFragmentViewModel!!.currentScore()
                }
                nextQuestion(view)
            } else context?.toast(getString(R.string.please_provide_answer_toast_message))

        }
        radioGroup = view.findViewById(R.id.question_radio)

        radioGroup.setOnCheckedChangeListener { radioGroup, chkId ->
            when (chkId) {
                R.id.radio_a -> answerSelection="a"
                R.id.radio_b -> answerSelection="b"
                R.id.radio_c -> answerSelection ="c"
                R.id.radio_d -> answerSelection ="d"
            }


        }
        return view
    }



    private fun nextQuestion(view:View) {
        if(!questionStatus){
            val selectedAns = if(answerSelection!=null) answerSelection else ""
            answers.add(selectedAns!!)
        }
        questionStatus = false
        if (qIndex == 15) {
            val action = HomeFragmentDirections.actionHomeFragmentToResultFragment(
                score = homeFragmentViewModel?.finalScore()?.value!!, answers = answers.toTypedArray()
            )
            Navigation.findNavController(requireView()).navigate(action)
            return
        }
        currentQ = questions[qIndex]
        tvQuestion.text = currentQ.question
        val radioGroup = view.findViewById(R.id.question_radio) as RadioGroup
        val questionChoices = listOf(currentQ.a, currentQ.b, currentQ.c, currentQ.d)
        for (i in 0 until radioGroup.childCount) {
            (radioGroup.getChildAt(i) as RadioButton).text = questionChoices[i]
        }
        qIndex++
        answerSelection = null
        radioGroup.clearCheck()
    }





}