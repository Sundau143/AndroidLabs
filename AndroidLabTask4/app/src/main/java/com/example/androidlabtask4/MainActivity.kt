
package com.example.androidlabtask4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidlabtask4.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val list: MutableList<WordSet> = mutableListOf()
    private var setCounter = 0


    override fun onCreate(savedInstanceState: Bundle?) {

        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        val difficulties = resources.getStringArray(R.array.difficulties)
        val flags = resources.getStringArray(R.array.flags)

        val adapter = WordSetAdapter(layoutInflater)

        binding.wordSetList.adapter = adapter
        binding.wordSetList.layoutManager = LinearLayoutManager(this)

        adapter.submitList(null)

        binding.btnAdd.setOnClickListener {

            val randomDifficulty = Random.nextInt(0, difficulties.size)
            setCounter += 1

            val randomFlag = Random.nextInt(0, flags.size)

            val addedItem = WordSet("Набір слів №$setCounter", difficulties[randomDifficulty], flags[randomFlag])
            list.add(addedItem)

            adapter.submitList(list.toList())
            binding.wordSetList.smoothScrollToPosition(list.size - 1)
        }

        binding.btnDelete.setOnClickListener {
            if (list.isNotEmpty()) {
                list.removeLast()
                adapter.submitList(list.toList())
            }
        }

        binding.btnClear.setOnClickListener {
            list.clear()
            adapter.submitList(list.toList())
        }
    }
    
    //data class WordSet(val word: String, val definition: String)
    data class WordSet(val name: String, val difficulty: String, val flag: String)

}