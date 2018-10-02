package com.edwin.randompicture.data.repository.post

import com.edwin.randompicture.data.model.PostEntity
import io.reactivex.Single

interface PostRemote {

    fun getPost(): Single<List<PostEntity>>

    fun publishPost(postEntity: PostEntity): Single<PostEntity>
}