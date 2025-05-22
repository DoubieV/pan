<template>
	<div>
		<div class="home_box">
			<!-- 青年驿站推荐 -->
			<div class="recomList_view">
<div class="recomList_title"><span>{{tableName}}推荐</span></div>

<div class="tjlist">
  
    <div class="item" v-for="(item,index) in qingnianyizhanRecomList" @click="detailClick('qingnianyizhan',item.id)">
        <div class="imgbox"><img :src="item.imgUrls[0]" alt=""></div>
		
        <div class="infobox">
            <div class="titles"><div class="title">{{item.yizhanmingcheng}}</div>
</div>
            <div class="price"></div>
            <div class="xys">
                
                <div class="collect">
	<span class="iconfont icon-likeline4"></span>
	<div class="num">{{item.storeupNumber}}</div>
</div>

                
            </div>
        </div>
		
    </div>
  
</div>
<div class="homeList_more_text" @click="moreClick('qingnianyizhan')">
    查看更多 +
</div>
			</div>
			<!-- 招聘活动推荐 -->
			<div class="recomList_view">
<div class="recomList_title"><span>{{tableName}}推荐</span></div>

<div class="tjlist">
  
    <div class="item" v-for="(item,index) in zhaopinhuodongRecomList" @click="detailClick('zhaopinhuodong',item.id)">
        <div class="imgbox"><img :src="item.imgUrls[0]" alt=""></div>
		
        <div class="infobox">
            <div class="titles"><div class="title">{{item.gangweimingcheng}}</div>
<div class="title">薪资待遇：{{item.xinzidaiyu}}</div>
<div class="title">企业名称：{{item.qiyemingcheng}}</div>
</div>
            <div class="price"></div>
            <div class="xys">
                
                <div class="collect">
	<span class="iconfont icon-likeline4"></span>
	<div class="num">{{item.storeupNumber}}</div>
</div>

                
            </div>
        </div>
		
    </div>
  
</div>
<div class="homeList_more_text" @click="moreClick('zhaopinhuodong')">
    查看更多 +
</div>
			</div>
		</div>
	</div>
</template>

<script setup>
	import {
		ref,
		getCurrentInstance
	} from 'vue';
	import moment from 'moment'
	import {
		useRouter
	} from 'vue-router';
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const router = useRouter()
	//青年驿站推荐
	const qingnianyizhanRecomList = ref([])
	const getqingnianyizhanRecomList = () => {
		let autoSortUrl = 'qingnianyizhan/autoSort'
		if(context?.$toolUtil.storageGet('frontToken')){
			autoSortUrl = "qingnianyizhan/autoSort2"
		}
		let params = {
			page: 1,
			limit: 8
		}
		context?.$http({
			url: autoSortUrl,
			method: 'get',
			params: params
		}).then(res => {
			qingnianyizhanRecomList.value = res.data.data.list
			qingnianyizhanRecomList.value.forEach(item=>{
				if(!isHttp(item.mendiantu)){
					item.imgUrls = item.mendiantu.split(',').map(item=>context.$config.url+item)
				}
			})
		})
	}
	//招聘活动推荐
	const zhaopinhuodongRecomList = ref([])
	const getzhaopinhuodongRecomList = () => {
		let autoSortUrl = 'zhaopinhuodong/autoSort'
		let params = {
			page: 1,
			limit: 8
		}
		context?.$http({
			url: autoSortUrl,
			method: 'get',
			params: params
		}).then(res => {
			zhaopinhuodongRecomList.value = res.data.data.list
			zhaopinhuodongRecomList.value.forEach(item=>{
				if(!isHttp(item.bangonghuanjing)){
					item.imgUrls = item.bangonghuanjing.split(',').map(item=>context.$config.url+item)
				}
			})
		})
	}
	//判断图片链接是否带http
	const isHttp = (str) => {
        return str && str.substr(0,4)=='http';
    }
	//跳转详情
	const detailClick = (table,id) => {
		router.push(`/index/${table}Detail?id=${id}`)
	}
	const moreClick = (table) => {
		router.push(`/index/${table}List`)
	}
	const init = () => {
		//青年驿站推荐
		getqingnianyizhanRecomList()
		//招聘活动推荐
		getzhaopinhuodongRecomList()
	}
	init()
