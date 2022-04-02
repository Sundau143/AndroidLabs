package com.example.android_lab_task_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.android_lab_task_1.databinding.ActivityWordScrambleBinding
import kotlin.random.Random

class WordScrambleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWordScrambleBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityWordScrambleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // деактивація статус-бару та назви застоснку
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        // початок гри
        startGame()

    }

    // функція, яка підготовує дане Activity до початку гри
    private fun startGame() {

        // завантаження слова з ресурсів
        val sWord = getWord()
        // перемішування завантаженого слова
        val mixedWord = mixWord(sWord)
        binding.scrambledWord.text = mixedWord

        binding.buttonUnscramble.setOnClickListener {
            val userWord = binding.userInput.text.toString() ?: ""
            if (userWord == sWord) {
                Toast.makeText(this, "You guessed!", Toast.LENGTH_SHORT).show()
                binding.userInput.text.clear()
                startGame()
            }
            else {
                Toast.makeText(this, "Try again!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // фукнкція для отримання випадкового слова з масиву рядків, який знаходиться в ресурсах
    private fun getWord(): String {
        val words = resources.getStringArray(R.array.words)

        return words[Random.nextInt(words.size)]
    }

    // функція для перемішування рядку
    private fun mixWord(word: String): String {

        val shuffledWord = word.toCharArray().let {
            it.shuffle()
            it.concatToString()
        }

        return shuffledWord
    }

}