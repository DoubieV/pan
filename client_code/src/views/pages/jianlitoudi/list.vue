<template>
	<div class="list-page" :style='{}'>
		<div class="bread_view">
			<el-breadcrumb separator="/" class="breadcrumb">
				<el-breadcrumb-item class="first_breadcrumb" :to="{ path: '/' }">首页</el-breadcrumb-item>
				<el-breadcrumb-item class="second_breadcrumb" v-for="(item,index) in breadList" :key="index">{{item.name}}</el-breadcrumb-item>
			</el-breadcrumb>
		</div>
		<div class="back_view" v-if="centerType">
			<el-button class="back_btn" @click="backClick" type="primary">返回</el-button>
		</div>
		<el-form :inline="true" :model="searchQuery" class="list_search">
			<div class="search_view">
				<div class="search_label">
					岗位名称：
				</div>
				<div class="search_box">
					<el-input class="search_inp" v-model="searchQuery.gangweimingcheng" placeholder="岗位名称"
						clearable>
					</el-input>
				</div>
			</div>
			<div class="search_btn_view">
				<el-button class="search_btn" type="primary" @click="searchClick">搜索</el-button>
				<el-button class="add_btn" type="success" v-if="btnAuth('jianlitoudi','新增')" @click="addClick">新增</el-button>
			</div>
		</el-form>
		<div class="page_list">
			<div class="data_box">
				<div class="data_view">
					<el-table v-loading="listLoading" class="data_table" :data="list" border :row-style="{'cursor':'pointer'}"
						@row-click="tableDetailClick" :stripe='true'>
						<el-table-column :resizable='true' align="left" header-align="left" type="selection" width="55" />
						<el-table-column label="序号" width="120" :resizable='true' align="left" header-align="left">
							<template #default="scope">{{ (listQuery.page-1)*listQuery.limit+scope.$index + 1}}</template>
						</el-table-column>
						<el-table-column label="岗位名称" :resizable='true' align="left" header-align="left">
							<template #default="scope">
								{{scope.row.gangweimingcheng}}
							</template>
						</el-table-column>
						<el-table-column label="办公环境" :resizable='true' align="left" header-align="left">
							<template #default="scope">
								<div v-if="scope.row.bangonghuanjing">
									<el-image v-if="scope.row.bangonghuanjing.substring(0,4)=='http'" preview-teleported
										:preview-src-list="[scope.row.bangonghuanjing.split(',')[0]]"
										:src="scope.row.bangonghuanjing.split(',')[0]" style="width:100px;height:100px" @click.stop></el-image>
									<el-image v-else preview-teleported
										:preview-src-list="[$config.url+scope.row.bangonghuanjing.split(',')[0]]"
										:src="$config.url+scope.row.bangonghuanjing.split(',')[0]" style="width:100px;height:100px" @click.stop>
									</el-image>
								</div>
								<div v-else>无图片</div>
							</template>
						</el-table-column>
						<el-table-column label="招聘人数" :resizable='true' align="left" header-align="left">
							<template #default="scope">
								{{scope.row.zhaopinrenshu}}
							</template>
						</el-table-column>
						<el-table-column label="学历要求" :resizable='true' align="left" header-align="left">
							<template #default="scope">
								{{scope.row.xueliyaoqiu}}
							</template>
						</el-table-column>
						<el-table-column label="薪资待遇" :resizable='true' align="left" header-align="left">
							<template #default="scope">
								{{scope.row.xinzidaiyu}}
							</template>
						</el-table-column>
						<el-table-column label="工作时间" :resizable='true' align="left" header-align="left">
							<template #default="scope">
								{{scope.row.gongzuoshijian}}
							</template>
						</el-table-column>
						<el-table-column label="企业账号" :resizable='true' align="left" header-align="left">
							<template #default="scope">
								{{scope.row.qiyezhanghao}}
							</template>
						</el-table-column>
						<el-table-column label="企业名称" :resizable='true' align="left" header-align="left">
							<template #default="scope">
								{{scope.row.qiyemingcheng}}
							</template>
						</el-table-column>
						<el-table-column label="联系电话" :resizable='true' align="left" header-align="left">
							<template #default="scope">
								{{scope.row.lianxidianhua}}
							</template>
						</el-table-column>
						<el-table-column label="企业地址" :resizable='true' align="left" header-align="left">
							<template #default="scope">
								{{scope.row.qiyedizhi}}
							</template>
						</el-table-column>
						<el-table-column label="账号" :resizable='true' align="left" header-align="left">
							<template #default="scope">
								{{scope.row.zhanghao}}
							</template>
						</el-table-column>
						<el-table-column label="姓名" :resizable='true' align="left" header-align="left">
							<template #default="scope">
								{{scope.row.xingming}}
							</template>
						</el-table-column>
						<el-table-column label="简历" :resizable='true' align="left" header-align="left">
							<template #default="scope">
								<el-button v-if="scope.row.jianli" type="text" size="small" @click.stop="download(scope.row.jianli)">下载</el-button>
								<el-button v-else disabled type="text" size="small">无</el-button>
							</template>
						</el-table-column>
						<el-table-column label="审核回复" v-if="centerType" :resizable='true' align="left" header-align="left">
							<template #default="scope">
								{{scope.row.shhf}}
							</template>
						</el-table-column>
						<el-table-column label="审核状态" v-if="centerType" :resizable='true' align="left" header-align="left">
							<template #default="scope">
								<el-tag type="success" v-if="scope.row.sfsh=='是'">通过</el-tag>
								<el-tag type="danger" v-if="scope.row.sfsh=='否'">未通过</el-tag>
								<el-tag type="warning" v-if="scope.row.sfsh=='待审核'">待审核</el-tag>
							</template>
						</el-table-column>
					</el-table>
				</div>
				<el-pagination
					background 
					:layout="layouts.join(',')"
					:total="total" 
					:page-size="listQuery.limit"
					prev-text="上一页"
					next-text="下一页"
					:hide-on-single-page="false"
					:style='{}'
					@size-change="sizeChange"
					@current-change="currentChange" 
					@prev-click="prevClick"
					@next-click="nextClick"  />
			</div>
		</div>
		<el-dialog v-model="preViewVisible" :title="'查看大图'" width="60%" destroy-on-close>
			<img :src="preViewUrl" style="width: 100%;" alt="">
		</el-dialog>
	</div>
