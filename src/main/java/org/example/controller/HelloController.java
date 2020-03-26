package org.example.controller;

import org.example.domain.ImageModel;
import org.example.domain.SortableModel;
import org.example.utils.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        ImageModel imageModel = new ImageModel();
        List<ImageModel> imageModelList = new ArrayList<ImageModel>();

        imageModel = new ImageModel();
        imageModel.setImgId("img001");
        imageModel.setImgName("back.jpg");
        imageModel.setImgUrl("http://localhost:88/images/back.jpg");
        imageModel.setImgSize("56.1KB");
        imageModel.setUpDate("2020年3月24日 0:45 上午");
        imageModelList.add(imageModel);

        imageModel = new ImageModel();
        imageModel.setImgId("img002");
        imageModel.setImgName("girl.jpg");
        imageModel.setImgUrl("http://localhost:88/images/girl.jpg");
        imageModel.setImgSize("207KB");
        imageModel.setUpDate("2020年3月24日 1:20 上午");
        imageModelList.add(imageModel);

        imageModel = new ImageModel();
        imageModel.setImgId("img003");
        imageModel.setImgName("loginBack.jpg");
        imageModel.setImgUrl("http://localhost:88/images/loginBack.jpg");
        imageModel.setImgSize("37.8KB");
        imageModel.setUpDate("2020年3月24日 2:30 上午");
        imageModelList.add(imageModel);

        imageModel = new ImageModel();
        imageModel.setImgId("img004");
        imageModel.setImgName("profile.jpg");
        imageModel.setImgUrl("http://localhost:88/images/profile.jpg");
        imageModel.setImgSize("79.2KB");
        imageModel.setUpDate("2020年3月24日 4:50 上午");
        imageModelList.add(imageModel);

        model.addAttribute("imageModelList", imageModelList);
        model.addAttribute("name", "Dear my heart editorTrial!!!!!!!");
        return "editorTrial";
    }

    /**
     * 通用上传请求
     */
    @PostMapping("/common/upload")
    @ResponseBody
    public Map uploadFile(MultipartFile file) throws Exception
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("imgPath", "http://localhost:88/images/profile.jpg");
        map.put("imgName", "ceshitest.jpg");
        map.put("imgDate", "2020年3月25日 21:50 下午");
        map.put("id", "img_test_one");
        return  map;
    }

    /**
     * 通用删除请求
     */
    @PostMapping("/common/delete")
    @ResponseBody
    public Map deleteFile(HttpServletRequest request) throws Exception
    {
        String imgId = request.getParameter("imgId");
        String imgPath = request.getParameter("imgPath");

        Map<String, String> map = new HashMap<String, String>();
        map.put("id", imgId);
        map.put("imgPath", imgPath);
        map.put("data", "success");
        return  map;
    }

    /**
     * 图片上传 file
     * @return
     */
    @RequestMapping(value = "/file",method = RequestMethod.GET)
    public String uploadFile(Model model) {
        ImageModel imageModel = new ImageModel();
        List<ImageModel> imageModelList = new ArrayList<ImageModel>();

        imageModel = new ImageModel();
        imageModel.setImgId("img001");
        imageModel.setImgName("back1223243536456456sdfsdfxvggdfer123424534564564.jpg");
        imageModel.setImgUrl("http://localhost:88/images/back.jpg");
        imageModel.setImgSize("56.1KB");
        imageModel.setUpDate("2020年3月24日 0:45 上午");
        imageModelList.add(imageModel);

        imageModel = new ImageModel();
        imageModel.setImgId("img002");
        imageModel.setImgName("girl.jpg");
        imageModel.setImgUrl("http://localhost:88/images/girl.jpg");
        imageModel.setImgSize("207KB");
        imageModel.setUpDate("2020年3月24日 1:20 上午");
        imageModelList.add(imageModel);

        imageModel = new ImageModel();
        imageModel.setImgId("img003");
        imageModel.setImgName("loginBack.jpg");
        imageModel.setImgUrl("http://localhost:88/images/loginBack.jpg");
        imageModel.setImgSize("37.8KB");
        imageModel.setUpDate("2020年3月24日 2:30 上午");
        imageModelList.add(imageModel);

        imageModel = new ImageModel();
        imageModel.setImgId("img004");
        imageModel.setImgName("profile.jpg");
        imageModel.setImgUrl("http://localhost:88/images/profile.jpg");
        imageModel.setImgSize("79.2KB");
        imageModel.setUpDate("2020年3月24日 4:50 上午");
        imageModelList.add(imageModel);

        model.addAttribute("imageModelList", imageModelList);
        model.addAttribute("name", "Dear my heart file upload!!!!!!!");
        return "file";
    }

}
