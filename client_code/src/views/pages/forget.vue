<template>
	<div>
		<div class="forget_view">
			<el-form :model="forgetForm" class="forget_box">
				<div class="forget_title">基于Spring Boot的青年驿站管理与服务平台{{pageType==1?'找回密码':pageType==2?'输入密保':'重置密码'}}</div>
				<div class="tab_line">
					<div class="line"></div>
					<div class="num_line">
						<div class="line_number" :class="pageType==1?'line_number1':'',pageType>1?'line_number2':''"><div class="number" v-if="pageType<2">1</div><el-icon v-else><Check /></el-icon></div>
						<div class="line_number" :class="pageType==2?'line_number1':'',pageType>2?'line_number2':''"><div class="number" v-if="pageType<3">2</div><el-icon v-else><Check /></el-icon></div>
						<div class="line_number" :class="pageType==3?'line_number1':''"><div class="number">3</div></div>
					</div>
				</div>
				<div class="list_item" v-if="pageType==1">
					<div class="item_label">账号：</div>
					<input class="list_inp" v-model="forgetForm.username" placeholder="请输入账号" />
				</div>

				<div class="list_item" v-if="pageType==2">
					<div class="item_label">密保问题：</div>
					<input class="list_inp question" v-model="userForm.pquestion" placeholder="请输入密保问题" />
				</div>
				<div class="list_item" v-if="pageType==2">
					<div class="item_label">密保答案：</div>
					<input class="list_inp answer" v-model="forgetForm.myanswer" placeholder="请输入密保答案" />
				</div>
				<div class="list_item" v-if="pageType==3">
					<div class="item_label">密码：</div>
					<input class="list_inp mima" v-model="forgetForm.mima" type="password" placeholder="请输入密码" />
				</div>
				<div class="list_item" v-if="pageType==3">
					<div class="item_label">确认密码：</div>
					<input class="list_inp mima1" v-model="forgetForm.mima2" type="password" placeholder="请输入确认密码" />
				</div>
				<div class="list_btn">
					<el-button v-if="pageType==1" class="get_btn" type="success" @click="getSecurity">获取密保</el-button>
					<el-button v-if="pageType==2" class="valid_btn" type="success" @click="validateSecurity">确认密保</el-button>
					<el-button v-if="pageType==3" class="update_btn" type="success" @click="updatePassword">重置密码</el-button>
					<div class="r-login" @click="close">已有账号，直接登录</div>
				</div>
			</el-form>
		</div>
	</div>
</template>
<script setup>
	import {
		ref,
		getCurrentInstance,
		nextTick,
		onMounted,
	} from 'vue';
    import { useRoute } from 'vue-router'
    const route = useRoute()
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	onMounted(()=>{
	})
	const pageType = ref(1)
	const forgetForm = ref({})
	const userForm = ref({})
    //获取用户信息
    const getSecurity=()=>{
            forgetForm.value.role = 'yonghu'
		if(!forgetForm.value.role) {
		    context?.$toolUtil.message('请选择角色','error');
		    return false
		}
		if(!forgetForm.value.username){
			context?.$toolUtil.message('请输入账号','error');
		    return false
		}
		context?.$http({
			url:forgetForm.value.role + `/security?username=${forgetForm.value.username}`,
			method:'get',
		}).then(res=>{
			if(res.data.data){
				userForm.value = res.data.data
				pageType.value = 2
			}else{
				context?.$toolUtil.message('未获取到用户信息','error');
			}
			
		})
	}
	//验证
	const validateSecurity=()=>{
		if(userForm.value.panswer != forgetForm.value.myanswer){
			context?.$toolUtil.message('答案输入不正确','error');
			return false
		}
		context?.$toolUtil.message('答案正确','success',()=>{
			pageType.value = 3
		})
	}
	const updatePassword=()=>{
		if(forgetForm.value.mima!=forgetForm.value.mima2){
			context?.$toolUtil.message('两次密码输入不一致','error')
			return false
		}
		if(forgetForm.value.role == 'yonghu'){
			userForm.value.mima = forgetForm.value.mima
		}
		context?.$http({
			url:forgetForm.value.role + `/update`,
			method:'post',
			data:userForm.value
		}).then(res=>{
			context?.$toolUtil.message('修改密码成功','success',obj=>{
				close()
			});
		})
	}
	//返回登录
	const close = () => {
		context?.$router.push({
			path: "/login"
		});
	}
</script>

