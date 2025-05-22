<template>
	<div class="center_view" :style='{}'>
		<div class="section_title">
			<span>{{formName}}</span>
		</div>
		<div class="usersView">
			<div class="usersTabView">
				<div class="usersTab" :class="tabIndex=='center'?'usersTabActive':''" @click="tabClick({tableName:'center'})">个人中心</div>
				<div class="usersTab " :class="tabIndex=='updatePassword'?'usersTabActive':''" @click="tabClick({tableName:'updatePassword'})">修改密码</div>
				<template v-for="(item,index) in menuList">
					<div v-if="item.child.length>1" class="usersTab" @mouseenter="usersTabHover(index)"
						 @mouseleave="usersTabLeave">
						{{item.menu}}
						<el-collapse-transition>
							<div class="usersTabHoverView" v-if="usersTabIndex==index">
								<div class="usersTabHoverTab" v-for="(items,indexs) in item.child" @click="tabClick(items)">
									{{items.menu}}
                                </div>
							</div>
						</el-collapse-transition>
					</div>
					<div v-else-if="hasBack(item.child[0])" class="usersTab" @click="tabClick(item.child[0])">
						{{item.child[0].menu}}
					</div>
				</template>
                <div class="usersTab" @click="tabClick({tableName:'storeup',type:1})">我的收藏</div>
			</div>
			<div class="usersBox updateInfo" v-if="tabIndex=='center'">
				<el-form class="usersForm" ref="userFormRef" :model="userForm" label-width="120px" :rules="rules">
					<el-row>
						<el-col :span="12">
							<el-form-item prop="qiyezhanghao" label="企业账号">
								<el-input class="list_inp" v-model="userForm.qiyezhanghao" placeholder="企业账号" readonly></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="12">
							<el-form-item prop="mima" label="密码">
								<el-input class="list_inp" v-model="userForm.mima" placeholder="密码" type="password"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="12">
							<el-form-item prop="qiyemingcheng" label="企业名称">
								<el-input class="list_inp" v-model="userForm.qiyemingcheng" placeholder="企业名称" ></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="24">
							<el-form-item prop="fengmian" label="封面">
								<uploads
									action="file/upload" 
									tip="请上传封面" 
									:limit="1" 
									style="width: 100%;text-align: left;"
									:fileUrls="userForm.fengmian?userForm.fengmian:''" 
									@change="fengmianUploadSuccess">
								</uploads>
							</el-form-item>
						</el-col>
						<el-col :span="12">
							<el-form-item prop="lianxiren" label="联系人">
								<el-input class="list_inp" v-model="userForm.lianxiren" placeholder="联系人" ></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="12">
							<el-form-item prop="lianxidianhua" label="联系电话">
								<el-input class="list_inp" v-model="userForm.lianxidianhua" placeholder="联系电话" ></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="12">
							<el-form-item prop="qiyedizhi" label="企业地址">
								<el-input class="list_inp" v-model="userForm.qiyedizhi" placeholder="企业地址" ></el-input>
							</el-form-item>
						</el-col>
					</el-row>
					<div class="formModel_btn_box">
						<el-button class="formModel_confirm" @click="updateSession">更新信息</el-button>
						<el-button class="formModel_cancel" @click="loginout" type="danger">退出登录</el-button>
					</div>
				</el-form>
			</div>
			<div class="usersBox updatePassword" v-if="tabIndex=='updatePassword'">
				<el-form class="usersForm" ref="passwordFormRef" :model="passwordForm" label-width="120px"
					:rules="passwordRules">
					<el-row>
						<el-col :span="12">
							<el-form-item label="原密码" prop="mima">
								<el-input class="list_inp" v-model="passwordForm.mima" placeholder="原密码"
									type="password"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="12">
							<el-form-item label="新密码" prop="newmima">
								<el-input class="list_inp" v-model="passwordForm.newmima" placeholder="新密码"
									type="password"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="12">
							<el-form-item label="确认密码" prop="newmima2">
								<el-input class="list_inp" v-model="passwordForm.newmima2" placeholder="确认密码"
									type="password"></el-input>
							</el-form-item>
						</el-col>
					</el-row>
					<div class="formModel_btn_box">
						<el-button class="formModel_confirm" @click="updatePassword">修改密码</el-button>
					</div>
				</el-form>
			</div>
		</div>
	</div>
