package flame4ost.antisocialnetwork.ua.model

data class User(val id: Int, val name: String, val time: String, val photoUri: String,
                val status: String, val socialScore: Int, val followers: Int, val following: Int,
                val posts: String, val reach: String, val sharemeter: Int) {

}