var app = new Vue({
	el: "#app",
	data: {
		username: "",
		password: "",
		code: "",
		errors: ""
	},
	methods: {
		submitForm: function() {
			if(this.username == "" || this.password == "" || this.code == "") {
				this.errors = "账号、密码或者验证码不能为空"
				return
			} else {
				this.errors = ""
			}

			axios({
					url: 'http://localhost:8080/LoginServlet',
					method: "post",
					data: {
						username: this.username,
						password: this.password,
						code: this.code
					},
					//将JSON对象 转 键=值&键=值
					/*
					{
					  name:"david",
					  age:30
					}
					name=小李&age=30
					// 在发送数据之前 将对象转键值对
					*/
					transformRequest: [function(data) {
						// Do whatever you want to transform the data
						let ret = ''
						for(let it in data) {
							// 如果要发送中文 编码 
							ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'
						}
						return ret
					}],
					headers: {
						'Content-Type': 'application/x-www-form-urlencoded'
					}
				})
				.then(response => {
					var data = response.data;
					console.log(data);
					if(data.code == 0) {
						var userData = JSON.parse(data.detail)
						login(userData.account, userData.type);
						window.location = "index.html"
					} else {
						this.errors = data.detail;
					}
				})
				.catch(function(error) {
					console.log(error);
				})
		},
		register: function() {
			window.location = "register.html"
		},
		reflesh: function() {
			$("#img").attr("src", "http://localhost:8080/VerificationCodeServlet?flag=" + Math.random());
		}
	}
})