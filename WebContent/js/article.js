
window.onload = function (){
    var id = $("#person_id").val();
    var name = $(".person_name").val();
    console.log(name)

   $.ajax({
        url:"selectAllAriticle.action",
        type:"post",
        data:{
            "id":id
        },
        dataType:'json',
        async:false,
        success:function(data){
            console.log(data)
            var res = data;
            for (let i = 0; i<res.length;i++){
                var art_title = res[i].art_title;
                var art_time = res[i].art_time;
                var art_content = res[i].art_content;
                var art_img = res[i].art_img;
                var art_id = res[i].art_id
                var html = `<article class="white-panel">
                        
						<p style="font-size: 24px;font-weight: bold">${art_title}</p>
						<span class="art_time">${art_time}</span>
						
						<p class="art_cont">${art_content}</p>
						<div class="art_bottom">
						<img src="upimg/${art_img }" class="thumb">
						<div class="art_comment">
							<span style="font-size: 18px;margin-left: 20px" >${name}:</span>
							<input value="${art_id}" class="art_id" name="art_id" style="display: none;">
							<input value="${id}"  name="person_id" style="display: none;">
							<input value="${name}" class="per_name"  name="per" style="display: none;">
							<input type="text" class="comm_name" name="comm_name" size="50" placeholder="输入您的评论...">
							<button onclick="pushcomment()">发表</button>
						</div>
							<div class="art_cle">
								<span class="glyphicon glyphicon-thumbs-up goods"></span>
							</div>
							
						</div>
						<div class="commtes"></div>
					</article>`;
                $('#gallery-wrapper').append(html)
                $.ajax({
                    url:"selectPersonArticle.action",
                    dataType:'json',
                    async:false,
                    data:{
                        "id":art_id
                    },
                    success:function (data) {
                        console.log(data)
                        var com = data;
                        for ( let j = 0;j<com.length;j++){
                            var per_id = com[j].person_id
                            var per_name = com[j].person_name
                            var com_name = com[j].comm_name
                            var com_date = com[j].date
                            console.log(per_name)
                            console.log(com_name)
                            console.log(com_date)
                            var comments = `
                    <hr/>
			 <div class="art_comm">
				 <div><span style="font-size: 20px;font-weight: 500;margin-left: 20px" >${per_name}</span><span>${com_name}</span>
				 <span style="margin-left: 300px">${com_date}</span>
				 </div>
			 </div>
                `;
                            $('.commtes').append(comments)
                        }
                    }
                })
            }




        },
        error:function(error){
            console.log("错误")
        }
    })
}

function pushcomment() {

    var comt_name = $(".comm_name").val();
    var id = $("#person_id").val();
    var art_id = $(".art_id").val();
    var person_name = $(".per_name").val();
    console.log(comt_name);
    console.log(id);
    console.log(art_id);

    $.ajax({
        url:"pushArticleComment.action",
        data:{
            "comm_name": comt_name,
            "person_id": id,
            "art_id": art_id,
            "person_name":person_name
        },
        type:"post",
        dataType:'json',
        contentType : "application/json; charset=utf-8",
        success:function (data) {
            console.log(data)
        },
        error:function (error) {
            
        }
    })
}









