package az.edu.bhos.l14todoapp.flows.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import az.edu.bhos.l14todoapp.data.TodoRepository
import az.edu.bhos.l14todoapp.entities.TodoCategory

class EditTodoViewModel(
    private val todoRepo: TodoRepository
) : ViewModel() {

    private val _selectedCategory: MutableLiveData<TodoCategory> =
        MutableLiveData(TodoCategory.OTHER)

    val selectedCategory: LiveData<TodoCategory>
        get() = _selectedCategory

    fun saveTodo(title: String) {
        // todo save todo entity in repository
    }

    fun select(category: TodoCategory) {
        _selectedCategory.postValue(category)
    }
}