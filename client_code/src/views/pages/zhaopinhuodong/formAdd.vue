
<template>
	<div class="edit_view" :style='{}'>
		<div class="bread_view">
			<el-breadcrumb separator="/" class="breadcrumb">
				<el-breadcrumb-item class="first_breadcrumb" :to="{ path: '/' }">首页</el-breadcrumb-item>
				<el-breadcrumb-item class="second_breadcrumb" v-for="(item,index) in breadList" :key="index">{{item.name}}</el-breadcrumb-item>
			</el-breadcrumb>
		</div>
		<el-form ref="formRef" :model="form" class="add_form" label-width="120px" :rules="rules">
			<el-row>
				<el-col :span="12">
					<el-form-item label="岗位名称" prop="gangweimingcheng">
						<el-input class="list_inp" v-model="form.gangweimingcheng" placeholder="岗位名称"
							 type="text" 							:readonly="!isAdd||disabledForm.gangweimingcheng?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="12">
					<el-form-item label="办公环境" prop="bangonghuanjing">
						<uploads
							:disabled="!isAdd||disabledForm.bangonghuanjing?true:false"
							action="file/upload" 
							tip="请上传办公环境" 
							:limit="3" 
							style="width: 100%;text-align: left;"
							:fileUrls="form.bangonghuanjing?form.bangonghuanjing:''" 
							@change="bangonghuanjingUploadSuccess">
						</uploads>
					</el-form-item>
				</el-col>
				<el-col :span="12">
					<el-form-item label="招聘人数" prop="zhaopinrenshu">
						<el-input class="list_inp" v-model.number="form.zhaopinrenshu" placeholder="招聘人数"
							 type="text" 							:readonly="!isAdd||disabledForm.zhaopinrenshu?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="12">
					<el-form-item label="学历要求" prop="xueliyaoqiu">
						<el-input class="list_inp" v-model="form.xueliyaoqiu" placeholder="学历要求"
							 type="text" 							:readonly="!isAdd||disabledForm.xueliyaoqiu?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="12">
					<el-form-item label="薪资待遇" prop="xinzidaiyu">
						<el-input class="list_inp" v-model="form.xinzidaiyu" placeholder="薪资待遇"
							 type="text" 							:readonly="!isAdd||disabledForm.xinzidaiyu?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="12">
					<el-form-item label="工作时间" prop="gongzuoshijian">
						<el-input class="list_inp" v-model="form.gongzuoshijian" placeholder="工作时间"
							 type="text" 							:readonly="!isAdd||disabledForm.gongzuoshijian?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="12">
					<el-form-item label="活动地点" prop="huodongdidian">
						<el-input class="list_inp" v-model="form.huodongdidian" placeholder="活动地点"
							 type="text" 							:readonly="!isAdd||disabledForm.huodongdidian?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="12">
					<el-form-item label="活动时间" prop="huodongshijian">
						<el-date-picker
							class="list_date"
							v-model="form.huodongshijian"
							format="YYYY-MM-DD HH:mm:ss"
							value-format="YYYY-MM-DD HH:mm:ss"
							type="datetime"
							style="width:100%;"
							:readonly="!isAdd||disabledForm.huodongshijian?true:false"
							placeholder="请选择活动时间" />
					</el-form-item>
				</el-col>
				<el-col :span="12">
					<el-form-item label="企业账号" prop="qiyezhanghao">
						<el-input class="list_inp" v-model="form.qiyezhanghao" placeholder="企业账号"
							 type="text" 							:readonly="!isAdd||disabledForm.qiyezhanghao?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="12">
					<el-form-item label="企业名称" prop="qiyemingcheng">
						<el-input class="list_inp" v-model="form.qiyemingcheng" placeholder="企业名称"
							 type="text" 							:readonly="!isAdd||disabledForm.qiyemingcheng?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="12">
					<el-form-item label="联系电话" prop="lianxidianhua">
						<el-input class="list_inp" v-model="form.lianxidianhua" placeholder="联系电话"
							 type="text" 							:readonly="!isAdd||disabledForm.lianxidianhua?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="12">
					<el-form-item label="企业地址" prop="qiyedizhi">
						<el-input class="list_inp" v-model="form.qiyedizhi" placeholder="企业地址"
							 type="text" 							:readonly="!isAdd||disabledForm.qiyedizhi?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="24">
					<el-form-item label="岗位详情" prop="gangweixiangqing">
						<editor class="list_editor" :value="form.gangweixiangqing" placeholder="请输入岗位详情" :readonly="!isAdd||disabledForm.gangweixiangqing?true:false"
							@change="(e)=>editorChange(e,'gangweixiangqing')"></editor>
					</el-form-item>
				</el-col>
				<el-col :span="24">
					<el-form-item label="活动详情" prop="huodongxiangqing">
						<editor class="list_editor" :value="form.huodongxiangqing" placeholder="请输入活动详情" :readonly="!isAdd||disabledForm.huodongxiangqing?true:false"
							@change="(e)=>editorChange(e,'huodongxiangqing')"></editor>
					</el-form-item>
				</el-col>
			</el-row>
			<div class="formModel_btn_box">
				<el-button class="formModel_cancel" @click="backClick">取消</el-button>
				<el-button class="formModel_confirm"
                           @click="save"
                           type="success"
				>
					保存
				</el-button>
			</div>
		</el-form>
	</div>
