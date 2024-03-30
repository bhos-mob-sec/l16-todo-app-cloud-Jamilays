package az.edu.bhos.l14todoapp.flows.edit

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import az.edu.bhos.l14todoapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class EditTodoActivity : AppCompatActivity() {

    private val viewModel: EditTodoViewModel by viewModel()

    private lateinit var backBtn: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_todo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupUI()

        backBtn.setOnClickListener {
            // TODO: close the page
        }

        // TODO: show the todo list using recycler view
        // TODO: use the pre-coded layout files - list_item_todo_new, list_item_todo_entry
        // TODO: save each todo entry after keyboard click "DONE"
        // TODO: hint - edittext.onDone { saveData() }
        // TODO: show category selector at bottom `layout_category_selector`

        viewModel.selectedCategory.observe(this) { category ->
            // TODO: indicate the selected category visually
        }
    }

    private fun setupUI() {
        backBtn = findViewById(R.id.backBtn)
    }
}