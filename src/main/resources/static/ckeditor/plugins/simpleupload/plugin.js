(function () {
    var a = {
            exec: function (editor) {
                console.log("自定义");
                //调用js中的函数弹出上传框，
                showDialog();
                return "asdfaf";
            }
        },
        b = 'simpleupload';
    CKEDITOR.plugins.add(b, {
        init: function (editor) {
            editor.addCommand(b, a);
            editor.ui.addButton('simpleupload', {
                label: '添加图片',  //鼠标悬停在插件上时显示的名字
                icon: 'plugins/simpleupload/image.png',   //自定义图标的路径
                command: b
            });
        }
    });
})();
