class RegisterContract {

    interface View {
        fun showMessage(message: String)
        fun navigateToLogin()
    }

    interface Presenter {
        fun register(
            name: String,
            email: String,
            password: String,
            confirmPassword: String
        )
    }
}