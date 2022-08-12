package flame4ost.antisocialnetwork.ua.view_model.new_user_vm

import android.app.Application
import androidx.lifecycle.*
import flame4ost.antisocialnetwork.ua.model.User
import flame4ost.antisocialnetwork.ua.repository.UserDataBaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddUserViewModel(
    private val database: UserDataBaseDao,
    application: Application, ) : AndroidViewModel(application) {

    private suspend fun addNewUser(user: User) {
        database.insert(user)
    }

    private fun addNewUserToDb(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            addNewUser(user)
        }
    }

    fun validateAndAddNewUser(
        editImage: String,
        editUserName: String,
        editTextStatus: String,
        editFollowers: String,
        editFollowing: String,
        editScope: String,
        editSharemeter: String,
        editReach: String,
        editPosts: String,
        strTime: String,
    ): Boolean {
        if (editUserName.isEmpty() || editImage.isEmpty() || editTextStatus.isEmpty() ||
            editScope.isEmpty() || editFollowers.isEmpty() || editFollowing.isEmpty()  ||
            editPosts.isEmpty() || editReach.isEmpty() || editSharemeter.isEmpty()
        ) {
            return false
        } else {
            val user = User(
                editUserName,
                strTime,
                editImage,
                editTextStatus,
                editScope.toInt(),
                editFollowers.toInt(),
                editFollowing.toInt(),
                editPosts,
                editReach,
                editSharemeter.toInt()
            )
            addNewUserToDb(user)
            return true
        }
    }
}