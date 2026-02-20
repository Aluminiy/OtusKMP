package com.example.otuskmp

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context

lateinit var androidContext: Context

actual fun copyToClipboard(text: String) {
    val clipboard = androidContext.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText("Stopwatch", text)
    clipboard.setPrimaryClip(clip)
}
