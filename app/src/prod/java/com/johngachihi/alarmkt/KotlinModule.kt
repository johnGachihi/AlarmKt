package com.johngachihi.alarmkt.data.repository

import com.johngachihi.alarmkt.addeditalarm.AddEditAlarmViewModel
import com.johngachihi.alarmkt.data.db.AlarmsDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    factory { AlarmsDatabase.getDatabase(androidApplication()).alarmDao() }
    single<AlarmsRepository> { AlarmsRepositoryImpl(get()) }
    viewModel { AddEditAlarmViewModel(get()) }
}