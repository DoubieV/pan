<template>
	<div>
		<div class="center_view edit_form">
			<el-form class="userinfo_form" ref="userinfoFormRef" :model="form">
				<el-row>
					<el-col :span="24">
						<el-form-item label="企业账号" prop="qiyezhanghao">
							<el-input class="list_inp" v-model="user.qiyezhanghao" readonly placeholder="企业账号" clearable />
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="企业名称" prop="qiyemingcheng">
							<el-input class="list_inp" v-model="user.qiyemingcheng"  placeholder="企业名称" clearable />
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="封面" prop="fengmian">
							<uploads
								action="file/upload" 
								tip="请上传封面" 
								:limit="3" 
								style="width: 100%;text-align: left;"
								:fileUrls="user.fengmian?user.fengmian:''" 
								@change="qiyefengmianUploadSuccess">
							</uploads>
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="联系人" prop="lianxiren">
							<el-input class="list_inp" v-model="user.lianxiren"  placeholder="联系人" clearable />
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="联系电话" prop="lianxidianhua">
							<el-input class="list_inp" v-model="user.lianxidianhua"  placeholder="联系电话" clearable />
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="企业地址" prop="qiyedizhi">
							<el-input class="list_inp" v-model="user.qiyedizhi"  placeholder="企业地址" clearable />
						</el-form-item>
					</el-col>
					<span class="formModel_btn_box">
						<el-button class='confirm_btn' type="primary" @click="onSubmit">保存</el-button>
					</span>
				</el-row>
			</el-form>
		</div>
	</div>
</template>

<script setup>
	import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/toolUtil";
	import {
		reactive,
		ref,
		getCurrentInstance
	} from 'vue'
	import { useStore } from 'vuex'
	const store = useStore()
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const tableName = ref('qiye')
	const user = ref({})
	const init = () => {
	}
	const qiyefengmianUploadSuccess=(fileUrls)=> {
	    user.value.fengmian = fileUrls;
	}
	const onSubmit = () => {
		if((!user.value.qiyezhanghao)){
			context?.$toolUtil.message(`企业账号不能为空`,'error')
			return false
		}
		if((!user.value.mima)){
			context?.$toolUtil.message(`密码不能为空`,'error')
			return false
		}
		if((!user.value.qiyemingcheng)){
			context?.$toolUtil.message(`企业名称不能为空`,'error')
			return false
		}
		if(user.value.fengmian!=null){
			user.value.fengmian = user.value.fengmian.replace(new RegExp(context?.$config.url,"g"),"");
		}
		if((user.value.lianxidianhua)&&(!context?.$toolUtil.isMobile(user.value.lianxidianhua))){
			context?.$toolUtil.message(`联系电话应输入手机格式`,'error')
			return false
		}
		store.dispatch('user/update',user.value).then(res=>{
			if(res?.data&&res.data.code==0)context?.$toolUtil.message('修改成功','success')
		})

	}
	const getInfo = () => {
		context?.$http({
			url: `${tableName.value}/session`,
			method: 'get'
		}).then(res => {
			user.value = res.data.data
			init()
		})
	}
	getInfo()
</script>

<style lang="scss" scoped>
	// 表单
	.userinfo_form {
		// form item
		:deep(.el-form-item) {
			// 内容盒子
			.el-form-item__content{
			}
			// 输入框
			.list_inp {
			}
			//图片上传样式
			.el-upload-list  {
				//提示语
				.el-upload__tip {
				}
				//外部盒子
				.el-upload--picture-card {
					//图标
					.el-icon{
					}
				}
				.el-upload-list__item {
				}
			}

		}
		// 按钮盒子
		.formModel_btn_box {
			// 确定按钮
			.confirm_btn {
			}
			// 确定按钮-悬浮
			.confirm_btn:hover {
			}
		}
	}
</style>
