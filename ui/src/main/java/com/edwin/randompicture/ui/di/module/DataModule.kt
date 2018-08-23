package com.edwin.randompicture.ui.di.module

import com.edwin.randompicture.data.PendingPostDataRepository
import com.edwin.randompicture.data.PhotoDataRepository
import com.edwin.randompicture.domain.repository.PendingPostRepository
import com.edwin.randompicture.domain.repository.PhotoRepository
import com.edwin.randompicture.ui.di.scope.PerApplication
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @PerApplication
    @Provides
    fun providePhotoRepository(photoDataRepository: PhotoDataRepository): PhotoRepository = photoDataRepository

    @PerApplication
    @Provides
    fun providePendingPostDataRepository(pendingPostDataRepository: PendingPostDataRepository): PendingPostRepository = pendingPostDataRepository
}