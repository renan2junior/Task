package com.example.renanjunior.task.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.renanjunior.task.R
import com.example.renanjunior.task.business.UserBusiness
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() , View.OnClickListener {

    lateinit var mUserBusiness : UserBusiness

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mUserBusiness = UserBusiness(this)

        setListiners()
    }

    private fun setListiners() {
        buttonLogin.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.buttonLogin -> {
                handleLogin()
            }
        }
    }

    private fun handleLogin() {
        val email = editEmail.text.toString()
        val password = editPassword.text.toString()

        if(email != "" && password!="") {
            try {
                mUserBusiness.login(email, password)
                val intent : Intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }catch (e:Exception){
                throw e
            }

        }else{
            Toast.makeText(this, "Dados não preenchidos", Toast.LENGTH_LONG).show()
        }

    }
}
