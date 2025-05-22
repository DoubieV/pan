<template>
	<div class="detail-page" :style='{}'>
		<div class="bread_view">
			<el-breadcrumb separator="/" class="breadcrumb">
				<el-breadcrumb-item class="first_breadcrumb" :to="{ path: '/' }">首页</el-breadcrumb-item>
				<el-breadcrumb-item class="second_breadcrumb" v-for="(item,index) in breadList" :key="index">{{item.name}}</el-breadcrumb-item>
			</el-breadcrumb>
		</div>
		<div class="back_view">
			<el-button class="back_btn" @click="backClick" type="primary">返回</el-button>
		</div>
		<div class="detail_view">
			<div class="swiper_view">
				<mySwiper :data="bannerList" :type="3"
					:loop="false"
					:navigation="true"
					:pagination="false"
					:paginationType="1"
					:scrollbar="false"
					:slidesPerView="1"
					:spaceBetween="20"
					:autoHeight="false"
					:centeredSlides="false"
					:freeMode="false"
					:effectType="1"
					:direction="horizontal"
					:autoplay="false"
					:slidesPerColumn="1">
					<template #default="scope">
						<img :style='{"objectFit":"contain","width":"100%","height":"480px"}' :src="scope.row?$config.url + scope.row:''">
					</template>
				</mySwiper>
			</div>

			<div class="info_view">
				<div class="title_view">
					<div class="detail_title">
						<span>{{detail.gangweimingcheng}}</span>
					</div>
				</div>
				<div class="info_item">
					<div class="info_label">招聘人数</div>
					<div  class="info_text" >{{detail.zhaopinrenshu}}</div>
				</div>
				<div class="info_item">
					<div class="info_label">学历要求</div>
					<div  class="info_text" >{{detail.xueliyaoqiu}}</div>
				</div>
				<div class="info_item">
					<div class="info_label">薪资待遇</div>
					<div  class="info_text" >{{detail.xinzidaiyu}}</div>
				</div>
				<div class="info_item">
					<div class="info_label">工作时间</div>
					<div  class="info_text" >{{detail.gongzuoshijian}}</div>
				</div>
				<div class="info_item">
					<div class="info_label">企业账号</div>
					<div  class="info_text" >{{detail.qiyezhanghao}}</div>
				</div>
				<div class="info_item">
					<div class="info_label">企业名称</div>
					<div  class="info_text" >{{detail.qiyemingcheng}}</div>
				</div>
				<div class="info_item">
					<div class="info_label">联系电话</div>
					<div  class="info_text" >{{detail.lianxidianhua}}</div>
				</div>
				<div class="info_item">
					<div class="info_label">企业地址</div>
					<div  class="info_text" >{{detail.qiyedizhi}}</div>
				</div>
				<div class="info_item">
					<div class="info_label">账号</div>
					<div  class="info_text" >{{detail.zhanghao}}</div>
				</div>
				<div class="info_item">
					<div class="info_label">姓名</div>
					<div  class="info_text" >{{detail.xingming}}</div>
				</div>
				<div class="info_item">
					<div class="info_label">简历</div>
					<div class="info_text">
						<el-button class="info_down" v-if="detail.jianli" @click="downClick(detail.jianli)">点击下载</el-button>
						<el-button class="info_undown" v-else>暂无</el-button>
					</div>
				</div>
				<div class="info_item" v-if="centerType">
					<div class="info_label">是否审核</div>
					<div class="info_text">{{detail.sfsh}}</div>
				</div>
				<div class="info_item" v-if="centerType">
					<div class="info_label">回复内容</div>
					<div class="info_text">{{detail.shhf}}</div>
				</div>
				<div class="btn_view">
					<el-button class="approval_btn" v-if="btnAuth('jianlitoudi','审核')" type="warning" @click="approvalClick()">审核</el-button>
					<el-button v-if="centerType&&(detail.ispay=='未支付'||!detail.ispay)&&btnFrontAuth('jianlitoudi','支付')" class="approval_btn" @click="payClick">支付</el-button>
					<el-button class="edit_btn" v-if="centerType&&btnAuth('jianlitoudi','修改')" type="primary" @click="editClick">修改</el-button>
					<el-button class="del_btn" v-if="centerType&&btnAuth('jianlitoudi','删除')" type="danger" @click="delClick">删除</el-button>
				</div>
			</div>
		</div>
		<Approval ref="approvalRef" :tableName="tableName" @shChange="init()"></Approval>
	</div>
