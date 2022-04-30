package com.example.androidlabtask3

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import com.example.androidlabtask3.databinding.ActivityMainBinding
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var takeImageResult: ActivityResultLauncher<Uri>
    private lateinit var uri: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        takeImageResult = registerForActivityResult(ActivityResultContracts.TakePicture()) { isSuccess ->
            if (isSuccess) {
                binding.photo.setImageURI(uri)
                Toast.makeText(this, "Фото успішно зроблене!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Фотографування відмінено", Toast.LENGTH_SHORT).show()
            }
        }
        // TODO написати код, який виводитиме повідомлення про відстутність доступу до камери

        binding.btnPhoto.setOnClickListener {
            val callCameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            if (callCameraIntent.resolveActivity(packageManager) != null) {
                val imageFile: File = getImageFromGallery()
                val imageURI = FileProvider.getUriForFile(this, "com.example.android.fileprovider", imageFile)
                uri = imageURI
                takeImageResult.launch(imageURI)
            }
            else Toast.makeText(this, "Підходящі застосунки відсутні", Toast.LENGTH_SHORT).show()
        }

        binding.btnSend.setOnClickListener {
            if (binding.photo.drawable == null) {
                Toast.makeText(this, "Спочатку зробіть фотографію", Toast.LENGTH_SHORT).show()
            }
            else {
                val sharedIntent = Intent(Intent.ACTION_SEND).apply {
                        putExtra(Intent.EXTRA_SUBJECT, "УІ-191 Кисельов Даніїл. Селфі з ЛР№3 з ПМП")
                        putExtra(Intent.EXTRA_TEXT, "Додаток до написаного письма - моє селфі")
                        putExtra(Intent.EXTRA_STREAM, uri)
                        putExtra(Intent.EXTRA_EMAIL, arrayOf("Hodovychenko.labs@gmail.com"))
                        type = "text/plain"
                }
                startActivity(Intent.createChooser(sharedIntent, "Оберіть застосунок: "))
            }
        }
    }

    @Throws(IOException::class)
    private fun getImageFromGallery(): File {
        val timestamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageName = "jpg_$timestamp"
        val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)

        return File.createTempFile(imageName, ".jpg", storageDir)
    }
}