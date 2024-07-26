package com.example.desafio

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.desafio.databinding.ActivityAddDesafioBinding

class AddDesafioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddDesafioBinding
    private lateinit var db: NotesDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddDesafioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NotesDatabaseHelper(this)

        binding.saveButton.setOnClickListener {
            val title = binding.titleEditText.text.toString()
            val content = binding.contentEditText.text.toString()
            val note = Note(
                id = 0,
                title = title,
                content = content,
                isCompleted = false // Aquí se proporciona el valor para isCompleted
            )
            db.insertNote(note)
            finish()
            Toast.makeText(this, "Nota Guardada", Toast.LENGTH_SHORT).show()
        }
    }
}
