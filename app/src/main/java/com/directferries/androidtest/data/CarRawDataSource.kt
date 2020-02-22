package com.directferries.androidtest.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream


class CarRawDataSource constructor(
    private val context: Context
) : CarDataSource {
    override fun getCars(): List<CarEntity>? {
        val gson = Gson()
        val itemType = object : TypeToken<List<CarEntity>>() {}.type
        return gson.fromJson<List<CarEntity>>(readJsonFile(), itemType)
    }

    private fun readJsonFile(): String {
        val fileInputStream: InputStream = context.assets.open("cars.json")
        return readFile(fileInputStream)
    }

    fun readFile(inputStream: InputStream): String {
        val outputStream = ByteArrayOutputStream()
        val buf = ByteArray(1024)
        var len: Int = 0
        try {
            while (inputStream.read(buf).also({ len = it }) != -1) {
                outputStream.write(buf, 0, len)
            }
            outputStream.close()
            inputStream.close()
        } catch (e: IOException) {
        }
        return outputStream.toString()
    }
}