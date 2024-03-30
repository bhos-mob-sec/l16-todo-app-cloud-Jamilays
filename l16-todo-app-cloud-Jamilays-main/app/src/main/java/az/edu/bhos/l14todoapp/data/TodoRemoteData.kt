package az.edu.bhos.l14todoapp.data

import android.util.Log
import az.edu.bhos.l14todoapp.data.api.TodoAPI
import az.edu.bhos.l14todoapp.data.dto.TodoRemoteDto

interface TodoRemoteData {
    suspend fun getTodos(): List<TodoRemoteDto>
}

class TodoRemoteDataImpl(
    private val api: TodoAPI
) : TodoRemoteData {
    override suspend fun getTodos(): List<TodoRemoteDto> {
        return try {
            api.getTodos()
        } catch (ex: Exception) {
            Log.e("NETWORK", ex.toString())
            emptyList()
        }
    }
}