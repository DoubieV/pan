<template>
	<div class="top_view">
		<div class="top_left_view">
			<div class="fold_view" @click="toggleClick" :class="{'is_collapse':collapse}">
				<el-switch :value="collapse" :active-value="false" :inactive-value="true"></el-switch>
			</div>
		</div>

		<div class="projectTitle">基于Spring Boot的青年驿站管理与服务平台</div>
		<div class="top_right_view">
			<el-dropdown class="avatar-container" trigger="hover">
				<div class="avatar-wrapper">
					<div class="nickname">{{$toolUtil.storageGet("adminName")}}</div>
					<img class="user-avatar" :src="store.getters['user/avatar']">
					<el-icon class="el-icon-arrow-down">
						<arrow-down />
					</el-icon>
				</div>
				<template #dropdown>
					<el-dropdown-menu class="user-dropDown" slot="dropdown">
						<el-dropdown-item @click="centerClick" >
							个人中心
						</el-dropdown-item>
						<el-dropdown-item @click="updatepasswordClick">
							修改密码
						</el-dropdown-item>
						<el-dropdown-item>
							<span style="display:block;" @click="frontClick">系统前台</span>
						</el-dropdown-item>
						<el-dropdown-item>
							<span style="display:block;" @click="onLogout">退出登录</span>
						</el-dropdown-item>
					</el-dropdown-menu>
				</template>
			</el-dropdown>
		</div>
	</div>
</template>

<script setup>
	import axios from 'axios'
    import moment from "moment"
	import {
		ElMessageBox
	} from 'element-plus'
	import {
		toRefs,
		defineEmits,
		getCurrentInstance,
		ref,
		onBeforeUnmount,
		computed,
	} from 'vue';

	import {
		useRouter,
		useRoute
	} from 'vue-router';
	const router = useRouter()
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const emit = defineEmits(['collapseChange'])
	const role = context?.$toolUtil.storageGet('sessionTable')
	const roleName = context?.$toolUtil.storageGet('role')

	const props = defineProps({
		collapse: Boolean
	})
	const {collapse} = toRefs(props)

	//获取用户信息
	import { useStore } from 'vuex'
	const store = useStore()
	const user = computed(()=>store.getters['user/session'])
	const avatar = ref(store.state.user.avatar)
	if(!store.state.user.session.id){
		store.dispatch('user/getSession')
	}
	const toggleClick = () => {
		emit('collapseChange')
	}
	// 退出登录
	const onLogout = () => {
		let toolUtil = context?.$toolUtil
		store.dispatch('delAllCachedViews')
		store.dispatch('delAllVisitedViews')
		toolUtil.storageClear()
		router.replace({
			name: "login"
		});
	}
	// 跳转前台
	const frontClick = () => {
        window.open(`${context.$config.url}client/index.html#/index/home`,'_blank')
	}
	// 个人中心
	const centerClick = () => {
		router.push(`/${role}Center`)
	}
	// 修改密码
	const updatepasswordClick = () => {
		router.push(`/updatepassword`)
	}
</script>

<style lang="scss" scoped>
	// 总盒子
	.top_view {
		// 左边盒子
		.top_left_view {
			// 折叠按钮盒子
			.fold_view {
				padding: 0 15px;
				// 图标
				.icons {
				}
			}
		}
		// 标题
		.projectTitle{
		}
		// 右部盒子
		.top_right_view{
			// 头像盒子
			.avatar-container {
				.avatar-wrapper {
					// 昵称
					.nickname {
					}
					// 头像
					.user-avatar {
					}
					// 图标
					.el-icon-arrow-down {
					}
				}
			}
		}
	}
	// 下拉盒子
	.el-dropdown-menu{
		background: #fff;
		min-width: 110px;
		// 下拉盒子itme
		:deep(.el-dropdown-menu__item){
			color: #666;
			background: #fff;
		}
		// item悬浮
		:deep(.el-dropdown-menu__item:hover){
			color: #000;
			background: none;
		}
	}
