<template>
  <header id="header">
      <div class="container">
        <div class="row aln-center">
          <div class="col-6 text-right">
            <!-- 로그인 상태에 따른 아이디 표시 -->
              <div class="user-info">
                <div>
                  안녕하세요, <router-link :to="'/main/'+getUserId()">{{ getUserId() }}</router-link>님! &nbsp;&nbsp;
                  <span><button @click="logout" class="btn btn-danger">로그아웃</button></span>
                </div>
              </div>
            <!-- 네비게이션 바 -->
            <nav>
              <ul>
                <li><router-link to="/main">메인</router-link></li>
                <li><router-link to="/user">사용자명단</router-link></li>
                <li><router-link to="/movieList">영화 목록</router-link></li>
                <li><router-link to="/about">사이트 소개</router-link></li>
                <li><router-link to="/contact">연락처</router-link></li>
              </ul>
            </nav>
          </div>
        </div>
      </div>
    </header>
</template>

<script>
export default {
  name: 'LayOutMain',
  methods: {
    getUserId() {
      return sessionStorage.getItem('userId');
    },
    logout(){
      sessionStorage.removeItem('userId');
      this.$router.push('/');
    }
  },
  mounted(){
    const userId = sessionStorage.getItem('userId');
    console.log('세션에 있는 userId:'+userId);
    if(userId){
      console.log('로그인상태:'+userId+'님');
    }else {
      console.log('로그인되지 않은 상태');  
    }
  }
}
</script>

<style>

</style>