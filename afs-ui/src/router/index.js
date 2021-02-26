import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/dashboard'
    },
    {
      path: '/',
      component: () => import(/* webpackChunkName: "home" */ '../components/common/Home.vue'),
      meta: { title: '自述文件' },
      children: [
        {
          path: '/dashboard',
          component: () => import(/* webpackChunkName: "dashboard" */ '../components/page/Dashboard.vue'),
          meta: { title: '系统首页' }
        },
        {
          path: '/icon',
          component: () => import(/* webpackChunkName: "icon" */ '../components/page/Icon.vue'),
          meta: { title: '自定义图标' }
        },
        {
          path: '/house',
          component: () => import(/* webpackChunkName: "table" */ '../pages/house/list.vue'),
          meta: { title: '房屋管理' }
        },
        {
          path: '/tabs',
          component: () => import(/* webpackChunkName: "tabs" */ '../components/page/Tabs.vue'),
          meta: { title: 'tab选项卡' }
        },
        {
          path: '/form',
          component: () => import(/* webpackChunkName: "form" */ '../components/page/BaseForm.vue'),
          meta: { title: '基本表单' }
        },
        {
          // 富文本编辑器组件
          path: '/editor',
          component: () => import(/* webpackChunkName: "editor" */ '../components/page/VueEditor.vue'),
          meta: { title: '富文本编辑器' }
        },
        {
          // markdown组件
          path: '/markdown',
          component: () => import(/* webpackChunkName: "markdown" */ '../components/page/Markdown.vue'),
          meta: { title: 'markdown编辑器' }
        },
        {
          // 图片上传组件
          path: '/upload',
          component: () => import(/* webpackChunkName: "upload" */ '../components/page/Upload.vue'),
          meta: { title: '文件上传' }
        },
        {
          // vue-schart组件
          path: '/charts',
          component: () => import(/* webpackChunkName: "chart" */ '../components/page/BaseCharts.vue'),
          meta: { title: 'schart图表' }
        },
        {
          // 拖拽列表组件
          path: '/drag',
          component: () => import(/* webpackChunkName: "drag" */ '../components/page/DragList.vue'),
          meta: { title: '拖拽列表' }
        }
      ]
    },
    {
      path: '/login',
      component: () => import(/* webpackChunkName: "login" */ '../components/page/Login.vue'),
      meta: { title: '登录' }
    },
    {
      path: '*',
      redirect: '/404'
    }
  ]
});
