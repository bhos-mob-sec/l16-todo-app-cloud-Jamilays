package az.edu.bhos.l14todoapp.di

import az.edu.bhos.l14todoapp.data.TodoLocalData
import az.edu.bhos.l14todoapp.data.TodoLocalDataImpl
import az.edu.bhos.l14todoapp.data.TodoRemoteData
import az.edu.bhos.l14todoapp.data.TodoRemoteDataImpl
import org.koin.dsl.module
import az.edu.bhos.l14todoapp.flows.MainViewModel
import az.edu.bhos.l14todoapp.flows.edit.EditTodoViewModel
import az.edu.bhos.l14todoapp.data.TodoRepository
import az.edu.bhos.l14todoapp.data.TodoRepositoryImpl
import az.edu.bhos.l14todoapp.data.api.TodoAPI
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import org.koin.androidx.viewmodel.dsl.viewModelOf
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory


val androidModule = module {
    viewModelOf(::MainViewModel)
    viewModelOf(::EditTodoViewModel)

    single<TodoLocalData> { TodoLocalDataImpl() }
    factory<TodoRepository> { TodoRepositoryImpl(get(), get()) }

    factory<Json> {
        Json {
            ignoreUnknownKeys = true
        }
    }

    factory<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://6607bbf2a2a5dd477b1355dd.mockapi.io/")
            .addConverterFactory(
                get<Json>().asConverterFactory(
                    "application/json; charset=UTF8".toMediaType()
                )
            )
            .build()
    }

    factory<TodoAPI> { get<Retrofit>().create(TodoAPI::class.java) }

    factory<TodoRemoteData> {
        TodoRemoteDataImpl(get())
    }
}