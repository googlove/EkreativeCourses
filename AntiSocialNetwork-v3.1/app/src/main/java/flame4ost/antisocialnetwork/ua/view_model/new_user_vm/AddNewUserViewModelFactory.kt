package flame4ost.antisocialnetwork.ua.view_model.new_user_vm

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import flame4ost.antisocialnetwork.ua.repository.UserDataBaseDao

class AddNewUserViewModelFactory(
    private val dataSource: UserDataBaseDao,
    private val application: Application,
) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddUserViewModel::class.java)) {
            return AddUserViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}