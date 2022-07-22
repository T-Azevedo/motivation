package com.azevedo.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.azevedo.motivation.R
import com.azevedo.motivation.databinding.ActivityUserBinding
import com.azevedo.motivation.infra.MotivationConstants
import com.azevedo.motivation.infra.SecurityPreferences

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //Esconder barra de navegação
        supportActionBar?.hide()

        // Eventos
        binding.buttonSave.setOnClickListener(this)

        verifyUserName()

    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_save) {
            handleSave()

        }
    }

    private fun verifyUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)

        if(name != "") {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }


    private fun handleSave() {

        val name = binding.editName.text.toString()

        if (name != "") {

            SecurityPreferences(this).storeString("USER_NAME", name)


            startActivity(Intent(this, MainActivity::class.java))
            finish()

        } else {
            Toast.makeText(this, R.string.validation_mandatory_name, Toast.LENGTH_SHORT).show()
        }

    }

}
