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
    el: '#dataSource',
    data: {
        saveDataSourceUrl:urlHead+'/datasource/saveDataSource'//数据接口
    },
    methods: {
    	verifyParam : function(elements){
    		if(elements.dataSourceType.value == null || elements.dataSourceType.value == ""){
      		  alert("数据源类型为空");
      		  return false;
    		}
    		if(elements.connectUrl.value == null || elements.connectUrl.value == ""){
    		  alert("数据源链接为空");
    		  return false;
      		}
    		return true;
    	},
    	saveDataSource : function(elements){
    		if(this.verifyParam(elements)){
    			this.$http({//调用接口
    				method:'POST',
    				url:this.saveDataSourceUrl,
    				body:{
    					"dataSoureceKey":elements.dataSoureceKey.value,
    					"intialSize":elements.intialSize.value,
    					"maxActive":elements.maxActive.value,
    					"maxIdle":elements.maxIdle.value,
    					"dataSourceType":elements.dataSourceType.value,
    					"connectUrl":elements.connectUrl.value,
    					"userName":elements.userName.value,
    					"passWord":elements.passWord.value,
    				}
    			}).then(function(response){//接口返回数据
    				alert("保存成功");
    				console.log(response);
    			},function(error){
    				console.log('失败');
    			})
    		}
        }
    }
})