package edu.miu.quizapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import edu.miu.quizapp.R

class ResultFragment : BaseFragment() {

    private lateinit var tvResult: TextView
    private lateinit var resultBtn: Button
    private lateinit var tryAgainBtn: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_result, container, false)
        tvResult = view.findViewById(R.id.tv_result)
        val score = ResultFragmentArgs.fromBundle(requireArguments()).score
        val answers = ResultFragmentArgs.fromBundle(requireArguments()).answers
        val wrongAnswers = 15 - score
        val finalScore = "$score/15"
        val scoreResult = String.format(
            "Total Questions: 15\n\nCorrect Answers(Score): %d\n\nWrong Answer: %d\n\nYour Score is: %s",
            score, wrongAnswers, finalScore
        )
        tvResult.text = scoreResult
        resultBtn = view.findViewById(R.id.btn_ra)
        tryAgainBtn = view.findViewById(R.id.btn_ta)
        tryAgainBtn.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_resultFragment_to_homeFragment)
        }
        resultBtn.setOnClickListener {
            val action = ResultFragmentDirections.actionResultFragmentToAnalysisFragment(answers)
            Navigation.findNavController(requireView()).navigate(action)
        }
        return view
    }


}