</template>
<script setup>
	import {
		ElMessageBox
	} from 'element-plus'
	import moment from 'moment'
	import {
		ref,
		getCurrentInstance,
		watch,
		onUnmounted,
		onMounted,
	} from 'vue';
	import {
		useRoute,
		useRouter
	} from 'vue-router';
	import { useStore } from 'vuex'
	const store = useStore()
	import menu from '@/utils/menu'
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const route = useRoute()
	const router = useRouter()
	//基础信息
	const tableName = 'qiye'
	const formName = '个人中心'
	//基础信息
	const uploadUrl = context.$config.url + 'file/upload'
	//个人信息
	const userFormRef = ref(null)
	const userForm = ref({})
	//修改密码
	const passwordFormRef = ref(null)
	const passwordForm = ref({
		mima: '',
		newmima: '',
		newmima2: ''
	})
	const passwordRules = ref({
		mima: [{
			required: true,
			message: '请输入',
			trigger: 'blur'
		}, ],
		newmima: [{
			required: true,
			message: '请输入',
			trigger: 'blur'
		}, ],
		newmima2: [{
			required: true,
			message: '请输入',
			trigger: 'blur'
		}, ],
	})
	//验证规则
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
		qiyezhanghao: [
			{required: true,message: '请输入',trigger: 'blur'}, 
		],
		mima: [
			{required: true,message: '请输入',trigger: 'blur'}, 
		],
		qiyemingcheng: [
			{required: true,message: '请输入',trigger: 'blur'}, 
		],
		fengmian: [
		],
		lianxiren: [
		],
		lianxidianhua: [
			{ validator: validateMobile, trigger: 'blur' },
		],
		qiyedizhi: [
		],
	})
	const getSession = () =>{
		context?.$http({
			url: `${context?.$toolUtil.storageGet('frontSessionTable')}/session`,
			method:'get'
		}).then(res=>{
			context?.$toolUtil.storageSet('userid',res.data.data.id)
			context?.$toolUtil.storageSet("frontName", res.data.data.qiyezhanghao)
			context?.$toolUtil.storageSet('headportrait',res.data.data.fengmian)
			userForm.value = res.data.data
		})
	}
	//菜单跳转
	const tabIndex = ref('center')
	const tabClick = (item) => {
		if (item.tableName == 'center') {
			tabIndex.value = 'center'
			return
		}
		if (item.tableName == 'updatePassword') {
			passwordForm.value = {
				mima: '',
				newmima: '',
				newmima2: ''
			}
			tabIndex.value = 'updatePassword'
			return
		}
		if(item.tableName=='examrecord'&&item.menuJump=='22'){
			router.push(`/index/examfailrecord?centerType=1`)
			return
		}
		if(item.tableName=='forum'&&item.menuJump=='14'){
			router.push(`/index/forumList?centerType=1&&myType=1`)
			return
		}
        if(item.tableName=='storeup'){
            router.push(`/index/storeupList?centerType=1&&type=${item.type}`)
            return;
        }
        router.push(`/index/${item.classname||item.tableName}List?centerType=1${item.menuJump?'&menuJump='+item.menuJump:''}`)
	}
    const hasBack = (menu)=>{
        if(menu.tableName=='storeup'){
            return false
        }
        return true
    }
	// 修改密码
	const updatePassword = async ()=>{
		passwordFormRef.value.validate(async (valid) => {
			if (valid) {
				if(passwordForm.value.mima != userForm.value.mima){
					context?.$toolUtil.message('原密码不正确', 'error')
					return false
				}
				if(passwordForm.value.newmima != passwordForm.value.newmima2){
					context?.$toolUtil.message('两次密码输入不正确', 'error')
					return false
				}
				userForm.value.mima = passwordForm.value.newmima
				store.dispatch('user/update',userForm.value).then(res=>{
					if(res?.data&&res.data.code==0){
						context?.$toolUtil.message('更新成功','success')
						passwordForm.value = {
							mima: '',
							newmima: '',
							newmima2: ''
						}
						getSession()
					}
				})
			}
		})
	}
	//菜单
	const menuList = ref([])
	const role = ref('')
	//封面上传回调
	const fengmianUploadSuccess=(e)=>{
		userForm.value.fengmian = e
	}
	//初始化
	const init = () => {
		const menus = menu.list()
		let arr = []
		if (menus) {
			menuList.value = menus
		}
		role.value = context?.$toolUtil.storageGet('frontRole')
		for (let i = 0; i < menuList.value.length; i++) {
			if (menuList.value[i].roleName == role.value) {
				arr = menuList.value[i].backMenu
				break;
			}
		}
		menuList.value = arr
		getSession()
	}
	//菜单悬浮的显示与隐藏
	const usersTabIndex = ref(-1)
	const usersTabHover = (index) => {
		usersTabIndex.value = index
	}
	const usersTabLeave = () => {
		usersTabIndex.value = -1
	}
	//富文本
	const editorChange = (e,name) =>{
		userForm.value[name] = e
	}
	//保存
	const updateSession = () => {
		userFormRef.value.validate((valid)=>{
			if(valid){
				if(userForm.value.fengmian!=null){
					userForm.value.fengmian = userForm.value.fengmian.replace(new RegExp(context?.$config.url,"g"),"");
				}
				store.dispatch('user/update',userForm.value).then(res=>{
					if(res?.data&&res.data.code==0){
						context?.$toolUtil.message('更新成功','success')
						getSession()
					}
				})
			}
		})
	}
	//退出登录
	const loginout = () => {
		context?.$toolUtil.message('退出成功', 'success')
		context?.$toolUtil.storageClear()
		router.replace('/index/home')
	}
	init()
