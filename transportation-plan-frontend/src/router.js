import Vue from 'vue';
import Router from 'vue-router';
import Home from './views/Home.vue';
import PlanIndex from './views/plan/Index.vue';
import PlanEdit from './views/plan/Edit.vue';

Vue.use(Router);

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: '/plan',
      name: 'plan-index',
      component: PlanIndex,
    },
    {
      path: '/plan/create',
      name: 'plan-create',
      component: PlanEdit,
    },
    {
      path: '/plan/edit/:id',
      name: 'plan-edit',
      component: PlanEdit,
    },
  ],
});
