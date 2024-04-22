 package com.in28minutes.myfirstwebapp.loginAuthentticationService.loginController;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.in28minutes.myfirstwebapp.entities.Todo;
import com.in28minutes.myfirstwebapp.loginAuthentticationService.TodoService;

import jakarta.validation.Valid;

@Controller
public class TodoController {
	
	
       public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

       private  TodoService todoService;

	@RequestMapping("list-todos")
       public String listAllTodos(ModelMap model) {
		List<Todo>todos= todoService.findByUsername("shoaib");
		model.addAttribute("todos", todos);
    	   return "listTodos";
       }
	
	@GetMapping(value="add-todo")
    public String showNewTodoPage(ModelMap model) {
		String username=(String)model.get("name");
		Todo todo= new Todo(0,username,"Default Des",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		
 	   return "todo";
    }
	
	@PostMapping(value="add-todo")
    public String addNewTodo(ModelMap model,@Valid Todo todo,BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		String username=(String)model.get("name");
		todoService.addTodo(username,todo.getDescription(),
				todo.getTargetDate(),false);
 	   return "redirect:list-todos";
    }
	
	@RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {
//		delete todo by the specific id
		todoService.deleteById(id);
		
		return "redirect:list-todos";
    }
	
	@GetMapping(value="update-todo")
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
//		update  todo page 
		Todo todo= todoService.findById(id);
		model.addAttribute("todo",todo);
		return "todo";
    }
	
	@PostMapping(value="update-todo")
    public String updateTodo(ModelMap model,@Valid Todo todo,BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		String username=(String)model.get("name");
		todoService.updateTodo(todo);
 	   return "redirect:list-todos";
    }
	
	
}
