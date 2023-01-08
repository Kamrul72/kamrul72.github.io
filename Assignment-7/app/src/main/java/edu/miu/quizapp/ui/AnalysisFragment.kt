package edu.miu.quizapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import edu.miu.quizapp.R
import edu.miu.quizapp.db.Question
import edu.miu.quizapp.db.QuestionDatabase
import kotlinx.coroutines.launch


class AnalysisFragment : BaseFragment() {

    private lateinit var questions: List<Question>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_analysis, container, false)
        val listView = view.findViewById<ListView>(R.id.list_view)
        val answers = ResultFragmentArgs.fromBundle(requireArguments()).answers
        launch {
            context?.let {
                questions = QuestionDatabase(it).getQuestionDao().getAllQuestions()
                questions.forEach{ q ->
                    q.answer
                }

                val listItems = mutableListOf<String>()
                questions.forEachIndexed { index, ques ->
                    val listItem = String.format("%s\nYour answer: %s\nCorrect answer: %s",ques.question,answers[index],ques.explanation)
                    listItems.add(listItem)
                }

                listView.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1,listItems)




            }
        }

        return view
    }



}