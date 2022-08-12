package flame4ost.antisocialnetwork.ua.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import flame4ost.antisocialnetwork.ua.model.User
import flame4ost.antisocialnetwork.ua.model.UserData

class UserViewModel : ViewModel() {

    private val userData: UserData = UserData()

    private val _userId = MutableLiveData<Int>()
    val userId: LiveData<Int> = _userId

    private val _userListLiveData = MutableLiveData<UserData>()
    val userListLiveData: LiveData<UserData> = _userListLiveData

    private val _userDetailsLiveData = MutableLiveData<User>()
    val userDetailsLiveData: LiveData<User> = _userDetailsLiveData

    fun loadListUsers() {
        _userListLiveData.value = userData
    }

    fun loadDetailsUser(id: Int) {
        _userDetailsLiveData.value = userData.userList[id]
    }

    fun openUserDetails(id: Int) {
        _userId.value = id
    }


}