</template>
<script setup>
	import axios from 'axios'
	import moment from 'moment'
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
		ElMessageBox
	} from 'element-plus'
	import {
		useRoute,
		useRouter
	} from 'vue-router';
	import {
		useStore
	} from 'vuex';
	const store = useStore()
	const user = computed(()=>store.getters['user/session'])
	const userAvatar = computed(()=>store.getters['user/avatar'])
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const route = useRoute()
	const router = useRouter()
	//基础信息
	const tableName = 'jianlitoudi'
	const formName = '简历投递'
	//基础信息
	const breadList = ref([{
		name: formName
	}])
	//权限验证
	const btnAuth = (e,a)=>{
		if(centerType.value){
			return context?.$toolUtil.isBackAuth(e,a)
		}else{
			return context?.$toolUtil.isAuth(e,a)
		}
	}
	//查看权限验证
	const btnFrontAuth = (e,a)=>{
		if(centerType.value){
			return context?.$toolUtil.isBackAuth(e,a)
		}else{
			return context?.$toolUtil.isFrontAuth(e,a)
		}
	}
	// 返回
	const backClick = () =>{
		history.back()
	}
	// 轮播图
	const bannerList = ref([])
	// 详情
	const title = ref('')
	const detail = ref({})
    const activeName = ref('false')
	const getDetail = () => {
		context?.$http({
			url: `${tableName}/detail/${route.query.id}`,
			method: 'get'
		}).then(res => {
            bannerList.value = res.data.data.bangonghuanjing?res.data.data.bangonghuanjing.split(','):[]
            title.value = res.data.data.gangweimingcheng
			detail.value = res.data.data
		})
	}
	// 下载文件
	const downClick = (file) => {
		if(!file){
			context?.$toolUtil.message('文件不存在','error')
		}
		let arr = file.replace(new RegExp('file/', "g"), "")
		axios.get((location.href.split(context?.$config.name).length>1 ? location.href.split(context?.$config.name)[0] :'') + context?.$config.name + '/file/download?fileName=' + arr, {
			headers: {
				token: context?.$toolUtil.storageGet('frontToken')
			},
			responseType: "blob"
		}).then(({
			data
		}) => {
			const binaryData = [];
			binaryData.push(data);
			const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
				type: 'application/pdf;chartset=UTF-8'
			}))
			const a = document.createElement('a')
			a.href = objectUrl
			a.download = arr
			// a.click()
			// 下面这个写法兼容火狐
			a.dispatchEvent(new MouseEvent('click', {
				bubbles: true,
				cancelable: true,
				view: window
			}))
			window.URL.revokeObjectURL(data)
		})
	}
	// 判断是否从个人中心跳转
	const centerType = ref(false)
	const init = () => {
		if(route.query.centerType){
			centerType.value = true
		}
		getDetail()
	}
	//审核
	import Approval from '@/components/approval.vue'
	const approvalRef = ref(null)
	const approvalClick = (btnType='审核') => {
		if(!context?.$toolUtil.storageGet('frontToken')){
			context?.$toolUtil.message('请登录后再操作！','error')
			return false
		}
		if(!btnAuth(tableName,btnType)){
			context?.$toolUtil.message('暂无权限操作！','error')
			return false
		}
		let row = detail.value
		let params = {
			id: row.id,
			sfsh: row.sfsh,
			shhf: row.shhf,
		}
		nextTick(() => {
			approvalRef.value.approvalClick(params)
		})
	}
	//修改
	const editClick = () => {
		router.push(`/index/${tableName}Add?id=${detail.value.id}&&type=edit`)
	}
	//删除
	const delClick = () => {
		ElMessageBox.confirm(`是否删除此${formName}？`, '提示', {
			confirmButtonText: '是',
			cancelButtonText: '否',
			type: 'warning',
		}).then(()=>{
			context?.$http({
				url: `${tableName}/delete`,
				method: 'post',
				data: [detail.value.id]
			}).then(res=>{
				context?.$toolUtil.message('删除成功','success',()=>{
					history.back()
				})
			})

		})
	}
	onMounted(()=>{
		init()
	})
</script>
<style lang="scss" scoped>
	// 返回盒子
	.back_view {
		border-radius: 4px;
		padding: 10px 0px;
		margin: 10px auto;
		background: none;
		width: 100%;
		text-align: right;
		// 返回按钮
		.back_btn {
			cursor: pointer;
			border-radius: 0px;
			padding: 0 20px;
			color: #828bd6;
			background: #fff;
			width: auto;
			font-size: 14px;
			border-color: #828bd6;
			border-width: 1px 0;
			border-style: solid;
			height: 36px;
		}
		// 返回按钮-悬浮
		.back_btn:hover {
			color: #fff;
			background: #828bd6;
		}
	}
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

	.detail_view{
		// 轮播图
		.swiper_view {
		}
		// 文字区
		.info_view {

			.title_view {

				.detail_title {
				}
				.collect_view {
					border: 0px solid #eee;
					cursor: pointer;
					border-radius: 10px;
					padding: 10px 0px;
					color: #999;
					background: none;
					display: flex;
					width: auto;
					line-height: 1;
					justify-content: center;
					align-items: center;
					.iconfont {
						margin: 0 5px 0 0;
						color: #fff;
					}
					.iconfontActive {
						margin: 0 5px 0 0;
						color: #fcf197;
					}
					span {
						color: #fff;
					}
					.textActive {
						color: #fcf197;
					}
				}
				.collect_view:hover {
				}
				.collect_view:active {
					transform: scale(0.8);
				}
			}

			.info_item {

				.info_label {
				}
				.info_text {
				}
				.info_down {
					padding: 5px 20px;
					background: #fff;
				}
				.info_down:hover {
					color: #333;
					border-color: #ddd;
				}
				.info_undown {
					padding: 5px 20px;
					color: #999;
					background: #fff;
				}
			}
			.btn_view {
				// 审核-按钮
				.approval_btn {
				}
				// 悬浮
				.approval_btn:hover {
				}
				// 修改-按钮
				.edit_btn {
				}
				// 悬浮
				.edit_btn:hover {
				}
				// 删除-按钮
				.del_btn {
				}
				// 悬浮
				.del_btn:hover {
				}
			}
		}
	}

	//底部盒子
	.tabs_view {
		:deep(.el-tabs__header) {
			background: transparent;
			border: none;
		}
		// 头部
		:deep(.el-tabs__nav-scroll) {
			.el-tabs__nav {
				.el-tabs__item {
				}
				.el-tabs__item:hover {
				}
				.is-active {
				}
			}
		}
		// 内容区
		:deep(.el-tabs__content) {
		}
	}
</style>