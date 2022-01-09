package com.junaid.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.junaid.Models.TaskModel;
import com.junaid.Repo.TaskRepo;

@RestController
public class TaskController {

	@Autowired
	private TaskRepo taskRepo;

	@GetMapping("/tasks")
	public List<TaskModel> tasks(){
		return taskRepo.findAll();
	}

	@GetMapping("/tasks/{Taskid}")
	public TaskModel tasks(@PathVariable String Taskid){

		return taskRepo.getById(Long.parseLong(Taskid));
		//return taskRepo.getOne(Long.parseLong(Taskid));
	}

	@PostMapping("/tasks")
	public TaskModel addtasks(@RequestBody TaskModel tm){
		
		return taskRepo.save(tm);
	}

	//not working
	@PutMapping("/tasks/{Taskid}")
	public TaskModel puttask(@PathVariable String Taskid,@RequestBody TaskModel tm){

		return taskRepo.save(tm);
	}

	@DeleteMapping("/tasks/{Taskid}")
	public List<TaskModel> deletetask(@PathVariable String Taskid){
		taskRepo.deleteById(Long.parseLong(Taskid));
		return taskRepo.findAll();
	}

}