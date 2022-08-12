package flame4ost.antisocialnetwork.ua.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import flame4ost.antisocialnetwork.ua.R
import flame4ost.antisocialnetwork.ua.repository.UserDataBase
import flame4ost.antisocialnetwork.ua.view_model.details_vm.DetailsUserViewModel
import flame4ost.antisocialnetwork.ua.view_model.details_vm.DetailsUserViewModelFactory
import kotlinx.android.synthetic.main.edit_profile_activity.*

class EditUserActivity : AppCompatActivity() {

    private lateinit var vm: DetailsUserViewModel
    private var strTime: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_profile_activity)

        val dataSource = UserDataBase.getDatabase(application).userDataBaseDao()

        val detailsUserViewModelFactory = DetailsUserViewModelFactory(dataSource, application)
        vm = ViewModelProvider(this, detailsUserViewModelFactory)[DetailsUserViewModel::class.java]

        vm.setUserId(getUserIdFromUserDetails())
        onClickButChange()
        initUserDetailsObservers()
    }

    private fun initUserDetailsObservers() {
        vm.userDetailsLiveData.observe(this, Observer {
            title = it.name
            editLink.setText(it.photoUri)
            editName.setText(it.name)
            editStatus.setText(it.status)
            editFollowers.setText(it.followers.toString())
            editFollowing.setText(it.following.toString())
            editSocialScope.setText(it.socialScore.toString())
            editSharemeter.setText(it.sharemeter.toString())
            editReach.setText(it.reach)
            editPosts.setText(it.posts)
            strTime = it.time
        })
    }

    private fun onClickButChange() {
        btn_change.setOnClickListener {
            if (vm.validateAndUpdateUser(
                    editLink.text.toString(),
                    editName.text.toString(),
                    editStatus.text.toString(),
                    editFollowers.text.toString(),
                    editFollowing.text.toString(),
                    editSocialScope.text.toString(),
                    editSharemeter.text.toString(),
                    editReach.text.toString(),
                    editPosts.text.toString(),
                    strTime,
                )
            ) {
                finish()
            } else {
                val toast = Toast.makeText(
                    this,
                    "Please fill in all fields !!", Toast.LENGTH_SHORT
                )
                toast.show()
            }
        }
    }

    private fun getUserIdFromUserDetails() = intent.extras?.getInt("id")!!.toInt()
}