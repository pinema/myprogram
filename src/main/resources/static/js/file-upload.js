
// 图片上传的路径
let imgPath;
let imgId;

// 点击上传
$("#upload_btn").click(function () {
    $("#upload_file").click();
});

// 上传图片
$("#upload_file").change(function () {
    var formData = new FormData();
    formData.append('file', $('#upload_file')[0].files[0]);
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
        let textHtml = "<li class=\"file-item\"><a class=\"file-inner\"><img class=\"ui-li-thumb\" id="
            + res.id + " src=" + res.imgPath + " onclick=\"selectImg(this)\"/>"
        document.getElementById("img_area").insertAdjacentHTML("beforeend", textHtml);

    }).fail(function(res) {
        console.log("fail");
    });
});

// 点击图片
$(".file-inner").click(function () {
    console.log("图片选择");
    rmIsSelected();
    this.classList.add("is_select");
    imgPath = "<img src='" + this.children[0].src + "'/>";
    imgId = this.children[0].id;
    console.log(imgPath);

});

function selectImg (elem) {
    console.log("图片选择");
    rmIsSelected();
    elem.parentElement.classList.add("is_select");
    imgPath = "<img src='" + elem.src + "'/>";
    imgId = elem.id;
    console.log(imgPath);

}

// 选择图片
$("#select_btn").click(function () {
    if (imgPath) {
        // 将图片插入编辑器
        // CKEDITOR.instances.editor1.insertHtml(imgPath);
        // 关闭弹窗
        // close
        console.log("insert image:" + imgPath);
    } else {
        return;
    }
});

// 删除图片
$("#delete_btn").click(function () {
    if (imgId) {
        document.getElementById(imgId).parentElement.parentElement.remove();
        $.ajax({
            type: "POST",
            url: "/common/delete",
            data: {
                imgId:  imgId,
                imgPath: imgPath,
            },
            // dataType: "json",
            success: function(data){
                console.log(data);
            },
            error: function(){
                console.error("error");
            }
        });

        console.log("delete imgId:" + imgId);
        console.log("delete imgSrc:" + imgPath);
    } else {
        return;
    }
});

function rmIsSelected() {
    let nodeList = document.getElementById("img_area").children;
    for(let i = 0; i < nodeList.length; i ++) {
        nodeList[i].children[0].classList.remove("is_select");
    }
}
