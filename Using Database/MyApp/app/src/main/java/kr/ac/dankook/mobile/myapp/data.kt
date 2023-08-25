package kr.ac.dankook.mobile.myapp

import androidx.room.*

@Database(entities = [User::class], version = 1)
abstract class UserDB : RoomDatabase() {
    abstract fun userDao(): UserDao
}

@Entity
data class User(
    @PrimaryKey val id: Int,
    val username: String?,
    val password: String?
    )

@Dao
interface UserDao {
    @Query("SELECT * FROM User")
    fun getAll(): List<User>

    @Query("SELECT * FROM User WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: Int): List<User>

    @Query("SELECT * FROM User WHERE id LIKE :uid ")
    fun findByID(uid: Int): User

    @Insert
    fun insertAll(vararg user: User)

    @Query("SELECT (SELECT COUNT(*) FROM User) == 0")
    fun isEmpty(): Boolean

    @Delete
    fun delete(user: User)
}