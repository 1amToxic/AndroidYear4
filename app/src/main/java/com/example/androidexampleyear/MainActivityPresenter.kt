package com.example.androidexampleyear

class MainActivityPresenter(viewz: MainView) {
    private lateinit var user : User
    private var view : MainView = viewz
    init {
        user = User()
    }
    fun updateUser(userz : User){
        view.showProgressBar()
        user = userz
    }
    fun loginWithUser(){

        if(user.username == "admin" && user.password == "1"){
            view.onLoginSuccess()
        }
        else{
            view.onLoginFailure()
        }
        view.hideProgressBar()
    }
    interface MainView{
        fun hideProgressBar()
        fun showProgressBar()
        fun onLoginSuccess()
        fun onLoginFailure()
    }
}
