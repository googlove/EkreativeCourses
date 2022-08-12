package flame4ost.antisocialnetwork.ua.view_model.user_list_vm


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import flame4ost.antisocialnetwork.ua.model.*
import flame4ost.antisocialnetwork.ua.repository.UserDataBaseDao
import kotlinx.coroutines.launch

class UserViewModel(
    private val database: UserDataBaseDao,
    application: Application,
) : AndroidViewModel(application) {

    private val _userListLiveData = MutableLiveData<List<User>>()
    var userListLiveData: LiveData<List<User>> = _userListLiveData

    private var _userId = MutableLiveData<Int>()
    val userId: LiveData<Int> = _userId

    private suspend fun insert() {
        if (database.checkTablesInDataBase() == null) {
            for (user in userList)
                database.insert(user)
        }
    }

    private fun load() {
        userListLiveData = database.getAllUsers()
    }

    fun insertUserToDB() {
        load()
        viewModelScope.launch {
            insert()
        }
    }

    fun setUserId(id: Int) {
        _userId.value = id
    }

    private var _navigateToAdd = MutableLiveData<Boolean>()
    var navigateToAdd: LiveData<Boolean> = _navigateToAdd

    fun navigateToAdd() {
        _navigateToAdd.value = true
    }
}