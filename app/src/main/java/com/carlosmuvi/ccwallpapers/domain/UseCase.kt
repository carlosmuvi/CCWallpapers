package com.carlosmuvi.ccwallpapers.domain

interface UseCase<T, R> {

    fun execute(t: T, onSuccess: (r: R) -> Unit, onError: (error: Exception) -> Unit)

}