</script>

<style lang="scss" scoped>
	.usersView {

		.usersTabView {

			.usersTab {

				.usersTabHoverView {
					padding: 10px 0px;
					z-index: 999;
					clip-path: polygon(10% 0, 100% 0%, 90% 100%, 0% 100%);
					top: 0px;
					left: -200px;
					background: #fac12c;
					display: block;
					width: 200px;
					position: absolute;
					.usersTabHoverTab {
						color: #fff;
						line-height: 40px;
					}
					.usersTabHoverTab:hover {
						color: #ff0;
					}
				}
			}
			.usersTab:hover {
			}
			.usersTabActive {
			}
		}

		.usersBox {
			.usersForm {
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
	}
</style>
<style>
/**总盒子**/
.center_view {
    margin: 20px auto;
    width: 1200px;
    position: relative;
    background: rgb(255, 255, 255);
    font-size:16px;
    color:#666;
}
/**标题**/
.center_view .section_title{
    width: 1200px;
    margin:0px auto;
    background: none;
    text-align: left;
    border-bottom:2px solid var(--theme);
}
.center_view .section_title span{
    display: inline-block;
    background: var(--theme);
    padding: 10px 40px 10px 40px;
    font-size: 22px;
    color:#fff;
}

/**内容区**/
.center_view .usersView{
    display: flex;
    align-items: flex-start;
    justify-content: space-between;
    margin: 20px auto;
}

/**右部 总盒子**/
.center_view .usersView .usersBox{
    width: calc(100% - 240px);
    background: #fff;
    margin: 0px;
    padding: 0px;
    box-sizing: border-box;
    box-shadow: none;
    border: 0px solid #eee;
}
/**form盒子**/
.center_view .usersView .usersBox .usersForm{
    width: 100%;
    padding: 30px;
}
.center_view .usersView .usersBox .usersForm .el-form-item{
    margin: 0px 0px 20px;
    display: flex;
}
.center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__label{
    width: 150px;
    background: none;
    text-align: right;
    display: block;
    font-size: 16px;
    color: rgb(51, 51, 51);
    font-weight: 500;
}
.center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content{
    display: flex;
    justify-content: flex-start;
    align-items: center;
    flex-wrap: wrap;
    width: calc(100% - 120px);
}
.center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_inp{
    height: 36px;
    line-height: 36px;
    border: 1px solid rgb(221, 221, 221);
    padding: 0px 10px;
    width: 100%;
    box-sizing: border-box;
    background: rgb(255, 255, 255);
    font-size: 16px;
}

/**会员**/
.center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .vip_item{
    display: flex;
    align-items: center;
}
.center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .vip_item .vip_inp{
    height: 36px;
    line-height: 36px;
    border: 1px solid rgb(221, 221, 221);
    padding: 0px 10px;
    width: 80%;
    box-sizing: border-box;
    background: rgb(255, 255, 255);
    font-size: 16px;
}
.center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .vip_item .vip_btn{
    background: var(--theme);
    color: rgb(255, 255, 255);
    height: 36px;
    line-height: 36px;
    padding: 0px 20px;
    border-radius: 0px;
    margin: 0px 0px 0px 5px;
    border-color: var(--theme);
}
/**end**/

/**下拉选择**/
.center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_sel{
    line-height: 36px;
    border: 1px solid rgb(221, 221, 221);
    box-sizing: border-box;
    width: calc(100% - 120px);
    padding: 0px 10px;
    border-radius: 0px;
    background: rgb(255, 255, 255);
    font-size: 16px;
}
/**end**/

/**日期选择**/
.center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_date{
    line-height: 36px;
    border: 1px solid rgb(221, 221, 221);
    box-sizing: border-box;
    width: 100%;
    border-radius: 0px;
    background: rgb(255, 255, 255);
    font-size: 16px;
}
/**end**/

/**radio**/
.center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_radio{
    display: flex;
    width: calc(100% - 120px);
    align-items: center;
    flex-wrap: wrap;
}
.center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_radio .el-radio{
    width: 30%;
    margin: 0px;
    display: flex;
    justify-content: center;
    align-items: center;
}
.center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_radio .el-radio .el-radio__inner{
    border-color: #999;
    background: #fff;
}
.center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_radio .el-radio .el-radio__label{
    color: #999;
    font-size: 16px;
}
.center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_radio .el-radio.is-checked .el-radio__inner{
    border-color: var(--theme);
    background: var(--theme);
}
.center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_radio .el-radio.is-checked .el-radio__label{
    color: var(--theme);
    font-size: 16px;
}
/**end**/

/**checkbox**/
.center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_checkbox{
    display: flex;
    width: calc(100% - 120px);
    flex-wrap: wrap;
    align-items: center;
}
.center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_checkbox .el-checkbox{
    width: 20%;
    margin: 0px;
    display: flex;
    justify-content: center;
    align-items: center;
}
.center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_checkbox .el-checkbox .el-checkbox__inner{
    border-color: #999;
    background: #fff;
}
.center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_checkbox .el-checkbox .el-checkbox__label{
    color: #999;
    font-size: 16px;
}
.center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_checkbox .el-checkbox.is-checked .el-checkbox__inner{
    border-color: var(--theme);
    background: var(--theme);
}
.center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_checkbox .el-checkbox.is-checked .el-checkbox__label{
    color: var(--theme);
    font-size: 16px;
}
/**end**/

/**textarea**/
.center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_textarea{
}
.center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_textarea .el-textarea__inner{
    width: 100%;
    min-height: 150px;
    padding: 12px;
    border: 1px solid rgb(221, 221, 221);
    border-radius: 0px;
    color: #666;
    font-size: 16px;
}
/**end**/

/**图片上传**/
/* 盒子 */
.center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .el-upload--picture-card{
    background-color: rgb(255, 255, 255);
    width: 100px;
    height: 90px;
    line-height: 100px;
    text-align: center;
    border: 1px solid rgb(221, 221, 221);
    border-radius: 0px;
    cursor: pointer;
}
/* 图标 */
.center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .el-upload--picture-card .el-icon{
    font-size: 32px;
    color: #999;
}
/* 提示语 */
.center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .img-uploader .el-upload__tip{
    font-size: 15px;
    color: #666;
    margin: 0;
}
/**end**/

/**文件上传**/
.center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .el-upload--text .el-upload-dragger{
    background-color: rgb(255, 255, 255);
    border: 1px solid rgb(221, 221, 221);
    border-radius: 0px;
    box-sizing: border-box;
    width: 360px;
    height: 180px;
    text-align: center;
    cursor: pointer;
    overflow: hidden;
}
/* 图标 */
.center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .el-upload--text .el-upload-dragger .el-icon-upload{
    font-size: 67px;
    color: var(--theme);
    line-height: 50px;
}
/* 提示语 */
.center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .upload-demo .el-upload__tip{
    font-size: 15px;
    color: #666;
    margin: 0px 0 0;
    line-height:1;
}
/* 点击上传 */
.center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .el-upload--text .el-upload-dragger em{
    color: var(--theme);
    font-size: 15px;
}
/**end**/

/**富文本**/
.center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_editor{
    width: 100%;
    height: auto;
    margin: 0px;
    padding: 0px;
    border-radius: 0px;
    border-width: 0px;
    border-style: solid;
    border-color: rgb(204, 204, 204);
    background-color: rgb(255, 255, 255);
}
/**end**/

/**按钮**/
.center_view .formModel_btn_box{
    display: flex;
    align-items: center;
    justify-content:center;
    width: 100%;
    padding: 30px 0px 10px 150px;
    margin: 20px 0px 0px;
}
/**更新信息**/
.center_view .formModel_btn_box .formModel_confirm{
    padding: 0px 40px;
    width: auto;
    height: 42px;
    border-radius: 0px;
    border: 1px solid #828BD6;
    border-width:1px 0;
    background: none;
    cursor: pointer;
    color: #828BD6;
    font-size: 16px;
    background-repeat: no-repeat;
    background-position: bottom;
    background-image: -webkit-linear-gradient(left, #828BD6, #828BD6);
    background-image: linear-gradient(to left, #828BD6, #828BD6);
    background-size: 100% 0;
    transition: all .5s;
    clip-path: polygon(10% 0, 100% 0, 90% 100%, 0% 100%);
}
.center_view .formModel_btn_box .formModel_confirm:hover{
    background-size:100% 100%;
    color: #fff;
    border-color:#828BD6;
}
/**退出登陆**/
.center_view .formModel_btn_box .formModel_cancel{
    margin: 0px 10px;
    padding: 0px 40px;
    width: auto;
    height: 42px;
    border-radius: 0px;
    border: 1px solid var(--theme);
    border-width:1px 0;
    background: none;
    cursor: pointer;
    color: var(--theme);
    font-size: 16px;
    background-repeat: no-repeat;
    background-position: bottom;
    background-image: -webkit-linear-gradient(left, var(--theme), var(--theme));
    background-image: linear-gradient(to left, var(--theme), var(--theme));
    background-size: 100% 0;
    transition: all .5s;
    clip-path: polygon(10% 0, 100% 0, 90% 100%, 0% 100%);
}
.center_view .formModel_btn_box .formModel_cancel:hover{
    background-size:100% 100%;
    color: #fff;
    border-color:var(--theme);
}

/**tab总盒子**/
.center_view .usersView .usersTabView{
    width: 220px;
    background: none;
    padding: 0px 0px;
    box-sizing: border-box;
    order:2;
}
/**item**/
.center_view .usersView .usersTabView .usersTab{
    position: relative;
    width:100%;
    padding: 0px 10px;
    margin: 0 0 20px;
    box-sizing: border-box;
    cursor: pointer;
    border: 0px dashed #ccc;
    border-radius: 0px;
    background: url(http://clfile.zggen.cn/20241021/d1a1e5952f654080b0ebc08ac9e37db0.png) no-repeat left center / 100% 100%,#fac12c;
    color: #fff;
    text-align: center;
    height:50px;
    line-height:50px;
}
.center_view .usersView .usersTabView .usersTab:hover{
    color: rgb(255, 255, 255) !important;
    border-color: rgba(0, 118, 202,1) !important;
    background: url(http://clfile.zggen.cn/20241021/65b8a1bdcadc4ee29d64031450909c38.png) no-repeat left center / 100% 100%;
}
.center_view .usersView .usersTabView .usersTab.usersTabActive{
    color: rgb(255, 255, 255) !important;
    border-color: rgba(0, 118, 202,1) !important;
    background: url(http://clfile.zggen.cn/20241021/65b8a1bdcadc4ee29d64031450909c38.png) no-repeat left center / 100% 100%;
}
</style>