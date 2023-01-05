package com.univerlist.commonui.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ValidatorOtp

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ValidatorEmail

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ValidatorSsn

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ValidatorPassword

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ValidatorFullName

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MainDispatcher

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IoDispatcher

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DefaultDispatcher

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class UnconfinedDispatcher
