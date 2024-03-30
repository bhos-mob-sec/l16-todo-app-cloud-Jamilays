package az.edu.bhos.l14todoapp.entities

data class TodoBundle(
    val weekday: String,
    val todos: List<TodoEntity>
)