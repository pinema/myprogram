
const editor = CKEDITOR.replace('editor1');

// 提交富文本
$("#commit").click(function () {
    let richText = CKEDITOR.instances.editor1.getData();
    console.log("提交文本：" + richText);
});

function showDialog() {
    window.open("/file", "", "width=768, height=500, location=no,")
}