package edu.miu.quizapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import edu.miu.quizapp.R
import edu.miu.quizapp.db.Question
import edu.miu.quizapp.db.QuizDatabase
import edu.miu.quizapp.utils.BaseFragment
import edu.miu.quizapp.utils.PrefManager
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment() {

    private lateinit var tvWelcome: TextView
    private var prefManager: PrefManager? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        prefManager = PrefManager(context)
        val view = inflater.inflate(R.layout.fragment_splash, container, false)
        tvWelcome = view.findViewById(R.id.logo_welcome)
        addQuestionsToDB()
        return view
    }

    override fun onResume(){
        super.onResume()
        tvWelcome.postDelayed({
            if (!prefManager?.isFirstTimeLaunch()!!) {
                Navigation.findNavController(requireView()).navigate(R.id.action_splashFragment_to_homeFragment)
            }else{
                Navigation.findNavController(requireView()).navigate(R.id.action_splashFragment_to_welcomeFragment)
            }
        }, 2000)
    }

    fun addQuestionsToDB(){
        val question1 = Question(1L,"1) What is the JSON exception in android?","A. JSon Exception", "B. Json Not found exception","C. Input not found exception","D. None of the above","a","Answer: (a) JSon Exception\n")

        val question2 = Question(2L,"2) How to kill an activity in Android??", "A. finish()","B. finishActivity(int requestCode)","C. A & B","D. kill()","c","Answer: (c) A & B\n")

        val question3 = Question(3L,"3) What is android view group?","A. Collection of views and other child views", "B. Base class of building blocks","C. Layouts","D. None of the Above","a","Answer: (a) Collection of views and other child views\n")

        val question4 = Question(4L,"4) How to pass the data from activity to services in android?","A. We can store the data in a common database and access the data on services as well as in Activity", "B. We can't pass data from activity to services","C. Using putExtra() method in intent, we can pass the data using setResult()","D. A & C","d","A & C\n")

        val question5 = Question(5L,"5) How many applications are there in a given task in android?","A. Two", "B. One","C. Many","D. Zero","c","Answer: (c) Many\n")

        val question6 = Question(6L,"6) Which permissions are required to get a location in android?","A. ACCESS_FINE and ACCESS_COARSE", "B. GPRS permission","C. Internet permission","D. WIFI permission.","a","Answer: (a) ACCESS_FINE and ACCESS_COARSE\n")

        val question7 = Question(7L,"7) What is DDMS in android?","A. Dalvik memory server", "B. Device memory server","C. Dalvik monitoring services","D. Dalvik debug monitor services","d","Answer: (d) Dalvik debug monitor services\n")

        val question8 = Question(8L,"8) What is an HTTP client class in android?","A. httprequest(get/post) and returns response from the server", "B. Cookies management","C. Authentication management","D. None of the above","a","Answer: (a) httprequest(get/post) and returns response from the server\n")

        val question9 = Question(9L,"9) How many levels of securities are there in android?","A. App level security and kernel level security", "B. Android level security","C. Java level security","D. None of the above","a","Answer: (a) App level security and kernel level security\n")

        val question10 = Question(10L,"10) What is a thread in android?","A. Same as services", "B. Background activity","C. Broadcast Receiver","D. Independent dis-patchable unit is called a thread","d","Answer: (d) Independent dis-patchable unit is called a thread\n")

        val question11 = Question(11L,"11) The package of compiled Java codes with some other resources is called?","A. IDE", "B. APK","C. JDK","D. PJR","c","Answer: (b) APK\n")

        val question12 = Question(12L,"12)  The property that is used for formatting font is?","A. Color", "B. typeface","C. ImageView","D. Mip Map","b","Answer: (b) typeface\n")

        val question13 = Question(13L,"13) What are the functionalities in asyncTask in android?", "A. onPreExecution()","B. doInBackground()","C. onProgressUpdate()", " D. onPostExecution()", "d","Answer: (d) onPostExecution()\n")

        val question14 = Question(14L,"14) What is the life cycle of broadcast receivers in android??",
            "A. send intent()", "B. onRecieve()","C. implicitBroadcast()","D. sendBroadcast(), sendOrderBroadcast(), and sendStickyBroadcast().","b","Answer: (b) onRecieve()\n")

        val question15 = Question(15L,"15) Which of the following is the core module of Android for Internet computing?","A. SQLite RDBMS", "B. SQL Server RDBMS","C. OpenPL","D. None of the mentioned","a","Answer: (a) SQLite RDBMS\n")

        launch {
            context?.let {
                QuizDatabase(it)
                    .getQuizDao().deleteAllQuiz()
                QuizDatabase(it)
                    .getQuizDao().addQuizzes(question1,question2,question3,question4,question5,question6,question7,question8,
                    question9,question10,question11,question12,question13,question14,question15)
            }
        }
    }

}