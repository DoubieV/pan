import { createRouter, createWebHashHistory } from 'vue-router'
import index from '../views'
import home from '../views/pages/home.vue'
import login from '../views/pages/login.vue'
import forumList from '@/views/pages/forum/list'
import qiyeList from '@/views/pages/qiye/list'
import qiyeDetail from '@/views/pages/qiye/formModel'
import qiyeAdd from '@/views/pages/qiye/formAdd'
import qingnianyizhanList from '@/views/pages/qingnianyizhan/list'
import qingnianyizhanDetail from '@/views/pages/qingnianyizhan/formModel'
import qingnianyizhanAdd from '@/views/pages/qingnianyizhan/formAdd'
import shenqingruzhuList from '@/views/pages/shenqingruzhu/list'
import shenqingruzhuDetail from '@/views/pages/shenqingruzhu/formModel'
import shenqingruzhuAdd from '@/views/pages/shenqingruzhu/formAdd'
import storeupList from '@/views/pages/storeup/list'
import likaishangbaoList from '@/views/pages/likaishangbao/list'
import likaishangbaoDetail from '@/views/pages/likaishangbao/formModel'
import likaishangbaoAdd from '@/views/pages/likaishangbao/formAdd'
import huodongxinxiList from '@/views/pages/huodongxinxi/list'
import huodongxinxiDetail from '@/views/pages/huodongxinxi/formModel'
import huodongxinxiAdd from '@/views/pages/huodongxinxi/formAdd'
import jianlitoudiList from '@/views/pages/jianlitoudi/list'
import jianlitoudiDetail from '@/views/pages/jianlitoudi/formModel'
import jianlitoudiAdd from '@/views/pages/jianlitoudi/formAdd'
import zhaopinhuodongList from '@/views/pages/zhaopinhuodong/list'
import zhaopinhuodongDetail from '@/views/pages/zhaopinhuodong/formModel'
import zhaopinhuodongAdd from '@/views/pages/zhaopinhuodong/formAdd'
import huodongbaomingList from '@/views/pages/huodongbaoming/list'
import huodongbaomingDetail from '@/views/pages/huodongbaoming/formModel'
import huodongbaomingAdd from '@/views/pages/huodongbaoming/formAdd'
import yonghuList from '@/views/pages/yonghu/list'
import yonghuDetail from '@/views/pages/yonghu/formModel'
import yonghuAdd from '@/views/pages/yonghu/formAdd'
import yonghuRegister from '@/views/pages/yonghu/register'
import yonghuCenter from '@/views/pages/yonghu/center'

const routes = [{
		path: '/',
		redirect: '/index/home'
	},
	{
		path: '/index',
		component: index,
		children: [{
			path: 'home',
			component: home
		}
		, {
			path: 'forumList',
			component: forumList
		}
		, {
			path: 'qiyeList',
			component: qiyeList
		}, {
			path: 'qiyeDetail',
			component: qiyeDetail
		}, {
			path: 'qiyeAdd',
			component: qiyeAdd
		}
		, {
			path: 'qingnianyizhanList',
			component: qingnianyizhanList
		}, {
			path: 'qingnianyizhanDetail',
			component: qingnianyizhanDetail
		}, {
			path: 'qingnianyizhanAdd',
			component: qingnianyizhanAdd
		}
		, {
			path: 'shenqingruzhuList',
			component: shenqingruzhuList
		}, {
			path: 'shenqingruzhuDetail',
			component: shenqingruzhuDetail
		}, {
			path: 'shenqingruzhuAdd',
			component: shenqingruzhuAdd
		}
		, {
			path: 'storeupList',
			component: storeupList
		}
		, {
			path: 'likaishangbaoList',
			component: likaishangbaoList
		}, {
			path: 'likaishangbaoDetail',
			component: likaishangbaoDetail
		}, {
			path: 'likaishangbaoAdd',
			component: likaishangbaoAdd
		}
		, {
			path: 'huodongxinxiList',
			component: huodongxinxiList
		}, {
			path: 'huodongxinxiDetail',
			component: huodongxinxiDetail
		}, {
			path: 'huodongxinxiAdd',
			component: huodongxinxiAdd
		}
		, {
			path: 'jianlitoudiList',
			component: jianlitoudiList
		}, {
			path: 'jianlitoudiDetail',
			component: jianlitoudiDetail
		}, {
			path: 'jianlitoudiAdd',
			component: jianlitoudiAdd
		}
		, {
			path: 'zhaopinhuodongList',
			component: zhaopinhuodongList
		}, {
			path: 'zhaopinhuodongDetail',
			component: zhaopinhuodongDetail
		}, {
			path: 'zhaopinhuodongAdd',
			component: zhaopinhuodongAdd
		}
		, {
			path: 'huodongbaomingList',
			component: huodongbaomingList
		}, {
			path: 'huodongbaomingDetail',
			component: huodongbaomingDetail
		}, {
			path: 'huodongbaomingAdd',
			component: huodongbaomingAdd
		}
		, {
			path: 'yonghuList',
			component: yonghuList
		}, {
			path: 'yonghuDetail',
			component: yonghuDetail
		}, {
			path: 'yonghuAdd',
			component: yonghuAdd
		}
		, {
			path: 'yonghuCenter',
			component: yonghuCenter
		}
		]
	},
	{
		path: '/login',
		component: login
	}
	,{
		path: '/yonghuRegister',
		component: yonghuRegister
	}
	,{
		path: '/forget',
		name: 'forget',
		component: () => import('../views/pages/forget.vue')
	}
]

const router = createRouter({
  history: createWebHashHistory(process.env.BASE_URL),
  routes
})

export default router