</style>
<style>
/*总盒子*/
.top_view{ 
    background: #2b3c4c;
    height: 90px;
    width: 100%;
    display: flex;
    align-items: center;
    justify-content: flex-end;
    position: fixed;
    left: 0px;
    top: 0px;
    z-index: 9;
    padding: 0px;
    border-width: 0 0 10px;
    border-style: solid;
    border-color: #1590f0;
    font-size:16px;
}
/*标题*/
.top_view .projectTitle{
    font-size: 20px;
    margin: 0px;
    padding: 0px 0px 0px 40px;
    line-height: 1;
    width: auto;
    font-weight: 600;
    color:#fff; 
    background:none;
    text-align:left;
    text-shadow:0 -2px 0 rgba(0, 0, 0, 0.25);
    letter-spacing: 1px;
    order:-1;
    position:absolute;
    left:0px;
}

/*左边盒子*/
.top_left_view{
    width: auto !important;
    color:#fff; 
}
/*总盒子*/
.top_left_view .weather_time_view{
    display: flex;
    align-items: center;
}
/*天气盒子*/
.top_left_view .weather_time_view .weather{
    padding: 0px 10px;
    border-image: initial;
    display: flex;
    align-items: center;
    line-height: 1;
    margin-right: 30px;
}
.top_left_view .weather_time_view .weather .city{
    display: inline-block;
    white-space: nowrap;
}
.top_left_view .weather_time_view .weather .wea{
    display: inline-block;
    white-space: nowrap;
}
/*时间盒子*/
.top_left_view .weather_time_view .time{
    display: flex;
    align-items: center;
    padding: 0px 10px;
    margin-right: 30px;
}
.top_left_view .weather_time_view .time .date{
    display: inline-block;
    white-space: nowrap;
    margin: 0px 10px 0px 0px
}
.top_left_view .weather_time_view .time .timer{
    display: inline-block;
    white-space: nowrap;
    line-height: 1;
}

/*折叠按钮*/
.top_left_view .fold_view{
    display: none;
    padding: 0px;
    margin: 0px 0px 0px 40px;
    background: none;
    border-radius: 50%;
    width: 32px;
    height: 32px;
    align-items: center;
    justify-content: center;
 }
.top_left_view .fold_view:hover {
 }
/*图标*/
.top_left_view .fold_view .icons{
    font-size: 24px;
    color: rgb(255, 255, 255);
}

/*系统公告*/
.top_view .notice-btn{
    background: rgba(255, 255, 255,0);
    border-color: rgba(255, 255, 255,0);
    padding: 0 10px;
    margin-right:20px;
    height: 44px;
    line-height: 44px;
    font-size: inherit;
    color:#fff; 
    border-radius:30px;
}
.top_view .notice-btn:hover{
    color:#fff; 
}
.top_view .notice-btn .iconfont{
    font-size: inherit;
}

/*右边盒子*/
/*无下拉操作栏*/
.top_right_view{
    width: auto;
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: flex-end;
    order: 3;
    min-width: 300px;
 }
.top_right_view .actionBar{ }
.top_right_view .actionBar .item { float:left; margin-right:20px; margin-bottom:5px; font-size:16px; color:#fff; font-weight:500;  }
.top_right_view .actionBar .item:hover { color:#fff; cursor:pointer;  }
.top_right_view .actionBar .item i { font-size:18px; }

.top_view .user-info{
    position:absolute;
    left:20px;
    display: flex;
    align-items: center;
}
.top_view .user-info .img-wrapper{
    margin-right:10px;
}
.top_view .user-info .img-wrapper .user-avatar{
    width:50px;
}
.top_view .user-info .nickname{
    font-size:16px;
    color:#fff; 
    white-space:nowrap;
}

/*头像下拉 默认*/
/*头像盒子*/
.top_right_view .el-dropdown{
    height: 50px;
    margin: 0px 30px 0px 0px;
    cursor: pointer;
    color: rgb(255, 255, 255);
    display: flex;
    align-items: center;
}
/*item*/
.top_right_view .el-dropdown .avatar-wrapper{
    margin: 5px 0px 0px;
    position: relative;
    display: flex;
    align-items: center;
}
/*昵称*/
.top_right_view .el-dropdown .avatar-wrapper .nickname{
    cursor: pointer;
    margin: 0px 5px;
    line-height: 44px;
    color: rgb(255, 255, 255);
    font-size:16px;
    white-space:nowrap;
    order:2;
}
/*头像*/
.top_right_view .el-dropdown .avatar-wrapper .user-avatar{
    cursor: pointer;
    width: 40px;
    height: 40px;
    border-radius: 30px;
}
/*图标*/
.top_right_view .el-dropdown .avatar-wrapper .el-icon{
    color: rgb(255, 255, 255);
    order:3;
}

</style>