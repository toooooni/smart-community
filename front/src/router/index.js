import Vue from 'vue'
import Router from 'vue-router'
import login from '../components/view/login.vue'
import manage from '../components/view/manage.vue'
import register from '../components/view/register.vue'
import repair from '../components/view/repair.vue'
import report from '../components/view/report.vue'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path:'/login',
      name:'login',
      component:login,
    },
    {
      path:'/manage',
      name:'manage',
      component:manage,
    },
    {
      path:'/register',
      name:'register',
      component:register,
    },
    {
      path:'/repair',
      name:repair,
      component:repair,
    },
    {
      path:'/report',
      name:report,
      component:report,
    }
  ]
})
