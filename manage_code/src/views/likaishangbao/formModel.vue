<template>
	<div>
		<el-dialog modal-class="edit_form_modal" class="edit_form" v-model="formVisible" :title="formTitle" width="80%" destroy-on-close :fullscreen='false'>
			<el-form class="formModel_form" ref="formRef" :model="form" :rules="rules">
				<el-row>
					<el-col :span="24">
						<el-form-item label="驿站名称" prop="yizhanmingcheng">
							<el-input class="list_inp" v-model="form.yizhanmingcheng" placeholder="驿站名称"
								 type="text" 								:readonly="!isAdd||disabledForm.yizhanmingcheng?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item prop="mendiantu"
									  label="门店图"
						>
							<uploads
								:disabled="!isAdd||disabledForm.mendiantu?true:false"
								action="file/upload"

								tip="请上传门店图"
								:limit="3"
								style="width: 100%;text-align: left;"
								:fileUrls="form.mendiantu?form.mendiantu:''" 
								@change="mendiantuUploadSuccess">
							</uploads>
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="入住详情" prop="ruzhuxiangqing">
							<el-input class="list_inp" v-model="form.ruzhuxiangqing" placeholder="入住详情"
								 type="text" 								:readonly="!isAdd||disabledForm.ruzhuxiangqing?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="入住时间" prop="ruzhushijian">
							<el-input class="list_inp" v-model="form.ruzhushijian" placeholder="入住时间"
								 type="text" 								:readonly="!isAdd||disabledForm.ruzhushijian?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="确认离开时间" prop="shijian">
							<el-date-picker
								class="list_date"
								v-model="form.shijian"
								format="YYYY-MM-DD HH:mm:ss"
								value-format="YYYY-MM-DD HH:mm:ss"
								type="datetime"
								:readonly="!isAdd||disabledForm.shijian?true:false"
								placeholder="请选择确认离开时间" />
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="账号" prop="zhanghao">
							<el-input class="list_inp" v-model="form.zhanghao" placeholder="账号"
								 type="text" 								:readonly="!isAdd||disabledForm.zhanghao?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="姓名" prop="xingming">
							<el-input class="list_inp" v-model="form.xingming" placeholder="姓名"
								 type="text" 								:readonly="!isAdd||disabledForm.xingming?true:false" />
						</el-form-item>
					</el-col>

				</el-row>
			</el-form>
			<template #footer v-if="isAdd||type=='logistics'||type=='reply'">
				<span class="formModel_btn_box">
					<el-button class="cancel_btn" @click="closeClick">取消</el-button>
					<el-button class="confirm_btn" type="primary" @click="save"
						>
						提交
					</el-button>
				</span>
			</template>
		</el-dialog>
	</div>
