package com.edwin.randompicture.cache.dao

import android.arch.persistence.room.*
import com.edwin.randompicture.cache.model.CachedPendingPost


@Dao
interface CachedPendingPostDao {

    companion object {
        const val TABLE_NAME = "pending_post"
        const val FIELD_ID = "id"
    }

    @Query("Select * from $TABLE_NAME LIMIT 1")
    fun getFirstPendingPost(): CachedPendingPost

    @Query("Select * FROM $TABLE_NAME WHERE $FIELD_ID = :id")
    fun getPendingPostById(id: Long): CachedPendingPost

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPendingPost(pendingPost: CachedPendingPost): Long

    @Delete
    fun delete(cachedPendingPost: CachedPendingPost)
}