<style lang="scss" scoped>
	.forget_view {
        background-image: url("http://clfile.zggen.cn/20241022/8078e310b766407e990e16bc4492e5ae.jpg");
		// 表单盒子
		.forget_box {
			// 标题
			.forget_title {
				padding: 0 0 30px;
				color: #333;
				font-weight: 600;
				width: 100%;
				font-size: 22px;
				text-align: center;
			}
			// tab
			// 盒子
			.tab_line{
				padding: 30px 0;
				flex-direction: column;
				display: flex;
				width: 100%;
				align-items: center;
				// 中间线
				.line{
				background: #ccc;
				width: 80%;
				height: 1px;
				}
				// item盒子
				.num_line{
					margin: -20px 0 0;
					display: flex;
					width: 80%;
					justify-content: space-between;
					align-items: center;
					height: 40px;
					// 默认样式
					.line_number{
						border: 4px solid #ddd;
						border-radius: 50%;
						color: #aaa;
						background: #eee;
						display: flex;
						width: 40px;
						font-size: 18px;
						justify-content: center;
						align-items: center;
						height: 40px;
					}
					// 选中样式
					.line_number1{
						color: #fac12c;
						background: #fff;
						font-size: 22px;
						border-color: #fac12c;
					}
					// 完成样式
					.line_number2{
						color: #339933;
						background: #fff;
						border-color: #339933;
					}
				}
			}
			// item
			.list_item {
				// label
				.item_label {
				}
				// 输入框
				:deep(.list_inp) {
				}
			}
			// 按钮盒子
			.list_btn {
				// 获取密保
				:deep(.el-button--success) {
				}
				// 获取密保悬浮
				:deep(.el-button--success:hover) {
				}
				// 确认密保
				:deep(.el-button--primary) {
				}
				// 确认密保悬浮
				:deep(.el-button--primary:hover) {
				}
				// 重置密码
				:deep(.el-button--warning) {
				}
				// 重置密码悬浮
				:deep(.el-button--warning:hover) {
				}
				.r-login {
				}
			}
		}
	}
</style>
<style>

.forget_view{
    min-height: 100vh;
    position: relative;
    background: url(http://clfile.zggen.cn/20241022/8078e310b766407e990e16bc4492e5ae.jpg) no-repeat center center / 100% 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}

.forget_view .forget_box{
    width: 750px;
    box-shadow: rgb(187, 187, 187) 0px 4px 9px;
    padding: 50px 60px 50px 20px;
    margin:0 0 0 40%;
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    border-radius: 10px;
    background: rgba(255, 255, 255,1);
    margin-bottom:20px;
    box-shadow: none;
}


.forget_view .outTitle_view{
    display: flex;
    align-items: center;
    padding: 0px 0px 60px;
    position:absolute;
    left:40px;
    top:20px;
}
.forget_view .outTitle_view .outTilte{
    color: #2dc6cc;
    font-size: 24px;
    font-weight: 600;
}


.forget_view .forget_box .tab_view{
    width: 100%;
    display: flex;
    align-items: center;
    padding: 0px 0px 20px;
}

.forget_view .forget_box .tab_view .tab{
    width: calc(33.3333%);
    padding: 16px 0px;
    box-sizing: border-box;
    text-align: center;
    font-size: 16px;
}
.forget_view .forget_box .tab_view .tab.tab_active{
    width: calc(33.3333%);
    padding: 16px 0px;
    box-sizing: border-box;
    text-align: center;
    font-size: 16px;
    clip-path: polygon(0% 0%, 92% 0%, 100% 50%, 92% 100%, 0px 100%, 8% 50%);
    background: rgb(254, 176, 67);
    color: rgb(255, 255, 255);
}


.forget_view .forget_box .list_item{
display: flex;
    align-items: center;
    width: 100%;
    justify-content: flex-start;
    margin: 0px 0px 20px;
}
.forget_view .forget_box .list_item .item_label{
    width: 120px;
    text-align: right;
    box-sizing: border-box;
    font-size: 16px;
}
.forget_view .forget_box .list_item .list_inp{
    height: 40px;
    line-height: 40px;
    border:none;
    border: 1px solid #ddd;
    padding: 0px 10px;
    width: calc(100% - 120px);
    box-sizing: border-box;
    font-size: 15px;
}
.forget_view .forget_box .list_item .list_sel{
    height: 40px;
    line-height: 40px;
    border:none;
    border: 1px solid #ddd;
    box-sizing: border-box;
    width: calc(100% - 120px);
    padding: 0px 10px;
    border-radius: 0px;
}
.forget_view .forget_box .list_item .list_sel .el-input__inner{
    font-size: 15px;
    color:#666;
}


.forget_view .forget_box .list_btn{
    display: flex;
    align-items: center;
    flex-wrap: wrap;
    width: 100%;
    margin: 0px;
    padding: 20px 0px 0px 120px;
}

.forget_view .forget_box .list_btn .get_btn{
    margin: 0px 0px 0px 0px;
    padding: 0px 24px;
    width: auto;
    height: 40px;
    font-size: 16px;
    color: rgb(255, 255, 255);
    border: 0px;
    border-radius: 0;
    cursor: pointer;
    background: var(--theme);
    min-width:120px;
}

.forget_view .forget_box .list_btn .valid_btn{
    margin: 0px 0px 0px 0px;
    padding: 0px 24px;
    width: auto;
    height: 40px;
    font-size: 16px;
    color: rgb(255, 255, 255);
    border: 0px;
    border-radius: 0;
    cursor: pointer;
    background: var(--theme);
    min-width:120px;
}

.forget_view .forget_box .list_btn .update_btn{
    margin: 0px 0px 0px 0px;
    padding: 0px 24px;
    width: auto;
    height: 40px;
    font-size: 16px;
    color: rgb(255, 255, 255);
    border: 0px;
    border-radius: 0;
    cursor: pointer;
    background:var(--theme);
    min-width:120px;
}

.forget_view .forget_box .list_btn .r-login{
    width: 100%;
    text-align: right;
    cursor: pointer;
    padding: 20px 0px 0px;
    font-size: 15px;
    color: #666;
}
.forget_view .forget_box .list_btn .r-login:hover{
    text-decoration:underline;
}

</style>
