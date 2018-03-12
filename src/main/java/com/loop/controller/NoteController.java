package com.loop.controller;

import com.loop.entity.Note;
import com.loop.service.NoteService;
import com.loop.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/note")
public class NoteController extends BaseController {
	
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/list.do")
	@ResponseBody
	public JsonResult list(String notebookId){
		List<Map<String, Object>> list=
			noteService.listNotes(notebookId);
		return new JsonResult(list);
	}	
	
	@RequestMapping("/get.do")
	@ResponseBody
	public JsonResult get(String noteId){
		Note note = noteService.getNote(noteId);
		return new JsonResult(note);
	}	
	
	@RequestMapping("/update.do")
	@ResponseBody
	public JsonResult update(String noteId,
			String title, String body){
		boolean success = noteService.update(noteId,title, body);
		return new JsonResult(success);
	}	
	
	@RequestMapping("/add.do")
	@ResponseBody
	public JsonResult add(String userId, 
			String notebookId, String title){
		Note note=noteService.addNote(
			userId, notebookId, title);
		return new JsonResult(note);
	}
	@RequestMapping("/move.do")
	@ResponseBody
	public JsonResult move(String noteId, String notebookId) {
		boolean success = noteService.moveNote(noteId, notebookId);
		return new JsonResult(success);
	}

	@RequestMapping("/remove.do")
	@ResponseBody
	public JsonResult remove(String noteId) {
		boolean success = noteService.removeNote(noteId);
		return new JsonResult(success);
	}
}





