class MainViewModel(
    todoRepo: TodoRepository
) : ViewModel() {

    private val _todoBundles: MutableLiveData<List<TodoBundle>> = MutableLiveData()

    val todoBundles: LiveData<List<TodoBundle>>
        get() = _todoBundles

    init {
        viewModelScope.launch {
            todoRepo.syncTodos()
        }

        todoRepo.observeTodoEntries()
            .onEach { todos ->
                val groupedTodos = todos.groupBy { it.weekday }
                val todoBundles = groupedTodos.map { (weekday, todos) ->
                    TodoBundle(
                        todos = todos,
                        weekday = weekday
                    )
                }.sortedBy { bundle ->
                    val order = when (bundle.weekday.toLowerCase()) {
                        "monday" -> 1
                        "tuesday" -> 2
                        "wednesday" -> 3
                        "thursday" -> 4
                        "friday" -> 5
                        "saturday" -> 6
                        "sunday" -> 7
                        else -> Int.MAX_VALUE
                    }
                    order
                }

                _todoBundles.postValue(todoBundles)
            }.launchIn(viewModelScope)
    }
}