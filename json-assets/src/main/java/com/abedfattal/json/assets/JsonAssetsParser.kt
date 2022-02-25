package com.abedfattal.json.assets

import com.abedfattal.json.assets.ContextInitializer.Companion.context
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import java.io.IOException
import java.io.InputStream

class JsonAssetsParser(private val json: Json) {

    fun <T> parse(assetsFilePath: String, dataSerializer: KSerializer<List<T>>): List<T> {
        val data = context.assets.open(assetsFilePath).stringify()

        return Json.decodeFromString(dataSerializer, data)
    }

    fun <T> parse(
        assetsFilePath: String,
        deserializationStrategy: DeserializationStrategy<T>
    ): T {
        val data = context.assets.open(assetsFilePath).stringify()

        return Json.decodeFromString(deserializationStrategy, data)
    }

    private fun InputStream.stringify(): String {
        return try {
            val bytes = ByteArray(available())
            read(bytes, 0, bytes.size)
            String(bytes)
        } catch (e: IOException) {
            ""
        }
    }
}