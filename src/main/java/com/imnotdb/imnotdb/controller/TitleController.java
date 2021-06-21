package com.imnotdb.imnotdb.controller;

import com.imnotdb.imnotdb.commons.JsonResult;
import com.imnotdb.imnotdb.commons.PageJson;
import com.imnotdb.imnotdb.pojo.Title;
import com.imnotdb.imnotdb.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/title")
public class TitleController {
    @Autowired
    private TitleService titleService;
    @ResponseBody
    @GetMapping("/getTitleByTconst")
    public PageJson<Title> getByTconst(@RequestParam String tconst, @RequestParam(defaultValue = "0", required = false) Integer fetchAll){
        Title title = titleService.getTitleByTconst(tconst, fetchAll);
        PageJson<Title> pageJson = new PageJson<>();
        pageJson.getData().add(title);
        return pageJson;
    }
    @ResponseBody
    @PostMapping("/update")
    public JsonResult update(@RequestBody Title title){
        titleService.updateTitle(title);
        return new JsonResult().setOk();
    }
    @ResponseBody
    @PostMapping("/insert")
    public JsonResult insert(@RequestBody Title title){
        titleService.insertTitle(title);
        return new JsonResult().setOk();
    }
    @ResponseBody
    @GetMapping
    public JsonResult delete(@RequestParam String tconst){
        titleService.deleteTitle(tconst);
        return new JsonResult().setOk();
    }
}
