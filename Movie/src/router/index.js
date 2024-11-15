import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/user',
    name: 'ListView',
    component: () => import(/* webpackChunkName: "about" */ '../views/ListView.vue')
  },
  {
    path: '/user/findById/:name', // 주소처럼 인식해서 name의 데이터가 넘어감.
    name: 'SelectView',
    component: () => import(/* webpackChunkName: "about" */ '../views/SelectView.vue')
  },
  {
    path: '/user/editById/:no',
    name: 'UpdateView',
    component: () => import(/* webpackChunkName: "about" */ '../views/UpdateView.vue')
  },
  {
    path: '/user/save',
    name: 'CreateView',
    component: () => import(/* webpackChunkName: "about" */ '../views/CreateView.vue')
  },
  {
    path: '/Movie',
    name: 'MovieList',
    component: () => import(/* webpackChunkName: "about" */ '../views/MovieList.vue')
  },

  {
    path: '/Movie/:movie_num',
    name: 'DetailMovie',
    component: () => import(/* webpackChunkName: "about" */ '../views/DetailMovie.vue')
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