</template>

<script setup>
	import {
		ref,
		getCurrentInstance,
		nextTick,
        computed,
	} from 'vue';
	import {
		useRoute,
		useRouter
	} from 'vue-router';
    import {
        useStore
    } from 'vuex';
    const store = useStore()
    const user = computed(()=>store.getters['user/session'])
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const router = useRouter()
	const route = useRoute()
	//基础信息
	const tableName = 'jianlitoudi'
	const formName = '简历投递'
	//基础信息
	const breadList = ref([{
		name: formName
	}])
	const list = ref([])
	const listQuery = ref({
		page: 1,
		limit: 20,
	})
	const total = ref(0)
	const listLoading = ref(false)
	//权限验证
	const btnAuth = (e,a)=>{
		if(centerType.value){
			return context?.$toolUtil.isBackAuth(e,a)
		}else{
			return context?.$toolUtil.isAuth(e,a)
		}
	}
	const addClick = () => {
		router.push('/index/jianlitoudiAdd')
	}
	//判断是否从个人中心跳转
	const centerType = ref(false)
	//返回
	const backClick = () => {
		router.push(`/index/${context?.$toolUtil.storageGet('frontSessionTable')}Center`)
	}
	//搜索
	const searchQuery = ref({})
	//下拉列表
	const searchClick = () => {
		listQuery.value.page = 1
		getList()
	}
	//分页
	const layouts = ref(["total","prev","pager","next","sizes","jumper"])
	const sizeChange = (size) => {
		listQuery.value.limit = size
		getList()
	}
	const currentChange = (page) => {
		listQuery.value.page = page
		getList()
	}
	const prevClick = () => {
		listQuery.value.page = listQuery.value.page - 1
		getList()
	}
	const nextClick = () => {
		listQuery.value.page = listQuery.value.page + 1
		getList()
	}
	//分页
	//列表
	const getList = () => {
		listLoading.value = true
		let params = JSON.parse(JSON.stringify(listQuery.value))
		if(searchQuery.value.gangweimingcheng&&searchQuery.value.gangweimingcheng!=''){
			params.gangweimingcheng = '%' + searchQuery.value.gangweimingcheng + '%'
		}
		if(!centerType.value){
			params['sfsh'] = '是';
		} 
		context?.$http({
			url: `${tableName}/${centerType.value?'page':'list'}`,
			method: 'get',
			params: params
		}).then(res => {
			listLoading.value = false
			list.value = res.data.data.list
			total.value = Number(res.data.data.total)
		})
	}
	const tableDetailClick = (row) => {
		router.push(`${tableName}Detail?id=` + row.id + (centerType.value?'&&centerType=1':''))
	}
	//下载文件
	const download = (file) =>{
		if(!file){
			context?.$toolUtil.message('文件不存在','error')
		}
		const a = document.createElement('a');
		a.style.display = 'none';
		a.setAttribute('target', '_blank');
		file && a.setAttribute('download', file);
		a.href = context?.$config.url + file;
		document.body.appendChild(a);
		a.click();
		document.body.removeChild(a);
	}
	// 查看大图
	const preViewUrl = ref('')
	const preViewVisible = ref(false)
	const preViewClick = (url) =>{
		preViewUrl.value = url
		preViewVisible.value = true
	}
	const init = () => {
		if(route.query.centerType){
			centerType.value = true
		}
		getList()
	}
	init()
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
	// 分类盒子
	.category_view {
		// 分类item
		.category {
		}
		// item-悬浮
		.category:hover {
		}
		// item-选中
		.categoryActive {
		}
	}

	//搜索
	.list_search {
		.search_view {
			.search_label {
			}
			.search_box {
				// 输入框
				:deep(.search_inp) {
					.is-focus {
						box-shadow: none !important;
					}
				}
			}
		}
		.search_btn_view {
			// 搜索按钮
			.search_btn {
			}
			// 搜索按钮-悬浮
			.search_btn:hover {
			}
			// 新增按钮
			.add_btn {
			}
			// 新增按钮-悬浮
			.add_btn:hover {
			}
		}
	}

	// 数据盒子
	.page_list {
		//列表
		.data_box {
			.data_view {
				// 表格样式
				.el-table {
					padding: 0;
					background: #fff;
					width: 100%;
					border-color: #eee;
					border-width: 1px 0 0 1px;
					border-style: solid;
					:deep(.el-table__header-wrapper) {
						thead {
							width: 100%;
							tr {
								background: #fff;
								th {
									padding: 10px 0;
									border-color: #eee;
									border-width: 0 1px 1px 0;
									border-style: solid;
									text-align: left;
									.cell {
										padding: 0 10px;
										word-wrap: normal;
										color: #666;
										white-space: normal;
										font-weight: bold;
										display: inline-block;
										vertical-align: middle;
										font-size: 15px;
										line-height: 24px;
										text-overflow: ellipsis;
										word-break: break-all;
										width: 100%;
										position: relative;
										//未选中样式
										.el-checkbox {
											//复选框
											.el-checkbox__inner {
												background: #fff;
												border-color: #999;
											}
										}
										//选中样式
										.is-checked {
											//复选框
											.el-checkbox__inner {
												background: #55ffff;
												border-color: #55ffff;
											}
										}
									}
								}
							}
						}
					}
					:deep(.el-table__body-wrapper) {
						tbody {
							width: 100%;
							tr {
								background: #fff;
								td {
									padding: 10px 0 0;
									color: #666;
									background: #fff;
									border-color: #eee;
									border-width: 0 1px 1px 0;
									border-style: solid;
									text-align: left;
									.cell {
										padding: 0 10px;
										overflow: hidden;
										word-break: break-all;
										white-space: normal;
										line-height: 24px;
										text-overflow: ellipsis;
										//未选中样式
										.el-checkbox {
											//复选框
											.el-checkbox__inner {
												background: #fff;
												border-color: #999;
											}
										}
										//选中样式
										.is-checked {
											//复选框
											.el-checkbox__inner {
												background: #55ffff;
												border-color: #55ffff;
											}
										}
									}
								}
							}
							tr.el-table__row--striped {
								td {
									background: #FAFAFA !important;
								}
							}
							tr:hover {
								td {
									padding: 10px 0 0;
									color: #333;
									background: #f6f6f6;
									border-color: #eee;
									border-width: 0 1px 1px 0;
									border-style: solid;
									text-align: left;
								}
							}
						}
					}
				}
			}
		}
	}

	// 分页器
	.el-pagination {
		// 总页码
		:deep(.el-pagination__total) {
		}
		// 上一页
		:deep(.btn-prev) {
		}
		// 下一页
		:deep(.btn-next) {
		}
		// 上一页禁用
		:deep(.btn-prev:disabled) {
		}
		// 下一页禁用
		:deep(.btn-next:disabled) {
		}
		// 页码
		:deep(.el-pager) {
			// 数字
			.number {
			}
			// 数字悬浮
			.number:hover {
			}
			// 选中
			.number.is-active {
			}
		}
		// sizes
		:deep(.el-pagination__sizes) {
			.el-select {
				//去掉默认样式
				.select-trigger{
					height: 100%;
					.el-input{
						height: 100%;
						.is-focus {
							box-shadow: none !important;
						}
					}
				}
			}
		}
		// 跳页
		:deep(.el-pagination__jump) {
			// 输入框
			.el-input {
				.is-focus {
					box-shadow: none !important;
				}
			}
		}
	}
	
	// 热门信息盒子
	.hot_view {
		// 标题
		.hot_title {
		}

		.hot_list {
			// item
			.hot {
				//图片盒子
				.hot_img_view {
					// 图片
					.hot_img {
					}
				}
				// 内容盒子
				.hot_content {
					// 名称
					.hot_text {
					}
				}
			}
		}
	}
</style>