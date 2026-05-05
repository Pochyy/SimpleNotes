class RegisterPresenter(
    private val view: RegisterContract.View,
    private val model: RegisterModel
) : RegisterContract.Presenter {

    override fun register(
        name: String,
        email: String,
        password: String,
        confirmPassword: String
    ) {

        if (password != confirmPassword) {
            view.showMessage("Password mismatch!")
            return
        }

        model.saveUser(name, email, password)

        view.showMessage("Registered Successfully")
        view.navigateToLogin()
    }
}