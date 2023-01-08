package edu.miu.quizapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import edu.miu.quizapp.R
import edu.miu.quizapp.db.Question
import edu.miu.quizapp.db.QuestionDatabase

import kotlinx.coroutines.launch

class SplashFragment : BaseFragment() {

    private lateinit var tvWelcome: TextView
   // private var prefManager: PrefManager? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       // prefManager = PrefManager(context)
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_splash, container, false)
        tvWelcome = view.findViewById(R.id.logo_welcome)
         addQuestionsToDB()



        return view
    }

    override fun onResume(){
        super.onResume()
        tvWelcome.postDelayed({


            Navigation.findNavController(requireView()).navigate(R.id.action_splashFragment_to_homeFragment)

        }, 3000)
    }





    fun addQuestionsToDB(){
        val q1 = Question(1L,"1) Mobile operating system based on","A.Linux Karnel", "B. Windows kernel","C. Unix kernel","D. None of the above","a","Answer: (a) Linux Karnel \n" +
                "\n" +
                "Mobile operating system based on Linux kernel(Component of Linux OS).")
        val q2 = Question(2L,"2) Android originated with  ", "A. Google","B. Apple","C. Android Inc","D. None of the above","c","Answer: (c) Android Inc\n" +
                "\n" +
                "Explanation:   Android was initially developed by Android Inc., California–based startup company .Google bought this company in the summer of 2005 and released a beta version of the Android Software Development Kit (SDK) in November 2007. ")
        val q3 = Question(3L,"3) Which one of the Android app component helps to share the data between different apps?","A. Activity ", "B. Service","C. Broadcast Receiver","D. Content Providers","d","Answer: (d) Content Providers\n" +
                "\n" +
                "Explanation: Applications can not directly share data between them in Android. It is one of the important security feature. But Content Providers implement a mechanism for the sharing of data between applications.")
        val q4 = Question(4L,"4) Default modifier in kotlin is :","A. Private", "B. Internal","C. Public","D. Protected","c","Answer: (c) Public\n" +
                "\n" +
                "Explanation: There are four visibility modifiers in Kotlin: private, protected, internal and public.In Kotlin the default visibility modifier is public")
        val q5 = Question(5L,"5) What is fragment in android?","A.JSON", "B. Peace of Activity","C. Layout","D. None of the above","b","Answer: (b) Peace of Activity\n" +
                "\n" +
                "Explanation: Fragment is a peace of an activity. If you want to move your application in 360 degrees, you can do this by using a fragment.")
        val q6 = Question(6L,"6)  What is a context in android ?","A. It is an interface to store global information about an application", "B.  It is not used to create new components.","C. Android has two contexts, those are Context() and getContext()","D. None of the above","a","Answer: (a) It is an interface to store global information about an application\n" +
                "\n" +
                "Explanation: Context is used to create new components or objects like views and it is used to start activity and services. Android has two kinds of contexts and those are getContext() and getApplicationContext().")
        val q7 = Question(7L,"7)Which thread is used for CPU-intensive work outside of the main thread","A. Dispatchers.Main", "B. Dispatchers.IO","C.Dispatchers.Default","D. None of the above","c","Answer: (c) Dispatchers.Default\n" +
                "\n" +
                "Explanation: Dispatchers.Default - This dispatcher is optimized to perform CPU-intensive work outside of the main thread.")
        val q8 = Question(8L,"8) What does API stand for?","A. Application Programming Interface", "B. Android Programming Interface","C. Android Page Interface","D. Application Page Interface","a","Answer: (a) Application Programming Interface\n" +
                "\n" +
                "Explanation: API stands for application program interface. It is a set of routines, protocols, and tools for building software and applications. It may be any type of system like a web-based system, operating system, or database system.")
        val q9 = Question(9L,"9) Which of the following converts Java byte code into Dalvik byte code?","A. Kotlin compiler", "B. Dex compiler","C. Java Compiler","D. None of the above","b","Answer: (b) Dex compiler\n" +
                "\n" +
                "Explanation: The Dex compiler converts the class files into a .dex file that runs on the Dalvik VM. Multiple class files are converted into one dex file.")
        val q10 = Question(10L,"10) On which thread services work in android?","A. Main Thread. ", "B. Worker Thread.","C. Own Thread","D. None of the above","a","Answer: (a) Main Thread. \n" +
                "\n" +
                "Explanation: Services, by default, work on Main thread. You can start services from any thread, but if you want to update the UI, you need to call Main thread.")
        val q11 = Question(11L,"11) What is an activity in android?","A. android class", "B. android package","C. A single screen in an application with supporting java code","D. None of the above","c","Answer: (c) A single screen in an application with supporting java code\n" +
                "\n" +
                "Explanation: An activity is a single screen in android. It is like a window or frame of Java. By the help of activity, you can place all your UI components or widgets in a single screen. Activity is like a frame or window in java that represents GUI. It represents one screen of android.")
        val q12 = Question(12L,"12) How can we kill an activity in android?","A. Using finish() method", "B. Using finishActivity(int requestCode)","C. Both (a) and (b)","D. Neither (a) nor (b)","c","Answer: (c) Both (a) and (b)\n" +
                "\n" +
                "Explanation: The finish() method is used to close the activity. Whereas the finishActivity(int requestCode) also closes the activity with requestCode.")
        val q13 = Question(13L,"13) What is the life cycle of foreground activity in android?","A. onCreate() −> onStart() −> onResume()", "B. onCreate() −> onStart() −> onResume() −> onStop() −> onRestart","C. onStart() −> onResume() −> onStop()","D. None of the above","a","Answer: (a) Android debug bridge\n" +
                "\n" +
                "After running the App, you will get the below screen and the Log message. The Activity is started by invoking 1. onCreate(), 2. onStart() and 3. onResume(). It is visible in the foreground. ")
        val q14 = Question(14L,"14) What is Manifest.xml in android?",
            "A. It has the information about activities in a Fragment.", "B. It has the information about activities in an application","C. It has information about layout in an application","D. It has all the information about an application","d","Answer: (d) All of the above\n" +
                    "\n" +
                    "Manifest.xml is having information about application as number components in your application,Activity information,service information, and icon about an application.")
        val q15 = Question(15L,"15)How to store heavy structured data in android?","A. Shared Preferences", "B. Cursor","C.  SQlite database","D. Not possible","c","Answer: (c) SQlite database\n" +
                "\n" +
                "Explanation:We can store structured data in SQlite database only. SQlite database is very efficient and faster to read and store the data.")

        launch {
            context?.let {
                QuestionDatabase(it)
                    .getQuestionDao().deleteAllQuestion()
                QuestionDatabase(it)
                    .getQuestionDao().addQuestions(q1,q2,q3,q4,q5,q6,q7,q8,
                    q9,q10,q11,q12,q13,q14,q15)
            }
        }
    }

}