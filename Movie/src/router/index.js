import { createRouter, createWebHistory } from 'vue-router'
import SubPage from '@/views/Main/SubPage.vue'
import MainPage from '../views/Main/MainPage.vue'

const routes = [
  {
    path: '/',
    name: 'SubPage',
    component: SubPage
  },
  {
    path: '/main',
    name: 'MainPage',
    component: () => import(/* webpackChunkName: "about" */ '../views/Main/MainPage.vue')
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
