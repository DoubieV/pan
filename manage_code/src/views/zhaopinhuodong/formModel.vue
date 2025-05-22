<template>
	<div>
		<el-dialog modal-class="edit_form_modal" class="edit_form" v-model="formVisible" :title="formTitle" width="80%" destroy-on-close :fullscreen='false'>
			<el-form class="formModel_form" ref="formRef" :model="form" :rules="rules">
				<el-row>
					<el-col :span="24">
						<el-form-item label="岗位名称" prop="gangweimingcheng">
							<el-input class="list_inp" v-model="form.gangweimingcheng" placeholder="岗位名称"
								 type="text" 								:readonly="!isAdd||disabledForm.gangweimingcheng?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item prop="bangonghuanjing"
									  label="办公环境"
						>
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
					<el-col :span="24">
						<el-form-item label="招聘人数" prop="zhaopinrenshu">
							<el-input class="list_inp" v-model.number="form.zhaopinrenshu" placeholder="招聘人数"
								 type="text" 								:readonly="!isAdd||disabledForm.zhaopinrenshu?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="学历要求" prop="xueliyaoqiu">
							<el-input class="list_inp" v-model="form.xueliyaoqiu" placeholder="学历要求"
								 type="text" 								:readonly="!isAdd||disabledForm.xueliyaoqiu?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="薪资待遇" prop="xinzidaiyu">
							<el-input class="list_inp" v-model="form.xinzidaiyu" placeholder="薪资待遇"
								 type="text" 								:readonly="!isAdd||disabledForm.xinzidaiyu?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="工作时间" prop="gongzuoshijian">
							<el-input class="list_inp" v-model="form.gongzuoshijian" placeholder="工作时间"
								 type="text" 								:readonly="!isAdd||disabledForm.gongzuoshijian?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="活动地点" prop="huodongdidian">
							<el-input class="list_inp" v-model="form.huodongdidian" placeholder="活动地点"
								 type="text" 								:readonly="!isAdd||disabledForm.huodongdidian?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="活动时间" prop="huodongshijian">
							<el-date-picker
								class="list_date"
								v-model="form.huodongshijian"
								format="YYYY-MM-DD HH:mm:ss"
								value-format="YYYY-MM-DD HH:mm:ss"
								type="datetime"
								:readonly="!isAdd||disabledForm.huodongshijian?true:false"
								placeholder="请选择活动时间" />
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="企业账号" prop="qiyezhanghao">
							<el-input class="list_inp" v-model="form.qiyezhanghao" placeholder="企业账号"
								 type="text" 								:readonly="!isAdd||disabledForm.qiyezhanghao?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="企业名称" prop="qiyemingcheng">
							<el-input class="list_inp" v-model="form.qiyemingcheng" placeholder="企业名称"
								 type="text" 								:readonly="!isAdd||disabledForm.qiyemingcheng?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="联系电话" prop="lianxidianhua">
							<el-input class="list_inp" v-model="form.lianxidianhua" placeholder="联系电话"
								 type="text" 								:readonly="!isAdd||disabledForm.lianxidianhua?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="企业地址" prop="qiyedizhi">
							<el-input class="list_inp" v-model="form.qiyedizhi" placeholder="企业地址"
								 type="text" 								:readonly="!isAdd||disabledForm.qiyedizhi?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="岗位详情" prop="gangweixiangqing">
							<editor :value="form.gangweixiangqing" placeholder="请输入岗位详情" :readonly="!isAdd||disabledForm.gangweixiangqing?true:false"
								class="list_editor" @change="(e)=>editorChange(e,'gangweixiangqing')"></editor>
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="活动详情" prop="huodongxiangqing">
							<editor :value="form.huodongxiangqing" placeholder="请输入活动详情" :readonly="!isAdd||disabledForm.huodongxiangqing?true:false"
								class="list_editor" @change="(e)=>editorChange(e,'huodongxiangqing')"></editor>
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
	const tableName = 'zhaopinhuodong'
	const formName = '招聘活动'
	//基础信息
	//form表单
	const form = ref({})
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
	//表单验证
	
	const formRef = ref(null)
	const id = ref(0)
	const type = ref('')
	//办公环境上传回调
	const bangonghuanjingUploadSuccess=(e)=>{
		form.value.bangonghuanjing = e
	}
	//methods

	//获取唯一标识
	const getUUID =()=> {
      return new Date().getTime();
    }
	//重置
	const resetForm = () => {
		form.value = {
			gangweimingcheng: '',
			bangonghuanjing: '',
			zhaopinrenshu: '',
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
			storeupNumber: '',
		}
	}
	//获取info
	const getInfo = ()=>{
		context?.$http({
			url: `${tableName}/info/${id.value}`,
			method: 'get'
		}).then(res => {
			let reg=new RegExp('../../../file','g')
			res.data.data.gangweixiangqing = res.data.data.gangweixiangqing?(res.data.data.gangweixiangqing.replace(reg,'../../../cl75385428/file')):'';
			res.data.data.huodongxiangqing = res.data.data.huodongxiangqing?(res.data.data.huodongxiangqing.replace(reg,'../../../cl75385428/file')):'';
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
			formVisible.value = true
		}

		context?.$http({
			url: `${context?.$toolUtil.storageGet('sessionTable')}/session`,
			method: 'get'
		}).then(res => {
			var json = res.data.data
			if(json.hasOwnProperty('qiyezhanghao')&& context?.$toolUtil.storageGet("role")!="管理员"){
				form.value.qiyezhanghao = json.qiyezhanghao
				disabledForm.value.qiyezhanghao = true;
			}
			if(json.hasOwnProperty('qiyemingcheng')&& context?.$toolUtil.storageGet("role")!="管理员"){
				form.value.qiyemingcheng = json.qiyemingcheng
				disabledForm.value.qiyemingcheng = true;
			}
			if(json.hasOwnProperty('lianxidianhua')&& context?.$toolUtil.storageGet("role")!="管理员"){
				form.value.lianxidianhua = json.lianxidianhua
				disabledForm.value.lianxidianhua = true;
			}
			if(json.hasOwnProperty('qiyedizhi')&& context?.$toolUtil.storageGet("role")!="管理员"){
				form.value.qiyedizhi = json.qiyedizhi
				disabledForm.value.qiyedizhi = true;
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
