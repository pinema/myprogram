package org.example.controller;

import org.example.domain.SortableModel;
import org.example.utils.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);
    /**
     * 测试hello
     * @return
     */
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("name", "Dear");
        return "hello";
    }

    /**
     * 测试 save
     * @return
     */
    @PostMapping("/dataListSave")
    @ResponseBody
    public String dataListSave(HttpServletRequest request)
    {
        logger.debug("==func dataSav start==elementIdList :"+request.getParameter("elementIdList"));
        String elementIdList = request.getParameter("elementIdList");
        List<SortableModel> stModelList = new ArrayList<SortableModel>();
        stModelList = JSONUtil.toCollection(ArrayList.class, SortableModel.class, elementIdList);
        for(int i = 0; i < stModelList.size(); i ++) {
            String id = stModelList.get(i).getElemId();
            String disFlg = stModelList.get(i).getDisFlg();
            String info = stModelList.get(i).getInfo();
            System.out.println("==div_id--div_flg--div_info :" + id + "--"
            + disFlg + "--" + info);
        }
        return "hello data";
    }

    /**
     * 测试sortable
     * @return
     */
    @RequestMapping(value = "/sortable",method = RequestMethod.GET)
    public String sortable(Model model) {
        List<SortableModel> stModelList = new ArrayList<SortableModel>();
        SortableModel sortModel = new SortableModel();
        sortModel.setElemId("item6");
        sortModel.setDisFlg("1");
        sortModel.setInfo("item6 info");
        stModelList.add(sortModel);

        sortModel = new SortableModel();
        sortModel.setElemId("item2");
        sortModel.setInfo("item2 info");
        sortModel.setDisFlg("1");
        stModelList.add(sortModel);

        sortModel = new SortableModel();
        sortModel.setElemId("item5");
        sortModel.setInfo("item5 info");
        sortModel.setDisFlg("1");
        stModelList.add(sortModel);

        sortModel = new SortableModel();
        sortModel.setElemId("item7");
        sortModel.setInfo("item7 info");
        sortModel.setDisFlg("0");
        stModelList.add(sortModel);

        sortModel = new SortableModel();
        sortModel.setElemId("item1");
        sortModel.setInfo("item1 info");
        sortModel.setDisFlg("0");
        stModelList.add(sortModel);

        sortModel = new SortableModel();
        sortModel.setElemId("item4");
        sortModel.setInfo("item4 info");
        sortModel.setDisFlg("1");
        stModelList.add(sortModel);

        sortModel = new SortableModel();
        sortModel.setElemId("item3");
        sortModel.setInfo("item3 info");
        sortModel.setDisFlg("1");
        stModelList.add(sortModel);

        model.addAttribute("name", "Dear my heart!!!!!!!");
        model.addAttribute("stModelList", stModelList);
        model.addAttribute("stModelList1", JSONUtil.toJson(stModelList));
        return "sortable";
    }

    /**
     * 测试color selector
     * @return
     */
    @RequestMapping(value = "/color",method = RequestMethod.GET)
    public String color(Model model) {
        model.addAttribute("name", "Dear my heart!!!!!!!");
        return "color";
    }

    /**
     * 测试 轮播图 carousel
     * @return
     */
    @RequestMapping(value = "/carousel",method = RequestMethod.GET)
    public String carousel(Model model) {
        model.addAttribute("name", "Dear my heart!!!!!!!");
        return "carousel";
    }


    /**
     * 测试 图片上传和文字编辑 editorTrial
     * @return
     */
    @RequestMapping(value = "/editorTrial",method = RequestMethod.GET)
    public String editorTrial(Model model) {
        model.addAttribute("name", "Dear my heart!!!!!!!");
        return "editorTrial";
    }
}
