package com.example.login

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    lateinit var password: TextInputEditText
    lateinit var confirmPassword: TextInputEditText
    lateinit var passwordLayout: TextInputLayout
    lateinit var confirmLayout: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // INIT VIEW
        password = findViewById(R.id.passwordInput)
        confirmPassword = findViewById(R.id.confirmPasswordInput)

        passwordLayout = findViewById(R.id.passwordLayout)
        confirmLayout = findViewById(R.id.confirmLayout)

        val name = findViewById<TextInputEditText>(R.id.nameInput)
        val email = findViewById<TextInputEditText>(R.id.emailInput)

        val nameLayout = findViewById<TextInputLayout>(R.id.nameLayout)
        val emailLayout = findViewById<TextInputLayout>(R.id.emailLayout)

        val btn = findViewById<Button>(R.id.registerButton)
        val hobbyGroup = findViewById<ChipGroup>(R.id.hobbyGroup)

        // REAL-TIME VALIDATION PASSWORD
        confirmPassword.addTextChangedListener {
            val pass = password.text.toString()
            val confirm = confirmPassword.text.toString()

            if (confirm != pass) {
                confirmLayout.error = "Password tidak cocok"
            } else {
                confirmLayout.error = null
            }
        }

        // SPINNER
        val spinner = findViewById<Spinner>(R.id.spinner)

        val data = arrayOf(
            "Pilih Kota",
            "Jakarta",
            "Bandung",
            "Surabaya",
            "Yogyakarta"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            data
        )

        spinner.adapter = adapter

        // BUTTON LONG PRESS
        btn.setOnLongClickListener {

            Toast.makeText(this, "Long Press terdeteksi 🔥", Toast.LENGTH_SHORT).show()

            true
        }

        // BUTTON CLICK
        btn.setOnClickListener {

            val nameVal = name.text.toString()
            val emailVal = email.text.toString()
            val pass = password.text.toString()
            val confirm = confirmPassword.text.toString()

            var valid = true

            // NAME
            if (nameVal.isEmpty()) {
                nameLayout.error = "Nama tidak boleh kosong"
                valid = false
            }

            // EMAIL
            if (emailVal.isEmpty()) {
                emailLayout.error = "Email tidak boleh kosong"
                valid = false
            } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailVal).matches()) {
                emailLayout.error = "Format email tidak valid"
                valid = false
            }

            // VALIDASI PASSWORD
            if (pass.isEmpty()) {
                passwordLayout.error = "Password tidak boleh kosong"
                valid = false
            } else {
                passwordLayout.error = null
            }
            if (confirm.isEmpty()) {
                confirmLayout.error = "Konfirmasi Password tidak boleh kosong"
                valid = false
            } else {
                confirmLayout.error = null
            }

            if (pass.length < 6) {
                passwordLayout.error = "Minimal 6 karakter"
                valid = false
            }

            if (pass != confirm) {
                confirmLayout.error = "Password tidak cocok"
                valid = false
            } else {
                confirmLayout.error = null
            }

            // AMBIL HOBI
            val selectedHobbies = mutableListOf<String>()

            for (i in 0 until hobbyGroup.childCount) {
                val chip = hobbyGroup.getChildAt(i) as Chip
                if (chip.isChecked) {
                    selectedHobbies.add(chip.text.toString())
                }
            }

            // VALIDASI MIN 3 HOBI
            if (selectedHobbies.size < 3) {
                Toast.makeText(this, "Pilih minimal 3 hobi", Toast.LENGTH_SHORT).show()
                valid = false
            }

            val selected = spinner.selectedItem.toString()

            if (selected == "Pilih Kota") {
                Toast.makeText(this, "Pilih kota terlebih dahulu", Toast.LENGTH_SHORT).show()
                valid = false
            }

            if (!valid) return@setOnClickListener
            // SUCCESS
            AlertDialog.Builder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah data sudah benar?")
                .setPositiveButton("Ya") { _, _ ->
                    Toast.makeText(this, "Register berhasil 🎉", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Batal", null)
                .show()
        }
    }
}