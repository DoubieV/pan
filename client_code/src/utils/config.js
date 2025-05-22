const config = {
    get() {
        return {
            url : process.env.VUE_APP_BASE_API_URL + process.env.VUE_APP_BASE_API + '/',
            name: process.env.VUE_APP_BASE_API,
			menuList:[
				{
					name: '活动管理',
					icon: 'icon-common13',
					child:[

						{
							name:'活动信息',
							url:'/index/huodongxinxiList'
						},
					]
				},
				{
					name: '招聘管理',
					icon: 'icon-common15',
					child:[

						{
							name:'招聘活动',
							url:'/index/zhaopinhuodongList'
						},
					]
				},
				{
					name: '论坛交流',
					icon: '',
					child:[

						{
							name:'论坛交流',
							url:'/index/forumList'
						},
					]
				},
				{
					name: '青年驿站管理',
					icon: 'icon-common14',
					child:[

						{
							name:'青年驿站',
							url:'/index/qingnianyizhanList'
						},
					]
				},
			]
        }
    },
    getProjectName(){
        return {
            projectName: "基于Spring Boot的青年驿站管理与服务平台"
        } 
    }
}
export default config
