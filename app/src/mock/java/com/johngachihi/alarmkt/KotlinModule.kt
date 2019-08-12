package com.johngachihi.alarmkt

import com.johngachihi.alarmkt.addeditalarm.AddEditAlarmViewModel
import com.johngachihi.alarmkt.data.db.AlarmsDatabase
import com.johngachihi.alarmkt.data.repository.AlarmsRepository
import com.johngachihi.alarmkt.data.repository.FakeAlarmsRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { AlarmsDatabase.getDatabase(androidApplication()).alarmDao() }
    single<AlarmsRepository> { FakeAlarmsRepository() }
    viewModel { AddEditAlarmViewModel(get()) }
}