</template>
<script setup>
	import {
		ref,
		getCurrentInstance,
		watch,
		onUnmounted,
		onMounted,
		nextTick,
		computed
	} from 'vue';
	import {
		useRoute,
		useRouter
	} from 'vue-router';
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const route = useRoute()
	const router = useRouter()
	//基础信息
	const tableName = 'zhaopinhuodong'
	const formName = '招聘活动'
	//基础信息
	const breadList = ref([{
		name: formName
	}])
	//获取唯一标识
	const getUUID =()=> {
      return new Date().getTime();
    }
	//form表单
	const form = ref({
		gangweimingcheng: '',
		bangonghuanjing: '',
		zhaopinrenshu: 0,
		xueliyaoqiu: '',
		xinzidaiyu: '',
		gongzuoshijian: '',
		gangweixiangqing: '',
		huodongdidian: '',
		huodongshijian: '',
		huodongxiangqing: '',
		qiyezhanghao: '',
		qiyemingcheng: '',
		lianxidianhua: '',
		qiyedizhi: '',
		clicktime: '',
		storeupNumber: 0,
	})
	const formRef = ref(null)
	const id = ref(0)
	const type = ref('')
	const disabledForm = ref({
		gangweimingcheng : false,
		bangonghuanjing : false,
		zhaopinrenshu : false,
		xueliyaoqiu : false,
		xinzidaiyu : false,
		gongzuoshijian : false,
		gangweixiangqing : false,
		huodongdidian : false,
		huodongshijian : false,
		huodongxiangqing : false,
		qiyezhanghao : false,
		qiyemingcheng : false,
		lianxidianhua : false,
		qiyedizhi : false,
		clicktime : false,
		storeupNumber : false,
	})
	const isAdd = ref(false)
	//表单验证
	//匹配整数
	const validateIntNumber = (rule, value, callback) => {
		if (!value) {
			callback();
		} else if (!context?.$toolUtil.isIntNumer(value)) {
			callback(new Error("请输入整数"));
		} else {
			callback();
		}
	}
	//匹配数字
	const validateNumber = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isNumber(value)) {
			callback(new Error("请输入数字"));
		} else {
			callback();
		}
	}
	//匹配手机号码
	const validateMobile = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isMobile(value)) {
			callback(new Error("请输入正确的手机号码"));
		} else {
			callback();
		}
	}
	//匹配电话号码
	const validatePhone = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isPhone(value)) {
			callback(new Error("请输入正确的电话号码"));
		} else {
			callback();
		}
	}
	//匹配邮箱
	const validateEmail = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isEmail(value)) {
			callback(new Error("请输入正确的邮箱地址"));
		} else {
			callback();
		}
	}
	//匹配身份证
	const validateIdCard = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.checkIdCard(value)) {
			callback(new Error("请输入正确的身份证号码"));
		} else {
			callback();
		}
	}
	//匹配网站地址
	const validateUrl = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isURL(value)) {
			callback(new Error("请输入正确的URL地址"));
		} else {
			callback();
		}
	}
	const rules = ref({
		gangweimingcheng: [
			{required: true,message: '请输入',trigger: 'blur'}, 
		],
		bangonghuanjing: [
		],
		zhaopinrenshu: [
			{ validator: validateIntNumber, trigger: 'blur' },
		],
		xueliyaoqiu: [
		],
		xinzidaiyu: [
		],
		gongzuoshijian: [
		],
		gangweixiangqing: [
		],
		huodongdidian: [
		],
		huodongshijian: [
		],
		huodongxiangqing: [
		],
		qiyezhanghao: [
		],
		qiyemingcheng: [
		],
		lianxidianhua: [
		],
		qiyedizhi: [
		],
		clicktime: [
		],
		storeupNumber: [
			{ validator: validateIntNumber, trigger: 'blur' },
		],
	})
	//办公环境上传回调
	const bangonghuanjingUploadSuccess=(e)=>{
		form.value.bangonghuanjing = e
	}
	//methods

	//methods
	//获取info
	const getInfo = ()=>{
		context?.$http({
			url: `${tableName}/info/${id.value}`,
			method: 'get'
		}).then(res => {
			let reg=new RegExp('../../../file','g')
			res.data.data.gangweixiangqing = res.data.data.gangweixiangqing.replace(reg,'../../../cl75385428/file');
			res.data.data.huodongxiangqing = res.data.data.huodongxiangqing.replace(reg,'../../../cl75385428/file');
			form.value = res.data.data
		})
	}
	const crossRow = ref('')
	const crossTable = ref('')
	const crossTips = ref('')
	const crossColumnName = ref('')
	const crossColumnValue = ref('')
	//初始化
	const init = (formId=null,formType='add',formNames='',row=null,table=null,statusColumnName=null,tips=null,statusColumnValue=null) => {
		if(formId){
			id.value = formId
			type.value = formType
		}
		if(formType == 'add'){
			isAdd.value = true
		}else if(formType == 'info'){
			isAdd.value = false
			getInfo()
		}else if(formType == 'edit'){
			isAdd.value = true
			getInfo()
		}
		else if(formType == 'cross'){
			isAdd.value = true
			// getInfo()
			for(let x in row){
				if(x=='gangweimingcheng'){
					form.value.gangweimingcheng = row[x];
					disabledForm.value.gangweimingcheng = true;
					continue;
				}
				if(x=='bangonghuanjing'){
					form.value.bangonghuanjing = row[x];
					disabledForm.value.bangonghuanjing = true;
					continue;
				}
				if(x=='zhaopinrenshu'){
					form.value.zhaopinrenshu = row[x];
					disabledForm.value.zhaopinrenshu = true;
					continue;
				}
				if(x=='xueliyaoqiu'){
					form.value.xueliyaoqiu = row[x];
					disabledForm.value.xueliyaoqiu = true;
					continue;
				}
				if(x=='xinzidaiyu'){
					form.value.xinzidaiyu = row[x];
					disabledForm.value.xinzidaiyu = true;
					continue;
				}
				if(x=='gongzuoshijian'){
					form.value.gongzuoshijian = row[x];
					disabledForm.value.gongzuoshijian = true;
					continue;
				}
				if(x=='gangweixiangqing'){
					form.value.gangweixiangqing = row[x];
					disabledForm.value.gangweixiangqing = true;
					continue;
				}
				if(x=='huodongdidian'){
					form.value.huodongdidian = row[x];
					disabledForm.value.huodongdidian = true;
					continue;
				}
				if(x=='huodongshijian'){
					form.value.huodongshijian = row[x];
					disabledForm.value.huodongshijian = true;
					continue;
				}
				if(x=='huodongxiangqing'){
					form.value.huodongxiangqing = row[x];
					disabledForm.value.huodongxiangqing = true;
					continue;
				}
				if(x=='qiyezhanghao'){
					form.value.qiyezhanghao = row[x];
					disabledForm.value.qiyezhanghao = true;
					continue;
				}
				if(x=='qiyemingcheng'){
					form.value.qiyemingcheng = row[x];
					disabledForm.value.qiyemingcheng = true;
					continue;
				}
				if(x=='lianxidianhua'){
					form.value.lianxidianhua = row[x];
					disabledForm.value.lianxidianhua = true;
					continue;
				}
				if(x=='qiyedizhi'){
					form.value.qiyedizhi = row[x];
					disabledForm.value.qiyedizhi = true;
					continue;
				}
				if(x=='clicktime'){
					form.value.clicktime = row[x];
					disabledForm.value.clicktime = true;
					continue;
				}
				if(x=='storeupNumber'){
					form.value.storeupNumber = row[x];
					disabledForm.value.storeupNumber = true;
					continue;
				}
			}
			if(row){
				crossRow.value = row
			}
			if(table){
				crossTable.value = table
			}
			if(tips){
				crossTips.value = tips
			}
			if(statusColumnName){
				crossColumnName.value = statusColumnName
			}
			if(statusColumnValue){
				crossColumnValue.value = statusColumnValue
			}
		}
		context?.$http({
			url: `${context?.$toolUtil.storageGet('frontSessionTable')}/session`,
			method: 'get'
		}).then(res => {
			var json = res.data.data
			if(json.hasOwnProperty('qiyezhanghao') && context?.$toolUtil.storageGet("frontRole")!="管理员"){
				form.value.qiyezhanghao = json.qiyezhanghao
				disabledForm.value.qiyezhanghao = true;
			}
			if(json.hasOwnProperty('qiyemingcheng') && context?.$toolUtil.storageGet("frontRole")!="管理员"){
				form.value.qiyemingcheng = json.qiyemingcheng
				disabledForm.value.qiyemingcheng = true;
			}
			if(json.hasOwnProperty('lianxidianhua') && context?.$toolUtil.storageGet("frontRole")!="管理员"){
				form.value.lianxidianhua = json.lianxidianhua
				disabledForm.value.lianxidianhua = true;
			}
			if(json.hasOwnProperty('qiyedizhi') && context?.$toolUtil.storageGet("frontRole")!="管理员"){
				form.value.qiyedizhi = json.qiyedizhi
				disabledForm.value.qiyedizhi = true;
			}
            if (localStorage.getItem('autoSave')) {
                localStorage.removeItem('autoSave')
                save()
            }
		})
	}
	//初始化
	//取消
	const backClick = () => {
		history.back()
	}
	//富文本数据回调
	const editorChange = (e,name) =>{
		form.value[name] = e
	}
	//提交
	const save=()=>{
		if(form.value.bangonghuanjing!=null) {
			form.value.bangonghuanjing = form.value.bangonghuanjing.replace(new RegExp(context?.$config.url,"g"),"");
		}
		var table = crossTable.value
		var objcross = JSON.parse(JSON.stringify(crossRow.value))
		let crossUserId = ''
		let crossRefId = ''
		let crossOptNum = ''
		if(type.value == 'cross'){
			if(crossColumnName.value!=''){
				if(!crossColumnName.value.startsWith('[')){
					for(let o in objcross){
						if(o == crossColumnName.value){
							objcross[o] = crossColumnValue.value
						}
					}
					//修改跨表数据
					changeCrossData(objcross)
				}else{
					crossUserId = context?.$toolUtil.storageGet('userid')
					crossRefId = objcross['id']
					crossOptNum = crossColumnName.value.replace(/\[/,"").replace(/\]/,"")
				}
			}
		}
		formRef.value.validate((valid)=>{
			if(valid){
				if(crossUserId&&crossRefId){
					form.value.crossuserid = crossUserId
					form.value.crossrefid = crossRefId
					let params = {
						page: 1,
						limit: 1000, 
						crossuserid:form.value.crossuserid,
						crossrefid:form.value.crossrefid,
					}
					context?.$http({
						url: `${tableName}/page`,
						method: 'get', 
						params: params 
					}).then(res=>{
						if(res.data.data.total>=crossOptNum){
							context?.$toolUtil.message(`${crossTips.value}`,'error')
							return false
						}else{
							context?.$http({
								url: `${tableName}/${!form.value.id ? "save" : "update"}`,
								method: 'post', 
								data: form.value 
							}).then(res=>{
								context?.$toolUtil.message(`操作成功`,'success')
                                history.back()
							})
						}
					})
				}else{
					context?.$http({
						url: `${tableName}/${!form.value.id ? "save" : "update"}`,
						method: 'post', 
						data: form.value 
					}).then(res=>{
                        context?.$toolUtil.message(`操作成功`,'success')
                        history.back()
					})
				}
			}
		})
	}
	//修改跨表数据
	const changeCrossData=(row)=>{
		context?.$http({
			url: `${crossTable.value}/update`,
			method: 'post',
			data: row
		}).then(res=>{})
	}
	onMounted(()=>{
		type.value = route.query.type?route.query.type:'add'
		let row = null
		let table = null
		let statusColumnName = null
		let tips = null
		let statusColumnValue = null
		if(type.value == 'cross'){
			row = context?.$toolUtil.storageGet('crossObj')?JSON.parse(context?.$toolUtil.storageGet('crossObj')):{}
			table = context?.$toolUtil.storageGet('crossTable')
			statusColumnName = context?.$toolUtil.storageGet('crossStatusColumnName')
			tips = context?.$toolUtil.storageGet('crossTips')
			statusColumnValue = context?.$toolUtil.storageGet('crossStatusColumnValue')
		}
		init(route.query.id?route.query.id:null, type.value,'', row, table, statusColumnName, tips, statusColumnValue)
	})
    onUnmounted(()=>{
        Object.keys(localStorage).map(item=>{
            if(item.startsWith('cross')){
                localStorage.removeItem(item)
            }
        })
    })
