package com.loop.controller;

import com.loop.entity.Notebook;
import com.loop.service.NotebookService;
import com.loop.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/notebook")
public class NotebookController extends BaseController {

    @Resource
    private NotebookService notebookService;

    @RequestMapping("/list.do")
    @ResponseBody
    public JsonResult list(String userId) {
        //调用业务层 notebookService
        List<Map<String, Object>> list =
                notebookService.listNotebooks(userId);
        return new JsonResult(list);
    }

    @RequestMapping("/add.do")
    @ResponseBody
    public JsonResult add(String userId, String name) {
        Notebook notebook = notebookService.addNotebook(userId, name);
        return new JsonResult(notebook);
    }

	
}






