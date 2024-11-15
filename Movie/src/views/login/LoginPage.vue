<template>
    <div>
        <h1 class="login-title">로그인</h1>
        <form class="login-form">
            <div class="form-group">
                <label for="username">사용자 이름</label>
                <input type="text" id="username" v-model="username" placeholder="아이디를 입력하세요" required />
            </div>
            <div class="form-group">
                <label for="password">비밀번호</label>
                <input type="password" id="password" v-model="password" placeholder="비밀번호를 입력하세요" required />
            </div>
            <div class="form-group">
                <button type="submit" class="btn-login">로그인</button>
            </div>
        </form>
        <router-link to="/main">메인페이지로 가기</router-link>
    </div>
</template>

<script>


export default {
    name: 'LoginPage',
}
</script>
    
<style>
 @import '@/assets/LoginPage.css';
</style>