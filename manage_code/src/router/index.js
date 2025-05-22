	import {
		createRouter,
		createWebHashHistory
	} from 'vue-router'
	import discussqingnianyizhan from '@/views/discussqingnianyizhan/list'
	import huodongxinxi from '@/views/huodongxinxi/list'
	import storeup from '@/views/storeup/list'
	import users from '@/views/users/list'
	import forum from '@/views/forum/list'
	import qiye from '@/views/qiye/list'
	import likaishangbao from '@/views/likaishangbao/list'
	import jianlitoudi from '@/views/jianlitoudi/list'
	import qingnianyizhan from '@/views/qingnianyizhan/list'
	import huodongbaoming from '@/views/huodongbaoming/list'
	import yonghu from '@/views/yonghu/list'
	import zhaopinhuodong from '@/views/zhaopinhuodong/list'
	import shenqingruzhu from '@/views/shenqingruzhu/list'
	import config from '@/views/config/list'
	import usersCenter from '@/views/users/center'
	import qiyeRegister from '@/views/qiye/register'
	import qiyeCenter from '@/views/qiye/center'

export const routes = [{
		path: '/login',
		name: 'login',
		component: () => import('../views/login.vue')
	},{
		path: '/',
		name: '首页',
		component: () => import('../views/index'),
		children: [{
			path: '/',
			name: '首页',
			component: () => import('../views/HomeView.vue'),
			meta: {
				affix: true
			}
		}, {
			path: '/updatepassword',
			name: '修改密码',
			component: () => import('../views/updatepassword.vue')
		}
		
		,{
			path: '/usersCenter',
			name: '管理员个人中心',
			component: usersCenter
		}
		,{
			path: '/qiyeCenter',
			name: '企业个人中心',
			component: qiyeCenter
		}
		,{
			path: '/discussqingnianyizhan',
			name: '青年驿站评论-评论',
			component: discussqingnianyizhan
		}
		,{
			path: '/huodongxinxi',
			name: '活动信息',
			component: huodongxinxi
		}
		,{
			path: '/storeup',
			name: '我的收藏',
			component: storeup
		}
		,{
			path: '/users',
			name: '管理员',
			component: users
		}
		,{
			path: '/forum',
			name: '我的发布',
			component: forum
		}
		,{
			path: '/qiye',
			name: '企业',
			component: qiye
		}
		,{
			path: '/likaishangbao',
			name: '离开上报',
			component: likaishangbao
		}
		,{
			path: '/jianlitoudi',
			name: '简历投递',
			component: jianlitoudi
		}
		,{
			path: '/qingnianyizhan',
			name: '青年驿站',
			component: qingnianyizhan
		}
		,{
			path: '/huodongbaoming',
			name: '活动报名',
			component: huodongbaoming
		}
		,{
			path: '/yonghu',
			name: '用户',
			component: yonghu
		}
		,{
			path: '/zhaopinhuodong',
			name: '招聘活动',
			component: zhaopinhuodong
		}
		,{
			path: '/shenqingruzhu',
			name: '申请入住',
			component: shenqingruzhu
		}
		,{
			path: '/config',
			name: '轮播图',
			component: config
		}
		]
	},
	{
		path: '/qiyeRegister',
		name: '企业注册',
		component: qiyeRegister
	},
]

const router = createRouter({
	history: createWebHashHistory(process.env.BASE_URL),
	routes
})

export default router
