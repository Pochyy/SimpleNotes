import android.content.Context

class RegisterModel(private val context: Context) {

    fun saveUser(name: String, email: String, password: String) {
        val sharedPref = context.getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        editor.putString("name", name)
        editor.putString("email", email)
        editor.putString("password", password)

        editor.apply()
    }
}