package com.azevedo.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.azevedo.motivation.R
import com.azevedo.motivation.data.Mock
import com.azevedo.motivation.databinding.ActivityMainBinding
import com.azevedo.motivation.infra.MotivationConstants
import com.azevedo.motivation.infra.SecurityPreferences

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = MotivationConstants.FILTER.INFINITY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //Esconder barra de navegação
        supportActionBar?.hide()

        handleUserName()
        handleFilter(R.id.image_infinity)
        handleNextPhrase()

        // Eventos
        binding.buttonNewText.setOnClickListener(this)
        binding.imageInfinity.setOnClickListener(this)
        binding.imageSmile.setOnClickListener(this)
        binding.imageSun.setOnClickListener(this)


    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_new_text) {
            handleNextPhrase()

        } else if (view.id in listOf(R.id.image_infinity, R.id.image_smile, R.id.image_sun)) {
            handleFilter(view.id)

        }
    }

    private fun handleNextPhrase(){
        binding.textText.text = Mock().getPhrase(categoryId)


    }

    private fun handleFilter(id: Int) {

        binding.imageInfinity.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageSmile.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageSun.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

        when (id) {
            R.id.image_infinity -> {
                binding.imageInfinity.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.INFINITY

            }
            R.id.image_smile -> {
                binding.imageSmile.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.SMILE

            }
            R.id.image_sun -> {
                binding.imageSun.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.SUN

            }
        }

    }


    private fun handleUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        binding.textHello.text = "Olá, $name!"
    }

}