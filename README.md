# 📱 Aplikasi Form Register Android

Aplikasi Android modern yang dibuat menggunakan **Kotlin** dan **Material 3**, dengan fitur autentikasi lengkap, validasi lanjutan, gesture interaction, serta tampilan UI yang clean dan responsif.

---

## 🚀 Fitur Utama

### 🔐 1. Form Lengkap (Register)

  * Nama
  * Email
  * Password
  * Konfirmasi Password

---

### ⚙️ 2. Validasi Lanjutan (Advanced Validation)

* Validasi real-time (langsung saat mengetik)
* Validasi field tidak boleh kosong
* Validasi format email
* Validasi password:

  * Minimal 6 karakter
  * Konfirmasi password harus sama
* Menampilkan error menggunakan **TextInputLayout**

---

### 🎯 3. Selection Controls

* Pilihan jenis kelamin:

  * Menggunakan RadioGroup / Chip (UI modern)
* Pilihan hobi:

  * Menggunakan ChipGroup (multi-select)
* Validasi:

  * Minimal memilih 3 hobi

---

### 📌 4. Spinner & Dialog

* Spinner (dropdown) untuk memilih data (contoh: kota)
* Validasi agar user wajib memilih
* Konfirmasi sebelum submit menggunakan **AlertDialog**

---

### ✋ 5. Gesture Interaction

* Implementasi **Long Press** pada tombol Register:

  * Reset form
  * Aksi tambahan interaktif

---

### 🎨 6. UI Modern

* Menggunakan Material 3
* Input field dengan sudut rounded
* Button dan layout custom
* Tampilan clean dan responsif
* Terinspirasi dari UI modern (seperti Tailwind)

---

### 💾 7. Penyimpanan Data

* Menggunakan **SharedPreferences**
* Menyimpan:

  * Email
  * Password
* Digunakan untuk proses login

---

## 🛠️ Teknologi yang Digunakan

* **Bahasa:** Kotlin
* **UI:** XML + Material 3
* **Arsitektur:** Activity-based
* **Penyimpanan:** SharedPreferences

---

## 📂 Struktur Project

```
com.example.login
│
├── MainActivity.kt        # Halaman Register
├── LoginActivity.kt       # Halaman Login
│
├── res/
│   ├── layout/
│   │   ├── activity_main.xml     # UI Register
│   │   ├── activity_login.xml    # UI Login
│   │
│   ├── drawable/                 # Icon & background
│   └── values/
```

---

## ⚡ Cara Menjalankan

1. Clone repository:

   ```bash
   git clone https://github.com/username/nama-repo.git
   ```

2. Buka di **Android Studio**

3. Sync Gradle

4. Jalankan di:

   * Emulator, atau
   * Perangkat Android

---

## 🧪 Alur Aplikasi

```
Register → Validasi → Simpan Data → Login → Berhasil
```

---

## 📌 Checklist Requirement

| Requirement         | Status |
| ------------------- | ------ |
| Form Lengkap        | ✅      |
| Advanced Validation | ✅      |
| Selection Controls  | ✅      |
| Spinner & Dialog    | ✅      |
| Gesture Interaction | ✅      |
| GitHub Repository   | ✅      |

---

## 👨‍💻 Developer

**Taufik Ismail**

---

## 📄 Lisensi

Project ini dibuat untuk keperluan pembelajaran.