</script>

<style lang="scss">
	.home_box {
	}

	// 推荐
	.recomList_view {
		.recomList_title {
		}
		// list
		// list
		// animation
		.animation_box {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			z-index: initial;
		}
		.animation_box:hover {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			-webkit-perspective: 1000px;
			perspective: 1000px;
			transition: 0.3s;
		}
		.animation_box img {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			z-index: initial;
		}
		.animation_box img:hover {
			transform: rotate(0deg) scale(1.05) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			-webkit-perspective: 1000px;
			perspective: 1000px;
			transition: 0.3s;
		}
		// animation
		// 更多
		.recommend_more_view {
			cursor: pointer;
			top: 60px;
			position: absolute;
			right: calc((100% - 1180px)/2);
			.recommend_more_text {
			}
		}
	}
	// 推荐
	// 新闻资讯
	.newsList_view {

		.newsList_title {
		}
		// list
		.news_list_one {
			display: flex;
			flex-wrap: wrap;
			.news_item {
				box-shadow: 0 4px 6px rgba(0,0,0,.3);
				margin: 0 10px 10px;
				background: #fff;
				display: flex;
				width: calc(33% - 20px);
				align-items: center;
				.news_img_box {
					width: 40%;
					font-size: 0;
					.news_img {
						object-fit: cover;
						width: 100%;
						height: 200px;
					}
				}
				.news_content {
					margin: 0 0 0 20px;
					width: calc(60% - 20px);
					.news_title {
						font-weight: bold;
						font-size: 20px;
					}
					.news_text {
						font-size: 14px;
						line-height: 1.5;
					}
					.news_time {
						color: #999;
						width: 100%;
						text-align: right;
					}
				}
			}
		}
		// list
		// animation
		.animation_box {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			z-index: initial;
		}
		.animation_box:hover {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			-webkit-perspective: 1000px;
			perspective: 1000px;
			transition: 0.3s;
		}
		.animation_box img {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			z-index: initial;
		}
		.animation_box img:hover {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			-webkit-perspective: 1000px;
			perspective: 1000px;
			transition: 0.3s;
		}
		// animation
		// 更多
		.news_more_view {
			.news_more_text {
			}
			.el-icon {
			}
		}
	}
	// 新闻资讯
	// 首页展示
	.homeList_view {

		.homeList_title {
		}
		// list
		// list
		// animation
		.animation_box {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			z-index: initial;
		}
		.animation_box:hover {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			-webkit-perspective: 1000px;
			perspective: 1000px;
			transition: 0.3s;
		}
		.animation_box img {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			z-index: initial;
		}
		.animation_box img:hover {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			-webkit-perspective: 1000px;
			perspective: 1000px;
			transition: 0.3s;
		}
		// animation
		// 更多
		.homeList_more_view {
			cursor: pointer;
			.homeList_more_text {
			}
		}
	}
	// 首页展示