</template>
<script setup>
	import {
		reactive,
		ref,
		getCurrentInstance,
		nextTick,
		computed,
		defineEmits
	} from 'vue'
    import {
        useStore
    } from 'vuex';
    const store = useStore()
    const user = computed(()=>store.getters['user/session'])
	const context = getCurrentInstance()?.appContext.config.globalProperties;	
	const emit = defineEmits(['formModelChange'])
	//基础信息
	const tableName = 'likaishangbao'
	const formName = '离开上报'
	//基础信息
	//form表单
	const form = ref({})
	const disabledForm = ref({
		yizhanmingcheng : false,
		mendiantu : false,
		ruzhuxiangqing : false,
		ruzhushijian : false,
		shijian : false,
		zhanghao : false,
		xingming : false,
	})
	const formVisible = ref(false)
	const isAdd = ref(false)
	const formTitle = ref('')
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
		yizhanmingcheng: [
			{required: true,message: '请输入',trigger: 'blur'}, 
		],
		mendiantu: [
		],
		ruzhuxiangqing: [
		],
		ruzhushijian: [
		],
		shijian: [
		],
		zhanghao: [
		],
		xingming: [
		],
	})
	//表单验证
	
	const formRef = ref(null)
	const id = ref(0)
	const type = ref('')
	//门店图上传回调
	const mendiantuUploadSuccess=(e)=>{
		form.value.mendiantu = e
	}
	//methods

	//获取唯一标识
	const getUUID =()=> {
      return new Date().getTime();
    }
	//重置
	const resetForm = () => {
		form.value = {
			yizhanmingcheng: '',
			mendiantu: '',
			ruzhuxiangqing: '',
			ruzhushijian: '',
			shijian: '',
			zhanghao: '',
			xingming: '',
		}
	}
	//获取info
	const getInfo = ()=>{
		context?.$http({
			url: `${tableName}/info/${id.value}`,
			method: 'get'
		}).then(res => {
			let reg=new RegExp('../../../file','g')
			form.value = res.data.data
			formVisible.value = true
		})
	}
	const crossRow = ref('')
	const crossTable = ref('')
	const crossTips = ref('')
	const crossColumnName = ref('')
	const crossColumnValue = ref('')
	//初始化
	const init=(formId=null,formType='add',formNames='',row=null,table=null,statusColumnName=null,tips=null,statusColumnValue=null)=>{
		resetForm()
		if(formId){
			id.value = formId
			type.value = formType
		}
		if(formType == 'add'){
			isAdd.value = true
			formTitle.value = '新增' + formName
			formVisible.value = true
		}else if(formType == 'info'){
			isAdd.value = false
			formTitle.value = '查看' + formName
			getInfo()
		}else if(formType == 'edit'){
			isAdd.value = true
			formTitle.value = '修改' + formName
			getInfo()
		}
		else if(formType == 'cross'){
			isAdd.value = true
			formTitle.value = formNames
			// getInfo()
			for(let x in row){
				if(x=='yizhanmingcheng'){
					form.value.yizhanmingcheng = row[x];
					disabledForm.value.yizhanmingcheng = true;
					continue;
				}
				if(x=='mendiantu'){
					form.value.mendiantu = row[x];
					disabledForm.value.mendiantu = true;
					continue;
				}
				if(x=='ruzhuxiangqing'){
					form.value.ruzhuxiangqing = row[x];
					disabledForm.value.ruzhuxiangqing = true;
					continue;
				}
				if(x=='ruzhushijian'){
					form.value.ruzhushijian = row[x];
					disabledForm.value.ruzhushijian = true;
					continue;
				}
				if(x=='shijian'){
					form.value.shijian = row[x];
					disabledForm.value.shijian = true;
					continue;
				}
				if(x=='zhanghao'){
					form.value.zhanghao = row[x];
					disabledForm.value.zhanghao = true;
					continue;
				}
				if(x=='xingming'){
					form.value.xingming = row[x];
					disabledForm.value.xingming = true;
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
			formVisible.value = true
		}

		context?.$http({
			url: `${context?.$toolUtil.storageGet('sessionTable')}/session`,
			method: 'get'
		}).then(res => {
			var json = res.data.data
			if(json.hasOwnProperty('yizhanmingcheng')&& context?.$toolUtil.storageGet("role")!="管理员"){
				form.value.yizhanmingcheng = json.yizhanmingcheng
				disabledForm.value.yizhanmingcheng = true;
			}
			if(json.hasOwnProperty('mendiantu')&& context?.$toolUtil.storageGet("role")!="管理员"){
				form.value.mendiantu = json.mendiantu
				disabledForm.value.mendiantu = true;
			}
			if(json.hasOwnProperty('ruzhuxiangqing')&& context?.$toolUtil.storageGet("role")!="管理员"){
				form.value.ruzhuxiangqing = json.ruzhuxiangqing
				disabledForm.value.ruzhuxiangqing = true;
			}
			if(context?.$toolUtil.storageGet("role")!="管理员" && !context?.$toolUtil.storageGet("isAdmin")) {
				disabledForm.value.ruzhuxiangqing = true;
			}
			if(json.hasOwnProperty('ruzhushijian')&& context?.$toolUtil.storageGet("role")!="管理员"){
				form.value.ruzhushijian = json.ruzhushijian
				disabledForm.value.ruzhushijian = true;
			}
			if(json.hasOwnProperty('zhanghao')&& context?.$toolUtil.storageGet("role")!="管理员"){
				form.value.zhanghao = json.zhanghao
				disabledForm.value.zhanghao = true;
			}
			if(json.hasOwnProperty('xingming')&& context?.$toolUtil.storageGet("role")!="管理员"){
				form.value.xingming = json.xingming
				disabledForm.value.xingming = true;
			}
		})
	}
	//初始化
	//声明父级调用
	defineExpose({
		init
	})
	//关闭
	const closeClick = () => {
		formVisible.value = false
	}
	//富文本
	const editorChange = (e,name) =>{
		form.value[name] = e
	}
	//提交
	const save= async ()=>{
		if(form.value.mendiantu!=null) {
			form.value.mendiantu = form.value.mendiantu.replace(new RegExp(context?.$config.url,"g"),"");
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
					crossUserId = user.value.id
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
							}).then(async res=>{
								emit('formModelChange')
								context?.$toolUtil.message(`操作成功`,'success')
                                formVisible.value = false
							})
						}
					})
				}else{
					context?.$http({
						url: `${tableName}/${!form.value.id ? "save" : "update"}`,
						method: 'post', 
						data: form.value 
					}).then(async (res)=>{
						emit('formModelChange')
						context?.$toolUtil.message(`操作成功`,'success')
                        formVisible.value = false
					})
				}
			}
		})
	}
	//修改跨表数据
	const changeCrossData = async (row)=>{
		await context?.$http({
			url: `${crossTable.value}/update`,
			method: 'post',
			data: row
		}).then(res=>{})
	}
</script>
<style lang="scss" scoped>
	// 表单
	.formModel_form{
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
		.cancel_btn {
		}
		.cancel_btn:hover {
		}
		
		.confirm_btn {
		}
		.confirm_btn:hover {
		}
	}
</style>
