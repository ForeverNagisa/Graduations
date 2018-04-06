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
  console.log("1234")
  $(".registered").fadeIn("slow"); 
});
$("#close").click(function() {
  $(".hide-center").fadeOut("slow");
});
$("#regist").click(function() {
  $(".registered").fadeIn("slow");
});
$("#regclose").click(function() {
  $(".registered").fadeOut("slow");
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