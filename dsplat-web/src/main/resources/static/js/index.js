/*function freshWindow(){
	if(event.keyCode==116){
		alert("刷新");
		event.keyCode = 0; 
		event.cancelBubble = true; 
		return false; 
	}
}*/
/*document.onkeydown = function (e) {
    var ev = window.event || e;
    var code = ev.keyCode || ev.which;
    if (code == 116) {
    	alert("刷新");
        if(ev.preventDefault) {
            ev.preventDefault();
        } else {
            ev.keyCode = 0;
            ev.returnValue = false;
        }
    }
}*/
function freshTable(ele){
	var ev = window.event || e;
    var code = ev.keyCode || ev.which;
    if (code == 116) {
        if(ev.preventDefault) {
            ev.preventDefault();
        } else {
            ev.keyCode = 0;
            ev.returnValue = false;
        }
        this.app.changePage(this);
    }
}
var urlHead = "http://localhost:8080";
var app = new Vue({
    el: '#app',
    data: {
    	page:1,
    	rows:10,
    	pages:0,
        userList:[],
        returnRows:0,
        getUserListUrl:urlHead+'/datasource'//数据接口           
    },
    created: function(){//创建时执行
    	this.getUsers(1);
    },
    methods: {
    	verifyParam : function(pageNum){
    		if(pageNum >= 1){
      		  if(this.pages != 0){
      			  if(pageNum > this.pages){
      				  alert("当前页面已经是最后一页");
      				  return false;
      			  }
      		  }
    		}else{
    			alert("当前页面已经是第"+this.page+"页");
    			return false;
    		}
    		return true;
    	},
    	getUsers : function(pageNum){
    		if(this.verifyParam(pageNum)){
    			this.page = pageNum;
    			this.userList = [];
    			this.$http({//调用接口
    				method:'POST',
    				url:this.getUserListUrl,
    				body:{"page":this.page,"rows":this.rows}
    			}).then(function(response){//接口返回数据
    				this.pages = response.body.pages;
    				this.page = response.body.pageNum;
    				this.userList = response.body.list;
    				this.returnRows = response.body.size;
    			},function(error){
    				console.log('失败');
    			})
    		}
        },
        changePage : function(ele){
        	this.rows = Number(ele.rows.value);
        	this.getUsers(Number(ele.page.value));
        }
    }
})