
package edu.miu.quizapp.db

import androidx.room.*
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Delete


@Dao
interface QuestionDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addQuestion(question: Question)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addQuestions(vararg question: Question)

    @Query("SELECT * FROM question ORDER BY id")
    suspend fun getAllQuestions(): List<Question>

    @Update
    suspend fun updateQuestion(question: Question)

    @Delete
    suspend fun deleteQuestion(question: Question)

    @Query("DELETE FROM question WHERE 1=1")
    suspend fun deleteAllQuestion()
}
