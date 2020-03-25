
const editor = CKEDITOR.replace('editor1');

// 提交富文本
$("#commit").click(function () {
    let richText = CKEDITOR.instances.editor1.getData();
    console.log("提交文本：" + richText);
});

// 添加文件
$("#btn_addFile").click(function () {
    $("#file").click();
});

let imgPath;
let reset;
$("#file").change(function () {
    var formData = new FormData();
    formData.append('file', $('#file')[0].files[0]);
    $.ajax({
        url: '/common/upload',
        type: 'POST',
        cache: false,
        data: formData,
        processData: false,
        contentType: false
    }).done(function(res) {
        console.log("done");
        // 上传成功则将图片插入预览框
        let textHtml = "<img src='" + res.imgPath + "' style='width:180px;height:150px;'/>";
        document.getElementById("image_position").insertAdjacentHTML("afterend", textHtml);

        // reset =  $("#div1").html();
        // $("#div1").html("<img src='" + res.imgPath + "' style='width:180px;height:150px;'/>");
        // imgPath = "<img src='" + res.imgPath + "'/>";
        // imgPath = "<img src='http://localhost:88/images/profile.jpg'/>";

    }).fail(function(res) {
        console.log("fail");
    });
});

// 图片选择
$(".img-a").click(function () {
    console.log("图片选择");
    // $(this).css("border-color").val("#0a90eb");
    // document.getElementById(divList[divId]).style.setProperty("display", "none");
    // this.setAttribute("border-color", "#0a90eb");
    let nodeList = document.getElementById("image_position").children[0].children;
    for(let i = 0; i < nodeList.length; i ++) {
        nodeList[i].children[0].classList.remove("is_select");
    }
    this.classList.add("is_select");
    imgPath = "<img src='" + this.children[0].src + "'/>";
    console.log(imgPath);

});

$("#confirm").click(function () {
    if (imgPath) {
        // 将图片插入编辑器
        // $("#upload_layout").html(reset);
        CKEDITOR.instances.editor1.insertHtml(imgPath);
        // 关闭弹窗
    } else {
        return;
    }
});