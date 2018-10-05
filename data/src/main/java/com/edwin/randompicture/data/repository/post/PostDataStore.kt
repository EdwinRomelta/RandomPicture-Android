package com.edwin.randompicture.data.repository.post

import com.edwin.randompicture.data.model.PostEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

interface PostDataStore {

    fun getPost(): Flowable<List<PostEntity>>

    fun publishPost(postEntity: PostEntity): Single<PostEntity>

    fun savePost(postEntity: List<PostEntity>): Completable
}