</style>
<style>
.home_box{
    width: 100%;
    margin: 0px auto;
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
}
.home_box .appendBox1{
    width: 100%;
    height:299px;
    background:url(http://clfile.zggen.cn/20240927/708c7343aeeb4d728265133426b664a4.jpg) no-repeat center top / 100% 100%;
    order:5;
}
/* 总盒子 */
.recomList_view {
    width: 100%;
    margin:0;
    padding: 20px 0 50px;
    background: url() fixed no-repeat center top / cover,#fff;
    overflow: hidden;
    position:relative;
    order: 1;
    display: block;
}
/* 标题 */
.recomList_view .recomList_title{
    width: 1200px;
    margin:30px auto;
    background: none;
    text-align: left;
    border-bottom:2px solid var(--theme);
}
.recomList_view .recomList_title span{
    display: inline-block;
    background: var(--theme);
    padding: 10px 40px 10px 40px;
    font-size: 22px;
    color:#fff;

 }
/* 分类 */
.recomList_view .categoryList{
    display: none;
    flex-wrap: wrap;
}
.recomList_view .categoryList .item{
}

/* 自定义盒子 */
.recomList_view .tjlist{
  max-width:1200px;
  margin:0 auto;
  display: grid;
  grid-template-areas:
  ' . a1 a1. .'
  '. . . a8 a8';
  grid-gap: 20px;
  padding: 0px;
  border:0px solid var(--theme)80;
  background:#fff;
}
.recomList_view .tjlist .item:first-child {
   grid-area: a1;
   clip-path: polygon(2% 0, 100% 0, 98% 100%, 0% 100%);
}
.recomList_view .tjlist .item:last-child {
   grid-area: a8;
   clip-path: polygon(2% 0, 100% 0, 98% 100%, 0% 100%);
}

.recomList_view .tjlist .item{
    width: auto;
    margin: 0;
    background: none;
    cursor: pointer;
    height: 250px;
    overflow:hidden;
    position:relative;
    border-radius:0;
    clip-path: polygon(5% 0, 100% 0, 95% 100%, 0% 100%);
}
.recomList_view .tjlist .item .imgbox{
    width: 100%;
    height: 100%;
    overflow: hidden;
}
.recomList_view .tjlist .item .imgbox img{
    width: 100%;
    height: 100%;
    object-fit: cover;
}
.recomList_view .tjlist .item .infobox{
    cursor:pointer;  overflow:hidden; transition:0.3s; position:absolute; left:0px; bottom:-100%; width:100%; display:flex; flex-wrap:wrap; align-items:center; justify-content:center;flex-direction:column; background:none; 
}
.recomList_view .tjlist .item:hover .infobox{  padding:0px; bottom:0; height:100%; border-radius:0;background:rgba(0,0,0,.3);   }

.recomList_view .tjlist .item .infobox .titles{

}
.recomList_view .tjlist .item .infobox .title{
    width: 100%;
    line-height: 24px;
    white-space:nowrap;
    overflow:hidden;
    text-overflow:ellipsis;
    text-align:center;
}
.recomList_view .tjlist .item:hover .infobox .title{
    color: #fff;
}
.recomList_view .tjlist .item .infobox .price{
    width: 100%;
    text-align:center;
    color: #f00;
    font-size:16px;
}
.recomList_view .tjlist .item:hover .infobox .price{

}
.recomList_view .tjlist .item .infobox .xys{
    width: 100%;
    margin:10px 0 0;
}
.recomList_view .tjlist .item:hover .infobox .xys{
    color: #ccc;
    text-align:center;
}
.recomList_view .tjlist .item .infobox .xys div{
    display:inline-block;
}
.recomList_view .tjlist .item .infobox .xys .iconfont{
    color: inherit;
    margin: 0px 4px 0px 0px;
    display:inline-block;
}
.recomList_view .tjlist .item .infobox  .xys .num{
    display:inline-block;
    color: inherit;
}
.recomList_view .tjlist .item .infobox .xys .like{
    display: flex;
    align-items: center;
    color: inherit;
    font-size: 16px;
    margin: 0px 10px 0px 0px;
}
.recomList_view .tjlist .item .infobox .xys .collect{
    color: inherit;
    font-size: 16px;
    margin: 0px 10px 0px 0px;
}
.recomList_view .tjlist .item .infobox .xys .clickNum{
    display: flex;
    align-items: center;
    color: inherit;
    font-size: 16px;
    margin: 0px 10px 0px 0px;
}
.recomList_view .homeList_more_text{
    position: absolute;
    top: 50px;
    right: calc((100% - 1200px) / 2);
    cursor: pointer;
    padding:10px;
    background-repeat: no-repeat;
    background-position: bottom;
    background-image: -webkit-linear-gradient(left, var(--theme), var(--theme));
    background-image: linear-gradient(to left, var(--theme), var(--theme));
    background-size: 100% 0;
    transition: all .5s;
    clip-path: polygon(5% 0, 100% 0%, 95% 100%, 0% 100%);
}
.recomList_view .homeList_more_text:hover{
    background-size: 100% 100%;
    color: #fff;
}

</style>