import { createRouter, createWebHistory } from 'vue-router'
import LayOutMain from '@/views/Main/LayOutMain.vue'
import SubPage from '@/views/Main/SubPage.vue'
import MainPage from '../views/Main/MainPage.vue'
import LoginPage from '@/views/login/LoginPage.vue'
import MovieList from '@/views/Main/MovieList.vue'

const routes = [
  {
    path: '/api/login', // 이동할 페이지의 경로,로그인 상태 확인 후 접근 가능한 경로.
    component: MainPage,
    beforeEnter: (to, from, next) => { //  beforeEnter --> 네비게이션 가드 기능 , 라우터가 페이지로 이동하기 전에 특정 조건을 체크해줌.
      // sessionStorage에서 userId를 가져와서 로그인 여부를 확인
      // to : 현재 가고자 하는 라우트 정보( 이 정보를 통해서 대상 경로 및 파라미터를 알 수 있음.)
      // from : 현재 라우트 정보 (사용자가 이동하기 전)
      // next : 네비게이션을 이어서 진행할지, 중단하고 다른 경로로 리다이렉트하지 결정함.
      if (sessionStorage.getItem('userId')) {
        next(); // 로그인 상태라면 페이지 접근 허용
      } else {
        next('/'); // 로그인되지 않으면 로그인 페이지로 리다이렉트
      }
    }
  },
  {
    path: '/',
    name: 'LoginPage',
    component: LoginPage
  },
  {
    path: '/Sub',
    name: 'SubPage',
    component: () => import('../views/Main/SubPage.vue'),
    meta: { layout: LayOutMain } 
  },
  {
    path: '/main',
    name: 'MainPage',
    component: () => import(/* webpackChunkName: "about" */ '../views/Main/MainPage.vue'),
    meta: { layout: LayOutMain } 
  },

  {
    path: '/movieList',
    name: 'MovieList',
    component: () => import(/* webpackChunkName: "about" */ '../views/Main/MovieList.vue'),
    meta: { layout: LayOutMain } 
  },

  {
    path: '/movieList/:movie_num',  
    name: 'MovieOne',
    component: () => import(/* webpackChunkName: "about" */ '../views/Main/MovieOne.vue'),
    meta: { layout: LayOutMain } 
  },

  {
    path: '/user',  
    name: 'UserList',
    component: () => import(/* webpackChunkName: "about" */ '../views/Main/UserList.vue')
  },

  {
    path: '/main/:userId',  
    name: 'UserOne',
    component: () => import(/* webpackChunkName: "about" */ '../views/Main/UserOne.vue')
  },
  {
    path: '/AddMovie',  
    name: 'AddMovie',
    component: () => import(/* webpackChunkName: "about" */ '../views/Main/AddMovie.vue')
  },
  {
    path: '/cart',  
    name: 'UserCart',
    component: () => import(/* webpackChunkName: "about" */ '../views/Main/UserCart.vue')
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
