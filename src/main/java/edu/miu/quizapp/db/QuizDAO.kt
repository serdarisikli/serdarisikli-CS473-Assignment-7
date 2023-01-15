package edu.miu.quizapp.db

import androidx.room.*

@Dao
interface QuizDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addQuiz(question: Question)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addQuizzes(vararg questions: Question)

    @Query("SELECT * FROM quiz ORDER BY id")
    suspend fun getAllQuizzes(): List<Question>

    @Update
    suspend fun updateQuiz(question: Question)

    @Delete
    suspend fun deleteQuiz(question: Question)

    @Query("DELETE FROM quiz WHERE 1=1")
    suspend fun deleteAllQuiz()
}
