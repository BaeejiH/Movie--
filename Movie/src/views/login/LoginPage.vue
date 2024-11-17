<template>
    <div>
        <h1 class="login-title">로그인</h1>
        <form @submit.prevent="Login" class="login-form">
            <div class="form-group">
                <label for="userName">사용자 이름</label>
                <input type="text" id="userName" v-model="userName" placeholder="아이디를 입력하세요" required />
            </div>
            <div class="form-group">
                <label for="userPw">비밀번호</label>
                <input type="password" id="userPw" v-model="userPw" placeholder="비밀번호를 입력하세요" required />
            </div>
            <div class="form-group">
                <button type="submit" class="btn-login">로그인</button>
            </div>
            <div v-if="errorMessage" class="error-message">{{ errorMessage }}</div>
        </form>
        <router-link to="/main">메인페이지로 가기</router-link>
    </div>
</template> 

<script>
import axios from 'axios';

export default {
    name: 'LoginPage',
    data() {
        return {
            userName: '',
            userPw: '',
            errorMessage: '',
        }
    },
    methods: {
        async Login() {
            try {
                const response = await axios.post('http://localhost:8080/', {
                    userName: this.userName,
                    userPw: this.userPw,
                });

                if (response.data.state) {
                    // 로그인 성공 시 메인 페이지로 이동
                    this.$router.push('/main');
                } else {
                    // 로그인 실패 시 에러 메시지 표시
                    this.errorMessage = response.data.message || '로그인 실패';
                    console.log(response)
                }
            } catch (error) {
                console.error('Login error', error);
                this.errorMessage = '서버 오류가 발생했습니다. 다시 시도해주세요.';
            }
        }
    }

}
</script>

<style>
@import '@/assets/LoginPage.css';
</style>