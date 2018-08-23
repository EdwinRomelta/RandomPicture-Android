package com.edwin.randompicture.presentation.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.edwin.randompicture.domain.interactor.usecase.SavePhoto
import com.edwin.randompicture.presentation.R
import com.edwin.randompicture.presentation.data.Resource
import com.edwin.randompicture.presentation.mapper.PhotoMapper
import com.edwin.randompicture.presentation.model.PhotoView
import javax.inject.Inject

class PhotoViewModel @Inject constructor(private val savePhoto: SavePhoto,
                                         private val photoMapper: PhotoMapper) : BaseViewModel() {

    val photo: LiveData<Resource<PhotoView>>
        get() = photoLiveData
    private val photoLiveData = MutableLiveData<Resource<PhotoView>>()

    init {
        photoLiveData.postValue(Resource.success(PhotoView()))
    }

    fun createPhoto(byteArray: ByteArray) {
        photoLiveData.postValue(Resource.loading())
        compositeDisposable.add(savePhoto.execute(byteArray)
                .subscribe(
                        {
                            photoLiveData.postValue(Resource.success(photoMapper.mapToView(it)))
                        },
                        {
                            photoLiveData.postValue(Resource.error(R.string.capture_errorprocessingimage))
                        }
                ))
    }
}