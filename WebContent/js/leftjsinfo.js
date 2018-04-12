var navbutton = document.getElementsByClassName("navbutton")[0];
var leftnavinfo = document.getElementsByClassName("leftnavinfo")[0];
var isclick = true;

navbutton.onclick = function() {
  if (isclick) {
    // 点击
    leftnavinfo.className = "leftnavinfos";
    isclick = false;
  } else {
    leftnavinfo.className = "leftnavinfo";
    isclick = true;
  }
};

function changeCode() {
  var img = document.getElementById("codeimg");
  img.src = "/Graduation/code?time=" + new Date().getTime();
}

$("#login").click(function() {
  $(".hide-center").fadeIn("slow");
});
$("#myinfo").click(function() {
  $(".registered").fadeIn("slow");
});

$("#close").click(function() {
  $(".hide-center").fadeOut("slow");
});
$("#regclose").click(function() {
  $(".registered").fadeOut("slow");
});
$("#regist").click(function() {
  $(".registered").fadeIn("slow");
});

$("#article").click(function() {
  $(".article-page").fadeIn("slow");
});
$("#article-close").click(function() {
  $(".article-page").fadeOut("slow");
});
if ($('#article-ti').val() != null) {
  $('.article-s').disabled = true;
}

// 上传头像弹窗 
$('#upheandimg').click(function() {
  $('.heand-img').fadeIn('slow');
});
$("#head-close").click(function() {
  $(".heand-img").fadeOut("slow");
});

var password;
var repassword;
$("#passjudge").blur(function() {
  password = $(this).val();
});
$("#repassjudge").blur(function() {
  repassword = $(this).val();
  if (password != repassword) {
    alert("两次输入密码不一样");
  }
});