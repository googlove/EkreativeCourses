package flame4ost.antisocialnetwork.ua.repository

import androidx.lifecycle.LiveData
import androidx.room.*
import flame4ost.antisocialnetwork.ua.model.User

@Dao
interface UserDataBaseDao {
    @Insert
    suspend fun insert(user: User)

    @Update
    suspend fun update(user: User)

    @Query("SELECT * from users WHERE userId = :key")
    fun getUser(key: Int): LiveData<User?>

    @Query("SELECT * FROM users")
    fun getAllUsers(): LiveData<List<User>>

    @Query("SELECT * FROM users LIMIT 1")
    suspend fun checkTablesInDataBase(): User?

    @Query("DELETE FROM users WHERE userId = :userId")
    suspend fun remove(userId: Int)

}