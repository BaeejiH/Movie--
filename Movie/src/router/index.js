import { createRouter, createWebHistory } from 'vue-router'
import SubPage from '@/views/Main/SubPage.vue'
import MainPage from '../views/Main/MainPage.vue'
import LoginPage from '@/views/login/LoginPage.vue'
import MovieList from '@/views/Main/MovieList.vue'

const routes = [
  {
    path: '/',
    name: 'LoginPage',
    component: LoginPage
  },
  {
    path: '/Sub',
    name: 'SubPage',
    component: () => import('../views/Main/SubPage.vue')
  },
  {
    path: '/main',
    name: 'MainPage',
    component: () => import(/* webpackChunkName: "about" */ '../views/Main/MainPage.vue')
  },

  {
    path: '/movieList',
    name: 'MovieList',
    component: () => import(/* webpackChunkName: "about" */ '../views/Main/MovieList.vue')
  },

  {
    path: '/movieList/:movie_num',  
    name: 'MovieOne',
    component: () => import(/* webpackChunkName: "about" */ '../views/Main/MovieOne.vue')
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