</script>
<style lang="scss" scoped>
	// 面包屑盒子
	.bread_view {
		:deep(.breadcrumb) {
			.el-breadcrumb__separator {
			}
			.first_breadcrumb {
				.el-breadcrumb__inner {
				}
			}
			.second_breadcrumb {
				.el-breadcrumb__inner {
				}
			}
		}
	}
	// 表单
	.add_form{
		// form item
		:deep(.el-form-item) {
			//label
			.el-form-item__label {
			}
			// 内容盒子
			.el-form-item__content {
				// 输入框
				.list_inp {

				}
				//日期选择器
				.list_date {
				}
				// 富文本
				.list_editor {
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
		}
	}
	// 按钮盒子
	.formModel_btn_box {
		.formModel_cancel {
		}
		.formModel_cancel:hover {
		}
		
		.formModel_confirm {
		}
		.formModel_confirm:hover {
		}
	}
</style>
<style>
.edit_view {
    width: 1200px;
    margin: 20px auto;
    padding: 0px ;
    background: #fff;
    overflow: hidden;
    font-size: 16px;
    color:#666;
}
.edit_view .add_form{
    width: 100%;
    padding: 30px;
    border:0px solid #eee
}
.edit_view .add_form .el-form-item{
    margin: 0px 0px 20px;
    display: flex;
}
.edit_view .add_form .el-form-item .el-form-item__label{
    width: 150px;
    background: none;
    text-align: right;
    display: block;
    font-size: 16px;
    color: rgb(51, 51, 51);
    font-weight: 500;
}
.edit_view .add_form .el-form-item .el-form-item__content{
    display: flex;
    justify-content: flex-start;
    align-items: center;
    flex-wrap: wrap;
    width: calc(100% - 120px);
}
.edit_view .add_form .el-form-item .el-form-item__content .list_inp{
    height: 36px;
    line-height: 36px;
    border: 1px solid rgb(221, 221, 221);
    padding: 0px 10px;
    width: 100%;
    box-sizing: border-box;
    background: rgb(255, 255, 255);
    font-size: 16px;
}


.edit_view .add_form .el-form-item .el-form-item__content .list_date{
    line-height: 36px;
    border: 1px solid rgb(221, 221, 221);
    box-sizing: border-box;
    width: 100%;
    border-radius: 0px;
    background: rgb(255, 255, 255);
    font-size: 16px;
}






.edit_view .add_form .el-form-item .el-form-item__content .el-upload--picture-card{
    background-color: rgb(255, 255, 255);
    width: 100px;
    height: 90px;
    line-height: 100px;
    text-align: center;
    border: 1px solid rgb(221, 221, 221);
    border-radius: 0px;
    cursor: pointer;
}

.edit_view .add_form .el-form-item .el-form-item__content .el-upload--picture-card .el-icon{
    font-size: 32px;
    color: #999;
}

.edit_view .add_form .el-form-item .el-form-item__content .img-uploader .el-upload__tip{
    font-size: 15px;
    color: #666;
    margin: 0;
}


.edit_view .add_form .el-form-item .el-form-item__content .list_editor{
    width: 100%;
    height: auto;
    margin: 0px;
    padding: 0px;
    border-radius: 0px;
    background: rgb(255, 255, 255);
    border: 1px solid rgb(221, 221, 221);
    min-height: 300px;
}

</style>