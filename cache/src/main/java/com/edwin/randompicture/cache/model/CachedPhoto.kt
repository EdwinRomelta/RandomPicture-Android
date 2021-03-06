package com.edwin.randompicture.cache.model

import java.util.*

data class CachedPhoto(
        val folderPath: String,
        val fileName: String,
        val byteArray: ByteArray) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CachedPhoto

        if (folderPath != other.folderPath) return false
        if (fileName != other.fileName) return false
        if (!Arrays.equals(byteArray, other.byteArray)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = folderPath.hashCode()
        result = 31 * result + fileName.hashCode()
        result = 31 * result + Arrays.hashCode(byteArray)
        return result
    }
}