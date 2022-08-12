package flame4ost.antisocialnetwork.ua.view_model.details_vm

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import flame4ost.antisocialnetwork.ua.repository.UserDataBaseDao

class DetailsUserViewModelFactory (
    private val dataSource: UserDataBaseDao,
    private val application: Application,
) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsUserViewModel::class.java)) {
            return DetailsUserViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}